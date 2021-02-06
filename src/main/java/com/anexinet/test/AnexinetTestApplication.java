package com.anexinet.test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.anexinet.test.classes.Test;

@SpringBootApplication
public class AnexinetTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnexinetTestApplication.class, args);

		System.out.println(
				"\n\n**************************************************************************************************");

		final double a = 3.0;
		final double b = 7.0;
		final double c = Test.addTwoNumbersWithoutArithmeticOperators(a, b);
		System.out.println(String.format(
				"\t1. Write a function that adds two numbers without using any arithmetic operators.\n\t\tfinal double a = %f;\n\t\tfinal double b = %f;\n\t\t\tOP: a + b = %f\n\n",
				a, b, c));

		final String s1 = "Flying bat!!";
		final String s2 = "Why batman?";
		final List<Character> s3 = Arrays.asList(Test.intersectChars(s1, s2));
		System.out.println(String.format(
				"\t2. Given 2 strings of unknown characters (but it cannot be repeated) create a function that returns an array of the characters\n\t\s\s\sthat are repeated in both strings in the most efficient way.\n\t\tfinal String s1 = \"%s\";\n\t\tfinal String s2 = \"%s\";\n\t\t\tOP: s1 intersect s2 = %s\n\n",
				s1, s2, s3));

		final String number = "55A";
		final int base = 16;
		final int decimal = Test.converToDecimal(number, base);
		System.out.println(String.format(
				"\t3. Write a function that takes a string containing a number in base X along with an integer of the base X. The function must\n\t\s\s\sreturn the integer value of that string/base pair.\n\t\tfinal String number = \"%s\";\n\t\tfinal int base = %d;\n\t\t\tOP: number in base = %s\n\n",
				number, base, ((decimal >= 0) ? decimal + " decimal" : "Invalid number")));

		int[][] matrix = { { 1, 2, 3 }, { 4, 0, 6 }, { 7, 8, 9 } };

		System.out.println(String.format(
				"\t4. Write a function such that if an element in an MxN matrix is 0 , its entire row and column are set to 0 and then printed out.\n\t\s\s\sOrigin matrix:"));
		Test.printMatrix(matrix);
		System.out.println("\t\s\s\sResult matrix:");
		Test.processMatrix(matrix);
		System.out.println("\n");

		final int decimalNumber = 3999;
		final String romanNumeral = Test.getRomanNumeral(decimalNumber);
		System.out.println(String.format(
				"\t5. Write a function that convert the given number into a Roman Numeral - The function needs to receive a Number and Return a String (The Number can be between 1 and 3999).\n\t\s\s\sfinal int decimalNumber = %d;\n\t\t\tOP: decimalNumber = %s\n\n",
				decimalNumber, romanNumeral));

		final String permutateString = "AB";
		System.out.println(String.format(
				"\t6. Write a function to print all permutations of a string. Max string length can be 50 characters.\n\t\s\s\sfinal Sting permutateString = %s;\n\t\t\tOP: permutateString:",
				permutateString));

		Test.findPermutationsOfAString(permutateString);
		System.out.println("\n");

		final String sentence = "Java is a cross-platform object-oriented programming language that was released by Sun Microsystems in the year 1995. Today, Java is needed to run various applications such as games, social media applications, audio and video applications, etc.";
		final Set<String> longestWords = Test.findLongestWords(sentence);
		System.out.println(String.format(
				"\t7. Write a function that receives a sentence, and return the longest word, if two or more words has the same lenght, they are returned as an array, but can't return duplicated words.\n\t\s\s\sfinal String sentence = \"%s\";\n\t\t\tOP: longestWords: %s",
				sentence, longestWords));

	}

}
