package arrays;

import java.util.Arrays;

public class ArraysMain {
	
	private String[] testArray;
	private int[] intRay;
	
	public ArraysMain() {
		//intRay = new int[100];
		//populate(intRay);
		//checkOccurences(intRay,3,18);
		//populate1ToN(intRay);
		//frontToBack(intRay);
		//int[] consecTest1 = {1,2,3,6,7,8,9,10,11,45,46,47};
		//int[] consecTest2 = {10,11,12,13,14,15,6,7,8,9,10,11,45,46,47};
		int[] randomRolls = new int[1000];
		populate(randomRolls);
		
		//System.out.println("The longest sequence in the first test is " + longestConsecutiveSequence(consecTest1));
		//System.out.println("The longest sequence in the second test is " + longestConsecutiveSequence(consecTest2));
		//Arrays is a Utility class included in Java for formatting output
		//System.out.println(Arrays.toString(intRay));
		int[] result = longestConsecSeqAndPos(randomRolls);
		System.out.println("The longest sequence of dice rolls is " + result[0] + 
				" it happened on the " + (result[1] + 1) + "th roll. Starting with a roll of " + randomRolls[result[1]] + ".");
	}
	
	private void shuffle(int[] intRay) {
		for (int i = 0; i < intRay.length; i++) {
			swap(intRay, (int)(Math.random()*intRay.length), (int)(Math.random()*intRay.length));
		}
	}

	private void swap(int[] intRay, int i, int j) {
		int temp = intRay[j];
		intRay[j] = intRay[i];
		intRay[i] = temp;
	}

	private void populate1ToN(int[] intRay) {
		for(int i = 0; i < intRay.length; i++) {
			intRay[i] = i + 1;
		}
	}

	private void checkOccurences(int[] arr, int start, int end) {
		int[] counter = new int[end - start + 1];
		for(int value:arr) {
			counter[value - start]++;
		}
		for(int i = 0; i < counter.length; i++) {
			System.out.println("A " + (start + i) + " was rolled "
					+ counter[i] + " times.");
		}
	}

	private void populate(int[] intRay) {
		for(int i = 0; i < intRay.length; i++) {
			intRay[i] = diceRoll(3);
		}
		//This does not work:
		/*for(int value: intRay) {
			value = diceRoll(2);
		}*/
	}
	
	public int[] reverseOrder(int[] intRay) {
		int[] testArray = new int[intRay.length];
		for(int i = 0; i < intRay.length; i++) {
			testArray[i] = intRay[intRay.length - 1 - i];
		}
		return testArray;
	}
	/**
	 * returns the length of the longest sequence of consecutive integers in intRay
	 * For example lCS({1,2,3,7,8,9,10}) returns 4 because 7,8,9,10 is 4 integers long
	 * @param arr
	 * @return
	 */
	public int longestConsecutiveSequence(int[] intRay) {
		int seq = 1;
		int longseq = 0;
		for (int i = 0; i < intRay.length - 1; i++) {
			if(nextElementIsInSequence(intRay, i)) {
				seq++;
			}else {
				if(longseq < seq) {
					longseq = seq;
				}
				seq = 1;
			}
		}
		return longseq;
	}
	
	public int[] longestConsecSeqAndPos(int[] intRay) {
		int[] data = new int[2];
		data[0] = longestConsecutiveSequence(intRay);
		
		return data;
	}
	
	public boolean nextElementIsInSequence(int[] intRay, int pos) {
		return intRay[pos] + 1 == intRay[pos + 1];
	}
	
	public int consecutiveLength(int[] intRay, int pos) {
		int seq = 1;
		for(int i = pos; i < intRay.length - 1; i++) {
			if(nextElementIsInSequence(intRay, i)) {
				seq++;
			}
			else {
				return seq;
			}
		}
		return seq;
	}
	/*
	 * remove the element at index zero, push every other element up by one. 1 to 0, 2 to 1, etc.
	 * Put the element that was at zero at the end of intRay
	 */
	public void frontToBack(int[] intRay) {
		int front = intRay[0];
		for(int i = 0; i < intRay.length - 1; i++) {
			intRay[i] = intRay[i + 1];
		}
		intRay[intRay.length - 1] = front;
	}
	/**
	 * moves the front to the back repeatedly, exactly n times
	 * @param intRay
	 * @param n
	 */
	public void cycleThrough(int[] intRay, int n) {
		for(int i = 0; i < n; i++) {
			frontToBack(intRay);
		}
	}
	
	public int countLessThan(int[] intRay, int n) {
		int count = 0;
		for(int value: intRay) {
			if(value < n) {
				count++;
			}
		}
		return count;
	}

	public void notes() {
		//1. collection of primitives or objects
		//SPECIAL NOTE; This is the ONLY collection of primitives
		
		//2. size cannot be modified
		
		/*
		* 3. Elements of an array are REFERENCES to objects.
		* In other words, changing an element of an array changes
		* the REFERENCE, not the object (more on this later)
		*/
		
		//________________________________________
				
		//There are two types of constructors, the first we've seen already:
		int[] firstType = {3,14,-9,10};
		//this constructor can only be used at the declaration. Error:
		//firstType = {12,13,14,15};
				
		//the 2nd type:
		testArray = new String[50];
		/*SPECIAL NOTE: for primitive arrays, when they are instantiated,
		they are automatically populated with 0s. This is not the case with
		Object arrays, which are populated with 'null'
		*/
		
		
		for(int i = 0; i < testArray.length; i++) {
			System.out.println("The #" + i + " item is: " + testArray[i]);
		}
		
		//for each loop (useful only when you don't need to keep track of an index
		for(String value:testArray) {
			//"for each int in testArray..."
			System.out.println(value);
		}
		
	}

	public static void main(String[] args) {
		ArraysMain arrayPractice = new ArraysMain();

	}
	/**
	 * Returns the result from rolling "numberOfDice" dice.
	 * @param numberOfDice
	 * @return
	 */
	public int diceRoll(int numberOfDice) {
		int result = 0;
		for (int i = 0; i < numberOfDice; i++) {
			result += 1 + (int)(Math.random() * 6);
		}
		return result;
	}

}
