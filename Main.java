
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
	public static void main(String[] args) {
	    int size = 3 ; //some integer>2
	    int height = (3*size) + 1;
	    int width = (2*size) + 1 ;
	    int canvas[][] = new int[height][width] ;
		
	}
}
