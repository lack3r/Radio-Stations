import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class RadioParser {

	Vector<RadioStation> stations;

	public RadioParser(final String fileName) throws FileNotFoundException {
		stations = new Vector<RadioStation>();
		File file = new File(fileName);
		Scanner input = new Scanner(file, "UTF-8");

		int index = 0;
		while (input.hasNext()) {
			String nextLine = input.nextLine();
			stations.add(index, new RadioStation(nextLine));
			// stations.get(index).prettyPrint();
			index++;
		}

		input.close();
	}

	public static void main(String[] args) {
		/*try {
			RadioParser myParser = new RadioParser("RadioStations.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

	}

}
