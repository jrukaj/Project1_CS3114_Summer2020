/**
 * Student class to store student information
 * @author Jonathan Rukaj
 *
 */
public class Student implements Comparable<Student> {
    


    private int score = 0;
    private int section = 1;
    private int id;

    private String first;
    private String last;
    private String fullName;
    
    
    /**
     * student constructor
     * @param initScore
     * @param first
     * @param last
     */    
    Student(String first, String last) {
        this.first = first;
        this.last = last;
        this.fullName = first + " " + last;
    }
    
    /**
     * Gets the student's full name
     * @return string representing student's full name
     */
    public String getFullName() {
        return this.fullName;
    }
    
    /**
     * Sets the name of the student 
     * @param first
     * @param last
     */
    public void setName(String first, String last) {
        this.first = first;
        this.last = last;
    }
    
    /**
     * Sets student's score
     * @param scoreParam
     */
    public void setScore(int scoreParam) {
        this.score = scoreParam;
    }
    
    /**
     * Gets the student's first and last name
     * @return string representing name
     */
    public String getName() {
        return this.first + " " + this.last;
    }
    
    /**
     * Gets the student's first name
     * @return string representing first name
     */
    public String getFirst() {
        return this.first;
    }
    
    /**
     * Gets the students last name
     * @return last name of the student
     */
    public String getLast() {
        return this.last;
    }
    
    /**
     * Returns the student's score
     * @return score of the student
     */
    public int getScore() {
        return this.score;
    }
    
    /**
     * Gets the student's id
     * @return int representing their id
     */
    public int getId() {
        return this.id;
    }
    
    /**
     * Sets the student's id
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Gets the section number of the student
     * @return int representing student's section number
     */
    public int getSection() {
        return section;
    }
    
    /**
     * Sets section number
     * @param num
     */
    public void setSection(int num) {
        section = num;
    }
    
    /**
     * Compares the scores of two given students, returning -1 if it is greater, and 1 if it
     * is less than or equal to
     * @param element
     * @return 1 if this student's score is less than or equal to the others
     */ 
    public int compareTo(Student otherStudent) {
        // Compare the last name.
        if (this.getLast().toUpperCase().compareTo(((Student)otherStudent).getLast()
            .toUpperCase()) < 0) {
            return -1;
        }
        else if (this.getLast().toUpperCase().compareTo(((Student)otherStudent)
            .getLast().toUpperCase()) > 0) {
            return 1;
        }
        // If the last name is the same, then compare the first name.
        else if (this.getFirst().toUpperCase().compareTo(((Student)otherStudent)
            .getFirst().toUpperCase()) < 0) {
            return -1;
        }
        else if (this.getFirst().toUpperCase().compareTo(((Student)otherStudent)
            .getFirst().toUpperCase()) > 0) {
            return 1;
        }
        // If the last name and first name are all the same.
        else {
            return 0;
        }
    }
    
    /**
     * Returns string representation of student
     * @return first and last name
     */
    public String toString() {
        return this.first + " " + this.last;
    }



}
