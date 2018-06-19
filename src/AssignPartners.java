import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Randomly assigns partners to mix things up a bit
 * Takes a text file of names and stores them, then randomly assigns them
 * @author Lara Quiring
 * Date: 6/18/18
 */

public class AssignPartners {
	
	/**
	 * Read in text file line by line
	 * @param filePath | String | file location
	 * @return List<String>
	 */
	private static List<String> readInFile(String filePath){
		List<String> ar = new ArrayList<>();
		BufferedReader br;
		try {
			File f = new File(filePath);
			FileInputStream fIS = new FileInputStream(f);
			br = new BufferedReader(new InputStreamReader(fIS));
			String line = null;
			
			while((line = br.readLine()) != null) {
				ar.add(line);
			}
			
			br.close();
		} catch (IOException e) {
			System.out.println("Check your input file and try again!");
		}
		
		return ar;
	}
	
	/**
	 * Random assignment
	 * @param List<String>
	 */
	private static List<Pair> assign(List<String> list) {
		List<Pair> l = new ArrayList<Pair>();
		Random r = new Random();
		
		while(!list.isEmpty() && list.size() >= 2) {
			//add 1st kid
			int i = r.nextInt(list.size());
			String kid = list.get(i).trim();
			list.remove(i);
			//add 2nd kid
			i = r.nextInt(list.size());
			String kiddo = list.get(i).trim();
			list.remove(i);
			//make pair and store
			Pair pair = new Pair(kid, kiddo);
			l.add(pair);
		}
		//odd number
		if(list.size() != 0) {
			int i = r.nextInt(l.size());
			l.get(i).add(list.get(0).trim());	
		}
		
		return l;
	}
	
	/**
	 * Print out resulting pairs
	 * @param List<Pair>
	 */
	private static void parseResult(List<Pair> al) {
		for(Pair str : al) {
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
		List<String> list = null;
		list = readInFile(str);
		
		//print out result
		parseResult(assign(list));
	}
}
