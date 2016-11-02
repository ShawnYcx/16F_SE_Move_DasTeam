package step_definitions;
import implementation.MoveClass;

import static org.junit.Assert.*;
import cucumber.api.java.en.*;
import cucumber.api.java.Before;
import cucumber.api.PendingException;

public class MoveClassTest {

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
}