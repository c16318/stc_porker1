
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

    
/** 
 *  
 *  @author c16318
 */  
public class Player {
    
    private String name;
    private int coins = 0;
    private List<Cards> hand;    //手札
    private int result = 0;
    private int scard;
    
    /*コンストラクタ*/
    public Player(String name,int coins){
        this.name = name;
        this.coins = coins;
        hand = new ArrayList<>();
    }
    
    public void clear(){
        hand.clear();
    } 
    
    public void setResult(int result){
        this.result = result;
    }
    
    public int getResult(){
        return result;
    }
    
    public void setCoints(int num){
        this.coins += num;
    }
    
        /*コインをかける*/
    public int  bet(int num){
        coins -= num;
        return num;
    }
    
    public int getCoin(){
        return coins;
    }
    
    public String getName(){
        return name;
    }
    

    /*カードを捨てる*/
    void drawOutIn(int index,List<Cards> deck){
        hand.remove(index);
        hand.add(index,deck.remove(0));
    }
    /*カードを引く(手札に加える)*/
    void drawIn(List<Cards> deck){
        hand.add(deck.remove(0));
    }
    
    public List<Cards> hand(){
        return hand;
    }

    
    public int ShowRank(int i){
       return (hand.get(i)).ShowRank();
        
    }
    
    public String ShowSuit(int i){
        return (hand.get(i)).ShowSuit();
    }
    
    
    
    
    /*jの添字の配列の値からの最小値の値の添字を返す*/
    int checkMin(int j){
        int min = hand.get(j).Ranknum();
        int a = j;
        for(int i = j;i < 5;i++){
            if(min > hand.get(i).Ranknum()){
               min = hand.get(i).Ranknum();
               a = i;
            }
        }
        return a;
    }
    
    /*カードの数字を小さい順に並びかえ*/
    void sortCard(){
        Cards tCard = new Cards();
        int c;
        
        for(int i = 0;i < 4;i++){
            c = checkMin(i);
            tCard = hand.get(i);
            hand.set(i, hand.get(c));
            hand.set(c, tCard);
        }
    }
    
    
}

