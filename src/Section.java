import java.util.*;

/**
 * Section class
 * @author Jonathan Rukaj
 * @version 1
 */
public class Section {

    private BST<Student> tree;
    private int secNum = 1;
    private int id;
    private Student currStudent;
	
	

	
	
	/**
	 * Section constructor
	 * @param sectionNumber
	 *            the section number
	 */
	public Section(int sectionNumber) {
		setSectionNumber(sectionNumber);
		tree = new BST();
		id = secNum * 10000;
	}
	
	/**
	 * Sets the ID number for the section
	 * @param num
	 *            number to set ID as
	 */
	public void setIdNum(int num) {
		id = num;
	}
	
	/**
	 * Gets the ID number being used as a counter
	 * @return id number
	 */
	public int getIdNum() {
		return id;
	}
	
	/**
	 * Gets the current student
	 * @return the current student being stored
	 */
	public Student getStudent() {
		return currStudent;
	}
	
	/**
	 * Sets the current student
	 * @param student 
	 *            student to be set
	 */
	public void setStudent(Student student) {
		currStudent = student;
	}
	
	/**
	 * Gets the section number
	 * @return integer representing the section number
	 */
	public int getSectionNumber() {
		return secNum;
	}
	
	/**
	 * Sets the section number
	 * @param num
	 *            number to set
	 */
	public void setSectionNumber(int num) {
		secNum = num;
	}
	
	/**
	 * Gets the tree object in the section
	 * @return tree object
	 */
	public BST getTree() {
		return tree;
	}
	
	/**
	 * Inserts student into the tree
	 * @param student
	 *            student to be inserted
	 */
	public void insert(Student student) {
		if (getTree().find(student) != null) {
			System.out.println(student.getFullName() 
					+ " is already in section " + Integer.toString(getSectionNumber()));
			System.out.println("0" + 
			Integer.toString(tree.find(student).getId()) 
			+ ", " + tree.find(student).getFullName() + ", score = " + Integer.toString(tree.find(student).getScore()));
			return;
		}
		else {
			student.setId(++id);
		    getTree().insert(student);
		    System.out.println(student.getFullName() + " inserted");
		}
		setStudent(student);
	}
	
	/**
	 * Searches for student by first and last name
	 * @param first
	 *            the first name
	 * @param last
	 *           the last name
	 * @return true if the student has been found
	 */
	public boolean search(String first, String last) {
		if (getTree().find(new Student(first, last)) == null) {
			System.out.println("Search failed. Student " + first + " " + last
					+ " doesn't exist in section " 
					+ Integer.toString(getSectionNumber()));
			setStudent(new Student(first, last));
			return false;
		}
		else {
			Student temp = (Student)getTree().find(new Student(first, last));
			System.out.println("Found 0" 
			+ Integer.toString(temp.getId()) + ", " 
					+ temp.getFullName() + ", score = " 
			+ Integer.toString(temp.getScore())); 
			setStudent(temp);
			return true;
		}
	}
	
	

	
	/**
	 * Searches for student by either first or last name
	 * @param name
	 *            name to search
	 * @return names of students searched for
	 */
	public boolean search(String name) {
		int count = 0;
		System.out.println("search results for " + name + ":");
		for (Student s: tree) {
			if (s.getFirst().toLowerCase().equals(name.toLowerCase()) 
					|| s.getLast().toLowerCase().equals(name.toLowerCase())) {
				currStudent = s;
				System.out.println("0" + 
				        Integer.toString(s.getId()) + ", " 
						+ s.getFullName() + ", score = " + Integer.toString(s.getScore()));
				count++;		
			}
		}
		System.out.println(name + " was found in " + Integer.toString(count) + " records in section " + Integer.toString(getSectionNumber()));
		if (count == 0 || count > 1) {
			return false;
		}
		return true;
	}
	
	/**
	 * Removes student from tree
	 * @param first
	 *            first name
	 * @param last
	 *           lastname
	 */
	public void remove(String first, String last) {
		if (getTree().find(new Student(first, last)) == null) {
			System.out.println("Remove failed. Student " + first + " " + last
					+ " doesn't exist in section " + Integer.toString(getSectionNumber()));
		}
		else {
			Student temp = (Student)getTree().find(new Student(first, last));
			getTree().remove(temp);
			System.out.println("Student " + temp.getFullName() + " get removed from section " + Integer.toString(getSectionNumber()));
			
		}
	}
	
