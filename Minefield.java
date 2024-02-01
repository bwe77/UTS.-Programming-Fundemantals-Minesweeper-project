import java.util.List;
import java.util.ArrayList;

public class Minefield{

    private int width;
    private int height;
    private List<Location> mines = new ArrayList<Location>();
    private Location loc = new Location(0,0);

    public Minefield(int w, int h){
        this.width = w;
        this.height = h;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public boolean isInBounds(Location l){

        if(l == null){
            return false;
        }
        
        if(l.getRow() < height && l.getRow() >= 0 && l.getCol() < width && l.getCol() >= 0){
            return true;
        }

        return false;
            
        
    }

    public void placeMine(Location l){
        
        if(l != null && isInBounds(l) && !hasMine(l) ){
            mines.add(l);
        } 
        
    }

    public boolean hasMine(Location l){

        if(l == null && !isInBounds(l)){
            return false;
        }  
        
        for(int i =0; i< mines.size(); i++){
            Location m = mines.get(i);
            if(m.getRow() == l.getRow() && m.getCol() == l.getCol()){
               return true;
            } 
            
        }
        
        return false;

    }

    public int getTotalMines(){
        
        return mines.size();
    }

    public int getAdjacentMines(Location l){
        
        int total = 0;
        

        for(int i = -1; i <= 1; i++){
            for(int k = -1; k <= 1; k++){
                if(i == 0 && k == 0){
                    continue;
                }

                Location x = new Location(i + l.getRow(), k + l.getCol());

                if(hasMine(x) && isInBounds(x)){
                    total ++;
                }
            }
        }
        return total;
   }


}