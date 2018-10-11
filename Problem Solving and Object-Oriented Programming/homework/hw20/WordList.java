import java.util.ArrayList;
 
public class WordList {
	private ArrayList<String> wordList;
//	private int size = 0;
	
	/**
	 * Initialize this word list object
	 */
	public WordList() {
		// TODO Add your code here
		ArrayList<String> wordList = new ArrayList<String>();
	}
 
	/**
	 * Add a word to this word list
	 * 
	 * @param word
	 *            The word to add
	 */
	public void add(String word) {
		// TODO Add your code here		
		if (wordList == null) {
			ArrayList<String> newList = new ArrayList<String>(1);
			newList.add(word);
			wordList = newList;
		}
		else wordList.add(word);		
	}
 
	/**
	 * Remove the first occurrence of the specified word from this word list
	 * 
	 * @param word
	 *            The word to remove
	 * @return true if word was removed and the list was modified,
	 *         false otherwise.
	 */
	public boolean remove(String word) {
		// TODO Add your code here
		if (wordList.size() == 0)
			System.out.println("Can't remove anything in an empty list!");
		else {
			for (int i = 0; i < wordList.size(); i++) 
				if (wordList.get(i).equals(word)) {
					wordList.remove(i);					
					return true;	//find first and break out of loop				
				}			
		}
		return false;
	}
 
	/**
	 * Test whether this list contains the specified word or not
	 * 
	 * @param word
	 *            The word to search for
	 * @return true if word exists in the list, false otherwise.
	 */
	public boolean contains(String word) {
		// TODO Add your code here
		for (int i = 0; i < wordList.size(); i++) {
			if (wordList.get(i).equals(word))
				return true;			
		}
		return false;
	}
 
	/**
	 * Remove all words from this word list
	 */
	public void clear() {
		// TODO Add your code here

		wordList.clear(); 
	}
 
	/**
	 * Return a reference to the wordList ArrayList
	 * 
	 * @return the wordList ArrayList
	 */
	public ArrayList<String> getWordList() {
		return wordList;
	}
 
	/**
	 * Calculate the average length of words in this word list. If the list is
	 * empty, return 0
	 * 
	 * @return The average length of words in the list, or 0 in case of an empty
	 *         list
	 */
	public double getAverageWordLength() {
		// TODO Add your code here
		double sum = 0.0;
		double avg = 0.0;
		if (wordList == null || wordList.size() == 0)
			return 0.0;
		else {
			for (String s : wordList) 
				sum += s.length();				 
			avg = sum / wordList.size();
		}
		return avg;
	}
 
	/**
	 * Count the number of occurrences of the specified word in this list
	 * 
	 * @param word
	 *            The word to search for
	 * @return The number of occurrences of this word in the list
	 */
	public int countOccurrences(String word) {
		// TODO Add your code here
		int count = 0;
		for (int i = 0; i < wordList.size(); i++)			
			if (wordList.get(i).equals(word))
				count++;
		return count;
	}
 
	/**
	 * Replace all occurrences of one word with another
	 * 
	 * @param oldWord
	 *            The word to be replaced
	 * @param newWord
	 *            The new word to replace all occurrences of old one
	 */
	public void replaceAll(String oldWord, String newWord) {		
		// TODO Add your code here		
		if (wordList == null || wordList.size() == 0)
			return;
		for (int i = 0; i < wordList.size(); i++) {		
			if (wordList.get(i).equals(oldWord)) {
	            wordList.remove(i);
	            wordList.add(i, newWord);
		    }		
	    }
    }
}
