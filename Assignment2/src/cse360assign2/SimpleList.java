package cse360assign2;
/**
 * Assignment 1
 * 
 * The SimpleList class creates an array of size 10
 * to store a list of integers.
 * 
 * @author	Jerimiah Kent (174)
 * @version 1.0
 * @since	2/5/2019
 * 
 */
public class SimpleList {
	private int count;
	private int[] list;
	
	/**
	 * Class constructor
	 */
	public SimpleList() {
		count = 0;
		list = new int[10];
	}
	
	/**
	 * This method adds an integer to the beginning of the list.
	 * If the list is full, the last integer in the list is removed.
	 * 
	 * @param value	an integer being added to the list
	 */
	public void add(int value) {
		for ( int index = 9; index >= 1; index -- ) {
			list[index] = list[index-1];
		}
		list[0] = value;
		if ( count != 10 ) {
			count ++;
		}
	}
	
	/**
	 * This method removes the first found instance of the provide 
	 * integer from the list.
	 * 
	 * @param value	an integer value to be removed from the list
	 */
	public void remove(int value) {
		int found = this.search(value);
		if (found != -1) {
			for( int index = this.search(value); index <= 8; index ++) {
				list[index] = list[index + 1];
			}
			count --;
		}
	}
	
	/**
	 * Returns the size of the list.
	 * 
	 * @return		the size of the list
	 */
	public int count() {
		return count;
	}
	
	/**
	 * Returns the elements of the list as a single String.
	 * 
	 * @return 		the String representation of the list
	 */
	public String toString() {
		String liststring = "";
		for (int index = 0; index <= count - 1; index ++) {
			liststring = liststring + Integer.toString(list[index]) + " ";
		}
		return liststring.trim();
	}
	
	/**
	 * Returns the index where the integer was found. If an
	 * integer is not found, then -1 is returned.
	 * 
	 * @param value	the integer being searched for
	 * @return		the index of the search, -1 if not found
	 */
	public int search(int value) {
		int location = -1;
		for (int index = 9; index >= 0; index --) {
			if (list[index] == value) {
				location = index;
			}
		}
		return location;
	}
}