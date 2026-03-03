
abstract class Seg
{
    int parent[][] ;
    int len = 0;
    
    Seg( int p[][], int l )
    {
        //shorten the parameter names
        this.parent = p ;
        this.len = l ;
    }
    
    abstract void turnON() ;
    //abstract comes before void
}

class Canvas
{
    int height = 0;
    int width = 0;
    int[][] canvas ;
    
    Canvas( int cell_gap )
    {
        this.height = (3*size) + 1;
	    this.width = (2*size) + 1 ;
	    this.canvas = new int[this.height][this.width] ;
    }
    
    //adding printMat as method eliminates the need for parameters
    void printMat( )
    {
        int i = 0; int j = 0;
        while(i<this.height)
        {
            j = 0;
            while(j<this.width)
            {
                System.out.print( mat[i][j] + " ")  ;
                j = j + 1;
                
                if(j==width)
                {
                    System.out.println() ;
                }
            }
            i = i + 1 ;
        }
        
    }
    
    
}

class StandingSeg extends Seg
{
    int column = 0;   int x_start = 0;
    
    StandingSeg( int p[][], int l, int col , int x_s )
    {
        super( p, l ) ;
        this.column = col;
        this.x_start = x_s;
    }
    
    @Override
    void turnON()
    {
        int k = 0;
        while( k<this.len )
        {
            //(this.parent)[k][this.column] = 1;
            (this.parent)[this.x_start + k][this.column] = 1;
            
            k = k + 1 ;
        }
    }
}

class SleepingSeg extends Seg
{
    int row = 0;   int y_start = 0;
    
    SleepingSeg( int p[][], int l, int r , int y_s )
    {
        super( p, l ) ;
        this.row = r;
        this.y_start = y_s;
    }
    
    @Override
    void turnON()
    {
        int k = 0;
        while( k<this.len )
        {
            //(this.parent)[this.row][k] = 1;
            (this.parent)[this.row][ this.y_start + k] = 1;
            
            k = k + 1 ;
        }
    }
}

class DiagonalSeg extends Seg
{
    int x_start = 0;   int y_start = 0;
    
    DiagonalSeg( int p[][], int l, int x_s, int y_s )
    {
        super( p, l ) ;
        this.x_start = x_s ;
        this.y_start = y_s ;
    }
    
    @Override
    void turnON()
    {
        int k = 0;
        while( k<this.len )
        {
            (this.parent)[this.x_start + k][this.y_start + k] = 1;
            k = k + 1 ;
        }
    }
}

class SlantingSeg extends Seg
{
    int x_start = 0;   int y_start = 0;
    
    SlantingSeg( int p[][], int l, int x_s, int y_s )
    {
        super( p, l ) ;
        this.x_start = x_s ;
        this.y_start = y_s ;
    }
    
    @Override
    void turnON()
    {
        int k = 0;
        while( k<this.len )
        {
            (this.parent)[this.x_start + k][this.y_start - k] = 1;
            k = k + 1 ;
        }
    }
}

public class Main
{
    //move the printMat method to Canvas class
	public static void main(String[] args) {
	    int size = 3 ; //some integer>2
	    
	    StandingSeg st1 = new StandingSeg( canvas, height, 1, 2 ) ;
	    st1.turnON() ;
	    
	    printMat(canvas, height, width) ;
		
	}
}
