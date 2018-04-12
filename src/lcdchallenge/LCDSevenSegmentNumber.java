package lcdchallenge;

/**
 * 
 * @author prada
 *
 */
public class LCDSevenSegmentNumber implements LCDCharacter {

	public final static char HORIZONTAL = '-';
	public final static char VERTICAL = '|';
	private String[] rows;
	private int width;
	private int height;
	
	
	
	public LCDSevenSegmentNumber(int width, int height) {
		super();
		rows = new String[height];
		this.width = width;
		this.height = height;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public String getRow(int row) throws IndexOutOfBoundsException {
		if(row<0 || row>height) {
			throw new IndexOutOfBoundsException("The value of the row is not in the range");
		}
		return rows[row];
	}

	@Override
	public void setRow(int row, String str) throws IndexOutOfBoundsException {
		if(row<0 || row>height) {
			throw new IndexOutOfBoundsException("The value of the row is not in the range");
		}
		rows[row] = str;
		
	}

}
