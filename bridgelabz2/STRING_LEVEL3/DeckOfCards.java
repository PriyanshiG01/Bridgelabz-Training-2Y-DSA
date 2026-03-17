package STRING3;
import java.util.Scanner;

public class DeckOfCards {

    static String[] suits = {"Hearts","Diamonds","Clubs","Spades"};
    static String[] ranks = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};

    public static String[] initializeDeck() {
        String[] deck = new String[suits.length*ranks.length];
        int index = 0;
        for(String suit : suits)
            for(String rank : ranks)
                deck[index++] = rank + " of " + suit;
        return deck;
    }

    public static void shuffleDeck(String[] deck) {
        int n = deck.length;
        for(int i = 0; i < n; i++) {
            int rand = i + (int)(Math.random()*(n-i));
            String temp = deck[i];
            deck[i] = deck[rand];
            deck[rand] = temp;
        }
    }

    public static String[][] distributeDeck(String[] deck, int players) {
        if(deck.length % players != 0) return null;
        int cardsPerPlayer = deck.length / players;
        String[][] distribution = new String[players][cardsPerPlayer];
        int index = 0;
        for(int i = 0; i < players; i++)
            for(int j = 0; j < cardsPerPlayer; j++)
                distribution[i][j] = deck[index++];
        return distribution;
    }

    public static void printDistribution(String[][] distribution) {
        for(int i = 0; i < distribution.length; i++) {
            System.out.println("Player " + (i+1) + ": ");
            for(String card : distribution[i])
                System.out.print(card + ", ");
            System.out.println("\n");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] deck = initializeDeck();
        shuffleDeck(deck);

        System.out.print("Enter number of players: ");
        int players = sc.nextInt();
        String[][] distributed = distributeDeck(deck, players);

        if(distributed == null) System.out.println("Cannot distribute evenly!");
        else printDistribution(distributed);

        sc.close();
    }
}