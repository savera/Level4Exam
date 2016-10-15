import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Anagrams {

	// String[] dictionary = new String[5];

	File dictionary = new File("/Users/league/Documents/workspace/Level4Exam/words.txt");

	public static void main(String[] args) {

		Anagrams ana = new Anagrams();

		System.out.println(ana.dictionary.getAbsolutePath());

		String usersWord = JOptionPane.showInputDialog("What word would you like an anagram for?");

		System.out.println(ana.allTheAnagrams(usersWord));

	}

	public ArrayList<String> allTheAnagrams(String word) {

		ArrayList<String> anagrams = new ArrayList<String>();

		try {

			Scanner scan = new Scanner(dictionary);

			while (scan.hasNextLine()) { // if there is a next line
				
				boolean anagram = true;

				String dictionaryWord = scan.nextLine(); // reading and holding the word
				
				//System.out.println(dictionaryWord);

				//String testWord = "hello";
				
				if (word.length() == dictionaryWord.length()) { // both the words are the same length

					for (int i = 0; i < word.length(); i++) {// goes through each letter

						String letter = word.substring(i, i + 1);
						
						//String testLetter = "o"; 

						if (!(dictionaryWord.contains(letter))) { // if dictionaryWord doesn't contain the letter

							//System.out.println("hello");
							
							anagram = false; // not an anagram

							break;
						}
					}
					if (anagram) {

						anagrams.add(dictionaryWord);

					}
				}
			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		return anagrams;

	}

}
