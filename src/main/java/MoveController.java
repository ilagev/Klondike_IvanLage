
import cards.collection.Waste;

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
    
    public void moveDiscover() {
        // TODO
    }
    
    public void moveFromFoundationToPile(int foundationNumber, int pileNumber) {
        tableau.getPiles().get(pileNumber).insert(tableau.getFoundations().get(foundationNumber).retrieve());
    }
    
    public boolean isPossibleMoveFromFoundationToPile(int foundationNumber, int pileNumber) {
        return !tableau.getFoundations().get(foundationNumber).empty() &&
                tableau.canPutOnPile(tableau.getFoundations().get(foundationNumber),
                                     tableau.getPiles().get(pileNumber));
    }
    
    public void moveFromPileToFoundation() {
        // TODO
    }
    
    public void moveFromPileToPile() {
        // TODO
    }
    
    public void moveFromDeckToWaste() {
        this.moveFromWasteToDeck();
        while (tableau.getWaste().size() < Waste.MAX_CARDS) {
            tableau.getWaste().insert(tableau.getDeck().retrieve());
        }
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
            return !tableau.getWaste().empty() &&
                    tableau.canPutOnFoundation(tableau.getWaste(),
                                               tableau.getFoundations().get(foundationNumber));
    }
    
    public void moveFromWasteToPile(int pileNumber) {
        tableau.getPiles().get(pileNumber).insert(tableau.getWaste().retrieve());
    }
    
    public boolean isPossibleMoveFromWasteToPile(int pileNumber) {
        return !tableau.getWaste().empty() &&
                tableau.canPutOnPile(tableau.getWaste(),
                                     tableau.getPiles().get(pileNumber));
    }
    
}
