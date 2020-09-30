import java.util.ArrayList;
/**
 * Class that creates Section objects and executes the commands.
 * @author Jonathan Rukaj
 * @version 1
 */
public class FileExecutor {


	
	/**
	 * Constructor for file executor
	 */
	public FileExecutor() {
		
	}
	
	/**
	 * Takes in list of list of strings, executing the commands
	 * @param list
	 *            the list of commands
	 */
	public void execute(ArrayList<ArrayList<String>> list) {
		// Student temp;
		for (ArrayList<String> cmd: list) {
			
			switch (cmd.get(0).toLowerCase()) {
				
			    case "summarydata":
			    	// summarydata function
				     break;
				
			    case "search":
				    if (cmd.size() == 3) {
					    // Search <state name> + <# records>
				    	String stateName = cmd.get(1);
				    	int records = Integer.parseInt(cmd.get(2));
				    }
				    else {
					    // Search <date>
				    	String date = cmd.get(1);
				    }
				    break;
				
			    case "dumpdata":
			    	String filename = cmd.get(1);
				    break;			
				
			} // end of Switch
		} // End of for
	} // End of execute
}
