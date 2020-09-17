import java.util.*;
import java.io.*;

/**
 * Parses commands, storing them in an array to be used for further evaluation.
 * @author Jonathan Rukaj (jrukaj)
 * @param <E> Generic support
 * @version 1
 */
public class CommandParser {

    private File file;
	private ArrayList<ArrayList<String>> commands;
	private Scanner scan;
	
	/** 
	 * CmdProcessor constructor
	 */
	public CommandParser() {
		// nothing to initialize
	}
	
	/**
	 * CmdProcessor 
	 * @param filename 
	 *            name of the file
	 */
	public CommandParser(String filename) {
		try {
			file = new File(filename);
			scan = new Scanner(file);
		}
		catch (Exception e) {
			System.out.println(
					"The file you are trying to "
					+ "open does not exist bröther.\n");
			e.printStackTrace();
			System.exit(0);
		}
		commands = new ArrayList<ArrayList<String>>();
	}
	
	/**
	 * Scans through the input file, adding commands to an ArrayList
	 * @return list with commands
	 */
	public ArrayList<ArrayList<String>> parseCmd() {
		while (scan.hasNextLine()) {
			// line = scan.nextLine();
			commands.add(parseLine(scan.nextLine()));
			// scan.nextLine();		
		}
		scan.close();
		return commands;
	}
	
	/**
	 * Parses through an individual line, adding command and 
	 * parameters to a list.
	 * @param line
	 *            the line to be parsed through
	 * @return list, with command as the first value and 
	 * 		the following values being the parameters
	 */
	public ArrayList<String> parseLine(String line) {
		ArrayList<String> list = new ArrayList<String>();
		// Add strings on the line to an array, then add to the ArrayList
		String[] splitted = line.trim().split("\\s+");
		for (String string: splitted) {
			list.add(string);
		}
		return list;
	}
	
}
