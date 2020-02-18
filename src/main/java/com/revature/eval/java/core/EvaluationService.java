package com.revature.eval.java.core;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		char[] reversed = new char[string.length()];
		for (int i = reversed.length - 1, j=0; i >= 0; i--, j++) {
			reversed[j] = string.charAt(i);
		}
		return new String(reversed);
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		
		String acronym = "";
		acronym += phrase.toUpperCase().charAt(0);

		for (int i=1; i<= phrase.length() - 1; i++) {
			if (phrase.charAt(i - 1) == ' ' || phrase.charAt(i - 1) == '-') {
		               acronym += phrase.toUpperCase().charAt(i);
			}
		}
		return acronym;
		}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			if (sideOne == sideTwo  && sideTwo == sideThree) {
				return true;
			} else {
			return false;
		}
		}

		public boolean isIsosceles() {
			if (sideOne == sideTwo || sideTwo == sideThree || sideOne == sideThree) {
				return true;
			} else {
			return false;
		}
		}

		public boolean isScalene() {
			if (sideOne != sideTwo && sideTwo != sideThree && sideOne != sideThree) {
				return true;
			} else {
			return false;
		}

	}
	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		String scrabble = "";
		scrabble += string.toUpperCase();

		int score = 0;

		for (int i=0; i< scrabble.length(); i++) {
		char letter = scrabble.charAt(i);

		switch(letter) {
		case 'A':
		case 'E':
		case 'I':
		case 'O':
		case 'U':
		case 'L':
		case 'N':
		case 'R':
		case 'S':
		case 'T':
		score += 1;
		break;

		case 'D':
		case 'G':
		score += 2;
		break;

		case 'B':
		case 'C':
		case 'M':
		case 'P':
		score += 3;
		break;

		case 'F':
		case 'H':
		case 'V':
		case 'W':
		case 'Y':
		score += 4;
		break;

		case 'K':
		score += 5;
		break;

		case 'J':
		case 'X':
		score += 8;
		break;

		case 'Q':
		case 'Z':
		score += 10;
		break;

		default:
		score += 0;
		break;

		}
		}


		return score;
		}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {

		if (string.contains("@") || string.contains("!")) {
			throw new IllegalArgumentException();
		}
		
		String fixed = string.replaceAll("[^0-9]","");

		
		if (fixed.length() > 11) {
			throw new IllegalArgumentException();
		} 

		return fixed;
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		String[] stringArray = string.split("[, \\n]+");
		Map <String, Integer> values = new HashMap<String, Integer>();
		
		int count = 0;
		for(String s: stringArray ) {
			if (values.containsKey(s)) {
				values.put(s, count++);
				} else {
					values.put(s, 1);
				}
		}
		return values;
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T extends Comparable<T>>{
		private List<T> sortedList;

		public int indexOf(T t) {
			
			int mid = 0;
			int min = 0;
			int max = sortedList.size();
			
			
			while (min <= max) {
				 mid = ((max - min)/2);
				 if (t == getSortedList().get(mid)) {
					 return mid;
				 } else {
					 for (T e : sortedList) {
						 if (e.compareTo(t) > 0) {
							 max--;
						 } else if (e.compareTo(t) < 0){
							 max++;
						 }
					 }
				 }
			}
			
			return mid;

		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {
		
		
		String newWord = "";
		
		if (isVowel(string.charAt(0))){
			newWord = string + "ay";
		} 
		
		for (int i=0; i < string.charAt(i); i++) {
			if (isVowel(string.charAt(i))) {
				newWord = string.substring(i) + string.substring(0,i) + "ay";
				break;
			}
		}
		
		return newWord;
	}
	
	public boolean isVowel(char c) {
		return (c == 'a' || c == 'e' || c == 'i' ||
				c == 'o' || c== 'u');
	}

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		
		int temp = input;
		int digits = String.valueOf(input).length();
		int sum = 0;
		
		
		while (temp != 0) {
			int lastNumb = temp % 10;
			sum += Math.pow(lastNumb, digits);
			temp /= 10;
		}
		
		if (sum == input) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		
		List<Long> theList = new ArrayList<>();;

		for(long i = 2; i <= l; i ++) {
			while (l % i == 0) {
				theList.add(i);
				l = l/i;
			}
		}
		return theList;
	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			
			char[] charArray = string.toCharArray();
			
			String rotatedString = "";
			for (int i =0; i<charArray.length; i++) {
				if(Character.isLetter(charArray[i])) {
					if(Character.isUpperCase(charArray[i])) {
						rotatedString += (char)(((charArray[i]) + key - 65) % 26 + 65);
					} else if (Character.isLowerCase(charArray[i])) {
						rotatedString += (char)(((charArray[i]) + key - 97) % 26 + 97);
				}
				} else {
				rotatedString += (char)(charArray[i]);
				
			}
		}
			return rotatedString;

	}
	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int i) {
		
		if(i == 0) {
			throw new IllegalArgumentException();
		}
		
		
		int primeNumber = 1;
		int count = 0;
		int numb;
		while (count < i) {
			primeNumber++;
			for( numb=2; numb <= primeNumber; numb++) {
			if (primeNumber % numb == 0) {
				break;
			}
			}
			if ( numb == primeNumber) {
				count++;
			}
		}
		return primeNumber;
	}

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			
			HashMap<String,String> map = new HashMap<>();
			map.put("a", "z");
			map.put("b", "y");
			map.put("c", "x");
			map.put("d", "w");
			map.put("e", "v");
			map.put("f", "u");
			map.put("g", "t");
			map.put("h", "s");
			map.put("i", "r");
			map.put("j", "q");
			map.put("k", "p");
			map.put("l", "o");
			map.put("m", "n");
			map.put("n", "m");
			map.put("o", "l");
			map.put("p", "k");
			map.put("q", "j");
			map.put("r", "i");
			map.put("s", "h");
			map.put("t", "g");
			map.put("u", "f");
			map.put("v", "e");
			map.put("w", "d");
			map.put("x", "c");
			map.put("y", "b");
			map.put("z", "a");
			
			String fixed = string.replaceAll("\\p{Punct}", "").replaceAll(" ", "").toLowerCase();
			String[] strArray = fixed.split("");
			String message = "";
			
			
			for (int i =0; i < strArray.length;i++) {
				if(map.containsKey(strArray[i])) {
					message += map.get(strArray[i]);
				} else {
					message += strArray[i];
				}
			}
			
			int val = 5;
			message = message.replaceAll("(.{" + val + "})", "$1 ").trim();
			
			return message;
		
		}
		

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			
			HashMap<String,String> map = new HashMap<>();
			map.put("a", "z");
			map.put("b", "y");
			map.put("c", "x");
			map.put("d", "w");
			map.put("e", "v");
			map.put("f", "u");
			map.put("g", "t");
			map.put("h", "s");
			map.put("i", "r");
			map.put("j", "q");
			map.put("k", "p");
			map.put("l", "o");
			map.put("m", "n");
			map.put("n", "m");
			map.put("o", "l");
			map.put("p", "k");
			map.put("q", "j");
			map.put("r", "i");
			map.put("s", "h");
			map.put("t", "g");
			map.put("u", "f");
			map.put("v", "e");
			map.put("w", "d");
			map.put("x", "c");
			map.put("y", "b");
			map.put("z", "a");
			
			String fixed = string.replaceAll("\\p{Punct}", "").replaceAll(" ", "").toLowerCase();
			String[] strArray = fixed.split("");
			String message = "";
			
			
			for (int i =0; i < strArray.length;i++) {
				if(map.containsValue((strArray[i]))) {
					message += map.get(strArray[i]);
				} else {
					message += strArray[i];
				}
			}
			
			return message;
		
	}
	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		string = string.replaceAll("-","");

		int result = 0;
		int moduloCheck;
		char lastDigit = string.charAt(9);
		for (int i =0; i < 9; i++) {
			if(!Character.isDigit(string.charAt(i))) {
				return false;
			} else {
				result += ((string.charAt(i) - '0') * (10 -i));
		}
		}
		
		if(lastDigit == 'X') {
			result += 10;
		} else if (Character.isDigit(string.charAt(9))) {
			result += (string.charAt(9) - '0');
		} else {
			return false;
		}

		moduloCheck = result % 11;
		if (moduloCheck == 0) {
			return true;
		} else {
			return false;
		}
	}


	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		
		string.replaceAll("\\s", "");
		
		if(string.isEmpty()) {
			return false;
		}

		HashMap<String,Integer> map = new HashMap<>();
		map.put("a", 0);
		map.put("b", 0);
		map.put("c", 0);
		map.put("d", 0);
		map.put("e", 0);
		map.put("f", 0);
		map.put("g", 0);
		map.put("h", 0);
		map.put("i", 0);
		map.put("j", 0);
		map.put("k", 0);
		map.put("l", 0);
		map.put("m", 0);
		map.put("n", 0);
		map.put("o", 0);
		map.put("p", 0);
		map.put("q", 0);
		map.put("r", 0);
		map.put("s", 0);
		map.put("t", 0);
		map.put("u", 0);
		map.put("v", 0);
		map.put("w", 0);
		map.put("x", 0);
		map.put("y", 0);
		map.put("z", 0);
		
		String[] strArray = string.split("");
		
		for (int i =0; i < strArray.length;i++) {
			if(map.containsKey(strArray[i])) {
				map.put(strArray[i], 1);
				
			}
		}
		
		if(map.containsValue(0)) {
			return false;
		}else {
			return true;
		}
		

	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		
		Temporal result;
		if (given instanceof LocalDate) {
			result = ((LocalDate)given).atStartOfDay().plusSeconds(1000000000);
			return result;
		} else if (given instanceof LocalDateTime) {
			result = ((LocalDateTime)given).plusSeconds(1000000000);
			return result;
			
		}
		
		
		return null;
	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		
		int sum = 0;
		int result = 0;
		
		Set<Integer> newSet = new HashSet<Integer>();
		
		for (int s = 0; s < i; s++) {
			for(int ii = 0; ii < set.length; ii++) {
				sum = s % set[ii];
				if(sum == 0) {
					newSet.add(s);
				
			}
			}
		}
		
		for(int plus : newSet) {
			result += plus;
		}
		return result;
		
	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		
		if (string.contains("-")) {
			return false;
		}
		
		if (string.matches(".*[a-z].*")) {
			return false;
		}
		
		int sum = 0;
		
		string = string.replaceAll("[^0-9]", "");
		String[] strArray = string.split("");
		
		Integer[] intArray = new Integer[strArray.length]; 
		
		for (int i =0; i < strArray.length; i++) {
			intArray[i] = Integer.parseInt(strArray[i]);
		}
		
		for (int i = 1; i < intArray.length;i = i +2) {
			intArray[i] = (intArray[i]) * 2;
			
			if (intArray[i] > 9) {
				intArray[i] = intArray[i] - 9;
			}
		}
		
		for (int i =0; i < intArray.length; i++) {
			
			sum += intArray[i];
		}
		
		if (sum % 10 == 0) {
			return true;
		} else {
			return false;
	}
	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {

		int result = 0;
		
		String plus = "plus";
		String minus = "minus";
		String multiplied = "multiplied";
		String divided = "divided";
		
		Integer[] intArray = new Integer[2];
		
		
		String[] strArray = string.split("[ \\?]");
		for(int i =0; i < strArray.length;i++) {
			if(strArray[i].equals(minus)) {
				intArray[0] = Integer.parseInt(strArray[2]);
				intArray[1] = Integer.parseInt(strArray[strArray.length -1 ]);
				result = intArray[0] - intArray[1];
			} 
			else if(strArray[i].equals(plus)) {
				intArray[0] = Integer.parseInt(strArray[2]);
				intArray[1] = Integer.parseInt(strArray[strArray.length -1 ]);
				result = intArray[0] + intArray[1];
			}
			else if(strArray[i].equals(multiplied)) {
				intArray[0] = Integer.parseInt(strArray[2]);
				intArray[1] = Integer.parseInt(strArray[strArray.length -1 ]);
				result = intArray[0] * intArray[1];
			}
			else if(strArray[i].equals(divided)) {
				intArray[0] = Integer.parseInt(strArray[2]);
				intArray[1] = Integer.parseInt(strArray[strArray.length -1 ]);
				result = intArray[0] / intArray[1];
			}
		}
		return result;
	}
}