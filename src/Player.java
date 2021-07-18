import java.util.ArrayList;

public abstract class Player {
    private ArrayList<Card> hand;
    private ArrayList<Card> validCards;

    /**
     * create a new player
     */
    public Player() {
        hand = new ArrayList<>();
    }

    /**
     * get hand's cards of player
     * @return hand's cards
     */
    public ArrayList<Card> getHand() {
        return hand;

    }

    /**
     * get valid card
     * @return list of valid cards
     */
    public ArrayList<Card> getValidCards() {
        return validCards;
    }

    /**
     * Add card to player's hand
     * @param card card to add
     */
    public void addCard(Card card) {
        hand.add(card);
    }

    /**
     * Remove card from hand
     * @param card card to remove
     */
    public void removeCard(Card card) {
        hand.remove(card);
    }

    /**
     * Calculate player's score
     * @return score
     */
    public int calculateScore() {
        int score = 0;
        for (Card card : hand)
            score += card.getCartScore();
        return score;
    }

    /**
     * check player's hand with top card to know if player can move
     * @param topCard UNO top card
     * @return true if player can move
     */
    public boolean canPlay(Card topCard) {
        boolean flag = false;
        validCards = new ArrayList<>();
        for (Card card : hand) {
            if (card.getColor().equals(topCard.getColor()) || card.getValue().equals(topCard.getValue())
                    || card.getValue().equals("wild")) {
                flag = true;
                validCards.add(card);
            }
        }
        if (!flag) {
            for (Card card : hand) {
                if (card.getValue().equals("wild+4")) {
                    flag = true;
                    validCards.add(card);
                }
            }
        }
        return flag;
    }

    /**
     * Check if player has wild draw four card
     * @return true if player have wild+4
     */
    public boolean haveWildDraw() {
        boolean flag = false;
        for (Card card : hand)
            if (card.getValue().equals("wild+4")) {
                flag = true;
                break;
            }
        return flag;
    }

    /**
     * Check if player has draw+2 card
     * @return true if player has draw+2
     */
    public boolean haveDrawTwo() {
        boolean flag = false;
        for (Card card : hand)
            if (card.getValue().equals("+2")) {
                flag = true;
                break;
            }
        return flag;
    }

    /**
     * play draw+2 card
     * @return draw+2 card
     */
    public abstract Card playDraw2Card();

    /**
     * play wild+4 card
     * @return wild+4 card
     */
    public abstract Card playWildDraw();

    /**
     * Set a color
     * @return string of color
     */
    public abstract String wildColor();

    /**
     * choose a card to put
     * @param game UNO game
     * @return card to put
     */
    public abstract Card cardToPut(Game game);
}
