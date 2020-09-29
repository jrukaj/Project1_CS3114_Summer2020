import student.TestCase;

public class StateTest extends TestCase {
    private State state;
    
    
    public void setUp() {
        state = new State();
    }
    
    /**
     * Tests the stateInfo method
     */
    public void testStateInfo() {
        String[] dataArr = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        state.stateInfo(dataArr);
        
        assertEquals(state.getDate(), dataArr[0]);
        assertEquals(state.getState(), dataArr[1]);
        assertEquals(state.getPositives(), dataArr[2]);
        assertEquals(state.getNegatives(), dataArr[3]);
        assertEquals(state.getHospitalized(), dataArr[4]);
        assertEquals(state.getOnVentilCurr(), dataArr[5]);
        assertEquals(state.getOnVentilCum(), dataArr[6]);
        assertEquals(state.getRecovered(), dataArr[7]);
        assertEquals(state.getGrade(), dataArr[8]);
        assertEquals(state.getDeath(), dataArr[9]);
    }  
    /**
     * Test stateInfo if string is empty
     */
    public void testStateInfoEmptyString() {   
        String[] dataArr = {"1", "2", "0", "4", "5", "6", "7", "8", "9", "10"};
        state.stateInfo(dataArr);
        assertEquals(state.getPositives(), "0");
    }
    /**
     * Test compareTo
     */
    public void testcompareTo1() {
        State state2 = new State();
        state.setState("AL");
        state2.setState("DC");
        
        assertEquals(state.compareTo(state2), -1);
    }
    /**
     * Test compareTo
     */
    public void testcompareTo2() {
        State state2 = new State();
        state.setState("WV");
        state2.setState("DC");
        
        assertEquals(state.compareTo(state2), 1);
    }
    /**
     * Test compareTo
     */
    public void testcompareTo3() {
        State state2 = new State();
        state.setState("AL");
        state2.setState("AL");
        
        assertEquals(state.compareTo(state2), 0);
    }
    /**
     * Test setters and getters
     */
    public void testSetAndGet() {
        String[] dataArr = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        state.stateInfo(dataArr);
        
        state.setDate("date");
        state.setState("state");
        state.setPositives("positives");
        state.setNegatives("negatives");
        state.setHospitalized("hospitalized");
        state.setOnVentilCurr("VentCurr");
        state.setOnVentilCum("VentilCum");
        state.setRecovered("recovered");
        state.setGrade("grade");
        state.setDeath("death");
        
        assertEquals(state.getDate(), "date");
        assertEquals(state.getState(), "state");
        assertEquals(state.getPositives(), "positives");
        assertEquals(state.getNegatives(), "negatives");
        assertEquals(state.getHospitalized(), "hospitalized");
        assertEquals(state.getOnVentilCurr(), "VentCurr");
        assertEquals(state.getOnVentilCum(), "VentilCum");
        assertEquals(state.getRecovered(), "recovered");
        assertEquals(state.getGrade(), "grade");
        assertEquals(state.getDeath(), "death");
    }
}
