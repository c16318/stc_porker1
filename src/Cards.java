
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author c16318
 */
public class Cards {
    
    public enum Suit{
        Diamond(0),Spade(1),Clover(2),Heart(3);
        private int id;
        
        private Suit(int id){ this.id = id;}
    }
    
    
    public enum Rank{
        A(1),Two(2),Three(3),Four(4),Five(5),Six(6),Seven(7),
        Eight(8),Nine(9),Ten(10),J(11),Q(12),K(13);
        private int id;
        
        private Rank(int id){ this.id = id; }
    }
    
    static final List<Cards> deck = new ArrayList<>();

    private final Suit suit;
    private final Rank rank;
    
    Cards(){
        suit = null;
        rank = null;
        
    }
    
    Cards(Suit suit,Rank rank){
        this.suit = suit;
        this.rank = rank;
    }
    
    
    
    static {
        for(Suit suit: Suit.values()){
            for(Rank rank: Rank.values()){
                deck.add(new Cards(suit,rank));
            }
        }
    }
    
    public void reset(){
        
    }
    
    /*"deck"の値を初期化*/
    static void resetdeck(){
        deck.clear();
        for(Suit suit: Suit.values()){
            for(Rank rank: Rank.values()){
                deck.add(new Cards(suit,rank));
            }
        }
    }
    
    public static ArrayList<Cards> newDeck(){
        return new ArrayList<Cards>(deck);
    }
    
    public int ShowRank(){
        return rank.id;
    }
    
    public String ShowSuit(){
        return suit.name();
    }
    
    public int Ranknum(){
        return rank.id;
    }
    
    public int Suitnum(){
        return suit.id;
    }
    

}
