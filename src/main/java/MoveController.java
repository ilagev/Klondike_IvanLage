
public class MoveController {
    
    public static boolean EXIT_FLAG = false;
    
    Tableau tableau;
    
    public MoveController(Tableau tableau) {
        this.tableau = tableau; 
    }
    
    public Tableau getTableau() {
        return this.tableau;
    }
    
    public boolean endOfTheGame() {
        // TODO
        return false;
    }

}
