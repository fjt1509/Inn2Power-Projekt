package TestNG;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class RandomTests {

	@Test(enabled = false)
	void ignoreTest_TestNG() {
		String ignore = "We ignoring this test yo";
		assertTrue(ignore == "We ignoring this test yo");
	}

	@Test(timeOut = 1000)
	void timeOut_TestNG() {
		String k = "message";
		assertTrue(k == "message");
	}

	@Test(expectedExceptions = NumberFormatException.class)
	void expectedException_TestNG() {
		Integer.parseInt("one");
	}
}
