package caveExplorer;

public class TwoDArrayPractice {
	
	public static void main(String[] args) {
		String[][] pic = new String[6][10];
		for(int row = 0; row < pic.length; row++) {
			for(int col = 0; col < pic[row].length; col++) {
				pic[row][col] = " ";
			}
		}
		//drawHorizontalLine(pic,1);
		//drawHorizontalLine(pic,3);
		//drawHorizontalLine(pic,5);
		//drawVerticalLine(pic, 2);
		drawBox(pic,4,5);
		print(pic);
	}
	/**
	 * Box looks like this
	 * 		___
	 * 		|*|
	 * 		|_|
	 * 
	 * but the * marks the coordinates of the box
	 * CATCH: No ArrayIndexOutOfBoundsException
	 * but draw any portion of the box that does fit on the "canvas"
	 * @param pic
	 * @param i
	 * @param j
	 */
	private static void drawBox(String[][] pic, int row, int col) {
		drawSlot(pic,row,col);
		drawSlot(pic, row + 1, col);
		drawIfInBounds("_",pic,row + 1,col);
		for(int j = col - 1; j <= col + 1; j++) {
			drawIfInBounds("_", pic, row - 1, j);
		}
	}
	

	private static void drawIfInBounds(String string, String[][] pic, int row, int col) {
		// SPECIAL NOTE: Always check row before column
		//(IOW, check row exists before checking if a column exists in the row)
		if(row >= 0 && row < pic.length && col >= 0 && col < pic[row].length) {
			pic[row][col] = string;
		}
		
	}
	/**
	 * A slot looks like this:
	 * 		| |
	 * It is two vertical lines with a space between them
	 * The coordinates, row, col are the coordinates of the space
	 * In other words, a slot is a vertical line in front of row,col and after row,col
	 * CATCH: No ArrayIndexOutOfBoundExceptions
	 * @param pic
	 * @param i
	 * @param j
	 */
	private static void drawSlot(String[][] pic, int row, int col) {
		if(row >= 0 && row < pic.length) {
			if(col > 0) {
				pic[row][col - 1] = "|";
			}
			if(col < pic[row].length - 1) {
				pic[row][col + 1] = "|";
			}
		}
	}

	private static void drawVerticalLine(String[][] pic, int col) {
		for(int row = 0; row < pic.length; row++) {
			pic[row][col] = "|";
		}
	}

	private static void drawHorizontalLine(String[][] pic, int row) {
		for(int col = 0; col < pic[row].length; col++) {
			pic[row][col] = "-";
		}
	}

	/**
	 * prints contents of pic, row by row
	 * NO BRACKETS OR COMMAS
	 * @param pic
	 */
	private static void print(String[][] pic) {
		String result = "";
		for(int row = 0; row < pic.length; row++) {
			for(int col = 0; col < pic[row].length; col++) {
				result += pic[row][col] + "";
			}
			result += "\n";
		}
		System.out.println(result);
	}
	
}
