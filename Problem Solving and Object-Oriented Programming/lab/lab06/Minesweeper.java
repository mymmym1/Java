import java.util.Random;
import java.util.Scanner;
public class Minesweeper {
//Instance variables
    private int rows;
    private int columns;
    public int mines;
    private final boolean[][] mineField;
    private final int[][] clueGrid;
    private boolean[][] checked;    
//Constructor
    public Minesweeper(int rows, int columns, int mines) {        
        this.rows = rows;
        this.columns = columns;
        this.mines = mines;       
        mineField = new boolean[rows][columns];
        clueGrid = new int[rows][columns];
        checked = new boolean[rows][columns];
        generateMinefield(mines);
        generateClueGrid();
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                checked[i][j] = false;
    }    
//Methods
    private void generateMinefield(int mines) {
        for (int i = 0; i < mineField.length; i++)
            for (int j = 0; j < mineField[i].length; j++)
                mineField[i][j] = false;
        Random random = new Random(System.currentTimeMillis()); //?
        int rrow = 0;
        int rcol = 0;
        for (int i = 0; i < mines; i++) { //to install mines. Because i start from mines
            do {
                rrow = random.nextInt(rows); //[0,rows)
                rcol = random.nextInt(columns); 
            } while (mineField[rrow][rcol]); //reference to line 29
            mineField[rrow][rcol] = true;
        }            
    }
    private void generateClueGrid() {
        for (int i = 0; i < clueGrid.length; i++)
            for (int j = 0; j < clueGrid[0].length; j++) {
                if (mineField[i][j] == true)
                    clueGrid[i][j] = -1;
                else
                    clueGrid[i][j] = countMines(i,j);
        }
    }
    private int countMines(int row, int column) {
        int count = 0; //Needs check   
        int i = row;
        int j = column;
        for (int r = Math.max(i-1,0); r <= Math.min(i+1,rows-1); r++)
    //count from the left side of i, but should not smaller than the edge of left;
    //count until the right side of i, but should not larger than the edge of right
            for (int c = Math.max(j-1,0); c <= Math.min(j+1,columns-1); c++) 
                if (!(r == i && c == j)) 
                    if (mineField[r][c] == true) 
                        count++; 
        return count;            
    }
    private void printBoard() {
        System.out.print("   ");
        for (int j = 0; j < columns; j++)
            System.out.print(" " + (j + 1));
        System.out.println();
        
        System.out.print("  +-");
        for (int j = 0; j < columns; j++)
            System.out.print("--");
        System.out.println();
        
        char row_letter = 'A';
        for (int i = 0; i < rows; i++) {            
            System.out.print(row_letter + " |");
            for (int j = 0; j < columns; j++) {
                char cell_symbol;
                if (!checked[i][j])
                    cell_symbol = '?';
                else if (mineField[i][j])
                    cell_symbol = '*';
                else if (clueGrid[i][j] > 0)
                    cell_symbol = (char)('0' + clueGrid[i][j]);
                else
                    cell_symbol = ' ';     
                System.out.print(" " + cell_symbol);
            }           
            System.out.println();
            row_letter++;
        }
    }
    public void start() {        
        Scanner in = new Scanner(System.in);
        boolean win = false;
        while (!win) {
            printBoard();
            System.out.print("Check cell? ");
            String line = in.nextLine().toUpperCase();
            int row = line.charAt(0) - 'A';
            int column = line.charAt(1) - '1';
            if (mineField[row][column])
                break;
            else
                checked[row][column] = true;
            win = true;
            for (int i = 0; i < rows && win; i++)
                for (int j = 0; j < columns && win; i++)
                    if(!checked[i][j] && !mineField[i][j])
                        win = false;
        }
        in.close();  //close scanner      
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++) 
                checked[i][j] = true;
        printBoard();
        if (win)
            System.out.println("\nYou win!");
        else
            System.out.println("\nYou're not very good at this are you?");
    }                
    public static void main(String[] args) {
        Minesweeper m = new Minesweeper(3,3,2);        
        m.start();
    }
}
