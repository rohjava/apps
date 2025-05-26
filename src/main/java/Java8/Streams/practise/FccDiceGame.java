package Java8.Streams.practise;
import java.util.*;
public class FccDiceGame {


        private static final int NUM_DICE = 5;
        private static final Random random = new Random();

        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the number of rounds to play: ");
            int totalNumOfRounds = scanner.nextInt();
            
            for(int round =1; round <= totalNumOfRounds;round++){
                System.out.println("---Playing Round "+round+ "---");
                int score = playRound();
                System.out.println("Score in round-"+round+" is: "+score);
            }
          scanner.close();
        }

    private static int playRound() {
            int activeDiceCount = NUM_DICE;
            int [] dice = {0,0,0,0,0};
            int roundScore =0;
            while(activeDiceCount>0){

                rollDice(dice,activeDiceCount);
                roundScore =+ getScore(dice,activeDiceCount);
                activeDiceCount = getActiveDiceCount(dice,activeDiceCount);


            }
            return roundScore;
    }



    private static int [] rollDice(int [] dice,int activeDiceCount) {
        for (int i = 0; i < activeDiceCount; i++) {

            dice[i] = random.nextInt(1,7);
        }
       return dice;
    }
    private static int getActiveDiceCount(int[] dice,int activeDiceCount) {
            int updatedDiceCount = activeDiceCount;
        for (int i = 0; i < activeDiceCount; i++) {

            if(dice[i] == 3){
                updatedDiceCount--;
            }
        }
        if(updatedDiceCount == activeDiceCount){
            updatedDiceCount--;
        }
        return updatedDiceCount;
    }
    private static int getScore(int[] dice,int activeDiceCount) {
            int score = 6;
        for (int i = 0; i < activeDiceCount; i++) {
            if(dice[i] == 3){
                return 0;
            }
            else{
                if(score > dice[i]){
                    score = dice[i];
                }
            }
        }
            return score;
    }

}

