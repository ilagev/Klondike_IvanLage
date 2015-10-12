package cards.collection;

import java.util.LinkedList;
import java.util.Queue;

import cards.Card;

public class Deck extends CardSet {
    
    private Queue<Card> cards;
    
    public Deck() {
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
    
    public int size() {
        return this.cards.size();
    }

}
