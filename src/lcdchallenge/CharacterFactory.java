package lcdchallenge;

/**
 * 
 * @author prada
 *
 */
public interface CharacterFactory {

	
	/**
	 * Creates a LCDCharacter with the desired character
	 * @param character the character that will be encoded to the selected type
	 * @param hegiht of the character
	 * @param width of the character
	 * @return the specified character with the specified type of display
	 * @exception if the arguments doesn't match with the specifications
	 */
	public LCDCharacter createCharacter(char character, int height, int width) throws IllegalArgumentException;
	
	
}
