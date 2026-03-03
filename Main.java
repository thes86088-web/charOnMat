
class Canvas
{
    int height = 0;
    int width = 0;
    int[][] canvas ;
    
    Canvas( int cell_gap )
    {
        this.height = ( 3*cell_gap ) ;
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
        
        Premade template = new Premade( this ) ;
        
        /*array of arrays that store required segments*/
        Seg[][] segments = {
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
        }; 
        
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
        
        for( Seg segment : segments[index] )
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
    int max_h = 0; int max_w = 0;
    
    Premade( Canvas t )
    {
        this.target = t ;
        this.mid = this.target.width / 2 ;
        this.tri = this.target.height / 3 ;
        this.tri_fold = 2*(this.tri) ; 
        this.max_y = this.target.width - 1 ;
        this.max_x = this.target.height - 1 ;
    }
    
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
    
    
    Seg[] segForZero = {
        st0, st1, st2, st3, st4, st5, st6, st7, st8, st9,       
        sl0, sl1, sl2, sl3, sl4, sl5, sl6, sl7,
        d0, d1, d2, d3, d4, d5,
        sn0, sn1, sn2, sn3, sn4, sn5
    };
    
    Seg[] segForOne = {
        st0, st1, st2, st3, st4, st5, st6, st7, st8, st9,       
        sl0, sl1, sl2, sl3, sl4, sl5, sl6, sl7,
        d0, d1, d2, d3, d4, d5,
        sn0, sn1, sn2, sn3, sn4, sn5
    };
    
    Seg[] segForTwo = {
        st0, st1, st2, st3, st4, st5, st6, st7, st8, st9,       
        sl0, sl1, sl2, sl3, sl4, sl5, sl6, sl7,
        d0, d1, d2, d3, d4, d5,
        sn0, sn1, sn2, sn3, sn4, sn5
    };
    
    Seg[] segForThree = {
        st0, st1, st2, st3, st4, st5, st6, st7, st8, st9,       
        sl0, sl1, sl2, sl3, sl4, sl5, sl6, sl7,
        d0, d1, d2, d3, d4, d5,
        sn0, sn1, sn2, sn3, sn4, sn5
    };
    
    Seg[] segForFour = {
        st0, st1, st2, st3, st4, st5, st6, st7, st8, st9,       
        sl0, sl1, sl2, sl3, sl4, sl5, sl6, sl7,
        d0, d1, d2, d3, d4, d5,
        sn0, sn1, sn2, sn3, sn4, sn5
    };
    
    Seg[] segForFive = {
        st0, st1, st2, st3, st4, st5, st6, st7, st8, st9,       
        sl0, sl1, sl2, sl3, sl4, sl5, sl6, sl7,
        d0, d1, d2, d3, d4, d5,
        sn0, sn1, sn2, sn3, sn4, sn5
    };
    
    Seg[] segForSix = {
        st0, st1, st2, st3, st4, st5, st6, st7, st8, st9,       
        sl0, sl1, sl2, sl3, sl4, sl5, sl6, sl7,
        d0, d1, d2, d3, d4, d5,
        sn0, sn1, sn2, sn3, sn4, sn5
    };
    
    Seg[] segForSeven = {
        st0, st1, st2, st3, st4, st5, st6, st7, st8, st9,       
        sl0, sl1, sl2, sl3, sl4, sl5, sl6, sl7,
        d0, d1, d2, d3, d4, d5,
        sn0, sn1, sn2, sn3, sn4, sn5
    };
    
    Seg[] segForEight = {
        st0, st1, st2, st3, st4, st5, st6, st7, st8, st9,       
        sl0, sl1, sl2, sl3, sl4, sl5, sl6, sl7,
        d0, d1, d2, d3, d4, d5,
        sn0, sn1, sn2, sn3, sn4, sn5
    };
    
    Seg[] segForNine = {
        st0, st1, st2, st3, st4, st5, st6, st7, st8, st9,       
        sl0, sl1, sl2, sl3, sl4, sl5, sl6, sl7,
        d0, d1, d2, d3, d4, d5,
        sn0, sn1, sn2, sn3, sn4, sn5
    };
    
    
    Seg[] segForA = {
        st0, st1, st2, st3, st4, st5, st6, st7, st8, st9,       
        sl0, sl1, sl2, sl3, sl4, sl5, sl6, sl7,
        d0, d1, d2, d3, d4, d5,
        sn0, sn1, sn2, sn3, sn4, sn5
    };
    
    Seg[] segForLowerA = {
        st0, st1, st2, st3, st4, st5, st6, st7, st8, st9,       
        sl0, sl1, sl2, sl3, sl4, sl5, sl6, sl7,
        d0, d1, d2, d3, d4, d5,
        sn0, sn1, sn2, sn3, sn4, sn5
    };
    
    
    Seg[] segForB = {
        st0, st1, st2, st3, st4, st5, st6, st7, st8, st9,       
        sl0, sl1, sl2, sl3, sl4, sl5, sl6, sl7,
        d0, d1, d2, d3, d4, d5,
        sn0, sn1, sn2, sn3, sn4, sn5
    };
    
    Seg[] segForLowerB = {
        st0, st1, st2, st3, st4, st5, st6, st7, st8, st9,       
        sl0, sl1, sl2, sl3, sl4, sl5, sl6, sl7,
        d0, d1, d2, d3, d4, d5,
        sn0, sn1, sn2, sn3, sn4, sn5
    };
    
    Seg[] segForC = {
        st0, st1, st2, st3, st4, st5, st6, st7, st8, st9,       
        sl0, sl1, sl2, sl3, sl4, sl5, sl6, sl7,
        d0, d1, d2, d3, d4, d5,
        sn0, sn1, sn2, sn3, sn4, sn5
    };
    
    Seg[] segForLowerC = {
        st0, st1, st2, st3, st4, st5, st6, st7, st8, st9,       
        sl0, sl1, sl2, sl3, sl4, sl5, sl6, sl7,
        d0, d1, d2, d3, d4, d5,
        sn0, sn1, sn2, sn3, sn4, sn5
    };
    
    Seg[] segForD = {
        st0, st1, st2, st3, st4, st5, st6, st7, st8, st9,       
        sl0, sl1, sl2, sl3, sl4, sl5, sl6, sl7,
        d0, d1, d2, d3, d4, d5,
        sn0, sn1, sn2, sn3, sn4, sn5
    };
    
    Seg[] segForLowerD = {
        st0, st1, st2, st3, st4, st5, st6, st7, st8, st9,       
        sl0, sl1, sl2, sl3, sl4, sl5, sl6, sl7,
        d0, d1, d2, d3, d4, d5,
        sn0, sn1, sn2, sn3, sn4, sn5
    };
    
    Seg[] segForE = {
        st0, st1, st2, st3, st4, st5, st6, st7, st8, st9,       
        sl0, sl1, sl2, sl3, sl4, sl5, sl6, sl7,
        d0, d1, d2, d3, d4, d5,
        sn0, sn1, sn2, sn3, sn4, sn5
    };
    
    Seg[] segForLowerE = {
        st0, st1, st2, st3, st4, st5, st6, st7, st8, st9,       
        sl0, sl1, sl2, sl3, sl4, sl5, sl6, sl7,
        d0, d1, d2, d3, d4, d5,
        sn0, sn1, sn2, sn3, sn4, sn5
    };
    
    Seg[] segForF = {
        st0, st1, st2, st3, st4, st5, st6, st7, st8, st9,       
        sl0, sl1, sl2, sl3, sl4, sl5, sl6, sl7,
        d0, d1, d2, d3, d4, d5,
        sn0, sn1, sn2, sn3, sn4, sn5
    };
    
    Seg[] segForLowerF = {
        st0, st1, st2, st3, st4, st5, st6, st7, st8, st9,       
        sl0, sl1, sl2, sl3, sl4, sl5, sl6, sl7,
        d0, d1, d2, d3, d4, d5,
        sn0, sn1, sn2, sn3, sn4, sn5
    };
    
    Seg[] segForG = {
        st0, st1, st2, st3, st4, st5, st6, st7, st8, st9,       
        sl0, sl1, sl2, sl3, sl4, sl5, sl6, sl7,
        d0, d1, d2, d3, d4, d5,
        sn0, sn1, sn2, sn3, sn4, sn5
    };
    
    Seg[] segForLowerG = {
        st0, st1, st2, st3, st4, st5, st6, st7, st8, st9,       
        sl0, sl1, sl2, sl3, sl4, sl5, sl6, sl7,
        d0, d1, d2, d3, d4, d5,
        sn0, sn1, sn2, sn3, sn4, sn5
    };
    
    Seg[] segForH = {
        st0, st1, st2, st3, st4, st5, st6, st7, st8, st9,       
        sl0, sl1, sl2, sl3, sl4, sl5, sl6, sl7,
        d0, d1, d2, d3, d4, d5,
        sn0, sn1, sn2, sn3, sn4, sn5
    };
    
    Seg[] segForLowerH = {
        st0, st1, st2, st3, st4, st5, st6, st7, st8, st9,       
        sl0, sl1, sl2, sl3, sl4, sl5, sl6, sl7,
        d0, d1, d2, d3, d4, d5,
        sn0, sn1, sn2, sn3, sn4, sn5
    };
    
    Seg[] segForI = {
        st0, st1, st2, st3, st4, st5, st6, st7, st8, st9,       
        sl0, sl1, sl2, sl3, sl4, sl5, sl6, sl7,
        d0, d1, d2, d3, d4, d5,
        sn0, sn1, sn2, sn3, sn4, sn5
    };
    
    Seg[] segForLowerI = {
        st0, st1, st2, st3, st4, st5, st6, st7, st8, st9,       
        sl0, sl1, sl2, sl3, sl4, sl5, sl6, sl7,
        d0, d1, d2, d3, d4, d5,
        sn0, sn1, sn2, sn3, sn4, sn5
    };
    
    Seg[] segForJ = {
        st0, st1, st2, st3, st4, st5, st6, st7, st8, st9,       
        sl0, sl1, sl2, sl3, sl4, sl5, sl6, sl7,
        d0, d1, d2, d3, d4, d5,
        sn0, sn1, sn2, sn3, sn4, sn5
    };
    
    Seg[] segForLowerJ = {
        st0, st1, st2, st3, st4, st5, st6, st7, st8, st9,       
        sl0, sl1, sl2, sl3, sl4, sl5, sl6, sl7,
        d0, d1, d2, d3, d4, d5,
        sn0, sn1, sn2, sn3, sn4, sn5
    };
    
    Seg[] segForK = {
        st0, st1, st2, st3, st4, st5, st6, st7, st8, st9,       
        sl0, sl1, sl2, sl3, sl4, sl5, sl6, sl7,
        d0, d1, d2, d3, d4, d5,
        sn0, sn1, sn2, sn3, sn4, sn5
    };
    
    Seg[] segForLowerK = {
        st0, st1, st2, st3, st4, st5, st6, st7, st8, st9,       
        sl0, sl1, sl2, sl3, sl4, sl5, sl6, sl7,
        d0, d1, d2, d3, d4, d5,
        sn0, sn1, sn2, sn3, sn4, sn5
    };
    
    Seg[] segForL = {
        st0, st1, st2, st3, st4, st5, st6, st7, st8, st9,       
        sl0, sl1, sl2, sl3, sl4, sl5, sl6, sl7,
        d0, d1, d2, d3, d4, d5,
        sn0, sn1, sn2, sn3, sn4, sn5
    };
    
    Seg[] segForLowerL = {
        st0, st1, st2, st3, st4, st5, st6, st7, st8, st9,       
        sl0, sl1, sl2, sl3, sl4, sl5, sl6, sl7,
        d0, d1, d2, d3, d4, d5,
        sn0, sn1, sn2, sn3, sn4, sn5
    };
    
    Seg[] segForM = {
        st0, st1, st2, st3, st4, st5, st6, st7, st8, st9,       
        sl0, sl1, sl2, sl3, sl4, sl5, sl6, sl7,
        d0, d1, d2, d3, d4, d5,
        sn0, sn1, sn2, sn3, sn4, sn5
    };
    
    Seg[] segForLowerM = {
        st0, st1, st2, st3, st4, st5, st6, st7, st8, st9,       
        sl0, sl1, sl2, sl3, sl4, sl5, sl6, sl7,
        d0, d1, d2, d3, d4, d5,
        sn0, sn1, sn2, sn3, sn4, sn5
    };
    
    Seg[] segForN = {
        st0, st1, st2, st3, st4, st5, st6, st7, st8, st9,       
        sl0, sl1, sl2, sl3, sl4, sl5, sl6, sl7,
        d0, d1, d2, d3, d4, d5,
        sn0, sn1, sn2, sn3, sn4, sn5
    };
    
    Seg[] segForLowerN = {
        st0, st1, st2, st3, st4, st5, st6, st7, st8, st9,       
        sl0, sl1, sl2, sl3, sl4, sl5, sl6, sl7,
        d0, d1, d2, d3, d4, d5,
        sn0, sn1, sn2, sn3, sn4, sn5
    };
    
    Seg[] segForO = {
        st0, st1, st2, st3, st4, st5, st6, st7, st8, st9,       
        sl0, sl1, sl2, sl3, sl4, sl5, sl6, sl7,
        d0, d1, d2, d3, d4, d5,
        sn0, sn1, sn2, sn3, sn4, sn5
    };
    
    Seg[] segForLowerO = {
        st0, st1, st2, st3, st4, st5, st6, st7, st8, st9,       
        sl0, sl1, sl2, sl3, sl4, sl5, sl6, sl7,
        d0, d1, d2, d3, d4, d5,
        sn0, sn1, sn2, sn3, sn4, sn5
    };
    
    Seg[] segForP = {
        st0, st1, st2, st3, st4, st5, st6, st7, st8, st9,       
        sl0, sl1, sl2, sl3, sl4, sl5, sl6, sl7,
        d0, d1, d2, d3, d4, d5,
        sn0, sn1, sn2, sn3, sn4, sn5
    };
    
    Seg[] segForLowerP = {
        st0, st1, st2, st3, st4, st5, st6, st7, st8, st9,       
        sl0, sl1, sl2, sl3, sl4, sl5, sl6, sl7,
        d0, d1, d2, d3, d4, d5,
        sn0, sn1, sn2, sn3, sn4, sn5
    };
    
    Seg[] segForQ = {
        st0, st1, st2, st3, st4, st5, st6, st7, st8, st9,       
        sl0, sl1, sl2, sl3, sl4, sl5, sl6, sl7,
        d0, d1, d2, d3, d4, d5,
        sn0, sn1, sn2, sn3, sn4, sn5
    };
    
    Seg[] segForLowerQ = {
        st0, st1, st2, st3, st4, st5, st6, st7, st8, st9,       
        sl0, sl1, sl2, sl3, sl4, sl5, sl6, sl7,
        d0, d1, d2, d3, d4, d5,
        sn0, sn1, sn2, sn3, sn4, sn5
    };
    
    Seg[] segForR = {
        st0, st1, st2, st3, st4, st5, st6, st7, st8, st9,       
        sl0, sl1, sl2, sl3, sl4, sl5, sl6, sl7,
        d0, d1, d2, d3, d4, d5,
        sn0, sn1, sn2, sn3, sn4, sn5
    };
    
    Seg[] segForLowerR = {
        st0, st1, st2, st3, st4, st5, st6, st7, st8, st9,       
        sl0, sl1, sl2, sl3, sl4, sl5, sl6, sl7,
        d0, d1, d2, d3, d4, d5,
        sn0, sn1, sn2, sn3, sn4, sn5
    };
    
    Seg[] segForS = {
        st0, st1, st2, st3, st4, st5, st6, st7, st8, st9,       
        sl0, sl1, sl2, sl3, sl4, sl5, sl6, sl7,
        d0, d1, d2, d3, d4, d5,
        sn0, sn1, sn2, sn3, sn4, sn5
    };
    
    Seg[] segForLowerS = {
        st0, st1, st2, st3, st4, st5, st6, st7, st8, st9,       
        sl0, sl1, sl2, sl3, sl4, sl5, sl6, sl7,
        d0, d1, d2, d3, d4, d5,
        sn0, sn1, sn2, sn3, sn4, sn5
    };
    
    Seg[] segForT = {
        st0, st1, st2, st3, st4, st5, st6, st7, st8, st9,       
        sl0, sl1, sl2, sl3, sl4, sl5, sl6, sl7,
        d0, d1, d2, d3, d4, d5,
        sn0, sn1, sn2, sn3, sn4, sn5
    };
    
    Seg[] segForLowerT = {
        st0, st1, st2, st3, st4, st5, st6, st7, st8, st9,       
        sl0, sl1, sl2, sl3, sl4, sl5, sl6, sl7,
        d0, d1, d2, d3, d4, d5,
        sn0, sn1, sn2, sn3, sn4, sn5
    };
    
    Seg[] segForU = {
        st0, st1, st2, st3, st4, st5, st6, st7, st8, st9,       
        sl0, sl1, sl2, sl3, sl4, sl5, sl6, sl7,
        d0, d1, d2, d3, d4, d5,
        sn0, sn1, sn2, sn3, sn4, sn5
    };
    
    Seg[] segForLowerU = {
        st0, st1, st2, st3, st4, st5, st6, st7, st8, st9,       
        sl0, sl1, sl2, sl3, sl4, sl5, sl6, sl7,
        d0, d1, d2, d3, d4, d5,
        sn0, sn1, sn2, sn3, sn4, sn5
    };
    
    Seg[] segForV = {
        st0, st1, st2, st3, st4, st5, st6, st7, st8, st9,       
        sl0, sl1, sl2, sl3, sl4, sl5, sl6, sl7,
        d0, d1, d2, d3, d4, d5,
        sn0, sn1, sn2, sn3, sn4, sn5
    };
    
    Seg[] segForLowerV = {
        st0, st1, st2, st3, st4, st5, st6, st7, st8, st9,       
        sl0, sl1, sl2, sl3, sl4, sl5, sl6, sl7,
        d0, d1, d2, d3, d4, d5,
        sn0, sn1, sn2, sn3, sn4, sn5
    };
    
    Seg[] segForW = {
        st0, st1, st2, st3, st4, st5, st6, st7, st8, st9,       
        sl0, sl1, sl2, sl3, sl4, sl5, sl6, sl7,
        d0, d1, d2, d3, d4, d5,
        sn0, sn1, sn2, sn3, sn4, sn5
    };
    
    Seg[] segForLowerW = {
        st0, st1, st2, st3, st4, st5, st6, st7, st8, st9,       
        sl0, sl1, sl2, sl3, sl4, sl5, sl6, sl7,
        d0, d1, d2, d3, d4, d5,
        sn0, sn1, sn2, sn3, sn4, sn5
    };
    
    Seg[] segForX = {
        st0, st1, st2, st3, st4, st5, st6, st7, st8, st9,       
        sl0, sl1, sl2, sl3, sl4, sl5, sl6, sl7,
        d0, d1, d2, d3, d4, d5,
        sn0, sn1, sn2, sn3, sn4, sn5
    };
    
    Seg[] segForLowerX = {
        st0, st1, st2, st3, st4, st5, st6, st7, st8, st9,       
        sl0, sl1, sl2, sl3, sl4, sl5, sl6, sl7,
        d0, d1, d2, d3, d4, d5,
        sn0, sn1, sn2, sn3, sn4, sn5
    };
    
    Seg[] segForY = {
        st0, st1, st2, st3, st4, st5, st6, st7, st8, st9,       
        sl0, sl1, sl2, sl3, sl4, sl5, sl6, sl7,
        d0, d1, d2, d3, d4, d5,
        sn0, sn1, sn2, sn3, sn4, sn5
    };
    
    Seg[] segForLowerY = {
        st0, st1, st2, st3, st4, st5, st6, st7, st8, st9,       
        sl0, sl1, sl2, sl3, sl4, sl5, sl6, sl7,
        d0, d1, d2, d3, d4, d5,
        sn0, sn1, sn2, sn3, sn4, sn5
    };
    
    Seg[] segForZ = {
        st0, st1, st2, st3, st4, st5, st6, st7, st8, st9,       
        sl0, sl1, sl2, sl3, sl4, sl5, sl6, sl7,
        d0, d1, d2, d3, d4, d5,
        sn0, sn1, sn2, sn3, sn4, sn5
    };
    
    Seg[] segForLowerZ = {
        st0, st1, st2, st3, st4, st5, st6, st7, st8, st9,       
        sl0, sl1, sl2, sl3, sl4, sl5, sl6, sl7,
        d0, d1, d2, d3, d4, d5,
        sn0, sn1, sn2, sn3, sn4, sn5
    };
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
	    static int size = 3 ; //some integer>2
	    
	    Canvas canvas = new Canvas( size ) ;
	    
	    /*StandingSeg st1 = new StandingSeg( canvas, 10, 1, 2 ) ;
	    st1.turnON() ;
	    */
	    
	    char given = 'A' ;
	    canvas.drawChar( given ) ;
	    
	    //canvas.printMat() ;
		
	}
}
