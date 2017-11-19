package Percolation;
/******************************************************************************
 *  Compilation:  javac-algs4 Percolation.java
 *  Execution:    java-algs4 Percolation < input.txt
 *
 *  This program reads standard input.
 *
 *    - Reads the grid size n of the percolation system.
 *    - Creates an n-by-n grid of sites (intially all blocked)
 *    - Reads in a sequence of sites (row i, column j) to open.
 *
 *  After each site is opened, it checks if the system is percolated.
 ******************************************************************************/
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private int sizeOfGrid;                   // The Size of grid
    private WeightedQuickUnionUF grid;        // The grid system with top and bottom
    private WeightedQuickUnionUF gridNoBot;  // The grid system with top
    private int numOfGrid;
    private boolean[] gridsystem;             // The grid system
    private int id;                           // The id number based on x y
    private int opennum;                      // Open number


    public Percolation(int n)                 // create n-by-n grid, with all sites blocked
    {
        if (n<=0)                             // Check n value
            throw new IllegalArgumentException ("Not a good grid size!");
        sizeOfGrid = n;
        numOfGrid = sizeOfGrid*sizeOfGrid;    // Calculate the number of grid in the system
        gridsystem = new boolean[numOfGrid];   // Get the System Block
        grid = new WeightedQuickUnionUF(numOfGrid+2); //Establish a grid system with top and bottom
        gridNoBot = new WeightedQuickUnionUF(numOfGrid+1); //Establish a grid system with top
        opennum = 0;                            // Rest this number
    }
    public    void open(int row, int col)    // open site (row, col) if it is not open already
    {
        opennum = opennum+1;
        id = (row-1)*sizeOfGrid+col-1;
        if(gridsystem[id])
        {
            return;
        }
        gridsystem[id] = true;
        if (row == 1)                         // Is in the first line union it with the virtual top
        {
            grid.union(id,numOfGrid);
            gridNoBot.union(id,numOfGrid);
        }
        if (row == sizeOfGrid)
        {
            grid.union(id,numOfGrid+1);     // Is the last line union it with the virtual bottom
        }
        int nextoid;
        if (row > 1)                           // Union the top element
        {
            nextoid = (row-2)*sizeOfGrid+col-1;
            if(gridsystem[nextoid])
            {
                grid.union(id,nextoid);
                gridNoBot.union(id,nextoid);
            }
        }
        if (row < sizeOfGrid)                   // Union the bottom element
        {
            nextoid = row*sizeOfGrid+col-1;
            if(gridsystem[nextoid]) {
                grid.union(id,nextoid);
                gridNoBot.union(id,nextoid);
            }
        }
        if (col > 1)                            // left
        {
            nextoid = (row-1)*sizeOfGrid+col-2;
            if(gridsystem[nextoid]) {
                grid.union(id,nextoid);
                gridNoBot.union(id,nextoid);
            }
        }
        if (col < sizeOfGrid)                            // Right
        {
            nextoid = (row-1)*sizeOfGrid+col;
            if(gridsystem[nextoid]) {
                grid.union(id,nextoid);
                gridNoBot.union(id,nextoid);
            }
        }
    }
    public boolean isOpen(int row, int col)  // is site (row, col) open?
    {
        return gridsystem[(row-1)*sizeOfGrid+col-1];
    }
    public boolean isFull(int row, int col)  // is site (row, col) full?
    {
        return gridNoBot.connected(numOfGrid,((row-1)*sizeOfGrid+col-1));
    }
    public     int numberOfOpenSites()       // number of open sites
    {
        return opennum;
    }
    public boolean percolates()              // does the system percolate?
    {
        return grid.connected(numOfGrid,numOfGrid+1);
    }

    public static void main(String[] args)   // test client (optional)
    {

/*
        Percolation percolation = new Percolation(0);
        Percolation percolation = new Percolation(1);
        percolation.open(0, 1);
        percolation.open(1, 0);
*/

/*
        Percolation percolation = new Percolation(5);
        percolation.open(1, 1);
        percolation.open(1, 2);
        for (int i = 1; i <= 2; i++) {
            for(int j = 1; j <= 2; j++) {
                StdOut.println("" + percolation.isFull(i, j) + " " + percolation.isOpen(i, j));
            }
        }
        StdOut.println("percolation is " + percolation.percolates());
*/
        int n = StdIn.readInt();
        Percolation percolation = new Percolation(n);
        while (!StdIn.isEmpty()) {
            int row = StdIn.readInt();
            int col = StdIn.readInt();
            percolation.open(row, col);
        }
        StdOut.println("percolation is " + percolation.percolates());
    }
}