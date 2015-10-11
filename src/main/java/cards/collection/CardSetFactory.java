package cards.collection;

import cards.collection.Deck;
import cards.collection.Foundation;
import cards.collection.Pile;
import cards.collection.Waste;

public class CardSetFactory {
    
    public CardSetFactory() {
        
    }

    public CardSet getDeck() {
        return new Deck();
    }

    public CardSet getWaste() {
        return new Waste();
    }

    public CardSet getPile(int downcards) {
        return new Pile(downcards);
    }

    public CardSet getFoundation() {
        return new Foundation();
    }

}
