import java.util.HashMap;
import java.util.Map;

import cards.Card;
import cards.Suit;
import cards.collection.CardSet;
import cards.collection.Pile;

public class TableauView {

    private Tableau tableau;
    
    private Map<Character, String> foundationName;
    
    public TableauView(Tableau tableau) {
        this.tableau = tableau;
        this.foundationName = new HashMap<Character, String>();
        this.associateInitialsFoundations();
    }
    
    private void associateInitialsFoundations() {
        foundationName.put(Suit.CLUB.getValue(), "oros");
        foundationName.put(Suit.DIAMOND.getValue(), "diamantes");
        foundationName.put(Suit.HEART.getValue(), "corazones");
        foundationName.put(Suit.SPADE.getValue(), "espadas");
    }
    
    public void show() {
        IO.writeln("===========================");
        this.showDeck(tableau.getDeck());
        this.showWaste(tableau.getWaste());
        this.showFoundations(tableau.getFoundations());
        this.showPiles(tableau.getPiles());
        IO.writeln("---------------------------");
    }
    
    private void showPiles(Map<Integer, CardSet> piles) {
        Pile pile;
        for (int i = 1; i <= piles.keySet().size(); i++) {
            pile = (Pile) piles.get(i);
            IO.write("Escalera " + i + ": ");
            for (int j = 0; j < pile.size(); j++) {
                if (j + 1 <= pile.getDowncards()) {
                    IO.write("[");
                } else {
                    showCard(pile.cardAt(j));
                }
            }
            IO.writeln("");
        }
    }

    private void showFoundations(Map<Integer, CardSet> foundations) {
        for (int i = 1; i <= foundations.keySet().size(); i++) {
            IO.write("Palo " + i + ": ");
            if (!foundations.get(i).empty()) {
                showCard(foundations.get(i).top());
                IO.writeln("");
            } else {
                IO.writeln("<vacio>");
            }
        }
    }

    private void showWaste(CardSet waste) {
        IO.write("Descarte: ");
        if (waste.empty()) {
            IO.writeln("<vacio>");
        } else {
            for (int i = 0; i < waste.size(); i++) {
                showCard(waste.cardAt(i));
            }
        }
    }

    private void showCard(Card card) {
        IO.write("[" + card.getValue().getValue() + "," + card.getSuit().getValue() + "]");
    }
    
    private void showDeck(CardSet deck) {
        IO.write("Baraja: ");
        if (deck.empty()) {
            IO.writeln("<vacio>");
        } else {
            IO.writeln("[X,X]");
        }
    }

}
