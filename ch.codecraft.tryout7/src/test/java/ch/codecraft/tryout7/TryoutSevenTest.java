package ch.codecraft.tryout7;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author chris
 */
public class TryoutSevenTest {

	private static final ByteArrayOutputStream overridenSystemOut = new ByteArrayOutputStream();

	@BeforeClass
	public static void overrideSystemOut() {
		System.setOut(new PrintStream(overridenSystemOut));
	}

	@Test(expected = NullPointerException.class)
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

	@Test(expected=RuntimeException.class)
	public void testMainKo() {
		assertNotNull(overridenSystemOut);
		String[] args = { "key" };
		TryoutSeven.main(args);
	}

}
