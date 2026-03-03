
class Canvas
{
    int size = 0 ;
    int height = 0; int width = 0;
    int[][] canvas ;
    
    Canvas( int cell_gap )
    {
        this.size = cell_gap ;
        this.height = ( 3*cell_gap ) ;
	    this.width = ( 2*cell_gap ) ;
	    this.canvas = new int[this.height][this.width] ;
    }
    
    //adding printMat as method eliminates the need for parameters
    void printCanvas( )
    {
        int i = 0; int j = 0;
        while(i<this.height)
        {
            j = 0;
            while(j<this.width)
            {
                System.out.print( ( this.canvas[i][j] == 1 ? "*" : " " ) + " ")  ;
                j = j + 1;
                
                if(j==width)
                {
                    System.out.println() ;
                }
            }
            i = i + 1 ;
        }
        
    }
    
    void resetCanvas( )
    {
        int i = 0; int j = 0;
        while(i<this.height)
        {
            j = 0;
            while(j<this.width)
            {
                this.canvas[i][j] = 0  ;
                j = j + 1;
                
            }
            i = i + 1 ;
        }
    }
    
    void setCanvas( )
    {
        int i = 0; int j = 0;
        while(i<this.height)
        {
            j = 0;
            while(j<this.width)
            {
                this.canvas[i][j] = 1  ;
                j = j + 1;
                
            }
            i = i + 1 ;
        }
    }
    
    void toggleCanvas( )
    {
        int i = 0; int j = 0;
        while(i<this.height)
        {
            j = 0;
            while(j<this.width)
            {
                this.canvas[i][j] = ( this.canvas[i][j] == 1 ? 0 : 1 )  ;
                j = j + 1;
                
            }
            i = i + 1 ;
        }
    }
    
    void drawChar( char given )
    {
        int intValue = (int)( given ) ; int index = 0;
        
        Premade template = new Premade( this ) ;
       
        template.createTemplates() ;
        Seg[][] segments = template.result ; 
        /*array of arrays that store required segments*/
        
        if( intValue>=(int)('0') && intValue<=(int)('9') )
        {
            index = intValue - (int)('0') ;
            
        }
        else if( intValue>=(int)('A') && intValue<=(int)('Z') )
        {
            index = 10 + intValue - (int)('A') ;
            /*       \
                    first ten indexes allocated for digits
                
            */
        }
        else if( intValue>=(int)('a') && intValue<=(int)('z') )
        {
            index = 10 + 26 + intValue - (int)('a') ;
            /*            \
                    upcoming twenty-six indexes allocated for capital Alphabets
            */
        }
        else
        {
            System.out.println("invalid character !") ;    
        }
        
        Seg[] requiredSeg = segments[index] ; 
        for( Seg segment : requiredSeg )
        {
            segment.turnON() ;
        }
    }
}

class Premade 
{
    Canvas target;
    int mid = 0;
    int tri = 0; int tri_fold = 0;
    int max_x = 0; int max_y = 0;
    Seg[][] result ;
    Seg[] components;
    
    Premade( Canvas t )
    {
        this.target = t ;
        this.mid = this.target.width / 2 ;
        this.tri = this.target.height / 3 ;
        this.tri_fold = 2*(this.tri) ; 
        this.max_y = this.target.width - 1 ;
        this.max_x = this.target.height - 1 ;
    }
    
