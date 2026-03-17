package assignment;
import java.util.*;

public class RockPaperScissors {

    public static String computerChoice(){
        double rand = Math.random();
        if(rand<0.33) return "Rock";
        else if(rand<0.66) return "Paper";
        else return "Scissors";
    }

    public static String findWinner(String user,String computer){
        if(user.equals(computer)) return "Draw";
        if(user.equals("Rock") && computer.equals("Scissors")) return "User";
        if(user.equals("Paper") && computer.equals("Rock")) return "User";
        if(user.equals("Scissors") && computer.equals("Paper")) return "User";
        return "Computer";
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of games: ");
        int n = sc.nextInt();
        String[][] results = new String[n][3];
        int userWins=0, computerWins=0;
        for(int i=0;i<n;i++){
            System.out.print("Enter Rock/Paper/Scissors: ");
            String user = sc.next();
            String computer = computerChoice();
            String winner = findWinner(user,computer);
            results[i][0] = user; results[i][1] = computer; results[i][2]=winner;
            if(winner.equals("User")) userWins++;
            else if(winner.equals("Computer")) computerWins++;
        }

        System.out.println("Game\tUser\tComputer\tWinner");
        for(int i=0;i<n;i++)
            System.out.println((i+1)+"\t"+results[i][0]+"\t"+results[i][1]+"\t"+results[i][2]);

        System.out.println("User wins: "+userWins+", Computer wins: "+computerWins);
        System.out.println("User win %: "+(userWins*100.0/n)+"%, Computer win %: "+(computerWins*100.0/n)+"%");
    }
}