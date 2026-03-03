
class Canvas
{
    int height = 0;
    int width = 0;
    int[][] canvas ;
    
    Canvas( int cell_gap )
    {
        this.height = ( 3*cell_gap ) + 1;
	    this.width = ( 2*cell_gap ) + 1 ;
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
                System.out.print( this.canvas[i][j] + " ")  ;
                j = j + 1;
                
                if(j==width)
                {
                    System.out.println() ;
                }
            }
            i = i + 1 ;
        }
        
    }
    
    void drawChar( char given )
    {
        int intValue = (int)( given ) ; int index = 0;
        
        /*array of arrays that store required segments*/
        Seg[][] segments = {
            
            /*first 10 arrays for 0-9*/
            /*then 26 arrays for A-Z */
            /*finally 26 arrays for a-z*/ 
        }; 
        
        if( intValue>=(int)('0') && intValue<=(int)('9') )
        {
            index = intValue - (int)('0') ;
            
        }
        else if( intValue>=(int)('A') && intValue<=(int)('Z') )
        {
            index = intValue - (int)('A') ;
            
        }
        else if( intValue>=(int)('a') && intValue<=(int)('z') )
        {
            index = intValue - (int)('a') ;
            
        }
        else
        {
            System.out.println("invalid character !") ;    
        }
        
        for( Seg segment : segments[index] )
        {
            segment.turnON() ;
        }
    }
}

abstract class Seg
{
    Canvas parent ;
    int len = 0;
    
    Seg( Canvas p, int l )
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
    
    StandingSeg( Canvas p, int l, int col , int x_s )
    {
        super( p, l ) ;
        this.column = col;
        this.x_start = x_s;
    }
    
    @Override
    void turnON()
    {
        int k = 0;
        while( k<this.len && (this.x_start + k < this.parent.height)  )
        {
            //(this.parent)[k][this.column] = 1;
            //(this.parent)[this.x_start + k][this.column] = 1;
            
            (this.parent.canvas)[this.x_start + k][this.column] = 1;
            
            k = k + 1 ;
        }
    }
}

class SleepingSeg extends Seg
{
    int row = 0;   int y_start = 0;
    
    SleepingSeg( Canvas p, int l, int r , int y_s )
    {
        super( p, l ) ;
        this.row = r;
        this.y_start = y_s;
    }
    
    @Override
    void turnON()
    {
        int k = 0;
        while( k<this.len && (this.y_start + k < this.parent.width) )
        {
            //(this.parent)[this.row][k] = 1;
            //(this.parent)[this.row][ this.y_start + k] = 1;
            
            (this.parent.canvas)[this.row][ this.y_start + k] = 1;
            
            k = k + 1 ;
        }
    }
}

class DiagonalSeg extends Seg
{
    int x_start = 0;   int y_start = 0;
    
    DiagonalSeg( Canvas p, int l, int x_s, int y_s )
    {
        super( p, l ) ;
        this.x_start = x_s ;
        this.y_start = y_s ;
    }
    
    @Override
    void turnON()
    {
        int k = 0;
        while( 
            k<this.len 
            && (this.x_start + k < this.parent.height) 
            && (this.y_start + k < this.parent.width)
            )
        {
            //(this.parent)[this.x_start + k][this.y_start + k] = 1;
            
            (this.parent.canvas)[this.x_start + k][this.y_start + k] = 1;
            k = k + 1 ;
        }
    }
}

class SlantingSeg extends Seg
{
    int x_start = 0;   int y_start = 0;
    
    SlantingSeg( Canvas p, int l, int x_s, int y_s )
    {
        super( p, l ) ;
        this.x_start = x_s ;
        this.y_start = y_s ;
    }
    
    @Override
    void turnON()
    {
        int k = 0;
        while( 
            k<this.len 
            && (this.x_start + k < this.parent.height) 
            && (this.y_start - k >= 0)   
            )
        {
            //refers to upper point out of the two
            (this.parent.canvas)[this.x_start + k][this.y_start - k] = 1;
            k = k + 1 ;
        }
    }
}

public class Main
{
    //move the printMat method to Canvas class
	public static void main(String[] args) 
	{
	    int size = 3 ; //some integer>2
	    
	    Canvas canvas = new Canvas( size ) ;
	    
	    /*StandingSeg st1 = new StandingSeg( canvas, 10, 1, 2 ) ;
	    st1.turnON() ;
	    */
	    
	    char given = 'A' ;
	    canvas.drawChar( given ) ;
	    
	    //canvas.printMat() ;
		
	}
}
