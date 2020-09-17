import static org.junit.Assert.*; 

import java.io.*;
import java.util.*;

/**
 * Test class for driver
 * @author Jonathan Rukaj
 * @version 1
 *
 */
public class CoursemanagerTest extends student.TestCase {

    private File file;
    private String args[] = new String[2];
    private String expected = "Section 1 dump:\r\n" + 
			"Size = 0\r\n" + 
			"john obi inserted\r\n" + 
			"Update john obi record, score = 88\r\n" + 
			"susan obi inserted\r\n" + 
			"Update susan obi record, score = 15\r\n" + 
			"susan obi is already in section 1\r\n" + 
			"010002, susan obi, score = 15\r\n" + 
			"Update susan obi record, score = 27\r\n" + 
			"susan ibrahim inserted\r\n" + 
			"nancy henry inserted\r\n" + 
			"Update nancy henry record, score = 71\r\n" + 
			"Section 1 dump:\r\n" + 
			"010004, nancy henry, score = 71\r\n" + 
			"010003, susan ibrahim, score = 0\r\n" + 
			"010001, john obi, score = 88\r\n" + 
			"010002, susan obi, score = 27\r\n" + 
			"Size = 4\r\n" + 
			"score command can only be called"
			+ " after an insert command or a successful search command with one exact output.\r\n" + 
			"switch to section 2\r\n" + 
			"Search failed. Student X Y doesn't exist in section 2\r\n" + 
			"switch to section 1\r\n" + 
			"Found 010002, susan obi, score = 27\r\n" + 
			"Search failed. Student A B doesn't exist in section 1\r\n" + 
			"search results for Eva:\r\n" + 
			"Eva was found in 0 records in section 1\r\n" + 
			"search results for Susa:\r\n" + 
			"Susa was found in 0 records in section 1\r\n" + 
			"search results for Susan:\r\n" + 
			"010003, susan ibrahim, score = 0\r\n" + 
			"010002, susan obi, score = 27\r\n" + 
			"Susan was found in 2 records in section 1\r\n" + 
			"score command can only be called "
			+ "after an insert command or a successful search command with one exact output.\r\n" + 
			"search results for john:\r\n" + 
			"010001, john obi, score = 88\r\n" + 
			"john was found in 1 records in section 1\r\n" + 
			"Update john obi record, score = 98\r\n" + 
			"Remove failed. Student Virtual student doesn't"
			+ " exist in section 1\r\n" + 
			"virtual student inserted\r\n" + 
			"Update virtual student record, score = 77\r\n" + 
			"Student john obi get removed from section 1\r\n" + 
			"Student virtual student get removed from section 1\r\n" + 
			"switch to section 2\r\n" + 
			"david moses inserted\r\n" + 
			"Update david moses record, score = 85\r\n" + 
			"sarah moses inserted\r\n" + 
			"Update sarah moses record, score = 93\r\n" + 
			"susan obi inserted\r\n" + 
			"Found 020001, david moses, score = 85\r\n" + 
			"Update david moses record, score = 66\r\n" + 
			"Found 020001, david moses, score = 66\r\n" + 
			"Scores have to be integers in range of 0 to 100.\r\n" + 
			"Section 2 dump:\r\n" + 
			"020001, david moses, score = 66\r\n" + 
			"020002, sarah moses, score = 93\r\n" + 
			"020003, susan obi, score = 0\r\n" + 
			"Size = 3\r\n" + 
			"Section 3 removed\r\n" + 
			"Section 2 removed\r\n" + 
			"switch to section 1\r\n" + 
			"Students with score difference less than or equal 30:\r\n" + 
			"susan ibrahim, susan obi\r\n" + 
			"found 1 pairs\r\n" + 
			"Students with score difference less than or equal 0:\r\n" + 
			"found 0 pairs\r\n" + 
			"grading completed:\r\n" + 
			"2 students with grade F\r\n" + 
			"1 students with grade B-\r\n";
	
	/**
	 * Sets up test case
	 */
	public void setUp() {
		file = new File("input.txt");
		args[0] = "input.txt";
	}
	
	/**
	 * Tests driver class
	 * @throws FileNotFoundException
	 */
	public void testAll() throws FileNotFoundException {
		Coursemanager1.main(args);
		
		String output = systemOut().getHistory();
		assertEquals(output, expected);
	}

}
