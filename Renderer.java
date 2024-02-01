
public class Renderer {

    public static final char DEFAULT = '·' ;
    public static final char MINE = 'X' ;
    public static final char[] DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    private static Location loc;

    private static int cellCol2GridCol(int cellCol) {
        return 2 + (2*cellCol);
    }

    private static int cellRow2GridRow(int cellRow) {
        return 1 + cellRow ;
    }

    //Implement the rest of the Renderer class here
    public static char[][] render(int width, int height){


        char[][] grid = new char[height+1][width*2 + 2];

        for (int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[0].length; c++){
                char space = ' ';
                grid[r][c] = space;
            }
        } 

        for(int i =1; i < grid.length; i++){
            loc = new Location(1,1);
            grid[i][0] = loc.ROW_CHARS[i-1];
        } 

        for(int k =2; k < grid[0].length-1; k=k+2){
            grid[0][k] = Renderer.DIGITS[k/2];
        }

        for(int i=1; i <grid.length; i++){
            for(int k=2; k < grid[0].length-1; k=k+2){
                char empty = '·';
                grid[i][k] = empty;
            }
        }
            
        
        return grid;
    }

    public static char[][] render(Minefield m, Guesses g){
        int width = m.getWidth();
        int height = m.getHeight();

        char[][] guess = render(width, height);

        for(int row=0; row < height; row++){
            for(int col=0; col < width; col++){
                loc = new Location(row, col);
                if(g.isGuessed(loc)){
                    if(m.hasMine(loc)){
                        guess[cellRow2GridRow(row)][cellCol2GridCol(col)]=MINE;
                    } else{
                        guess[cellRow2GridRow(row)][cellCol2GridCol(col)]=DIGITS[m.getAdjacentMines(loc)];
                    }
                }
            }
        }

        return guess;
    }

    public static char[][] render(Minefield m){
        int width= m.getWidth();
        int height = m.getHeight();

        char[][] fullgrid = render(width, height);

        for(int row = 0; row < height; row++){
            for(int col = 0; col < width; col++){
                loc = new Location(row, col);
                if(m.hasMine(loc)){
                    fullgrid[cellRow2GridRow(row)][cellCol2GridCol(col)]=MINE;
                } else{
                    fullgrid[cellRow2GridRow(row)][cellCol2GridCol(col)]=DIGITS[m.getAdjacentMines(loc)];
                } 
            }
            
        }
        return fullgrid;
    }

    public static void display(char[][] grid){
        
        for(int i = 0; i< grid.length; i++){
            for(int k =0; k< grid[i].length; k++){
                System.out.print(grid[i][k]);
            }
            System.out.println();
        }
    } 


}