import java.util.ArrayList;
/**
 * Class that creates Section objects and executes the commands.
 * @author Jonathan Rukaj
 * @version 1
 */
public class FileExecutor {

    private boolean scoreFlag = false;
	private boolean sec1;
	private boolean sec2;
	private boolean sec3;
	
	private Section section1 = new Section(1);
	private Section section2 = new Section(2);
	private Section section3 = new Section(3);
	
	/**
	 * Constructor for file executor
	 */
	public FileExecutor() {
		sec1 = true;
		sec2 = false;
		sec3 = false;
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
				
			    case "section":
				    if (cmd.get(1).equals("1")) {
					    sec1 = true;
					    sec2 = false;
					    sec3 = false;
					    System.out.println("switch to section 1");
				    }
				
				    if (cmd.get(1).equals("2")) {
					    sec1 = false;
					    sec2 = true;
					    sec3 = false;
					    System.out.println("switch to section 2");
				    }
				
				    if (cmd.get(1).equals("3")) {
					    sec1 = false;
					    sec2 = false;
					    sec3 = true;
					    System.out.println("switch to section 3");
				    }
				    break;
				
			    case "insert":
				    String first = cmd.get(1).toLowerCase();
				    String last = cmd.get(2).toLowerCase();
				    Student newStu = new Student(first, last);
				    if (sec1) {
					    section1.insert(newStu);
				    }
				
				    if (sec2) {
					    section2.insert(newStu);
				    }
				
				    if (sec3) {
					    section3.insert(newStu);
				    } 
				    scoreFlag = true;
				    break;
				
				
			    case "search":
				    if (cmd.size() == 3) {
					    String firstName = cmd.get(1);
					    String lastName = cmd.get(2);
					    if (sec1) {
						    scoreFlag = section1.search(firstName, lastName);
					    }
					
					    if (sec2) {
						    scoreFlag = section2.search(firstName, lastName);
					    }
					
					    if (sec3) {
						    scoreFlag = section3.search(firstName, lastName);
					    }
					
					//TO DO: search by one name
				    }
				    else {
					    String name = cmd.get(1);
					    if (sec1) {
						    scoreFlag = section1.search(name);
					    }
					    if (sec2) {
						    scoreFlag = section2.search(name);
					    }
					    if (sec3) {
						    scoreFlag = section3.search(name);
					    }
				    }
				    break;
				
			    case "score":
				    int score = Integer.parseInt(cmd.get(1));
				    if (scoreFlag) {
					    if (sec1) {
						    section1.insertScore(section1.getStudent(), score);
					    }
					
					    if (sec2) {
						    section2.insertScore(section2.getStudent(), score);
					    }
					
					    if (sec3) {
						    section3.insertScore(section3.getStudent(), score);
					    }
				    }
				    else {
					    System.out.println(
					    		"score command can only be called "
					    		+ "after an insert command or a successful search command with one exact output.");
				    }
				    scoreFlag = false;
				    break;
				
			
			    case "remove":
				    String f = cmd.get(1);
				    String l = cmd.get(2);
				
				    if (sec1) {
					    section1.remove(f, l);
				    }
				
				    if (sec2) {
					    section2.remove(f, l);
				    }
				
				    if (sec3) {
					    section3.remove(f, l);
				    }
				
				    scoreFlag = false;
				    break;
				
			
			    case "removesection":
				    if (cmd.size() == 1) {
					    if (sec1) {
						    section1.removeSection();
					    }
				 
				        if (sec2) {
						    section2.removeSection();
					    }
					    if (sec3) {
						    section3.removeSection();
					    }
				    }
				    else {
					    int sectionToRemove = Integer.parseInt(cmd.get(1));
					    switch (sectionToRemove) {
					        case 1:
						        section1.removeSection();
						        break;
					        case 2:
						        section2.removeSection();
						        break;
					        case 3:
						        section3.removeSection();
						        break;
					    }
				    }
				    scoreFlag = false;
				    break;
				
				
			    case "dumpsection":
				    if (sec1) {
					    System.out.println("Section 1 dump:");
					    section1.dumpsection();
				    }
				
				    if (sec2) {
					    System.out.println("Section 2 dump:");
					    section2.dumpsection();
				    }
				
				    if (sec3) {
					    System.out.println("Section 3 dump:");
					    section3.dumpsection();
				    }
				    scoreFlag = false;
				    break;
				
				
			    case "grade":
				    if (sec1) {
					    section1.grade();
				    }
				 
				    if (sec2) {
					    section2.grade();
				    }
				
				    if (sec3) {
					    section3.grade();
				    }
				    scoreFlag = false;
				    break;
				
				
			    case "findpair":
				    int num = 0;
				    if (cmd.size() > 1) {
				        num = Integer.parseInt(cmd.get(1));
				    }
				    if (sec1) {
					    section1.findPair(num);
				    }
				
				    if (sec2) {
					    section2.findPair(num);
				    }
				
				    if (sec3) {
					    section3.findPair(num);
				    }
				    scoreFlag = false;
				    break;
				
			}
		}
	}
}
