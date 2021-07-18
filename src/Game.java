/**
 * Uno is the classic card game of matching colours and numbers.
 * Special Action Cards and Wild Cards for unexpected excitement and game-changing fun.
 * Use the Swap Hands cards to change hands with any other opponent.
 * Players take turns matching a card in their hand with the current colour or number card shown on the top of the deck
 * @author Raha Ahmadi
 * @version 0.0
 */

import java.util.Arrays;
import java.util.Random;

public class Game {
    public enum Order {
        CLOCKWISE, ANTICLOCKWISE
    }
    private Player[] players;
    private CardCollection cardDeck;
    private Card topCard;
    private int currentPlayer;
    private Order currentOrder;
    private int type;

    /**
     * Create a new game
     * @param num number of players
     * @param type type of game
     */
    public Game(int num, int type) {
        players = new Player[num];
        this.type = type;
        // play with computer
        if (type == 1 ) {
            players[0] = new HumanPlayer();
            for (int i = 1; i < num; i++)
                players[i] = new ComputerPlayer();
        }
        // all player are human
        else {
            for (int i = 0; i < num; i++)
                players[i] = new HumanPlayer();
        }
        currentOrder = Order.CLOCKWISE;
        cardDeck = new CardCollection();
        cardDeck.addCard();
        // top card should be number card instance
        do {
            int n = new Random().nextInt(cardDeck.getCards().size());
            topCard = cardDeck.getCards().get(n);
            cardDeck.removeCard(n);
        } while (!(topCard instanceof NumberCard));
        // choose starter player randomly
        currentPlayer = new Random().nextInt(num);
    }

    /**
     * get type of game
     * @return type
     */
    public int getType() {
        return type;
    }

    /**
     * get current player
     * @return current player
     */
    public Player getCurrentPlayer() {
        return players[currentPlayer];
    }

    /**
     * get top card
     * @return top card
     */
    public Card getTopCard() {
        return topCard;
    }

    /**
     * get index of current player
     * @return index of current player
     */
    public int indexOfCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * get card to Players at first
     */
    public void giveCart() {
        for (Player player : players) {
            for (int i = 0; i < 7; i++) {
                int n = new Random().nextInt(cardDeck.getCards().size());
                player.addCard(cardDeck.getCards().get(n));
                cardDeck.getCards().remove(n);
            }
        }
    }

    /**
     * update current player
     */
    public void updateCurrentPlayer() {
        if (currentOrder == Order.CLOCKWISE) {
            if (currentPlayer == players.length-1)
                currentPlayer = 0;
            else
                currentPlayer++;
        }
        else {
            if (currentPlayer == 0)
                currentPlayer = players.length - 1;
            else
                currentPlayer--;
        }
    }

    /**
     * draw n card to current player
     * @param n number of cards
     */
    public void drawCards(int n) {
        System.out.println("draw " + n + " cards to player" + (currentPlayer + 1));
        for (int i = 0; i < n; i++) {
            int random = new Random().nextInt(cardDeck.getCards().size());
            players[currentPlayer].addCard(cardDeck.getCards().get(random));
            cardDeck.getCards().remove(random);
        }
    }

    /**
     * draw one card to current player
     * this happened when player does not have match card with top card
     */
    public void drawOneCard() {
        int random = new Random().nextInt(cardDeck.getCards().size());
        players[currentPlayer].addCard(cardDeck.getCards().get(random));
        cardDeck.getCards().remove(random);
    }

    /**
     * put a card as top card
     * @param card card to put
     */
    public void putCard(Card card) {
        topCard = card;
        players[currentPlayer].removeCard(card);
    }

