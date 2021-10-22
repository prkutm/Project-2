
/**
 * Write a description of class Farkle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Farkle
{
    Player playerOne;
    GVdie[] dice;
    int[] tally;

    private static final int WINNING_SCORE = 10000;
    private static final int STRAIGHT = 3000;
    private static final int THREE_PAIRS = 1500;
    private static final int FOUR_OF_A_KIND = 1300;
    private static final int FIVE_OF_A_KIND = 2000;
    private static final int SIX_OF_A_KIND = 3000;
    private static final int THREE_ONES = 1000;
    private static final int THREE_TWOS = 200;
    private static final int THREE_THREES = 300;
    private static final int THREE_FOURS = 400;
    private static final int THREE_FIVES = 500;
    private static final int THREE_SIXES = 600;
    private static final int ONE_ONE = 100;
    private static final int ONE_FIVE = 50;

    public Farkle(){
        dice = new GVdie[6];
        for(int i=0; i<dice.length; i++){
            GVdie tempDie = new GVdie();
            dice[i] = tempDie;
        }

        tally = new int[7];
        playerOne = new Player("Mike");
        resetGame();
    }

    // Getter/Accessor Methods

    public Player getActivePlayer(){
        return playerOne;
    }

    public boolean gameOver(){
        if(getActivePlayer().getScore() >= WINNING_SCORE){
            return true;
        }else{
            return false;
        }
    }

    public GVdie[] getDice(){
        return dice;
    }

    //Helper Methods

    private void tallySelectedDice(){
        clearTally();
        for(int i=0; i<dice.length; i++){
            if(dice[i].isSelected()){
                int val = dice[i].getValue();
                tally[val]++;
            }
        }
    }

    private void clearTally(){
        for(int i=0; i<tally.length; i++){
            tally[i]=0;
        }
    }

    private void tallyUnscoredDice(){
        clearTally();
        for(int i=0; i<dice.length; i++){
            if(!dice[i].isScored()){
                int val = dice[i].getValue();
                tally[val]++;
            }
        }
    }

    private boolean wereDiceSelected(){
        boolean foundSelected = false;
        for(int i=0; i<dice.length; i++){
            if(!foundSelected){
                foundSelected = dice[i].isSelected();
            }
        }
        return foundSelected;
    }

    private boolean hasStraight(){
        for(int i=1; i<tally.length; i++){
            if(tally[i]!=1){
                return false;
            }
        }
        return true;
    }

    private boolean hasThreePairs(){
        int pairs = 0;
        for(int i = 1; i<tally.length; i++){
            int iPairs = tally[i]/2;
            if(iPairs==3){
                iPairs=0;
            }
            pairs+=iPairs;
        }
        if(pairs==3){
            return true;
        }else{
            return false;
        }
    }

    private boolean hasMultiples(int numberTimes){
        for(int i = 0; i<tally.length; i++){
            if(tally[i]==numberTimes){
                return true;
            }
        }
        return false;
    }

    private void diceSelectedToScored(){
        for(int i = 0; i<dice.length; i++){
            if(dice[i].isSelected()){
                dice[i].setScored(true);
            }
        }
    }

    private void nextTurn(){
        for(int i = 0; i<dice.length; i++){
            dice[i].setScored(false);
            dice[i].setSelected(false);
            dice[i].setBlank();
        }
    }

    private boolean hasNum(int num, int dieVal){
        if(tally[dieVal]==num){
            return true;
        }else{
            return false;
        }
    }

    private int checkScoringCategories(){
        int tempScore = 0;
        if(hasStraight()){
            tempScore +=STRAIGHT;
        }else if(hasMultiples(6)){
            tempScore += SIX_OF_A_KIND;
        }else if(hasMultiples(5)){
            tempScore += FIVE_OF_A_KIND;
        }else if(hasThreePairs()){
            tempScore += THREE_PAIRS;
        }else {
            if(hasMultiples(4)){
                tempScore += FOUR_OF_A_KIND;
            }
            if(hasNum(3, 1)){
                tempScore += THREE_ONES;
            }else if(!hasNum(4, 1)){
                int numOnes = tally[1];
                tempScore += (ONE_ONE * numOnes);
            }
            if(hasNum(3, 2)){
                tempScore += THREE_TWOS;
            }
            if(hasNum(3, 3)){
                tempScore += THREE_THREES;
            }
            if(hasNum(3, 4)){
                tempScore += THREE_FOURS;
            }
            if(hasNum(3, 5)){
                tempScore += THREE_FIVES;
            }else if(!hasNum(4, 5)){
                int numFives = tally[5];
                tempScore += (ONE_FIVE * numFives);
            }
            if(hasNum(3, 6)){
                tempScore += THREE_SIXES;
            }

        }
        return tempScore;
    }

    //Mutator methods

    public void resetGame(){
        getActivePlayer().newGame();
        nextTurn();
    }

    public void scoreSelectedDice(){
        tallySelectedDice();
        getActivePlayer().addToSubtotal(checkScoringCategories());
        diceSelectedToScored();
    }

    public void rollDice(){
        scoreSelectedDice();
        boolean allDiceScored=true;
        for(int i=0; i<dice.length; i++){
            if(!dice[i].isScored()){
                allDiceScored=false;
            }
        }
        if(allDiceScored){
            for(int i=0; i<dice.length; i++){
                dice[i].setSelected(false);
                dice[i].setScored(false);
            }
        }
        for(int i = 0; i<dice.length; i++){
            if(!dice[i].isScored()){
                dice[i].roll();
            }
        }
    }

    public void passDice(){
        scoreSelectedDice();
        getActivePlayer().updateScore();
        nextTurn();
    }

    //Support Testing

    public void setAllDice(int [] values){
        for(int i = 0; i<6; i++){
            if(values[i]>6 || values[i]<1){
                values[i]=i+1;
            }
        }
        for(int i=0; i<dice.length; i++){
            do{
                dice[i].roll();
            }while(dice[i].getValue()!=values[i]);
        }
    }

    public void selectDie(int id){
        dice[id-1].setSelected(true);
    }

    public String diceToString(){
        String diceString="[";
        for(int i =0; i<dice.length; i++){
            diceString = diceString.concat(""+dice[i].getValue());
            if(i+1<dice.length){
                diceString = diceString.concat(",");
            }
        }
        diceString = diceString.concat("]");
        return diceString;
    }
}
