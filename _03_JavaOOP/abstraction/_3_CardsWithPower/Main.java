package abstraction._3_CardsWithPower;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	String cardRank = reader.readLine();
	String suit = reader.readLine();

	CardRank cr = CardRank.valueOf(cardRank);
	Suits s = Suits.valueOf(suit);

	Card card = new Card(cr, s);

	System.out.printf("Card name: %s of %s; Card power: %d", cardRank, suit, card.getSum());

    }

}
