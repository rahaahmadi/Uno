import java.util.Scanner;

public class GameTest {
    static void options() {
        System.out.println("1: play with computer");
        System.out.println("2: play with other humans");
        System.out.println("3: exit");
    }
    public static void main(String[] args) {
        System.out.println("\033[1;91m" + "Welcome to UNO game" + "\033[0m");
        Scanner input = new Scanner(System.in);
        while (true) {
           options();
           int choice = input.nextInt();
           if (choice == 1 || choice == 2) {
               Game game;
               if (choice == 1) {
                   System.out.println("enter number of players (3 to 5)");
                   int n;
                   do {
                       n = input.nextInt();
                       if (n == 3 || n == 4 || n == 5)
                           break;
                       else
                           System.out.println("wrong number");
                   } while (true);
                   game = new Game(n, 1);
                   System.out.println("You are player1");
               }
               else {
                   System.out.println("enter number of players (3 to 10)");
                   int n;
                   do {
                       n = input.nextInt();
                       if (n >= 3 && n <= 10)
                           break;
                       else
                           System.out.println("wrong number");
                   } while (true);
                   game = new Game(n, 2);
               }
               game.giveCart();
               game.updateTable();
               game.whoseTurn();
               while (true) {
                   if (game.getCurrentPlayer().canPlay(game.getTopCard())) {
                       game.putCard(game.getCurrentPlayer().cardToPut(game));
                       game.updateTable();
                       if (game.isOver())
                           break;
                       game.action();
                   }
                   else {
                       System.out.println("get a card from card deck");
                       game.drawOneCard();
                       game.updateTable();
                       if (!game.getCurrentPlayer().canPlay(game.getTopCard())) {
                           System.out.println("player" + (game.indexOfCurrentPlayer()+1) + " can't move");
                           game.updateCurrentPlayer();
                           game.whoseTurn();
                           if (game.getType() == 2)
                               game.updateTable();
                       }
                       else {
                           game.putCard(game.getCurrentPlayer().cardToPut(game));
                           game.updateTable();
                           if (game.isOver())
                               break;
                           game.action();
                       }
                   }
               }
               game.winner();
               game.scoreBoard();
           }
           else if (choice == 3)
               break;
           else
               System.out.println("Wrong choice!");
        }
    }
}
