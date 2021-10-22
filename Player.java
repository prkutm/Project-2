
/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player
{
    String name;
    int score;
    int subtotal;
    int turns;
    
    public Player(String n){
        name= n;
        score= 0;
        subtotal= 0;
        turns = 0;
    }
    
    //Getter Methods
    
    public String getName(){
        return name;
    }
    
    public int getScore(){
        return score;
    }
    
    public int getSubtotal(){
        return subtotal;
    }
    
    public int getTurns(){
        return turns;
    }
    
    //Setter Methods
    
    public void setName(String n){
        name= n;
    }
    
    public void setScore(int s){
        score= s;
    }
    
    public void setSubtotal(int s){
        subtotal= s;
    }
    
    public void setTurns(int t){
        turns= t;
    }
    
    //Mutator Methods
    
    public void addToSubtotal(int amt){
        subtotal+=amt;
    }
    
    public void updateScore(){
        setScore(score+subtotal);
        setSubtotal(0);
        setTurns(turns+1);
    }
    
    public void newGame(){
        setScore(0);
        setSubtotal(0);
        setTurns(0);
    }
}
