
/**
 * Write a description of class FarkleTest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FarkleTest
{
    public static void main(String [] args){
        int STRAIGHT = 3000;
        int THREE_PAIRS = 1500;
        int ONES = 100;
        int THREE_ONES = 1000;
        int THREE_TWOS = 200;
        int THREE_THREES = 300;
        int THREE_FOURS = 400;
        int THREE_FIVES = 500;
        int THREE_SIXES = 600;
        int FIVES = 50;
        int FOUR_OF_A_KIND = 1300;
        int FIVE_OF_A_KIND = 2000;
        int SIX_OF_A_KIND = 3000;

        Farkle game = new Farkle();

        System.out.println("\nTesting begins...");

        //testing straight
        game.setAllDice(new int[] {2,4,5,6,1,3});
        for(int i=1; i<=6; i++){
            game.selectDie(i);
        }
        game.scoreSelectedDice();
        if(game.getActivePlayer().getSubtotal()!=STRAIGHT){
            System.out.println("FAIL: Straight not scored correctly");
        }

        game.passDice();
        //testing three pairs
        game.setAllDice(new int[] {2,2,5,5,4,4});
        for(int i = 1; i<=6; i++){
            game.selectDie(i);
        }
        game.scoreSelectedDice();
        if(game.getActivePlayer().getSubtotal() != THREE_PAIRS){
            System.out.println("FAIL: THREE PAIRS not scored correctly");
        }
        
        game.passDice();
        
        game.setAllDice(new int[] {2,2,2,2,3,3});
        for(int i = 1; i<=6; i++){
            game.selectDie(i);
        }
        game.scoreSelectedDice();
        if(game.getActivePlayer().getSubtotal() != THREE_PAIRS){
            System.out.println("FAIL: pair + four of a kind not scored correctly");
        }
        
        game.passDice();
        
        //testing ones and fives
        
        game.setAllDice(new int[] {1,6,2,3,4,2});
        for(int i = 1; i<=6; i++){
            game.selectDie(i);
        }
        game.scoreSelectedDice();
        if(game.getActivePlayer().getSubtotal() != ONES){
            System.out.println("FAIL: one one not scored correctly");
        }
        
        game.passDice();
        
        game.setAllDice(new int[] {1,1,2,3,4,2});
        for(int i = 1; i<=6; i++){
            game.selectDie(i);
        }
        game.scoreSelectedDice();
        if(game.getActivePlayer().getSubtotal() != ONES*2){
            System.out.println("FAIL: two ones not scored correctly");
        }
        
        game.passDice();
        
        game.setAllDice(new int[] {5,6,2,3,4,2});
        for(int i = 1; i<=6; i++){
            game.selectDie(i);
        }
        game.scoreSelectedDice();
        if(game.getActivePlayer().getSubtotal() != FIVES){
            System.out.println("FAIL: one five not scored correctly");
        }
        
        game.passDice();
        
        game.setAllDice(new int[] {5,5,2,3,4,2});
        for(int i = 1; i<=6; i++){
            game.selectDie(i);
        }
        game.scoreSelectedDice();
        if(game.getActivePlayer().getSubtotal() != FIVES*2){
            System.out.println("FAIL: two fives not scored correctly");
        }
        
        game.passDice();
        
        game.setAllDice(new int[] {5,5,2,3,1,1});
        for(int i = 1; i<=6; i++){
            game.selectDie(i);
        }
        game.scoreSelectedDice();
        if(game.getActivePlayer().getSubtotal() != ONES*2+FIVES*2){
            System.out.println("FAIL: two ones and two fives not scored correctly");
        }
        
        game.passDice();
        
        //testing threes
        
        game.setAllDice(new int[] {1,1,1,2,2,3});
        for(int i = 1; i<=6; i++){
            game.selectDie(i);
        }
        game.scoreSelectedDice();
        if(game.getActivePlayer().getSubtotal() != THREE_ONES){
            System.out.println("FAIL: three ones not scored correctly");
        }
        
        game.passDice();
        
        game.setAllDice(new int[] {2,4,2,3,2,6});
        for(int i = 1; i<=6; i++){
            game.selectDie(i);
        }
        game.scoreSelectedDice();
        if(game.getActivePlayer().getSubtotal() != THREE_TWOS){
            System.out.println("FAIL: three twos not scored correctly");
        }
        game.passDice();
        
        game.setAllDice(new int[] {2,3,4,3,6,3});
        for(int i = 1; i<=6; i++){
            game.selectDie(i);
        }
        game.scoreSelectedDice();
        if(game.getActivePlayer().getSubtotal() != THREE_THREES){
            System.out.println("FAIL: three threes not scored correctly");
        }
        game.passDice();
        
        game.setAllDice(new int[] {2,4,4,3,4,6});
        for(int i = 1; i<=6; i++){
            game.selectDie(i);
        }
        game.scoreSelectedDice();
        if(game.getActivePlayer().getSubtotal() != THREE_FOURS){
            System.out.println("FAIL: three fours not scored correctly");
        }
        game.passDice();
        
        game.setAllDice(new int[] {2,4,5,5,2,5});
        for(int i = 1; i<=6; i++){
            game.selectDie(i);
        }
        game.scoreSelectedDice();
        if(game.getActivePlayer().getSubtotal() != THREE_FIVES){
            System.out.println("FAIL: three fives not scored coreectly");
        }
        game.passDice();
        
        game.setAllDice(new int[] {2,3,1,6,6,6});
        for(int i = 1; i<=6; i++){
            game.selectDie(i);
        }
        game.scoreSelectedDice();
        if(game.getActivePlayer().getSubtotal() != THREE_SIXES + ONES){
            System.out.println("Fail: Three sixes and a one not scored correctly");
        }
        game.passDice();
        
        //testing four of a kind
        for(int i = 1; i<=6; i++){
            if(i<=3){
                game.setAllDice(new int[] {i,i,i,i,6,4});
            }else{
                game.setAllDice(new int[] {3, 2, i,i,i,i});
            }
            
            for(int j=1; j<=6; j++){
                game.selectDie(j);
            }
            game.scoreSelectedDice();
            if(game.getActivePlayer().getSubtotal() != FOUR_OF_A_KIND){
                System.out.println("FAIL: four of a kind not scored correctly for "+i);
                System.out.println(game.getActivePlayer().getSubtotal());
                System.out.println(FOUR_OF_A_KIND);
            }
            game.passDice();
        }

        System.out.println("Testing completed.");
    }
}
