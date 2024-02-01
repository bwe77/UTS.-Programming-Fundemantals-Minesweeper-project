import java.util.List;
import java.util.ArrayList;

public class Guesses{

    private int width;
    private int height;
    private List<Location> guesses = new ArrayList<Location>();

    public Guesses(int w, int h){
        this.width = w;
        this.height = h;
    }

    public void addGuess(Location l){

   
        if(l != null && !isGuessed(l) && l.getRow() < height && l.getRow() >= 0 && l.getCol() < width && l.getCol() >= 0 ){
            guesses.add(l);   
        } 
        
    }

    public boolean isGuessed(Location l){

        if(l == null && l.getRow() > height && l.getRow() < 0 && l.getCol() > width && l.getCol() < 0){
            return false;
        }  
        //boolean guessed = false;
        for(int i =0; i< guesses.size(); i++){
            Location g = guesses.get(i);
            if(g.getRow() == l.getRow() && g.getCol() == l.getCol()){
               return true;
            } 
            
        }
        
        return false;
        
    }

    public int getTotalGuesses(){
        
        return guesses.size();

    }
 
}