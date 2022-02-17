package challenge;

/**
 * Print the number of required characters missing
 * 
 * @author ramoncosta
 *
 */
public class Question02 {

	private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-+";
	private static final int PASSWORD_MIN_LEN = 6;
	
	public static void main(String[] args) {
		System.out.println(passwordValidator(args[0]));
	}
	
	/**
	 * 
	 * @param password	The password to be validated
	 * @return			If has minimum size return the number of missing required characters,
	 * 					else also return the number of characters needed to reach the minimum size
	 */
	public static int passwordValidator(String password) {
		boolean requiredType[] = new boolean[4];		// [0] for digit, [1] for uppercase, [2] for lowercase, [3] for special 
		
		char ch;
		int passwordLen = password.length();
		for (int i = 0; i < passwordLen; i++) {
			ch = password.charAt(i);
			
			requiredType[0] = !requiredType[0] ? isDigit(ch) : requiredType[0];
			requiredType[1] = !requiredType[1] ? isUpper(ch) : requiredType[1];
			requiredType[2] = !requiredType[2] ? isLower(ch) : requiredType[2];
			requiredType[3] = !requiredType[3] ? isSpecial(ch) : requiredType[3];
		}
		
		int count = 0;
		for (boolean req : requiredType) {
			if (!req)
				count++;
		}
		
		if (count + passwordLen < PASSWORD_MIN_LEN)
			count += PASSWORD_MIN_LEN - (count + passwordLen);
		
		return count;
	}
	
	private static boolean isDigit(char c) {
		return c > 47 && c < 58;
	}
	
	private static boolean isUpper(char c) {
		return c > 64 && c < 91;
	}
	
	private static boolean isLower(char c) {
		return c > 96 && c < 123;
	}
	
	private static boolean isSpecial(char c) {
		for (char specialChar : SPECIAL_CHARACTERS.toCharArray()) {
			if (specialChar == c)
				return true;
		}
		
		return false;
	}
}
