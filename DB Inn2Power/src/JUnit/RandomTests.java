package JUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

class RandomTests {

	@Test
	@Timeout(1)
	void timeout_JUnit() {
		String k = "message";
		assertTrue(k == "message");
	}

	@Test
	@Ignore
	void ignoringTest_JUnit() {
		String ignore = "We ignoring this test yo";
		assertTrue(ignore == "We ignoring this test yo");

	}

	@Test
	void expectedException_JUnit() {
		Assertions.assertThrows(NumberFormatException.class, () -> {
			Integer.parseInt("One");
		});

	}
}
