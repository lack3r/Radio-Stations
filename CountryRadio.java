import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Vector;

public class CountryRadio {

	HashMapList<String, RadioStation> map = new HashMapList<String, RadioStation>();
	Vector<RadioStation> stations;

	public CountryRadio(RadioParser myParser) {
		stations = myParser.stations;
		for (int i = 0; i < stations.size(); i++) {
			map.add(stations.get(i).getCountry(), stations.get(i));
		}
	}

	public HashSet<RadioStation> getCountryRadio(String country) {
		return map.get(country);
	}

	public void printCountriesRadios(String country) {
		HashSet<RadioStation> countrysStations = getCountryRadio(country);

		for (RadioStation station : countrysStations) {
			System.out.println(station);
		}
	}

	public void printCountriesURLs(String country) {
		HashSet<RadioStation> countrysStations = getCountryRadio(country);

		for (RadioStation station : countrysStations) {
			String[] URLs = station.URLs;
			for (int i = 0; i < URLs.length; i++) {
				if (URLs[i] != null) {
					System.out.println(URLs[i]);
				}
			}
		}
	}

	public static void main(String[] args) {
		try {
			RadioParser myParser = new RadioParser(
					"C:\\Users\\751909\\AppData\\Local\\RadioSure\\Stations\\stations-2016-08-01.rsd");
			// new CountryRadio(myParser).printCountriesRadios("Cyprus");
			new CountryRadio(myParser).printCountriesURLs("Cyprus");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
