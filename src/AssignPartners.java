import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

/**
 * Randomly assigns partners to mix things up a bit
 * Takes a text file of names and stores them, then randomly assigns them
 * @author Lara Quiring
 * Date: 6/18/18
 *
 */

public class AssignPartners {
	
	/**
	 * Read in text file line by line
	 * @param filePath | String | file location
	 * @return ArrayList<String>
	 */
	private static ArrayList<String> readInFile(String filePath) throws IOException {
		File f = new File(filePath);
		FileInputStream fIS = new FileInputStream(f);
		BufferedReader br = new BufferedReader(new InputStreamReader(fIS));
		String line = null;
		ArrayList<String> ar = new ArrayList<>();
		
		while((line = br.readLine()) != null) {
			ar.add(line);
		}
		
		br.close();
		return ar;
	}
	
	/**
	 * Random assignment
	 * @param
	 */
	private static ArrayList<ArrayList<String>> assign(ArrayList<String> list) {
		ArrayList<ArrayList<String>> al = new ArrayList<ArrayList<String>>();
		Random r = new Random();
		
		while(!list.isEmpty() && list.size() >= 2) {
			ArrayList<String> temp = new ArrayList<>();
			if(list.size() > 2) {
				int i = r.nextInt(list.size());
				int tempInt = i;
				String kid = list.get(i).trim();
				list.remove(i);
				while(i == tempInt) {
					i = r.nextInt(list.size());
				}
				String kiddo = list.get(i).trim();
				list.remove(i);
				temp.add(kid);
				temp.add(kiddo);
				
				al.add(temp);
			} else {
				temp.add(list.get(0).trim());
				temp.add(list.get(1).trim());
				al.add(temp);
				list.remove(1);
				list.remove(0);
			}
		}
		//odd number
		if(list.size() != 0) {
			int i = r.nextInt(al.size());
			al.get(i).add(list.get(0).trim());	
		}
		return al;
	}
	
	/**
	 * Print out resulting pairs
	 * @param ArrayList<ArrayList<String>>
	 */
	private static void parseResult(ArrayList<ArrayList<String>> al) {
		for(ArrayList<String> str : al) {
			if(!str.isEmpty()) {
				if(str.size() == 3) {
					System.out.println(str.get(0) + "  |  " + str.get(1) + "  |  " + str.get(2));
				} else {
					System.out.println(str.get(0) + "  |  " + str.get(1));
				}
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {
		//read in file
		String str = "names.txt";
		ArrayList<String> list = null;
		try {
			list = readInFile(str);
		} catch (IOException e) {
			System.out.println("Check your input file and try again!");
		}
		
		//System.out.println(list);
		//random assignment
		//ArrayList<ArrayList<String>> al = assign(list);

		//print out result
		parseResult(assign(list));
	}

}
