import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private WeightedQuickUnionUF uf;
    private WeightedQuickUnionUF uf_back;
    private int num, num_up, num_down, num_left, num_right;
    private int NN;
    private boolean[] arrayOpen;

    public Percolation(int NN)                // create n-by-n grid, with all sites blocked
    {
        this.NN   = NN;
        uf        = new WeightedQuickUnionUF((NN+1)*NN+NN+1);
        uf_back   = new WeightedQuickUnionUF(NN*NN+NN+1);
        arrayOpen = new boolean[(NN+1)*(NN)+NN+1];

        for (int i=1; i<=NN; i++){
            uf.union(0*NN+1, 0*NN+i);
            uf_back.union(0*NN+1, 0*NN+i);
            arrayOpen[0*NN+i] = true;
            uf.union((NN+1)*NN+1, (NN+1)*NN+i);
            arrayOpen[(NN+1)*NN+i] = true;
        }
    }

    public    void open(int row, int col)    // open site (row, col) if it is not open already
    {
        if (row <= 0 || row > NN)   throw new IndexOutOfBoundsException("row index "+row+" out of bounds");
        if (col <= 0 || col > NN)   throw new IndexOutOfBoundsException("col index "+col+" out of bounds");
        if (arrayOpen[row*NN+col])  return;

        arrayOpen[row*NN+col] = true;

        num = (row-1)*NN+col;                // Get open id-number
                                             // Get open id-number up, down, left and right id-number
        if (row==1)  {num_up = num;}
        else         {num_up = (row-1-1)*NN+col;}
        if (row==NN) {num_down = num;}
        else         {num_down = (row-1+1)*NN+col;}
        if (col==1)  {num_left = num;}
        else         {num_left = (row-1)*NN+col-1;}
        if (col==NN) {num_right = num;}
        else         {num_right = (row-1)*NN+col+1;}










        WeightedQuickUnionUF.union(num,num_up);

    }
    //public boolean isOpen(int row, int col)  // is site (row, col) open?
    //public boolean isFull(int row, int col)  // is site (row, col) full?
    //public     int numberOfOpenSites()       // number of open sites
    //public boolean percolates()              // does the system percolate?

    //public static void main(String[] args)   // test client (optional)
}
