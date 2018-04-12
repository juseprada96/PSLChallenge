package lcdchallenge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Handles the input of the program with the desired conditions
 * @author prada
 *
 */
public class Lector {

	public static final String EXIT_TOKEN = "0,0";
	public static final String SPLIT_TOKEN = ",";
	public static final int MAXIMUN_SIZE = 10;
	
	public static void main(String[] args) {
		//Here we handles the IOExceptions
		try {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(isr);
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter out = new BufferedWriter(osw);
		
			String line = in.readLine();
			while (!EXIT_TOKEN.equals(line)) {
				//Here we handle the errors of the inputs
				try {
					//Verify if the line contains a ','
					if (!line.contains(SPLIT_TOKEN)) {
						throw new IllegalArgumentException("There's not ',' in the input");
					}

					String[] arguments = line.split(",");
					//Verify if is there more than 2 arguments
					if (arguments.length > 2) {
						throw new IllegalArgumentException("There are more than three elements in the input \n"
								+ "The expected inputo should be size,number");
					}
					//Verify if the arguments are numeric
					else if (!isNumeric(arguments[0]) || !isNumeric(arguments[0])) {
						throw new NumberFormatException("The size and the number has to be numeric");
					}

					int size = Integer.parseInt(arguments[0]);
					//Verify if the size is between the range
					if (size <= 0 || size > MAXIMUN_SIZE) {
						throw new IllegalArgumentException("The size has to be a number between 1 and 10");
					}
					LCDDisplay display = new LCDSevenSegmentDisplay(arguments[1], size+2, 2*size+3);
					out.write(display.display()+"\n");
					
				} catch (NumberFormatException e) {
					out.write(e.getMessage()+"\n");
				} catch (IllegalArgumentException e) {
					out.write(e.getMessage()+"\n");
				}
				line = in.readLine();
			}
			in.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
			
		} 

	}

	/**
	 * Method used to know if a String its a number or not
	 * 
	 * @param line
	 *            The string to check
	 * @return true if its a number false otherwise
	 */
	private static boolean isNumeric(String line) {
		try {
			@SuppressWarnings("unused")
			int i = Integer.parseInt(line);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

}
