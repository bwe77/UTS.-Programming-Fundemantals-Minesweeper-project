import java.util.Scanner ;

public class Minesweeper {

    
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {


        Minefield field = MinefieldGenerator.generateMinefield(input);
        //MinefieldGenerator function provided by the tutor
        

       
        int width = field.getWidth();
    
        int height = field.getHeight();

        int mines = field.getTotalMines();
     
   
        Renderer.display(Renderer.render(width, height));

        Guesses guesses = new Guesses(width, height);
        GuessExpander g = new GuessExpander(field);
        //GuessExpander function provided by tutor
        boolean lose = false;

        int TotalSafeLoc = width * height - mines;

        while(!lose){

            System.out.println("Guess a location: ");
            String s = input.nextLine();

            Location loc = Location.fromString(s);
            if(loc == null || !field.isInBounds(loc)){
                System.out.println("Invalid location, please try again.");
                continue;
            }

            guesses = g.expandGuess(loc, guesses); 
            guesses.addGuess(loc); 

            
            if(field.hasMine(loc)){
                lose = true;
                break;
            } 

            if(guesses.getTotalGuesses() == TotalSafeLoc){
                break;
            }
   
            Renderer.display(Renderer.render(field, guesses));
                   
        }
        
        if(lose){
            Renderer.display(Renderer.render(field));
            System.out.println("BOOM! Game over.") ; 
        } else {
            Renderer.display(Renderer.render(field));
            System.out.println("Minefield cleared. Well done!");
            
        }     
    }

}
