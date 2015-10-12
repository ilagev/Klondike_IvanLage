package cards.collection;

import java.util.LinkedList;
import java.util.Queue;

import cards.Card;

public class Waste extends CardSet {
    
    public static final int MAX_CARDS = 3;
    
    private Queue<Card> cards;

    public Waste() {
        this.cards = new LinkedList<Card>();
    }

    @Override
    public Card retrieve() {
        return this.cards.poll();
    }

    @Override
    public void insert(Card card) {
        this.cards.add(card);
    }

    @Override
    public Card top() {
        return this.cards.peek();
    }

    @Override
    public boolean empty() {
        return this.cards.isEmpty();
    }
    
    @Override
    public int size() {
        return this.cards.size();
    }
    
    @Override
    public Card cardAt(int index) {
        throw new UnsupportedOperationException();
    }

}
