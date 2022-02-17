package challenge;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestQuestion03 {

	@Test
	public void testWhenWordThereAreNoAnagrams() {
		String word = "ixpluhkqj";
		int countAnagrams = Question03.countAnagrams(word);
		assertEquals(0, countAnagrams);
		
		word = "xpto";
		countAnagrams = Question03.countAnagrams(word);
		assertEquals(0, countAnagrams);
	}
	
	@Test
	public void testWhenWordHasTwoPairsOFAnagrams() {
		String word = "amora";
		int countAnagrams = Question03.countAnagrams(word);
		assertEquals(2, countAnagrams);
		
		word = "ovo";
		countAnagrams = Question03.countAnagrams(word);
		assertEquals(2, countAnagrams);
	}
	
	@Test
	public void testWhenWordHasThreePairsOFAnagrams() {
		String word = "ifailuhkqq";
		int countAnagrams = Question03.countAnagrams(word);
		assertEquals(3, countAnagrams);
	}
}
