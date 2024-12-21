package abstraction._3_CardsWithPower;

public class Card {

    CardRank cardRnk;
    Suits suit;

    public Card(CardRank cr, Suits s) {
	this.cardRnk = cr;
	this.suit = s;
    }

    public int getSum() {
	return this.cardRnk.getValue() + this.suit.getValue();
    }

}
