package cards.collection;

import java.util.Stack;

import cards.Card;

public class Foundation extends CardSet {
    
    private Stack<Card> cards;
    
    public Foundation() {
        this.cards = new Stack<Card>();
    }

    @Override
    public Card retrieve() {
        return this.cards.pop();
    }

    @Override
    public void insert(Card card) {
        this.cards.push(card);
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
