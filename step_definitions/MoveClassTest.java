package step_definitions;
import implementation.MoveClass;

import static org.junit.Assert.*;
import cucumber.api.java.en.*;
import cucumber.api.java.Before;
import cucumber.api.PendingException;

public class MoveClassTest {
	int counter = -1;
	MoveClass moveClass;

	@Before
	public void setUp()
	{
		moveClass = new MoveClass();
	}

	@Given("^the room number is \"([^\"]*)\"$")
	public void theRoomNumberIs(String arg1) throws Throwable {
	    moveClass.takeRoom(arg1);
	}

	@Then("^the maximum number of student allowed in that classroom is (\\d+)$")
	public void theMaximumNumberOfStudentAllowedInThatClassroomIs(int arg1) throws Throwable {
	    assertEquals(arg1, moveClass.getMaxAllowed()); 
	}

	@Given("^the course is \"([^\"]*)\", \"([^\"]*)\"$")
	public void theCourseIs(String subject_code, String course_num) throws Throwable {
	    moveClass.getClassData(subject_code,course_num);
	}

	@Then("^one of the student is \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\",\"([^\"]*)\"$")
	public void oneOfTheStudentIs(String first_name, String last_name, String classification,String result1) throws Throwable {
	     //moveClass.printStudentInClass();
	    // assertEquals(first_name, moveClass.getStudentInfo(Integer.parseInt(count)));
	    // assertEquals(last_name, moveClass.getStudentInfo(Integer.parseInt(count)+1)); 
	    // assertEquals(classification, moveClass.getStudentInfo(Integer.parseInt(count)+2)); 
	    String result = moveClass.getStudentInfo(first_name,last_name,classification);
	    assertEquals(result1, result);
	}

}