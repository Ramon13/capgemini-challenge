package challenge;

/**
 * Print one stair of n size in the console
 * 
 * @author ramoncosta
 */
public class Question01 {

	public static void main(String[] args) {
		int steps = Integer.parseInt(args[0]);
		printStair(steps, steps);
	}
	
	/**
	 * 
	 * @param n 	The size of stair (decrement during recursion) 
	 * @param size	The size of stair 
	 */
	public static void printStair(int n, final int size) {
		if (n == 0) {
			return;
		}
		
		printStair(n - 1, size);
		
		for (int i = 0; i < size; i++) {
			if((size - (n + i)) > 0) {
				System.out.print(" ");
			
			}else {
				System.out.print("*");
			}
		}
		
		System.out.println();
	} 
}
