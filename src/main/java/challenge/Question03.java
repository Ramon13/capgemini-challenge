package challenge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * Count and print the number of pairs of anagrams
 * 
 * @author ramoncosta
 *
 */
public class Question03 {
	
	public static void main(String[] args) {
		System.out.println(countAnagrams(args[0]));
	}
	
	/**
	 * Read all combinations and sort them. 
	 * The sorted combination is stored in a map as the key.
	 * The value is the position of original characters in the origin word.
	 * Example: The word "amora" in some execution will be read the characters [o, r, a] [2. 3 .4]
	 * will be stored and put in the map with key = "aor" and value = [2, 3, 4] 
	 * 
	 * @param word The word to be read
	 */
	public static int countAnagrams(String word) {
		String sub;
		char subArr[];
		int count = 0;
		int wordLen = word.length();
		Map<String, int[]> patternMapIndex = new HashMap<>();
		
		for (int i = 1; i <= wordLen; i++) {
			
			for (int j = 0; j <= (wordLen - i); j++) {
				subArr = word.substring(j, i+j).toCharArray();
				
				quickSort(subArr, 0, i - 1);
				
				sub = new String(subArr);						// sub gets the sorted substring
								
				if (patternMapIndex.get(sub) != null){			// If the key exists, then is an anagram!
					printIndexesAnagram(patternMapIndex.get(sub), IntStream.range(j, i+j).toArray());
					count++;
				}
				
				patternMapIndex.put(sub, IntStream.range(j, i+j).toArray());
			}
		}
		
		return count;
	}
	
	private static void quickSort(char arr[], int left, int right) {
		if (left >= right)
			return;
		
		swap(arr, left, (left + right) / 2);
		int last = left;
		
		for (int i = left + 1; i <= right; i++) {
			if (arr[i] < arr[left])
				swap(arr, ++last, i);
		}
		
		swap(arr, left, last);
		
		quickSort(arr, left, last - 1);
		quickSort(arr, last + 1, right);
	}
	
	private static void swap(char arr[], int i, int j) {
		char tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}	
	
	private static void printIndexesAnagram(int a[], int b[]) {
		System.out.printf("[%s, %s]\t\n", Arrays.toString(a), Arrays.toString(b));
	}
}
