import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cards.Card;
import cards.collection.CardSet;
import cards.collection.CardSetFactory;
import cards.Suit;
import cards.Value;

public class Tableau {

    public static final int PILES_NUMBER = 7;

    public static final int FOUNDATIONS_NUMBER = 4;

    private Map<Integer, CardSet> piles;

    private Map<Integer, CardSet> foundations;

    private CardSet deck;

    private CardSet waste;

    private CardSetFactory cardSetFactory;

    public Tableau() {
        cardSetFactory = new CardSetFactory();
        createPiles();
        createFoundations();
        this.deck = this.cardSetFactory.getDeck();
        this.waste = this.cardSetFactory.getWaste();
    }

    private void createPiles() {
        piles = new HashMap<Integer, CardSet>();
        for (int i = 1; i <= PILES_NUMBER; i++) {
            piles.put(i, cardSetFactory.getPile(PILES_NUMBER - 1));
        }
    }

    private void createFoundations() {
        foundations = new HashMap<Integer, CardSet>();
        for (int i = 1; i <= FOUNDATIONS_NUMBER; i++) {
            foundations.put(i, cardSetFactory.getFoundation());
        }
    }

    public void setup() {
        List<Card> cardsSet = this.generateCards();
        Collections.shuffle(cardsSet);
        this.dispenseForPiles(cardsSet);
        this.dispenseForDeck(cardsSet);
    }
    
    private void dispenseForPiles(List<Card> cardsSet) {
        CardSet pile;
        for (int i = 1; i <= PILES_NUMBER; i++) {
            pile = piles.get(i);
            for (int j = 1; j <= i; j++) {
                pile.insert(cardsSet.remove(0));
            }
        }
    }

    private void dispenseForDeck(List<Card> cardsSet) {
        for (Card card : cardsSet) {
            this.deck.insert(card);
        }
        cardsSet.clear();
    }

    private List<Card> generateCards() {
        List<Card> cards = new ArrayList<Card>();
        for (Value value : Value.values()) {
            for (Suit suit : Suit.values()) {
                cards.add(new Card(value, suit));
            }
        }
        return cards;
    }
    
    public Map<Integer, CardSet> getPiles() {
        return piles;
    }

    public Map<Integer, CardSet> getFoundations() {
        return foundations;
    }

    public CardSet getDeck() {
        return deck;
    }

    public CardSet getWaste() {
        return waste;
    }

}
