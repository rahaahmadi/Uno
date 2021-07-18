/**
 * This class holds color and value of each card.
 * @author Raha Ahamdi
 * @version 0.0
 */
public abstract class Card {
    private String color;
    private String value;
    private int cartScore;

    /**
     * Create a new card
     * @param color card color
     * @param value card value
     * @param cartScore card score
     */
    public Card(String color, String value, int cartScore) {
        this.color = color;
        this.value = value;
        this.cartScore = cartScore;
    }

    /**
     * get card color
     * @return card color
     */
    public String getColor() {
        return color;
    }

    /**
     * get card value
     * @return value
     */
    public String getValue() {
        return value;
    }

    /**
     * set color of card
     * @param color card color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * get card score
     * @return card score
     */
    public int getCartScore() {
        return cartScore;
    }

    /**
     * Find a code for each color for printing
     * @return color code
     */
    public String colorCode() {
        if (color.equals(Color.RED.name()))
            return "\033[1;31m";
        if (color.equals(Color.BLUE.name()))
            return "\033[1;34m";
        if (color.equals(Color.GREEN.name()))
            return "\033[1;32m";
        if (color.equals(Color.YELLOW.name()))
            return "\033[1;33m";
        else
            return "\033[1;30m";
    }

    /**
     * override toString method
     * @return String
     */
    @Override
    public abstract String toString();

}
