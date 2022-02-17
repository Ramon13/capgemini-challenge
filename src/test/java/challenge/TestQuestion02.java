package challenge;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestQuestion02 {

	@Test
	public void testWhenPasswordIsSafe() {
		String password = "xyZ&12";
		int requiredChars = Question02.passwordValidator(password);
		assertEquals(0, requiredChars);
		
		password = "x&A11abq@";
		requiredChars = Question02.passwordValidator(password);
		assertEquals(0, requiredChars);
	}
	
	@Test
	public void testWhenDigitIsMissing() {
		String password = "xyz&AA";
		int requiredChars = Question02.passwordValidator(password);
		assertEquals(1, requiredChars);
		
		password = "x&A";
		requiredChars = Question02.passwordValidator(password);
		assertEquals(3, requiredChars);
	}
	
	@Test
	public void testWhenLowerIsMissing() {
		String password = "123&AA";
		int requiredChars = Question02.passwordValidator(password);
		assertEquals(1, requiredChars);
		
		password = "1&A";
		requiredChars = Question02.passwordValidator(password);
		assertEquals(3, requiredChars);
	}
	
	@Test
	public void testWhenUpperMissing() {
		String password = "xyz&12";
		int requiredChars = Question02.passwordValidator(password);
		assertEquals(1, requiredChars);
		
		password = "x&1";
		requiredChars = Question02.passwordValidator(password);
		assertEquals(3, requiredChars);
	}
	
	@Test
	public void testWhenSpecialIsMissing() {
		String password = "xyz1A";
		int requiredChars = Question02.passwordValidator(password);
		assertEquals(1, requiredChars);
		
		password = "x1A";
		requiredChars = Question02.passwordValidator(password);
		assertEquals(3, requiredChars);
	}
}
