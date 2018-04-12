package lcdchallenge;

/**
 * 
 * @author prada
 *
 */
public interface LCDDisplay {
	
	/**
	 * 
	 * @return The String that will display the desired characters
	 */
	public String display();
	
	/**
	 * 
	 * @return The number of characters that are part of the display
	 */
	public int characterCount();
	
	/**
	 * Is calculated as the length of the concatenated Strings of all
	 * LCDCharacters
	 * @return the length of the concatenated Strings
	 */
	public int size();
	
	/**
	 * Appends a string to the actual string to the LCDDisplay<br/>
	 * creates a new LCDDisplay with the old string and the new to append
	 * @param str the string to append
	 * @return LCDDisplay with the appended string
	 */
	public LCDDisplay append(String str);
	
}
