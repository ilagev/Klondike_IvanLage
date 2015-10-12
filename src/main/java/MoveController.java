
import cards.Value;
import cards.collection.Waste;
import cards.collection.Foundation;

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
    
    public void moveFromDeckToWaste() {
        this.moveFromWasteToDeck();
        while (tableau.getWaste().size() < Waste.MAX_CARDS) {
            tableau.getWaste().insert(tableau.getDeck().retrieve());
        }
    }
    
    public void moveFromFoundationToPile() {
        // TODO
    }
    
    public void moveFromPileToFoundation() {
        // TODO
    }
    
    public void moveFromPileToPile() {
        // TODO
    }
    
    public void moveFromWasteToDeck() {
        while (!tableau.getWaste().empty()){
            tableau.getDeck().insert(tableau.getWaste().retrieve());
        }
    }
    
    public void moveFromWasteToFoundation(int foundation) {
        tableau.getFoundations().get(foundation).insert(tableau.getWaste().retrieve());
    }
    
    public boolean isPossibleMoveFromWasteToFoundation(int foundationNumber) {
        boolean possible = false;
        Foundation foundation = (Foundation) tableau.getFoundations().get(foundationNumber);
        Waste waste = (Waste) tableau.getWaste();
        
        if (!waste.empty()) {
            if (foundation.empty()) {
                possible = waste.top().getValue() == Value.ACE;
            } else {
                possible = foundation.top().isTheNextValueFromMe(waste.top()) &&
                           foundation.top().isTheSameSuit(waste.top());
            }
        }
        
        return possible;
    }
    
    public void moveFromWasteToPile() {
        // TODO
    }
    
    public void moveDiscover() {
        // TODO
    }

}
