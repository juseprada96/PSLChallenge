package lcdchallenge;

/**
 * 
 * @author prada
 *
 */
public interface LCDCharacter {

	/**
	 * The value of the width is equal to
	 * the length of the String in the row's
	 * @return The width of the LCDCharacter
	 */
	public int getWidth();
	
	/**
	 * The value of the height is equal to
	 * the number of rows in the character
	 * @return The heigth of the LCDCharacter
	 */
	public int getHeight();
	
	/**
	 * 
	 * @param row the position of the row in the LCDCharacter to return
	 * @return returns the row at the specified position
	 * @throws IndexOutOfBoundsException if the number if out of range of the rows
	 */
	public String getRow(int row) throws IndexOutOfBoundsException;
	
	/**
	 * 
	 * @param row the position of the row in the LCDCharacter to set
	 * @throws IndexOutOfBoundsException if the number if out of range of the rows
	 */
	public void setRow(int row, String str) throws IndexOutOfBoundsException;
	
	
}
