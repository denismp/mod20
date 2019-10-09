/**
 * 
 */
package mod20;

import java.util.HashMap;
import java.util.Map;

/**
 * @author denisputnam
 *
 */
public class Mod20 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Mod20 myMore = new Mod20();
		// TODO Auto-generated method stub
////		if( myMore.more20( 2 ))
////			System.out.println( "2 is 1 or 2 more than twenty");
		for (int i = 1; i <= 100; i++) {
			if (myMore.more20(i) == true) {
				System.out.println(i + " is 1 or 2 more than 20.");
			}
		}
		if (myMore.nearTen(12)) {
			System.out.println("12 is true");
		}
		if (myMore.nearTen(17) == false) {
			System.out.println("17 is false");
		}
		if (myMore.nearTen(19) == true) {
			System.out.println("19 is true");
		}

		String[] test = { "a", "b", "a" };
		System.out.println(myMore.wordAppend(test));
		String[] test2 = { "a", "b", "a", "c", "a", "d", "a" };
		String[] test3 = { "a", "", "a" };
		System.out.println(myMore.wordAppend(test2));
		System.out.println(myMore.wordAppend(test3));

		int[] unsortedArr = { 2,4,6,3,2,1 };
		printArr(unsortedArr);
		unsortedArr = oddEven(unsortedArr);
		printArr(unsortedArr);

	}

//	Return true if the given non-negative number is 1 or 2 more than a multiple of 20. See also: Introduction to Mod
//		
//		
//	more20(20) → false
//	more20(21) → true
//	more20(22) → true
	public boolean more20(int n) {
		if (n % 20 == 1)
			return true;
		if (n % 20 == 2)
			return true;
		return false;
	}

//	Given a non-negative number "num", return true if num is within 2 of a multiple of 10. Note: (a % b) is the remainder of dividing a by b, so (7 % 5) is 2. See also: Introduction to Mod
//	
//	
//	nearTen(12) → true
//	nearTen(17) → false
//	nearTen(19) → true
	public boolean nearTen(int num) {
		if (num % 10 < 3)
			return true;
		if (num % 10 >= 8)
			return true;
		return false;
	}

//	Loop over the given array of strings to build a result string like this: when a string appears the 2nd, 4th, 6th, etc. time in the array, append the string to the result. Return the empty string if no string appears a 2nd time.
//	wordAppend(["a", "b", "a"]) → "a"
//	wordAppend(["a", "b", "a", "c", "a", "d", "a"]) → "aa"
//	wordAppend(["a", "", "a"]) → "a"	
	public String wordAppend(String[] strings) {
		String rVal = "";
		Map<String, Integer> myMap = new HashMap<String, Integer>();
		for (int i = 0; i < strings.length; i++) {
			String currStr = strings[i];
			if (!myMap.containsKey(currStr)) {
				myMap.put(currStr, 1); // first match so add it to the map
			} else {
				// now mat the other keys bumping the value of the key arg by 1
				// The key is the string and the value is the number of times
				// the key appears in the HashMap<String,Integer>. So the first time
				// the value will be 1 and the myMap.get() will return 1 which now gets
				// bumped by 1. So the next time it will be 2 and etc...
				myMap.put(currStr, myMap.get(currStr) + 1);
				if (myMap.get(currStr) != 1 && myMap.get(currStr) % 2 == 0) {
					rVal += currStr;
				}
			}

		}
		return rVal;
	}

	static public int[] oddEven(int[] unsortedArr) {
		int i = 0;
		int j = unsortedArr.length - 1;
		boolean loop = true;
		while (loop) {
			System.out.println("i=" + i);
			System.out.println("j=" + j);
			if (i >= j)
				break;
			if (!isEven(unsortedArr[i]) && !isEven(unsortedArr[j])) {
				// we are okay on the left but not on the right.
				System.out.println("odd and odd case");
				i++;
			}
			if (!isEven(unsortedArr[i]) && isEven(unsortedArr[j])) {
				// This is the correct order.
				System.out.println("odd and even case");
				i++;
				j--;

			}
			if (isEven(unsortedArr[i]) && !isEven(unsortedArr[j])) {
				System.out.println("even and odd case");
				// swap to get odds on the left and evens on the right.
				int templ = unsortedArr[i];
				int tempr = unsortedArr[j];
				unsortedArr[i] = tempr;
				unsortedArr[j] = templ;
				i++;
				j--;
			}
			if (isEven(unsortedArr[i]) && isEven(unsortedArr[j])) {
				// right side is okay but the left isn't
				System.out.println("even and even case");
				j--;

			}
		}

		return unsortedArr;

	}

	static boolean isEven(int value) {
		return value % 2 == 0;
	}

	static void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println("arr[" + i + "]=" + arr[i]);
		}
	}
}
