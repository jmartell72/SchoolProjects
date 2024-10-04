package com.main;

public class Search {

	static int numberOfCharacters = 256;

	// Gets the maximum of two integers as an easy utility function
	private static int max(int a, int b) {
		return (Math.max(a, b));
	}

	/*Preprocessor for the bad character heuristic; it will generate all the ASCII
	 characters to be able to use a pattern search*/
	private static void badCharHeuristic(char[] letters, int size, int[] badCharacter) {
		//        Starts off all ASCII values at -1 to make sure it will write
		for (int i = 0; i < numberOfCharacters; i++) {
			badCharacter[i] = -1;
		}

		//        Uses the pattern length and values to populate the badCharacter index for searching
		for (int i = 0; i < size; i++) {
			badCharacter[letters[i]] = i;
		}
	}

    // public call in order to hide the full method function
	public static void search(char[] text, char[] pattern) {
		search1(text, pattern);
	}

	//    Pattern searching function that uses bad Character of Boyer Moore
	private static void search1(char[] text, char[] pattern) {
		//Length of the two arrays in order to know how long to search
		int m = pattern.length;
		int n = text.length;

		//Creates a new array and sets it to the ASCII max
		int[] badCharacter = new int[numberOfCharacters];

		// Feeds the preprocessor the pattern array, the pattern arrays length, and the amount of ASCII characters
		badCharHeuristic(pattern, m, badCharacter);

		// Create the shift
		int shift = 0;

		//        there are n-m+1 alignments
		while (shift <= (n - m)) {
			//            creates a new counter that is one less than pattern length
			int j = m - 1;

			//            Keep recycling while characters of patter and text are matching at this shift
			while (j >= 0 && pattern[j] == text[shift + j]) {
				j--;
			}

			//            Once we arrive at the end of j (end of one less than the pattern length) return pattern found
			if (j < 0) {
				System.out.println("Pattern located on index: " + shift);

                /* This will shift the pattern so the next character in text will align with the lost occurrence in
                the pattern. text[s+m] is the character after the pattern and s+m < n is needed if the pattern is found
                near the end
                 */
				shift += (shift + m < n) ? m - badCharacter[text[shift + m]] : 1;
			} else {
                /*This will shift the pattern so the bad character aligns with its last occurrence. Max is used to
                guarantee a positive shift
                 */
				shift += max(1, j - badCharacter[text[shift + j]]);
			}


		}
	}

}