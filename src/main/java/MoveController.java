
import cards.collection.Pile;
import cards.collection.Waste;
import cards.Value;

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
        for (int i = 1; i <= Tableau.FOUNDATIONS_NUMBER; i++) {
            if (tableau.getFoundations().get(i).empty() ||
                tableau.getFoundations().get(i).top().getValue() != Value.KING) {
                return false;
            }
        }
        return true;
    }
    
    public void moveDiscover(int pileNumber) {
        Pile pile = (Pile) tableau.getPiles().get(pileNumber);
        pile.uncover();
    }
    
    public boolean isPossibleMoveDiscover(int pileNumber) {
        Pile pile = (Pile) tableau.getPiles().get(pileNumber);
        return !pile.empty() && pile.size() == pile.getDowncards();
    }
    
    public void moveFromFoundationToPile(int foundationNumber, int pileNumber) {
        tableau.getPiles().get(pileNumber).insert(tableau.getFoundations().get(foundationNumber).retrieve());
    }
    
    public boolean isPossibleMoveFromFoundationToPile(int foundationNumber, int pileNumber) {
        return !tableau.getFoundations().get(foundationNumber).empty() &&
                tableau.canPutOnPile(tableau.getFoundations().get(foundationNumber).top(),
                                     tableau.getPiles().get(pileNumber));
    }
    
    public void moveFromPileToFoundation(int pile, int foundation) {
        tableau.getFoundations().get(foundation).insert(tableau.getPiles().get(pile).retrieve());
    }
    
    public boolean isPossibleMoveFromPileToFoundation(int pile, int foundation) {
        return !tableau.getPiles().get(pile).empty() &&
                tableau.canPutOnFoundation(tableau.getPiles().get(pile),
                                           tableau.getFoundations().get(foundation));
    }
    
    public void moveFromPileToPile(int pileNumberFrom, int pileNumberTo, int cards) {
        Pile pileFrom = (Pile) tableau.getPiles().get(pileNumberFrom);
        Pile pileTo = (Pile) tableau.getPiles().get(pileNumberTo);
        Pile cardsToMoveContainer = new Pile(0);
        int indexCardToHandle = pileFrom.size() - cards;
        
        for (int i = indexCardToHandle; i < pileFrom.size(); i++) {
            cardsToMoveContainer.insert(pileFrom.retrieve());
        }
        
        for (int i = indexCardToHandle; i < pileFrom.size(); i++) {
            pileTo.insert(cardsToMoveContainer.retrieve());
        }
    }
    
    public boolean isPossibleMoveFromPileToPile(int pileNumberFrom, int pileNumberTo, int cards) {
        boolean possible = false;
        
        Pile pileFrom = (Pile) tableau.getPiles().get(pileNumberFrom);
        Pile pileTo = (Pile) tableau.getPiles().get(pileNumberTo);
        int indexCardToHandle = pileFrom.size() - cards;
        
        if (!pileFrom.empty()) {
            if (indexCardToHandle >= pileFrom.getDowncards()) {
                possible = tableau.canPutOnPile(pileFrom.cardAt(indexCardToHandle), pileTo);
            }
        }
        
        return possible;
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
                tableau.canPutOnPile(tableau.getWaste().top(),
                                     tableau.getPiles().get(pileNumber));
    }
    
}
