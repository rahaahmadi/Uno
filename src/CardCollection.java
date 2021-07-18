/**
 * This class represent a card deck.
 */

import java.util.ArrayList;

public class CardCollection {
    private ArrayList<Card> cards;

    /**
     * Creat a new card collection
     */
    public CardCollection() {
        cards = new ArrayList<>();
    }

    /**
     * get cards
     * @return list of cards
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    /**
     * Add card to card collection
     */
    public void addCard() {
        for (int i = 0; i < 4; i++) {
            cards.add(new Wild());
            cards.add(new WildDrawFour());
        }
        for (Color color : Color.values())
            cards.add(new NumberCard(color.name(),0));
        for (Color color : Color.values()) {
            for (int i = 0; i < 2; i++) {
                for (int j = 1; j < 10; j++)
                    cards.add(new NumberCard(color.name(),j));
                cards.add(new DrawTwo(color.name()));
                cards.add(new Reverse(color.name()));
                cards.add(new Skip(color.name()));
            }
        }
    }

    /**
     * Remove card from card collection
     * @param index index of card to be remove
     */
    public void removeCard(int index) {
        cards.remove(index);
    }
    public boolean isEmpty() {
        return cards.size() == 0;
    }
}
