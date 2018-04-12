package lcdchallenge;

/**
 * This class handles the display of several LCDCharacters
 * @author prada
 *
 */
public class LCDSevenSegmentDisplay implements LCDDisplay {

	public final static int DEFAULT_SPACE=0;
	private int width;
	private int height;
	private String str;
	private LCDCharacter[] characters;
	
	/**
	 * Create a new Seven Segment Display with the desired
	 * characters
	 * @param str The string to be parsed to LCDSevenDisplay
	 * @param characterWidth The width of the Segments
	 * @param heigth the height of the Segments
	 */
	public LCDSevenSegmentDisplay(String str, int characterWidth, int height) {
		this.width=characterWidth;
		this.height=height;
		this.str = str;
		characters = new LCDCharacter[str.length()];
		initializeCharacters(str, characterWidth, height);
	}
	
	/**
	 * Creates all the LCDCharacters for the display
	 * @param str the string that form the desired number
	 * @param width the width of the LCDCharacters
	 * @param height the height of the LCDCharacters
	 */
	private void initializeCharacters(String str,int width, int height) {
		SevenSegmentNumberFactory segmentNumberFactory = new SevenSegmentNumberFactory();
		for(int i=0;i<str.length();i++) {
			char actual = str.charAt(i);
			LCDCharacter character = segmentNumberFactory.createCharacter(actual, height, width);
			characters[i] = character;
		}
	}
	
	@Override
	public String display() {
		StringBuilder str = new StringBuilder();
		for(int h=0;h<height;h++) {
			for(int i=0;i<characters.length;i++) {
				LCDCharacter character = characters[i];
				String row = character.getRow(h);
				str.append(row);
				for(int j=0;j<DEFAULT_SPACE;j++) {
					str.append(" ");
				}
			}
			str.append("\n");
		}
		return str.toString();
	}

	@Override
	public int characterCount() {
		if(characters==null) {
			return 0;
		}
		return characters.length;
	}

	@Override
	public int size() {
		int size = characterCount()*width+ characterCount()*DEFAULT_SPACE;
		return size;
	}

	@Override
	public LCDDisplay append(String str) {
		StringBuilder newStr = new StringBuilder();
		newStr.append(this.str);
		newStr.append(str);
		LCDDisplay newDisplay = new LCDSevenSegmentDisplay(newStr.toString(), width, height);
		return newDisplay;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	

}
