package cards.collection;

import cards.Card;

public abstract class CardSet {
    
    public abstract Card retrieve();
    
    public abstract void insert(Card card);
    
    public abstract Card top();
    
    public abstract boolean empty();
    
    public abstract int size();
    
    public abstract Card cardAt(int index);
    
}
