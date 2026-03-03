
abstract class Seg
{
    int parent[][] ;
    int len = 0;
    
    Seg( int parent[][], int len )
    {
        this.parent = parent ;
        this.len = len ;
    }
    
    abstract void turnON() ;
    //abstract comes before void
}

class StandingSeg extends Seg
{
    int column = 0;   int x_start = 0;
    
    StandingSeg( int parent[][], int len, int column , int x_start )
    {
        super( parent, len ) ;
        this.column = column;
        this.x_start = x_start;
    }
    
    @Override
    void turnON()
    {
        int k = 0;
        while( k<this.len )
        {
            (this.parent)[k][this.column] = 1;
            k = k + 1 ;
        }
    }
}


class SleepingSeg extends Seg
{
    int row = 0;   int y_start = 0;
    
    SleepingSeg( int parent[][], int len, int row , int y_start )
    {
        super( parent, len ) ;
        this.row = row;
        this.y_start = y_start;
    }
    
    @Override
    void turnON()
    {
        int k = 0;
        while( k<this.len )
        {
            (this.parent)[this.row][k] = 1;
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