	/**
	 * Removes section from tree
	 */
	public void removeSection() {
		tree.makeEmpty();
		System.out.println("Section " + Integer.toString(getSectionNumber()) + " removed");
	}
	
	/**
	 * Returns a dump of the current section
	 */
	public void dumpsection() {
		for (Student s: tree) {
			String tempId = Integer.toString(s.getId());
			String tempScore = Integer.toString(s.getScore());
			System.out.println("0" + tempId + ", " + s.getFullName() + ", score = " + tempScore);
		}
		System.out.println("Size = " + Integer.toString(tree.getSize()));
	}
	
	/**
	 * Grades the student and returns the amount of students in each
	 * grade level.
	 */
	public void grade() {
		
		int A = 0;
		int AMin = 0;
		int BPl = 0;
		int B = 0;
		int BMin = 0;
		int CPl = 0;
		int C = 0;
		int CMin = 0;
		int DPl = 0;
		int D = 0;
		int DMin = 0;
		int F = 0;
		
		for (Student s: tree) {
			int score = s.getScore();
			if (score < 50) {
				F++;
			}
			
			else if (score >= 50 && score < 52.5) {
				DMin++;
			}
			
			else if (score >= 52.5 && score < 55) {
				D++;
			}
			
			else if (score >= 55 && score < 57.5) {
				DPl++;
			}
			
			else if (score >= 57.5 && score < 60) {
				CMin++;
			}
			
			else if (score >= 60 && score < 65) {
				C++;
			}
			
			else if (score >= 65 && score < 70) {
				CPl++;
			}
			
			else if (score >= 70 && score < 75) {
				BMin++;
			}
			
			else if (score >= 75 && score < 80) {
				B++;
			}
			else if (score >= 80 && score < 85) {
				BPl++;
			}
			else if (score >= 85 && score < 90) {
				AMin++;
			}
			else {
				A++;
			}
			
		}
		
		System.out.println("grading completed:");
		if (F > 0) {
			System.out.println(Integer.toString(F) + " students with grade F");
		}
		
		if (DMin > 0) {
			System.out.println(Integer.toString(DMin) + " students with grade D-");		
		}
		
		if (D > 0) {
			System.out.println(Integer.toString(D) + " students with grade D");		}
		
		if (DPl > 0) {
			System.out.println(Integer.toString(DPl) + " students with grade D+");		}
		
		if (CMin > 0) {
			System.out.println(Integer.toString(CMin) + " students with grade C-");		}
		
		if (C > 0) {
			System.out.println(Integer.toString(C) + " students with grade C");		}
		
		if (CPl > 0) {
			System.out.println(Integer.toString(CPl) + " students with grade C+");		}
		
		if (BMin > 0) {
			System.out.println(Integer.toString(BMin) + " students with grade B-");		}
		
		if (B > 0) {
			System.out.println(Integer.toString(B) + " students with grade B");		}
		if (BPl > 0) {
			System.out.println(Integer.toString(BPl) + " students with grade B+");		}
		if (AMin > 0) {
			System.out.println(Integer.toString(AMin) + " students with grade A-");		}
		if (A > 0){
			System.out.println(Integer.toString(A) + " students with grade A");		}
		
	}
	
	/**
	 * Finds pair of students whose score differ by the parameter passed
	 * @param score 
	 *            score difference to check
	 */
	public void findPair(int score) {
		System.out.println("Students with score difference less than or equal " + Integer.toString(score) + ":");
		int count = 0;
		for (Student s: tree) {
			for (Student y: tree) {
				if (s.compareTo(y) < 0 && Math.abs(s.getScore() - y.getScore()) <= score) {
					System.out.println(s.getFullName() + ", " + y.getFullName());
					count++;
				}
			}
		}
		System.out.println("found " + Integer.toString(count) + " pairs");
	}
	
	/**
	 * Updates a student's score
	 * @param x: student object to update
	 * @param score: score value to insert
	 */
	public void insertScore(Student x, int score) {
		if (score < 0 || score > 100) {
			System.out.println("Scores have to be integers in range of 0 to 100.");
		}
		else {
            tree.updateScore(x, score);
            System.out.println("Update " + getStudent().getFullName() + " record, score = " + Integer.toString(getStudent().getScore()));
		}
	}
}
