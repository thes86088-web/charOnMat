
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
        //Seg( parent, len ) ;
        super( parent, len ) ;
        //first call in child constructor must be for parent constructor
        this.column = column;
        this.x_start = x_start;
    }
    
    //add override decorator to ensure polymmorphism success
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

public class Main
{
	public static void main(String[] args) {
	    int size = 3 ; //some integer>2
	    int height = (3*size) + 1;
	    int width = (2*size) + 1 ;
	    int canvas[][] = new int[height][width] ;
		
	}
}
