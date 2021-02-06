package com.anexinet.test.classes;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

	/**
	 * Function to sum two numbers without using arithmetic operators.
	 *
	 * @param a double first number of the sum
	 * @param b double second number of the sum
	 * 
	 * @return result double the sum of a and b
	 * 
	 * @see Double
	 * @author Orlando Villegas <orvigas@gmail.com>
	 */
	public static double addTwoNumbersWithoutArithmeticOperators(final double a, final double b) {
		return Double.sum(a, b);
	}

	/**
	 * Function to intersect strings s1 and s2 and return array of characters that
	 * are repeated in both string
	 *
	 * @param s1 String first string to compare
	 * @param s2 String second string to compare
	 * 
	 * @return Character[] result of the intersection of s1 and s2
	 * 
	 * @see Character
	 * @see Set
	 * @See Collectors
	 * @author Orlando Villegas <orvigas@gmail.com>
	 */
	public static Character[] intersectChars(String s1, String s2) {
		/*
		 * Transform s1 into a Set of Character, remove white spaces (Using Set
		 * interface we are avoiding duplicates)
		 **/
		final Set<Character> result = s1.replaceAll("\s", "").chars().mapToObj(c -> (char) c)
				.collect(Collectors.toSet());
		/*
		 * Transform s2 into a Set of Character, remove white spaces (Using Set
		 * interface we are avoiding duplicates) and intersect s1 and s2, this will keep
		 * only the elements that are present in both collections
		 **/
		result.retainAll(s2.replaceAll("\s", "").chars().mapToObj(c -> (char) c).collect(Collectors.toSet()));
		/*
		 * Finally we transform the resulting Set of Characters to an Array of
		 * Characters
		 **/
		return result.toArray(new Character[result.size()]);
	}

	/**
	 * Function to convert a string number in base n to a decimal integer
	 *
	 * @param number String valid number in base n
	 * @param base   int n
	 * 
	 * @return result int decimal representation of number
	 * 
	 * @author Orlando Villegas <orvigas@gmail.com>
	 */
	public static int converToDecimal(final String number, final int base) {
		/* Variable initialization */
		int decimal = 0, pow = 1, size = number.replace("\s", "").length(), i = size - 1;
		/*
		 * Iterates over the numeric string while the index 'i' greater than or equal to
		 * 0
		 */
		while (i >= 0) {
			/*
			 * Gets the int value of the char in numeric string at position 'i'
			 */
			int charVal = val(number.charAt(i));
			/*
			 * If charVal at position 'i' is greater than or equal to base, then make
			 * decimal equals to -1, break the loop and return decimal, this means that is
			 * an invalid numeric string in base x
			 */
			if (charVal >= base) {
				decimal = -1;
				break;
			}
			/*
			 * Accumulate the value of charVal * pow in decimal
			 **/
			decimal += charVal * pow;
			/*
			 * Assign the value of elevate the base to the iteration number
			 * (base^iteration_number)
			 **/
			pow *= base;
			/*
			 * Decrement the position index 'i' by 1
			 */
			i--;
		}

		return decimal;
	}

	/**
	 * Function to convert a char to it's integer value
	 *
	 * @param character char valid char
	 * 
	 * @return result int decimal representation of char
	 * 
	 * @author Orlando Villegas <orvigas@gmail.com>
	 */
	private static int val(char character) {
		/*
		 * If character is in between '0' to '9' (ASCII 048 to 057)
		 */
		if (character >= '0' && character <= '9')
			/*
			 * Returns the value of character less '0' (ASCII 048) example '1' - '0' = 1
			 * (ASCII 049 - 048 = 1)
			 **/
			return character - '0';
		else
			/*
			 * Otherwise returns the value of character less 'A' + 10 (ASCII 065) example
			 * 'B' - ('A' - 10 )= 11 (ASCII (066 - 065) + 10 = 11)
			 **/
			return (character - 'A') + 10;
	}

	/**
	 * Function to search number 0 in a MXN Matrix, if a 0 is found then its entire
	 * row and column are set to 0 and then printed out
	 *
	 * @param matrix int[][]
	 * 
	 * @author Orlando Villegas <orvigas@gmail.com>
	 */
	public static void processMatrix(final int[][] matrix) {

		/*
		 * Variables definition
		 **/
		int m = matrix.length;
		int row = -1, col = -1, exist = -1;
		final int[][] copy = new int[matrix.length][matrix[0].length];

		/*
		 * Loop to get the first occurrence of a 0, set the row and column number
		 **/
		for (int x = 0; x < m; x++) {
			exist = Arrays.binarySearch(matrix[x], 0);
			if (exist >= 0) {
				row = x;
				col = exist;
				break;
			}
		}

		/*
		 * Loop to fill a copy of the original matrix with the required values
		 **/
		for (int i = 0; i < copy.length; i++) {
			for (int j = 0; j < copy[i].length; j++) {
				copy[i][j] = (i == row || j == col) ? 0 : matrix[i][j];
			}
		}

		printMatrix(copy);
	}

	/**
	 * Function to print a matrix
	 *
	 * @param matrix int[][]
	 * 
	 * @author Orlando Villegas <orvigas@gmail.com>
	 */
	public static void printMatrix(final int[][] matrix) {
		int m = matrix.length, n = 0;
		String rows = "\t\t[\n";
		for (int x = 0; x < m; x++) {
			n = matrix[x].length;
			rows += "\t\t\s\s[";
			for (int y = 0; y < n; y++) {
				rows += matrix[x][y] + (y < n - 1 ? ", " : "");
			}
			rows += " ]" + (x < m - 1 ? ",\n" : "\n");

		}
		rows += "\t\t]\n";
		System.out.print(rows);
	}

	/**
	 * Function to print a matrix
	 *
	 * @param number int number to be transformed to Roman numeral
	 * 
	 * @return romanNumeral String
	 * 
	 * @author Orlando Villegas <orvigas@gmail.com>
	 */
	public static String getRomanNumeral(final int number) {
		/*
		 * By grouping chars we build the representation of the decimal number as roman
		 * numeral
		 **/
		return "I".repeat(number).replace("IIIII", "V").replace("IIII", "IV").replace("VV", "X").replace("VIV", "IX")
				.replace("XXXXX", "L").replace("XXXX", "XL").replace("LL", "C").replace("LXL", "XC")
				.replace("CCCCC", "D").replace("CCCC", "CD").replace("DD", "M").replace("DCD", "CM");
	}

	/**
	 * Function to find all possible permutations of a string
	 *
	 * @param inputString String string to be processed
	 * 
	 * 
	 * @author Orlando Villegas <orvigas@gmail.com>
	 */
	public static void findPermutationsOfAString(final String inputString) {
		/* We use method overloading to call the processing function */
		findPermutationsOfAString(inputString, "");
	}

	/**
	 * Function to find all possible permutations of a string recursively
	 *
	 * @param inputString String string to be processed
	 * @param result      String of each iteration
	 * 
	 * 
	 * @author Orlando Villegas <orvigas@gmail.com>
	 */
	private static void findPermutationsOfAString(final String inputString, final String result) {

		/* If the inputString is empty print the result and stops the process */
		if (inputString.isEmpty()) {
			System.out.println("\t\t\t".concat(result));
			return;
		} else if (inputString.length() > 50) {
			System.out.println("\t\t\tError, string can't be processed, max length allowed is 50 chars.");
		} else {
			int i = 0;
			/*
			 * Loop to iterate over the string and recursively find the next permutations
			 **/
			while (i < inputString.length()) {
				final String a = inputString.substring(0, i);
				final String b = inputString.substring(i + 1);
				final String character = Character.toString(inputString.charAt(i));
				findPermutationsOfAString(a.concat(b), result.concat(character));
				i++;
			}
		}
	}

	/**
	 * Function to find the largest words in a sentence
	 *
	 * @param sentence String sentence to be processed
	 * @param words    Set of the largest Stringsin a sentence
	 * 
	 * @see Set
	 * @see Stream
	 * @author Orlando Villegas <orvigas@gmail.com>
	 */
	public static Set<String> findLongestWords(final String sentence) {
		final Set<String> result = Stream
				.of(sentence.replace(",", " ").replace(".", " ").replace("-", " ").trim().split(" "))
				.filter(word -> !word.isBlank()).sorted(Comparator.comparing(String::length))
				.collect(Collectors.toSet());
		final int maxLength = result.stream().max(Comparator.comparingInt(String::length)).map(String::length).get();
		return result.stream().filter(word -> word.length() == maxLength).collect(Collectors.toSet());
	}
}