    void createTemplates()
    {
        int size = this.target.size ;
        
        Seg st0 = new StandingSeg( this.target, size, 0, 0 ) ;
        Seg st1 = new StandingSeg( this.target, size, 0, this.tri ) ;
        Seg st2 = new StandingSeg( this.target, size, 0, this.tri_fold ) ;
        
        Seg st3 = new StandingSeg( this.target, size, this.mid, 0 ) ;
        Seg st4 = new StandingSeg( this.target, size, this.mid, this.tri ) ;
        Seg st5 = new StandingSeg( this.target, size, this.mid, this.tri_fold ) ;
        
        Seg st6 = new StandingSeg( this.target, size, this.max_y, 0 ) ;
        Seg st7 = new StandingSeg( this.target, size, this.max_y, this.tri ) ;
        Seg st8 = new StandingSeg( this.target, size, this.max_y, this.tri_fold ) ;
        
        Seg sl0 = new SleepingSeg( this.target, size, 0, 0 ) ;
        Seg sl1 = new SleepingSeg( this.target, size, 0, this.mid ) ;
        
        Seg sl2 = new SleepingSeg( this.target, size, this.tri, 0 ) ;
        Seg sl3 = new SleepingSeg( this.target, size, this.tri, this.mid ) ;
        
        Seg sl4 = new SleepingSeg( this.target, size, this.tri_fold, 0 ) ;
        Seg sl5 = new SleepingSeg( this.target, size, this.tri_fold, this.mid ) ;
        
        Seg sl6 = new SleepingSeg( this.target, size, this.max_x, 0 ) ;
        Seg sl7 = new SleepingSeg( this.target, size, this.max_x, this.mid ) ;
        
        Seg d0 = new DiagonalSeg( this.target, size, 0, 0 ) ;
        Seg d1 = new DiagonalSeg( this.target, size, 0 , this.mid ) ;
        
        Seg d2 = new DiagonalSeg( this.target, size, this.tri , 0 ) ;
        Seg d3 = new DiagonalSeg( this.target, size, this.tri , this.mid ) ;
        
        Seg d4 = new DiagonalSeg( this.target, size, this.tri_fold , 0 ) ;
        Seg d5 = new DiagonalSeg( this.target, size, this.tri_fold , this.mid ) ;
        
        Seg sn0 = new SlantingSeg( this.target, size, 0, this.mid ) ;
        Seg sn1 = new SlantingSeg( this.target, size, 0, this.max_y ) ;
        
        Seg sn2 = new SlantingSeg( this.target, size, this.tri, this.mid ) ;
        Seg sn3 = new SlantingSeg( this.target, size, this.tri, this.max_y ) ;
        
        Seg sn4 = new SlantingSeg( this.target, size, this.tri_fold, this.mid ) ;
        Seg sn5 = new SlantingSeg( this.target, size, this.tri_fold, this.max_y) ;
        
        Seg dot = new StandingSeg( this.target, 1, mid, 0 );
       
       Seg[] tempComponents = {
        st0, st1, st2, st3, st4, st5, st6, st7,
        sl0, sl1, sl2, sl3, sl4, sl5, sl6, sl7,
        d0, d1, d2, d3, d4, d5,
        sn0, sn1, sn2, sn3, sn4, sn5   
       } ;
       
       this.components = tempComponents ;
        
        Seg[] segForZero = {
            st0, st1, st3, st4,       
            sl0, sl2, sl4,
        };
        
        Seg[] segForOne = {
            st1, st4
        };
        
        Seg[] segForTwo = {
            st1, st3,       
            sl0, sl2, sl4,
        };
        
        Seg[] segForThree = {
            st1, st4,       
            sl0, sl2, sl4,
        };
        
        Seg[] segForFour = {
            st0, st1, st4,       
            sl2,
        };
        
        Seg[] segForFive = {
            st0, st4,       
            sl0, sl2, sl4,
        };
        
        Seg[] segForSix = {
            st0, st3, st4,       
            sl0, sl2, sl4,
        };
        
        Seg[] segForSeven = {
            st1, st4,       
            sl0,
        };
        
        Seg[] segForEight = {
            st0, st1, st3, st4,       
            sl0, sl2, sl4,
        };
        
        Seg[] segForNine = {
            st0, st1, st4,       
            sl0, sl2, sl4,
        };
        
        Seg[] segForA = {
            st0, st2, st3, st5,       
            sl0, sl1, sl2, sl3,
        };
        
        Seg[] segForLowerA = {
            st3, st4,       
            sl2, sl4, sl5
        };
        
        Seg[] segForB = {
            st0, st3,       
            sl0, sl1, sl2, sl4, sl5,
            d3,
            sn1,
        };
        
        Seg[] segForLowerB = {
            st0, st3, st4,       
            sl2, sl4,
        };
        
        Seg[] segForC = {
            st0, st3,       
            sl0, sl1, sl4, sl5,
        };
        
        Seg[] segForLowerC = {
            st3,       
            sl2, sl4,
        };
        
        Seg[] segForD = {
            st1, st2, st4, st5,       
            sl0, sl1, sl4, sl5,
        };
        
        Seg[] segForLowerD = {
            st2, st4, st5,       
            sl3, sl5,
        };
        
        Seg[] segForE = {
            st0, st3,       
            sl0, sl1, sl2, sl3, sl4, sl5
        };
        /*
        Seg[] segForLowerE = {
            st0, st1, st3,       
            sl0, sl2, sl4,
        };
        */
        Seg[] segForLowerE = {
            st3,       
            sl2, sl4,
            sn2
        };
        
        Seg[] segForF = {
            st0, st3,       
            sl0, sl1, sl2, sl3
        };
        
        Seg[] segForLowerF = {
            st0, st3,       
            sl0, sl2
        };
        
        Seg[] segForG = {
            st0, st3,        
            sl0, sl1, sl4, sl5,
            d3
        };
        
        Seg[] segForLowerG = {
            st4, st5, st8,       
            sl3, sl5, sl7,
            sn5
        };
        
        Seg[] segForH = {
            st0, st2, st3, st5,       
            sl2, sl3
        };
        
        Seg[] segForLowerH = {
            st0, st3, st4,       
            sl2
        };
        
        Seg[] segForI = {
            st1, st4,      
            sl0, sl1, sl4, sl5
        };
        
        Seg[] segForLowerI = {
            st4, 
            dot
        };
        
        Seg[] segForJ = {
            st1, st4,       
            sl0, sl1, sl4
        };
        
        Seg[] segForLowerJ = {
            st4, st7,       
            sl6, 
            sn4,
            dot
        };
        
        Seg[] segForK = {
            st0, st3,       
            sl2,
            d3,
            sn1
        };
        
        Seg[] segForLowerK = {
            st0, st3,      
            sl2,
            d2
        };
        
        Seg[] segForL = {
            st0, st3,      
            sl4, sl5,
        };
        
        /* Seg[] segForLowerL = {
            st0, st3,     
            sl4
        };
        */
        
        Seg[] segForLowerL = {
            st0, d2
        };
        
        
        Seg[] segForM = {
            st0, st2, st3, st5,
            d0,
            sn1
        };
        
        Seg[] segForLowerM = {
            st3, st4, st5,      
            sl2, sl3
        };
        
        Seg[] segForN = {
            st0, st2, st3, st5,   
            d0, d3
        };
        
        Seg[] segForLowerN = {
            st3, st4,       
            sl2 
        };
        
        Seg[] segForO = {
            st0, st2, st3, st5,       
            sl0, sl1, sl4, sl5,
        };
        
        Seg[] segForLowerO = {
            st3, st4,    
            sl2, sl4,
        };
        
        Seg[] segForP = {
            st0, st2, st3,       
            sl0, sl1, sl2, sl3
        };
        
        Seg[] segForLowerP = {
            st3, st4, st6,      
            sl2, sl4
        };
        
        Seg[] segForQ = {
            st0, st1, st3, st4,    
            sl0, sl2, sl4,
            d3,
            sn2
        };
        
        Seg[] segForLowerQ = {
            st3, st4, st7,      
            sl2, sl4,
            sn5
        };
        
        Seg[] segForR = {
            st0, st2, st3,      
            sl0, sl1, sl2, sl3, 
            d3 
        };
        
        Seg[] segForLowerR = {
            st4,    
            sn3,
        };
        
        Seg[] segForS = {
            st0, st5,   
            sl0, sl1, sl2, sl3, sl4, sl5,
        };
        
        Seg[] segForLowerS = {
            sl2, sl4,
            d2
        };
        
        Seg[] segForT = {
            st1, st4,      
            sl0, sl1
        };
        
        Seg[] segForLowerT = {
            st1, st4,      
            sl2, sl3, sl5,
        };
        
        Seg[] segForU = {
            st0, st2, st3, st5,      
            sl4, sl5
        };
        
        Seg[] segForLowerU = {
            st3, st4,  
            sl4, sl5
        };
        
        Seg[] segForV = {
            st0, st2,      
            d2, 
            sn3
        };
        
        Seg[] segForLowerV = {
            d2, 
            sn3
        };
        
        Seg[] segForW = {
            st0, st1, st2, st3, st4, st5,       
            sl4, sl5
        };
        
        Seg[] segForLowerW = {
            st3, st4, st5,      
            sl4, sl5
        };
        
        Seg[] segForX = {
            d0, d3,
            sn1, sn2
        };
        
        Seg[] segForLowerX = {
            d2, 
            sn2
        };
        
        Seg[] segForY = {
            st4,   
            d0,
            sn1
        };
        
        Seg[] segForLowerY = {
            st4, st5, st8,       
            sl5, sl7,
            sn5
        };
        
        Seg[] segForZ = {
            sl0, sl1, sl4, sl5,
            sn1, sn2
        };
        
        Seg[] segForLowerZ = {
            sl3, sl5, 
            sn3
        };
        
        Seg[][] temp = {
            segForZero, segForOne, segForTwo, segForThree, segForFour, 
            segForFive, segForSix, segForSeven, segForEight, segForNine,
            
            segForA, segForB, segForC, segForD, segForE, segForF,
            segForG, segForH, segForI, segForJ, segForK, segForL,
            segForM, segForN, segForO, segForP, segForQ, segForR,
            segForS, segForT, segForU, segForV, segForW, segForX,
            segForY, segForZ,

            segForLowerA, segForLowerB, segForLowerC, segForLowerD, 
            segForLowerE, segForLowerF, segForLowerG, segForLowerH, 
            segForLowerI, segForLowerJ, segForLowerK, segForLowerL,
            segForLowerM, segForLowerN, segForLowerO, segForLowerP, 
            segForLowerQ, segForLowerR, segForLowerS, segForLowerT, 
            segForLowerU, segForLowerV, segForLowerW, segForLowerX,
            segForLowerY, segForLowerZ
            /*first 10 arrays for 0-9*/
            /*then 26 arrays for A-Z */
            /*finally 26 arrays for a-z*/ 
        } ;
        
        this.result = temp ;
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
    
    abstract void turnOFF() ;
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
    
    
    @Override
    void turnOFF()
    {
        int k = 0;
        while( k<this.len && (this.x_start + k < this.parent.height)  )
        {
            //(this.parent)[k][this.column] = 1;
            //(this.parent)[this.x_start + k][this.column] = 1;
            
            (this.parent.canvas)[this.x_start + k][this.column] = 0;
            
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
    
    
    @Override
    void turnOFF()
    {
        int k = 0;
        while( k<this.len && (this.y_start + k < this.parent.width) )
        {
            //(this.parent)[this.row][k] = 1;
            //(this.parent)[this.row][ this.y_start + k] = 1;
            
            (this.parent.canvas)[this.row][ this.y_start + k] = 0;
            
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
    
    @Override
    void turnOFF()
    {
        int k = 0;
        while( 
            k<this.len 
            && (this.x_start + k < this.parent.height) 
            && (this.y_start + k < this.parent.width)
            )
        {
            (this.parent.canvas)[this.x_start + k][this.y_start + k] = 0;
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
    
    @Override
    void turnOFF()
    {
        int k = 0;
        while( 
            k<this.len 
            && (this.x_start + k < this.parent.height) 
            && (this.y_start - k >= 0)   
            )
        {
            //refers to upper point out of the two
            (this.parent.canvas)[this.x_start + k][this.y_start - k] = 0;
            k = k + 1 ;
        }
    }
}

public class Main
{
	public static void main(String[] args) 
	{
	    int size = 3 ; //some integer>2
	    
	    Canvas canvas = new Canvas( size ) ;
	    
	    Premade template = new Premade( canvas ) ;
	    
	    Seg[] comps = template.components;
	    // System.out.println( comps ); --> null
	    
	    
	    /*char[] supportedCharSet =  {
	        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
            'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
	    };
	    */
	     
	    /*for( char given : supportedCharSet )
	    {
	        canvas.drawChar( given ) ;
	    
	        canvas.printCanvas() ;
	        System.out.println(); System.out.println();
	    }*/
	    
	    int count = 0; 
	    /*while( count < 30 )
	    {   
	        if( count < 9 )
	        {   System.out.println( "standing " + count );
	        }
	        else if( count < 17 )
	        {   System.out.println( "sleeping " + (17 - count)  );
	        }
	        else if( count < 23 )
	        {   System.out.println( "diagonal" + (23-count) );
	        }
	        else if( count < 29 )
	        {   System.out.println( "slanting" + (29 - count) );
	        }
	        else {
	            System.out.println( "dot" + count );
	        }
	        System.out.println();
	        
	        comps[count].turnON() ;
	        canvas.printCanvas() ;
	        comps[count].turnOFF() ;
	        canvas.resetCanvas() ;
	        System.out.println(); System.out.println();
	        count = count + 1 ;
	    }*/
	}
}
