package cse360assign2;
/**
 * Assignment 2
 * 
 * The SimpleList class creates an array of size 10
 * to store a list of integers.
 * 
 * Make modifications to SimpleList (Assignment1)
 * 
 * @author	Jerimiah Kent (174)
 * @version 1.1
 * @since	2/27/2019
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
	 * If the list is full, increase the size of the list by 50%.
	 * 
	 * @param value	an integer being added to the list
	 */
	public void add(int value) {
		int arrLen = 0;
		if (count == list.length) {
			arrLen = (int) ((list.length) * 1.5);
		}
		else {
			arrLen = list.length;
		}
		int[] tmplist = new int[arrLen];
		for ( int index = 0; index < count; index ++ ) {
			tmplist[index + 1] = list[index];
		}
		tmplist[0] = value;
		count++;
		list = tmplist;//replace the old list with the new list
	}
	
	/**
	 * This method removes the first found instance of the provide 
	 * integer from the list.
	 * 
	 * If the list is >=25% empty, reduce the size of the list.
	 * 
	 * @param value	an integer value to be removed from the list
	 */
	public void remove(int value) {
		int found = this.search(value);
		int arrlen = 0;
		if (found != -1) {
			if (list.length > (int)(count * 1.25)) {
				arrlen = (int)(list.length * 0.75);
			}
			else {
				arrlen = list.length - 1;
			}
			int[] tmplist = new int[arrlen];
			for( int index = this.search(value); index <= count - 2; index ++) {
				tmplist[index] = list[index + 1];
			}
			count --;
			list = tmplist;
		}
	}
	
	/**
	 * Returns the count of the list.
	 * 
	 * @return		the number of items in the list
	 */
	public int count() {
		return count;
	}

	/**
	 * Returns the length of the list.
	 * 
	 * @return		the size of the list
	 */	
	public int size() {
		//needed this method for JUnit 
		//test of reducing the size of the array by 25%
		return list.length;
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
		for (int index = list.length - 1; index >= 0; index --) {
			if (list[index] == value) {
				location = index;
			}
		}
		return location;
	}
}