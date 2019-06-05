package com.revature.eval.java.core;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluationService 
{

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) 
	{
		// Step 1: Use length of string to iterate backwards through string (if string is 5 long, loop will be 0 - 4.
				// Step 2: Concatenate each character onto a new string.
				// Step 3: Return the new string. 
		int stringLen = string.length();
		String backwardsString = "";
		
		System.out.println("String len: " + stringLen);
		
		for (int i = stringLen - 1; i >= 0; --i)
		{
			System.out.println("Index is: " + i);
			System.out.println("Value at index: " + backwardsString + string.charAt(i));
			backwardsString = backwardsString + string.charAt(i);
			System.out.println("String so far: " + backwardsString);
			System.out.println();
		}
		
		return backwardsString;
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) 
	{
		String acronym = "";
		String wordArray[] = phrase.split(" ");
		int arrayLength = wordArray.length;
		
		for(String s : wordArray)
		{
			System.out.println("s is: " + s);
			acronym = acronym + s.charAt(0);
			System.out.println("acronym is now: " + acronym);
		}
		acronym.toUpperCase();
		System.out.println(acronym);
		
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
	static class Triangle 
	{
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() 
		{
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) 
		{
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() 
		{
			return sideOne;
		}

		public void setSideOne(double sideOne) 
		{
			this.sideOne = sideOne;
		}

		public double getSideTwo() 
		{
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) 
		{
			this.sideTwo = sideTwo;
		}

		public double getSideThree() 
		{
			return sideThree;
		}

		public void setSideThree(double sideThree) 
		{
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() 
		{
			// TODO Write an implementation for this method declaration
			getSideOne();
			getSideTwo();
			getSideThree();
			
			if ((sideOne == sideTwo) && (sideOne == sideThree))
			{
				System.out.println("All sides are equal!");
				return true;
			}
			else
			{
				System.out.println("All sides are not equal!");
				return false;	
			}
		}

		public boolean isIsosceles() 
		{
			getSideOne();
			getSideTwo();
			getSideThree();
			
			if ((sideOne == sideTwo) || (sideTwo == sideThree) || (sideThree == sideOne))
			{
				return true;
			}
			else
			{
				return false;
			}
		}

		public boolean isScalene() 
		{
			if ((sideOne != sideTwo) && (sideOne != sideThree))
			{
				return true;
			}
			else
			{
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
	public int getScrabbleScore(String string) 
	{
		HashMap<String, Integer>scrabbleStorage = new HashMap<>();
		
		String onePoint[] = {"a", "A" , "e", "E", "i", "I", "o", "O", "u", "U", "l", "L", "n", "N", "r", "R", "s", "S", "t", "T"};
		String twoPoints[] = {"d", "D", "g" ,"G"};
		String threePoints[] = {"b", "B", "c", "C",  "m", "M", "p", "P"};
		String fourPoints [] = {"f", "F", "h", "H", "v", "V", "w", "W", "y", "Y"};
		String fivePoints [] = {"k", "K"};
		String eightPoints[] = {"j" , "J", "x", "X"};
		String tenPoints[] = {"q", "Q", "z", "Z"};
		
		//add onePoint to the map
		int onePointLength = onePoint.length;
		for (int i = 0; i < onePointLength; ++i)
		{
			scrabbleStorage.put(onePoint[i] , 1);
		}
		
		// add twoPoints to the map
		int twoPointsLength = twoPoints.length;
		for (int i = 0; i < 2; ++i)
		{
			scrabbleStorage.put(twoPoints[i] , twoPointsLength);
		}
		
		// add threePoints to the map
		int threePointsLength = threePoints.length;
		for (int i = 0; i < threePointsLength; ++i)
		{
			scrabbleStorage.put(threePoints[i] , 3);
		}
		
		// add FourPoints to the map
		int fourPointsLength = fourPoints.length;
		for (int i = 0; i < fourPointsLength; ++i)
		{
			scrabbleStorage.put(fourPoints[i] , 4);
		}
		
		int fivePointsLength = fivePoints.length;
		for (int i = 0; i < fivePointsLength; ++i)
		{
			scrabbleStorage.put(fivePoints[i] , 5);
		}
		
		
		// add eightPoints to the map
		int eightPointsLength = eightPoints.length;
		for (int i = 0; i < eightPointsLength; ++i)
		{
			scrabbleStorage.put(eightPoints[i] , 8);
		}
		// add tenPoints to the map
		int tenPointsLength = tenPoints.length;
		for (int i = 0; i < tenPointsLength; ++i)
		{
			scrabbleStorage.put(tenPoints[i] , 10);
		}
		
		System.out.println(scrabbleStorage);
		
		int stringLen = string.length();
		int score = 0;
		char letter;
		String word = "";
		for (int i = 0; i < stringLen; ++i)
		{
			letter = string.charAt(i);
			// converts char letter to a string
			String letterToFind = "" + letter;
			word = word + letter;
			//System.out.println(word);
			//System.out.println("The current letter evalu	ates to a score of: " + scrabbleStorage.get(letterToFind));
			score += scrabbleStorage.get(letterToFind);
			//System.out.println("The score total currently is " + score);
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
	public String cleanPhoneNumber(String string)
	{
		StringBuilder dirtyString = new StringBuilder(string);
		System.out.println("Starting String is: " + dirtyString);
		String cleanString = new String("");
		boolean tooLong = false;
		boolean invalidCharPresent = false;
		int stringLen = string.length();
		
		// test for invalid characters
		char nonNumericChars[] = {'!','@','#','$','%','^','&','*', ':', ';'};
		
		char validChars[] = {'0','1','2','3','4','5','6','7','8','9'};
		
		
		// iterate over string to be cleaned
		for (int i = 0; i < stringLen; ++i)
		{
			boolean validChar = false;
			char beingExamined = string.charAt(i);
			System.out.println("Index is: " + i + " and currently iterating over: " + beingExamined);
			
			// check index for membership with necessary characters
			for(int j = 0; j < 10; ++j)
			{
				if (beingExamined == nonNumericChars[j])
				{
					System.out.println("Invalid char found!");
					invalidCharPresent = true;
					break;
				}
				
				if (beingExamined == validChars[j])
				{
					validChar = true;
				}
			}
			
			// if valid char is true, add it to the new string
			if (validChar)
			{
				cleanString = cleanString + beingExamined;
				System.out.println(cleanString);
			}
		}
		
		// test for length
		int cleanLen = cleanString.length();
		System.out.println("Clean len: " + cleanLen);
		if (cleanLen > 11)
		{
			tooLong = true;
		}
		boolean invalidString = (tooLong || invalidCharPresent);
		System.out.println("Invalid string: " + invalidString);
		System.out.println("Too long? " + tooLong);
		System.out.println("Invalid char present? " + invalidCharPresent);
		
		if (invalidString)
		{
			throw new IllegalArgumentException();
		}
		else
		{
			System.out.println("No exceptions! Returning!");
			return cleanString;
		}
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
	public Map<String, Integer> wordCount(String string) 
	{
		HashMap<String, Integer> wordCount = new HashMap<>();
		String wordArray[] = string.split(",| ");
		
		int frequency = 1;
		
		for (String word : wordArray)
		{
			System.out.println("Now testing: " + word);
			if (wordCount.containsKey(word))
			{
				// add 1 to registered key
				System.out.println("We found " + word + " in the map!");
				int newValue = wordCount.get(word) + 1;
				wordCount.put(word, newValue);				
				System.out.println("The key is now: " + word + " and the value is: " + newValue);
			}
			else
			{
				// insert word into array and make key
				System.out.println("We did not find " + word + " in the map!");
				wordCount.put(word, frequency);
				System.out.println("The key is now: " + word + " and the value is: " + frequency);
			}
			
		}
		
		return wordCount;
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
	
	
	// MOVE COMAPRABLE INTO THE GENERIC BRACKETS
	static class BinarySearch<T extends Comparable<T>> 
	{
		private List<T> sortedList;

		public int indexOf(T t) 
		{	
			System.out.println(sortedList);
			int size = sortedList.size();
			int lower = 0;
			int upper = size - 1;
			int mid = (lower + upper) / 2;
			int comparisonResult;
			T valueInMid;
			
			while (lower <= upper)
			{
				mid = (lower + upper) / 2;
				System.out.println("Mid is index " + mid);
				System.out.println("Upper index is: " + upper);
				System.out.println("Lower index is: " + lower);
				valueInMid = sortedList.get(mid);
				comparisonResult = t.compareTo(valueInMid);
				System.out.println("Comparing value in index: " + valueInMid + " and desired result: " + t);
				if (comparisonResult > 0)
				{
					System.out.println(t + " is greater than the value contained in mid, which is " + valueInMid);
					System.out.println("We need to move our lower bound");
					lower = mid + 1;
					System.out.println("Lower bound moved to: " + lower);
					
				}
				else if(comparisonResult < 0)
				{
					System.out.println(t + " is less than the value contained in mid, which is: " + mid);
					System.out.println("We need to move our upper bound");
					upper = mid - 1;
					System.out.println("Upper bound moved to: " + upper);
				}
				// if they are equal
				else
				{
					System.out.println(t + " is equal to the value contained in mid, which is: " + mid);
					return mid;
				}
				
			}
			return 0;
		}

		public BinarySearch(List<T> sortedList) 
		{
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() 
		{
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) 
		{
		
			this.sortedList = sortedList;
		}

		public int compareTo(Object o) 
		{
			
			return 0;
		}

	}


	/**
	 * 8. An Armstrong number is a number that is the sum of its own digits each
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
	public boolean isArmstrongNumber(int input) 
	{
		// AutoBox the integer and convert it to a string
		Integer inputAsObject = new Integer(input);
		String inputAsString = inputAsObject.toString();
		
		// Use inputLen to hold the number of digits our value has
		int inputLen = inputAsString.length();
		//System.out.println(inputLen);
		
		// Convert the temporary string back to an integer
		// Put each element of the string into an array of Integers
		char inputAsCharArray[] = inputAsString.toCharArray();
		int digit;
		int digitRaisedToPower;
		int sumOfRaisedDigits = 0;
		
		for (int i = 0; i < inputLen; ++i)
		{
			 Character singleChar = new Character(inputAsCharArray[i]);
			 digit = singleChar.getNumericValue(singleChar);
			 //System.out.println(digit);
			 digitRaisedToPower = (int) Math.pow(digit, inputLen);
			 //System.out.println(digitRaisedToPower);
			 sumOfRaisedDigits += digitRaisedToPower;
			 System.out.println(sumOfRaisedDigits);
		}
		
		if(sumOfRaisedDigits == input)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * 9. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
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
	public boolean isPangram(String string)
	{
		// TODO Write an implementation for this method declaration
		
		char alphabet[] = {'a', 'b', 'c', 'd','e','f','g','h','i','j','k','l',
		'm','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		int length = string.length();
		char charArray[] = string.toCharArray();
		
		char letterInString;
		char alphabetCharToReplace;
		// this for loop scans through the input, which has been placed in a char array.
		for (int i = 0; i < length; ++i)
		{
			letterInString = charArray[i];
			System.out.println(letterInString);
			
			// iterates through the alphabet array with the current letter
			// replaces the alphabet array index with a zero if that letter is found
			// this should mean a pangram replaces all letters with zeros.
			for (int alphabetIndex = 0; alphabetIndex < 26; ++alphabetIndex)
			{
				alphabetCharToReplace = alphabet[alphabetIndex];
				if (alphabetCharToReplace == letterInString)
				{
					alphabet[alphabetIndex] = '0';
				}
			}

			//System.out.println("The alphaet has been searched. Results: ");
		}
		
		// checks the alphabet array for any remaining letters
		for (int index = 0; index < 26; ++index)
		{
			if (alphabet[index] != '0')
			{
				return false;
			}
		}
		
		return true;
	}

	
	/**
	 * 10. Create an implementation of the rotational cipher, also sometimes called
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
	static class RotationalCipher 
	{
		private int key;

		public RotationalCipher(int key)
		{
			super();
			this.key = key;
		}

		public String rotate(String string) 
		{
			
			HashMap<Character, Integer> defaultPositionLowercase = new HashMap<>();
			HashMap<Character, Integer> defaultPositionUppercase = new HashMap<>();
			
			char lowerAlphabet[] = {'a', 'b', 'c', 'd','e','f','g','h','i','j','k','l',
					'm','n','o','p','q','r','s','t','u','v','w','x','y','z'};
			
			char upperAlphabet[] = {'A', 'B', 'C', 'D', 'E','F','G','H','I','J','K','L','M',
					'N','O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
			
			
			// put alphabet into respective hashMaps
			int positionCounter = 0;
			for (int alphabetIndex = 0; alphabetIndex < 26; ++alphabetIndex)
			{
				defaultPositionLowercase.put(lowerAlphabet[alphabetIndex], positionCounter);
				defaultPositionUppercase.put(upperAlphabet[alphabetIndex], positionCounter);
				++positionCounter;
			}
			
			System.out.println(defaultPositionLowercase);
			System.out.println(defaultPositionUppercase);

			
			// put input into character array
			int inputLen = string.length();
			char inputArray[] = string.toCharArray();
			char inputChar;
			int unmathedKey;
			int mathedKey;
			char cipheredChar;
			boolean nonAlphabetic;
			String cipheredString = "";
			//System.out.println(inputArray);
			
			for (int inputIndex = 0; inputIndex < inputLen; ++inputIndex)
			{
				inputChar = inputArray[inputIndex];
				nonAlphabetic = !(Character.isAlphabetic(inputChar));
				if (Character.isUpperCase(inputChar))
				{
					System.out.println(inputChar + " is uppercase!");
					unmathedKey = defaultPositionUppercase.get(inputChar);
					System.out.println("Unaltered key is: " + unmathedKey);
					mathedKey = (unmathedKey + key) % 26;
					System.out.println("Mathed key is " + mathedKey);
					cipheredChar = upperAlphabet[mathedKey];
					System.out.println("Final Char is: " + cipheredChar);
					cipheredString = cipheredString + cipheredChar;
					System.out.println(cipheredString);
				}
				else if (Character.isLowerCase(inputChar))
				{
					System.out.println(inputChar + " is lowercase!");
					unmathedKey = defaultPositionLowercase.get(inputChar);
					System.out.println("Unaltered key is: " + unmathedKey);
					mathedKey = (unmathedKey + key) % 26;
					System.out.println("Mathed key is " + mathedKey);
					cipheredChar = lowerAlphabet[mathedKey];
					System.out.println("Final Char is: " + cipheredChar);
					cipheredString = cipheredString + cipheredChar;
					System.out.println(cipheredString);
				}
				
				else if (nonAlphabetic)
				{
					cipheredString = cipheredString + inputChar;
				}
			}
			
			return cipheredString;
		}

	}
	

	/**
	 * 11 & 12. Create an implementation of the atbash cipher, an ancient encryption
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
	static class AtbashCipher 
	{

		/**
		 * Question 11
		 * 
		 * @param string
		 * @return
		 * 
		 */
		public static String encode(String string)
		{
			HashMap<Character, Character> mapForAllInputs = new HashMap<>();
			
			char lowerAlphabet[] = {'a', 'b', 'c', 'd','e','f','g','h','i','j','k','l',
					'm','n','o','p','q','r','s','t','u','v','w','x','y','z'};
			
			char upperAlphabet[] = {'A', 'B', 'C', 'D', 'E','F','G','H','I','J','K','L','M',
					'N','O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
			
			// put all possible letters in hashMap.
			int decrementer = 25;
			for (int alphabetIndex = 0; alphabetIndex < 26; ++alphabetIndex)
			{
				mapForAllInputs.put(lowerAlphabet[alphabetIndex], lowerAlphabet[decrementer]);
				mapForAllInputs.put(upperAlphabet[alphabetIndex], lowerAlphabet[decrementer]);
				decrementer--;
				
			}
			
			System.out.println(mapForAllInputs);

			// put input into charArray
			
			int inputLen = string.length();
			char inputArray[] = string.toCharArray();
			char inputChar;
			char cipheredChar;
			boolean alphabetic;
			boolean numeric;
			boolean otherChar;
			String cipheredString = "";
			int group = 0;
			System.out.println(inputArray);
			
			// build the cipheredString
			for (int inputIndex = 0; inputIndex < inputLen; ++inputIndex)
			{
				inputChar = inputArray[inputIndex];
				alphabetic = (Character.isAlphabetic(inputChar));
				numeric = Character.isDigit(inputChar);
				otherChar = !(alphabetic || numeric);
				
				if (alphabetic)
				{
					System.out.println(inputChar + " is alphabetic!");
					cipheredChar = mapForAllInputs.get(inputChar);
					//System.out.println(cipheredChar + " is the key for " + inputChar);
					cipheredString += cipheredChar;
					System.out.println("cipheredString: " + cipheredString);
				}
				else if (numeric)
				{
					System.out.println(inputChar + " is numeric!");
					cipheredChar = inputChar;
					cipheredString += cipheredChar;
				}
				else if (otherChar)
				{
					System.out.println(inputChar + " is neither alphabetic nor numeric");
					System.out.println("cipheredString: " + cipheredString);
				}
				else
				{
					System.out.println(inputChar + " is something else you haven't accounted for!");
					System.out.println("cipheredString: " + cipheredString);
				}
			}
			
			// insert spaces where necessary
			int cipheredLen = cipheredString.length();
			String finalString = "";
			char addChar;
			for (int i = 0; i < cipheredLen; ++i)
			{
				System.out.println(cipheredString.charAt(i) + " is char " + group + " in the string");
				if (group == 5)
				{
					finalString += ' ';
					group = 0;
				}
				addChar = cipheredString.charAt(i);
				finalString += addChar;
				System.out.println(finalString);
				group++;
			}
			
			return finalString;
		}
		
	
		

		/**
		 * Question 12
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) 
		{
			// remove all spaces from input
			int stringLen = string.length();
			char inputChar;
			String noSpaces = "";
			for (int i = 0; i < stringLen; ++i)
			{
				inputChar = string.charAt(i);
				if (inputChar == ' ')
				{
					continue;
				}
				else
				{
					noSpaces += inputChar;
				}
				System.out.println("Building noSpace string! " + noSpaces);
			}
			
			
			// initialize map to decode
			char lowerAlphabet[] = {'a', 'b', 'c', 'd','e','f','g','h','i','j','k','l',
					'm','n','o','p','q','r','s','t','u','v','w','x','y','z'};
			
			HashMap<Character, Character> decoder = new HashMap<>();
			int decrementer = 25;
			for (int alphabetIndex = 0; alphabetIndex < 26; ++alphabetIndex)
			{
				decoder.put(lowerAlphabet[alphabetIndex], lowerAlphabet[decrementer]);
				decrementer--;
			}
			System.out.println(decoder);
			
			
			// take values from noSpace string and decode them
			int noSpaceLen = noSpaces.length();
			char encodedChar;
			char decodedChar;
			boolean alphabetic;
			boolean numeric;
			boolean otherChar;
			String decodedString = "";
			
			for (int i = 0; i < noSpaceLen; ++i)
			{
				encodedChar = noSpaces.charAt(i);
				alphabetic = (Character.isAlphabetic(encodedChar));
				numeric = Character.isDigit(encodedChar);
				otherChar = !(alphabetic || numeric);
				
				if (alphabetic)
				{
					System.out.println(encodedChar + " is alphabetic!");
					System.out.println(encodedChar);
					decodedChar = decoder.get(encodedChar);
					System.out.println("Encoded char is: " + encodedChar + " and decoded char is: " + decodedChar);
					decodedString += decodedChar;
					System.out.println("Decoded string so far: " + decodedString);
					
				}
				else if (numeric)
				{
					System.out.println(encodedChar + " is numeric!");
					decodedChar = encodedChar;
					decodedString += decodedChar;
					System.out.println("Decoded string so far: " + decodedString);
					
				}
				else if (otherChar)
				{
					System.out.println(encodedChar + " is neither numeric nor alphabetic!");
				}
				else
				{
					System.out.println(encodedChar + "is something else you haven't accounted for!");
				}
				
				
				
			}
			
			return decodedString;
		}
	
	}
	/**
	 * 13. (Optional) The ISBN-10 verification process is used to validate book identification
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
	public boolean isValidIsbn(String string) 
	{
		// TODO Write an implementation for this method declaration
		return false;
	}


	/**
	 * 14. (Optional) Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) 
	{
		// TODO Write an implementation for this method declaration
		return null;
	}

	
	/**
	 * 15. (Optional) Parse and evaluate simple math word problems returning the answer as an
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
	public int solveWordProblem(String string) 
	{
		// TODO Write an implementation for this method declaration
		return 0;
	}

}
