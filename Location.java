public class Location {

    public static char[] ROW_CHARS = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'};
    public static char[] COL_CHARS = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};


    //Implement the rest of the Location class here

    private int row;
    private int column;

    public Location(int r, int c){
        this.row = r;
        this.column = c;
    }

    public int getRow(){
        return this.row; 
    }

    public int getCol(){
        return this.column;
    }

    public String toString(){

        
        if(row >= 0 && row < ROW_CHARS.length && column >= 0 && column < COL_CHARS.length){
            return ROW_CHARS[row] + "" + COL_CHARS[column];
        } else{
            return "INVALID";
        }
        
    }

    public static Location fromString(String pos){

        pos = pos.toUpperCase();

        if(pos.length() == 2){
            char r = pos.charAt(0);
            char c = pos.charAt(1);
        

            if(r >= 'A' && r <= 'I' && c >= '1' && c <= '9'){
                int row = r - 'A';
                int column = c - '1'; 

                return new Location(row, column);       
            }
        }

        return null;
       
         
    }
}