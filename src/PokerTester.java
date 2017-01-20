
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 *
 * @author c16318
 */
public class PokerTester {
    public static void main(String[] args){
        
        //Cards cards = new Cards(); //トランプ1セット用意
        List<Cards> cards = Cards.newDeck();
        
        Collections.shuffle(cards);
        

        
        Player akiyama  = new HumanPlayer("AKIyama",100);
        Player computer = new  ComputerPlayer("Com",100);
        
        
        for(int i = 0;i < 5;i++){
            akiyama.drawIn(cards);
            computer.drawIn(cards);
        }
        

        
        akiyama.ShowList();
        System.out.println();
        akiyama.sortCard();
        akiyama.ShowList();
        
        
        
        
        
    }
}
