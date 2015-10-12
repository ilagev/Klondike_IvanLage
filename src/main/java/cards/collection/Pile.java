package cards.collection;

import java.util.Stack;

import cards.Card;

public class Pile extends CardSet {

    private int downcards;

    private Stack<Card> cards;

    public Pile(int downcards) {
        this.downcards = downcards;
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
    
    @Override
    public int size() {
        return this.cards.size();
    }
    
    @Override
    public Card cardAt(int index) {
        return this.cards.get(index);
    }
    
    public int getDowncards() {
        return downcards;
    }

    public void uncover() {
        downcards--;
    }

}
