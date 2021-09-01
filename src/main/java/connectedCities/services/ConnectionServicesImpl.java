package connectedCities.services;

import connectedCities.model.CityConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Search data map for requested connection.
 * */
public class ConnectionServicesImpl implements ConnectionServices{
	private BufferedReader textReader;
	private String cityStart;
	private String cityEnd;
	private final HashMap<String, CityConnection> cityMap=new HashMap<String, CityConnection>();
	private static final String DELIMITER = ",";

	public ConnectionServicesImpl(final BufferedReader textReader, final String cityStart,
								  final String cityEnd) {
		this.cityStart = cityStart.toLowerCase();
		this.cityEnd = cityEnd.toLowerCase();
		this.textReader=textReader;
	}


	public void mapConnectionList() {
		String line;
		try {
			while ((line = textReader.readLine()) != null) {
				String[] connectedCities = separateLine(line);
				List<CityConnection> citiesList = new ArrayList<CityConnection>();
				for (String city : connectedCities) {
					CityConnection cityConnection ;
					if (!cityMap.containsKey(city)) {
						cityConnection = new CityConnection(city);
						cityMap.put(city, cityConnection);
					} else {
						cityConnection =cityMap.get(city);
					}
					citiesList.add(cityConnection);
				}
				CityConnection firstCity= citiesList.get(0); CityConnection secondCity= citiesList.get(1);
				if (!firstCity.getConnectionMap().containsKey(secondCity.getCityName()))  firstCity.getConnectionMap().put(secondCity.getCityName(),secondCity);
				if (!secondCity.getConnectionMap().containsKey(firstCity.getCityName()))  secondCity.getConnectionMap().put(firstCity.getCityName(),firstCity);

			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
	}

	protected String[] separateLine(String line) {
		return line.trim().toLowerCase().replace(DELIMITER + " ", DELIMITER).split(DELIMITER);
	}
	public String findConnection() {
		return isConnected(cityMap.get(cityStart))?"yes":"no";
	}

	private boolean isConnected(CityConnection city) {
		if (city.getCityName().equals(cityEnd)) return true;
		// Clear current City Connection
		for (CityConnection targetCity : city.getConnectionMap().values()) {
			targetCity.getConnectionMap().remove(city.getCityName());
		}
		if (!city.isVisited()) {
			city.setVisited(true);
		} else {
			return  false;
		}

		for (CityConnection cityConnection : city.getConnectionMap().values()) {
			return isConnected(cityConnection);
		}
		return false;
	}
}
