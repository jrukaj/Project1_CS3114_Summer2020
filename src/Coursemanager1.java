// “As a Hokie, I will conduct myself with honor and 
// integrity at all times. 
// I will not lie, cheat, or steal, nor will I accept the 
// actions of those who do.” 
// I swear that I have neither given nor received help on 
// this assignment.
// Jonathan Rukaj (jrukaj)

import java.util.*;

/**
 * Main driver class for Project 1
 * @author Jonathan Rukaj
 * @version 1
 */
public class Coursemanager1 {

    /**
     * Main function. Calls other classes
     * @param args 
     *            array holding arguments passed
	 */
	public static void main(String[] args) {
		//System.out.println(args.length);
		String file = args[0];
		//System.out.println(file);
		
		CommandParser parser = new CommandParser(file);
		FileExecutor fileExecutor = new FileExecutor();
		ArrayList<ArrayList<String>> commands = parser.parseCmd();
		fileExecutor.execute(commands);
	}

}
