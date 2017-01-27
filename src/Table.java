import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Table {
    
    
    private int result;
    static int coin = 0;
    
    public Table(){
        result = 0;
    }
    
    
    String string(int i){
        String[] y ={"ロイヤルストレートフラッシュ","ストレートフラッシュ","4カード","フルハウス","フラッシュ","ストレート","3カード","2ペア","1ペア","役ナシ"};
        
        return y[i];
    }
    
    public void setCoin(int coin){
        this.coin += coin;
    }
    
    public int getCoin(){
        return coin;
    }
    
    public void resetCoin(){
        coin = 0;
    }
    
    /*役の判定*/
    public  int check(List<Cards> card){
        
        
        int straight  = checkStraight(card);
        int flush     = checkFlush(card);
        int ownpair   = checkOnePair(card);
        int twopair   = checkTwoPair(card);
        int threecard = checkThreeCard(card);
        int fourcard  = checkFourCard(card);
        int fullhouse = checkFullHouse(card);

        
        /*ロイヤルストレートフラッシュ*/
        if(((card.get(0)).ShowRank()) == 1 && straight == 1 && flush == 1){
            result= 0;
            return result;
        }
       
        /*ストレートフラッシュ*/
        if(straight == 1 && flush == 1){
            result = 1;
            return result;
        }
        
        /*4カード*/
        if(fourcard == 1){
            result = 2;
            return result;
        }
        
        /*フルハウス*/
        if(fullhouse == 1){
            result = 3;
            return result;
        }
        
        /*フラッシュ*/
        if(flush == 1){
            result = 4;
            return result;
        }
        
        /*ストレート*/
        if(straight == 1){
            result = 5;
            return result;
        }
        
        /*3カード*/
        if(threecard == 1){
            result = 6;
            return result;
        }
        
        /*2ペア*/
        if(twopair == 1){
            result = 7;
            return result;
        }
        
        /*1ペア*/
        if(ownpair == 1){
            result = 8;
            return result;
        }
        
        result = 9;
        return result;
        
    }
    
    /*フルハウスかどうか*/
    int checkFullHouse(List<Cards> card){
        
        if(((card.get(0)).ShowRank()) == ((card.get(1)).ShowRank()) && ((card.get(2)).ShowRank()) == ((card.get(3)).ShowRank()) && ((card.get(3)).ShowRank()) == ((card.get(4)).ShowRank()))
            return 1;
            
        else if(((card.get(0)).ShowRank()) == ((card.get(1)).ShowRank()) && ((card.get(1)).ShowRank()) == ((card.get(2)).ShowRank()) && ((card.get(3)).ShowRank()) == ((card.get(4)).ShowRank()))
            return 1;
        
        return 0;
    }
    
    /*フラッシュかどうか*/
    int checkFlush(List<Cards> card){
        
        for(int i = 0;i < 4;i++){
            if(((card.get(i)).Suitnum()) == ((card.get(i + 1)).Suitnum())){
               
            }
            else{
                return 0;
            }
        }
        return 1;
    }
    
    /*ストレートかどうか*/
    int checkStraight(List<Cards> card){
        int count = ((card.get(0)).ShowRank());
        
        if(((card.get(0)).ShowRank()) == 1 && ((card.get(1)).ShowRank()) == 10 && ((card.get(2)).ShowRank()) == 11 &&
                                                ((card.get(3)).ShowRank())== 12 && ((card.get(4)).ShowRank()) == 13){
            return 1;

        }
        
        
        for(int i = 1;i < 5;i++){
            if(count == ((card.get(i)).ShowRank()) - 1){
                count = ((card.get(i)).ShowRank());
            }
            else{
                return 0;
            }
        }
        return 1;
        
    }
    

    
    /*1ペアかどうか*/
    int checkOnePair(List<Cards> card){
        for(int i = 0;i < 4;i++){
            if(((card.get(i)).ShowRank()) == ((card.get(i + 1)).ShowRank())){
                 return 1;
            }
        }
       return 0;
    }
    
    /*2ペアかどうか*/
    int checkTwoPair(List<Cards> card){
        int count = 0;
        for(int i = 0;i < 4;i++){
             if(((card.get(i)).ShowRank()) == ((card.get(i + 1)).ShowRank())){
                count++;
                i++;
            }
        }
        if(count == 2){
            return 1;
        }
        return 0;
    }
    
    
    /*3カードか*/
    int checkThreeCard(List<Cards> card){
        for(int i = 0;i < 3;i++){
            if(((card.get(i)).ShowRank()) == ((card.get(i + 1)).ShowRank())){
                 if(((card.get(i + 1)).ShowRank())== ((card.get(i + 2)).ShowRank()))
                     return 1;
            }
        }
        return 0;
    }
    
     /*4カードか*/
    int checkFourCard(List<Cards> card){
        for(int i = 0;i < 2;i++){
            if(((card.get(i)).ShowRank()) == ((card.get(i + 1)).ShowRank())){
                 if(((card.get(i + 1)).ShowRank()) == ((card.get(i + 2)).ShowRank()))
                     if(((card.get(i + 2)).ShowRank()) == ((card.get(i + 3)).ShowRank()))
                         return 1;
            }
        }
        return 0;
    }
    
    /*手札のカードの中で一番強いカードを返す*/
    int checkSCard(List<Cards> card){
        //配列の中身が昇順になっているので、配列の0番目に1があれば14を返す。
        if(((card.get(0)).ShowRank()) == 1)
            return 14;
        
        //それ以外の場合は、配列の最後が一番大き値になっているので、その値を返す。
        return (card.get(4)).ShowRank();
        
    }
    
    
    
}
