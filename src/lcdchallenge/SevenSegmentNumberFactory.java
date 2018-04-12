package lcdchallenge;

/**
 * Create with the desired configuration an LCDSevenSegmentNumber
 * @author prada
 *
 */
public class SevenSegmentNumberFactory implements CharacterFactory {

	/**
	 * Constants for the sections of a segment
	 */
	public final static char A = 'A';
	public final static char B = 'B';
	public final static char C = 'C';
	public final static char D = 'D';
	public final static char E = 'E';
	public final static char F = 'F';
	public final static char G = 'G';

	@Override
	public LCDCharacter createCharacter(char character, int height, int width) throws IllegalArgumentException {
		// The segment represents the format of LCD7Segment
		boolean[][] segment = initializeSegment(character);
		int sectionHeight = (height - 3) / 2;
		int sectionWidth = width - 2;
		LCDCharacter newCharacter = new LCDSevenSegmentNumber(width, height);
		StringBuilder str;
		int actualRow = 0; // The representation of a row in the LCDCharacter

		for (int i = 0; i < segment.length; i++) {
			// The 0,2 and 4 lines are static and not affected by the height
			if (i % 2 == 0) {
				str = new StringBuilder();
				// true represents that the segment is on
				// The white spaces in the 0 and 2 columns are not affected by
				// the width
				str.append(" "); // the column 0
				for (int w = 0; w < sectionWidth; w++) {

					if (segment[i][1]) {
						str.append(LCDSevenSegmentNumber.HORIZONTAL);
					} else {
						str.append(" ");
					}
				}
				str.append(" ");// the column 2
				newCharacter.setRow(actualRow, str.toString());
				actualRow++;
			}
			// the 1 and 3 lines are affected by the height and the width
			else {
				// This loop is for increasing the number of rows-height
				for (int h = 0; h < sectionHeight; h++) {
					str = new StringBuilder();
					// true represents that the segment is on
					if (segment[i][0]) {
						str.append(LCDSevenSegmentNumber.VERTICAL);
					} else {
						str.append(" ");
					}
					for (int w = 0; w < sectionWidth; w++) {
						str.append(" ");
					}
					if (segment[i][2]) {
						str.append(LCDSevenSegmentNumber.VERTICAL);
					} else {
						str.append(" ");
					}
					newCharacter.setRow(actualRow, str.toString());
					actualRow++;
				}
			}
		}

		return newCharacter;
	}

	/**
	 * Initialize the segment with the format of the number function as a metaphor
	 * of a real LCD7Segment display
	 * 
	 * @param character
	 *            the character that is wanted to form
	 * @return an boolean[][] with the format of the number
	 * @throws IllegalArgumentException
	 *             if the character it's not supported
	 */
	private boolean[][] initializeSegment(char character) throws IllegalArgumentException {
		boolean[][] segment = new boolean[5][3];
		switch (character) {
		case '0':
			switchState(segment, A);
			switchState(segment, B);
			switchState(segment, C);
			switchState(segment, D);
			switchState(segment, E);
			switchState(segment, F);
			break;
		case '1':
			switchState(segment, B);
			switchState(segment, C);
			break;
		case '2':
			switchState(segment, A);
			switchState(segment, B);
			switchState(segment, D);
			switchState(segment, E);
			switchState(segment, G);
			break;
		case '3':
			switchState(segment, A);
			switchState(segment, B);
			switchState(segment, C);
			switchState(segment, D);
			switchState(segment, G);
			break;
		case '4':
			switchState(segment, B);
			switchState(segment, C);
			switchState(segment, F);
			switchState(segment, G);
			break;
		case '5':
			switchState(segment, A);
			switchState(segment, C);
			switchState(segment, D);
			switchState(segment, F);
			switchState(segment, G);
			break;
		case '6':
			switchState(segment, A);
			switchState(segment, C);
			switchState(segment, D);
			switchState(segment, E);
			switchState(segment, F);
			switchState(segment, G);
			break;
		case '7':
			switchState(segment, A);
			switchState(segment, B);
			switchState(segment, C);
			break;
		case '8':
			switchState(segment, A);
			switchState(segment, B);
			switchState(segment, C);
			switchState(segment, D);
			switchState(segment, E);
			switchState(segment, F);
			switchState(segment, G);
			break;
		case '9':
			switchState(segment, A);
			switchState(segment, B);
			switchState(segment, C);
			switchState(segment, D);
			switchState(segment, F);
			switchState(segment, G);
			break;
		default:
			throw new IllegalArgumentException("The character is not supported");
		}
		return segment;

	}

	/**
	 * This method switch on or off the sections of the segment function as a
	 * metaphor of a real LCD7Segment display<br/>
	 * A its the upper led<br/>
	 * B its the upper left led<br/>
	 * C its the bottom left led<br/>
	 * D its the bottom led </br>
	 * E its the bottom right led</br>
	 * F its the upper right led</br>
	 * G its the middle led</br>
	 * 
	 * @param segment
	 *            the segment of display
	 * @param section
	 *            the section of the segment that is mean to be switch
	 * @throws IllegalArgumentException
	 *             if the character doesn't represent a section
	 */
	private void switchState(boolean[][] segment, char section) throws IllegalArgumentException {
		switch (section) {
		case A:
			segment[0][1] = !segment[0][1];
			break;
		case B:
			segment[1][2] = !segment[1][2];
			break;
		case C:
			segment[3][2] = !segment[2][2];
			break;
		case D:
			segment[4][1] = !segment[2][1];
			break;
		case E:
			segment[3][0] = !segment[2][0];
			break;
		case F:
			segment[1][0] = !segment[1][0];
			break;
		case G:
			segment[2][1] = !segment[2][1];
			break;
		default:
			throw new IllegalArgumentException("The character is doesn't represent a section");

		}
	}

}
