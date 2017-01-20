
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *カードの山
 * @author c16318
 */
public class Deck extends ArrayList<Card>{
    public Deck(){
    }
    
    /*カードを追加する*/
    //deck.add(Card card);
    
    /*かーどを１枚引く
         もし、枚数以上のカード一の場合は最後のカードを返す
    */
    
    public Card withdraw(int num){
        if(num>size()) num =size();
        return remove(num);
    }
    
    
}
