public class Minesweeper {
	/**
	 * The mine field grid
	 */
	private boolean[][] mineField;
 
	/**
	 * The clue numbers grid, giving the number of mines in neighboring cells
	 */
	private int[][] clueGrid;
 
	/**
	 * A grid of booleans indicating whether each cell has been checked yet
	 */
	private boolean[][] checked;
 
	private int rows;
	private int columns;
 
	/**
	 * Construct a new Minesweeper game
	 * 
	 * @param mineField
	 *            The mine field; Each cell would be true, representing a mine
	 *            at that corresponding location, or false, representing any
	 *            empty location
	 */
	public Minesweeper(boolean[][] mineField) {
		// Initialize instance variables
		this.mineField = mineField;
		this.rows = mineField != null ? mineField.length : 0;
		this.columns = (mineField != null && mineField[0] != null) ? mineField[0].length
				: 0;
 
		// Build the clue grid
		buildClueGrid();
 
		// Initialize checked grid
		this.checked = new boolean[rows][columns];
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < columns; j++)
				checked[i][j] = false;
	}
 
	/**
	 * Build the clue grid and set each cell of it to the number of mines
	 * surrounding that cell in the mine field, or -1 if the cell contains a
	 * mine.
	 */
	private void buildClueGrid() {
		this.clueGrid = new int[rows][columns];
 
		// for each cell, count the mines around it
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < columns; j++)
				clueGrid[i][j] = mineField[i][j] ? -1 : countMines(i, j);
	}
 
	/**
	 * Count the number of mines surrounding a cell
	 * 
	 * @param row
	 *            The cell row
	 * @param column
	 *            The cell column
	 * @return the number of mines surrounding the specified cell
	 */
	private int countMines(int row, int column) {
		int n = 0;
		for (int i = Math.max(row - 1, 0); i <= Math.min(row + 1, rows - 1); i++)
			for (int j = Math.max(column - 1, 0); j <= Math.min(column + 1,
					columns - 1); j++)
				if (!(i == row && j == column))
					n += mineField[i][j] ? 1 : 0;
		return n;
	}
 
	/**
	 * Returns a string representation of the current status of the game
	 * ? - unchecked cells
	 * # - checked cells with 1-8 surrounding mines
	 * * - checked cells with a mine
	 * _ - checked cells with 0 surrounding mines
	 */
	public String printBoard() {
		String grid = "";
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (!checked[i][j]) {
					grid += "?";
				} else if (clueGrid[i][j] > 0) {
					grid += clueGrid[i][j];
				} else if (mineField[i][j]) {
					grid += "*";
				} else { // clue is zero or something weird
					grid += "_"; // print a space
				}
			}
			grid += "\n";
		}
		return grid;
	}
 
	/**
	 * Check a cell and update the checked grid accordingly. Note that when a
	 * cell has 0 mines surrounding it, the unchecked neighbors can be also
	 * (RECURSIVELY) safely checked since none will contain a mine.
	 * 
	 * @param row
	 *            The row of the cell to reveal
	 * @param column
	 *            The column of the cell to reveal
	 * 
	 * @returns false if this is a mine cell, true otherwise
	 */
	public boolean checkCell(int row, int column) {
		// TODO Implement this method
		checked[row][column] = true;
		if (mineField[row][column] == true) 
			return false;
		else if (countMines(row, column) == 0) {
            for (int i = Math.max(row - 1, 0); i <= Math.min(row + 1, rows - 1); i++)
			    for (int j = Math.max(column - 1, 0); j <= Math.min(column + 1, columns - 1); j++)
				    if (!(i == row && j == column) && checked[i][j] == false)
					    checkCell(i, j);
		}			
		return true;	
	}
}
