package connectedCities;

import connectedCities.services.ConnectionServices;
import connectedCities.services.ConnectionServicesImpl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Connected {
	public static void main(String[] args) throws FileNotFoundException {
		final String dataFile = args[0];
		final String startCity = args[1].toLowerCase();
		final String endCity = args[2].toLowerCase();
		BufferedReader reader =
				new BufferedReader(new FileReader(dataFile));
		ConnectionServices connectionServices =new ConnectionServicesImpl(reader,startCity,endCity);
		connectionServices.mapConnectionList();
		System.out.println(connectionServices.findConnection());
	}

}
