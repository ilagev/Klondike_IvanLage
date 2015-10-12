
import cards.Suit;
import cards.Value;
import cards.collection.Waste;
import cards.collection.Foundation;
import cards.collection.Pile;

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
    
    public void moveFromWasteToPile(int pileNumber) {
        tableau.getPiles().get(pileNumber).insert(tableau.getWaste().retrieve());
    }
    
    public boolean isPossibleMoveFromWasteToPile(int pileNumber) {
        boolean possible = false;
        Pile pile = (Pile) tableau.getPiles().get(pileNumber);
        Waste waste = (Waste) tableau.getWaste();
        
        if (!waste.empty()) {
            if (pile.empty()) {
                possible = waste.top().getValue() == Value.KING;
            } else {
                possible = pile.top().isThePreviousValueFromMe(waste.top()) &&
                               Suit.getColor(pile.top().getSuit()) !=
                               Suit.getColor(waste.top().getSuit());
            }
        }
        
        return possible;
    }
    
    public void moveDiscover() {
        // TODO
    }

}
