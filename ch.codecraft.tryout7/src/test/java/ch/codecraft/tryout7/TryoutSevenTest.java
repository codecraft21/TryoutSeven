package ch.codecraft.tryout7;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author chris
 */
public class TryoutSevenTest {

	private static final ByteArrayOutputStream overridenSystemOut = new ByteArrayOutputStream();

	@BeforeClass
	public static void overrideSystemOut() {
		System.setOut(new PrintStream(overridenSystemOut));
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testMainNoArgs() {
		assertNotNull(overridenSystemOut);
		TryoutSeven.main(null);
	}

	@Test
	public void testMainOk() {
		assertNotNull(overridenSystemOut);
		String[] args = { "key", "value" };
		TryoutSeven.main(args);
		assertEquals("Hello, Java 7\n", overridenSystemOut.toString());
	}

	@Test(expectedExceptions=RuntimeException.class)
	public void testMainKo() {
		assertNotNull(overridenSystemOut);
		String[] args = { "key" };
		TryoutSeven.main(args);
	}

}
