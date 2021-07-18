
import java.util.Random;

/**
 * create a new computer player
 */
public class ComputerPlayer extends Player {
    public ComputerPlayer() {
        super();
    }

    /**
     * player draw2 card for computer
     * @return card to play
     */
    @Override
    public Card playDraw2Card() {
        int index = 0;
        for (Card card : getHand()) {
            if (card.getValue().equals("+2")) {
                index = getHand().indexOf(card);
                break;
            }
        }
        return getHand().get(index);
    }

    /**
     * play wild draw card for computer
     * @return card to play
     */
    @Override
    public Card playWildDraw() {
        int index = 0;
        for (Card card : getHand()) {
            if (card.getValue().equals("wild+4")) {
                index = getHand().indexOf(card);
                break;
            }
        }
        return getHand().get(index);
    }

    /**
     * choose a color randomly
     * @return string of color
     */
    @Override
    public String wildColor() {
        Color color = Color.values()[(int)(Math.random()*Color.values().length)];
        return color.name();
    }

    /**
     * choose a card to put randomly
     * @param game game table
     * @return card to put
     */
    @Override
    public Card cardToPut(Game game) {
        int random = new Random().nextInt(getValidCards().size());
        return getValidCards().get(random);



    }
}