    /**
     * Card action
     */
    public void action() {
        switch (topCard.getValue()) {
            case "+2": {
                updateCurrentPlayer();
                whoseTurn();
                if (type == 2)
                    updateTable();
                int i = 2;
                while (players[currentPlayer].haveDrawTwo()) {
                    players[currentPlayer].canPlay(topCard);
                    putCard(players[currentPlayer].playDraw2Card());
                    updateTable();
                    i += 2;
                    updateCurrentPlayer();
                    whoseTurn();
                    if (type == 2)
                        updateTable();
                }
                drawCards(i);
                updateTable();
                updateCurrentPlayer();
                whoseTurn();
                if (type == 2)
                    updateTable();
                break;
            }
            case "wild+4": {
                topCard.setColor(players[currentPlayer].wildColor());
                updateTable();
                updateCurrentPlayer();
                whoseTurn();
                if (type == 2)
                    updateTable();
                int i = 4;
                while (players[currentPlayer].haveWildDraw()) {
                    players[currentPlayer].canPlay(topCard);
                    putCard(players[currentPlayer].playWildDraw());
                    topCard.setColor(players[currentPlayer].wildColor());
                    updateTable();
                    i += 4;
                    updateCurrentPlayer();
                    whoseTurn();
                    if (type == 2)
                        updateTable();
                }
                drawCards(i);
                updateTable();
                updateCurrentPlayer();
                whoseTurn();
                if (type == 2)
                    updateTable();
                break;
            }
            case "wild": {
                topCard.setColor(players[currentPlayer].wildColor());
                updateTable();
                updateCurrentPlayer();
                whoseTurn();
                if (type == 2)
                    updateTable();
                break;
            }
            case "reverse": {
                if (currentOrder == Game.Order.CLOCKWISE)
                    currentOrder = Order.ANTICLOCKWISE;
                else
                    currentOrder = Order.CLOCKWISE;
                updateCurrentPlayer();
                whoseTurn();
                if (type == 2)
                    updateTable();
                break;
            }
            case "skip": {
                updateCurrentPlayer();
                updateCurrentPlayer();
                whoseTurn();
                if (type == 2)
                    updateTable();
                break;
            }
            default: {
                updateCurrentPlayer();
                whoseTurn();
                if (type == 2)
                    updateTable();
                break;
            }
        }
    }

    /**
     * a method to show current player
     */
    public void whoseTurn() {
        System.out.println("\033[0;35m" + "Player" + (currentPlayer+1) + "'s turn:" + "\033[0m");
    }

    /**
     * method for printing top card
     */
    public void printTopCard() {
        String resetColor = "\u001B[0m";
        for (int i = 0; i < 5; i++) {
            String[] lines = topCard.toString().split("\n");
            System.out.println(topCard.colorCode() + lines[i] + resetColor + " ");
        }
    }

    /**
     * a method to print player's hand
     */
    public void printHand() {
        String resetColor = "\u001B[0m";
        System.out.println();
        System.out.println();
        if (type == 1) {
            for (int i = 0; i < 5; i++) {
                for (Card card : players[0].getHand()) {
                    String[] lines = card.toString().split("\n");
                    System.out.print(card.colorCode() + lines[i] + resetColor + " ");
                }
                System.out.println();
            }
        }
        if (type == 2) {
            for (int i = 0; i < 5; i++) {
                for (Card card : players[currentPlayer].getHand()) {
                    String[] lines = card.toString().split("\n");
                    System.out.print(card.colorCode() + lines[i] + resetColor + " ");
                }
                System.out.println();
            }
        }
    }

    /**
     * update game table
     */
    public void updateTable() {
        System.out.println("\033[1;36m" + currentOrder + "\033[0m");
        System.out.println();
        printTopCard();
        printHand();
        for (int i = 0; i < players.length; i++) {
            System.out.println("player" + (i+1) + " have " + players[i].getHand().size() + " cards");
        }
        System.out.println("---------------------");
    }

    /**
     * check if the game is over
     * @return true when the game is over
     */
    public boolean isOver() {
        for (Player player : players)
            if (player.getHand().size() == 0)
                return true;
        return cardDeck.isEmpty();
    }

    /**
     * show the winner
     */
    public void winner() {
        for (int i = 0; i < players.length; i++) {
            if (players[i].getHand().size() == 0)
                System.out.println("player" + (i+1) + " is winner");
        }
    }

    /**
     * show score board
     */
    public void scoreBoard() {
        int[] scores = new int[players.length];
        for (int i = 0; i < players.length; i++) {
            scores[i] = players[i].calculateScore();
        }
        Arrays.sort(scores);
        System.out.println("Player\t\tScore");
        for (int score : scores) {
            for (int i = 0; i < players.length; i++) {
                if (players[i].calculateScore() == score)
                     System.out.println("player" + (i+1) + "\t\t" + score);
            }
        }
    }
}
