package connectedCities.model;

import java.util.HashMap;
import java.util.Map;


public class CityConnection {
	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public Map<String, CityConnection> getConnectionMap() {
		return connectionMap;
	}

	public void setConnectionMap(Map<String, CityConnection> connectionMap) {
		this.connectionMap = connectionMap;
	}

	private String cityName;
	private boolean visited;
	private Map<String, CityConnection> connectionMap;


	public CityConnection(final String cityName) {
		this.cityName = cityName;
		this.visited = false;
		connectionMap = new HashMap<String, CityConnection>();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		CityConnection other = (CityConnection) obj;
		if (cityName == null) {
			if (other.cityName != null) {
				return false;
			}
		} else if (!cityName.equals(other.cityName)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cityName == null) ? 0 : cityName.hashCode());
		return result;
	}

}
