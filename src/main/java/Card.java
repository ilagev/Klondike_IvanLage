
public class Card {

    private Value value;

    private Suit suit;

    public Card(Value value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    public Value getValue() {
        return value;
    }

    public Suit getSuit() {
        return suit;
    }
    
    public boolean isTheNextValueFromMe(Card card) {
        return this.value.ordinal() == card.getValue().ordinal() - 1; 
    }
    
    public boolean isTheSameSuit(Card card) {
        return this.suit == card.getSuit();
    }

}
