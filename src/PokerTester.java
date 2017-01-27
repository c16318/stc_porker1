
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author c16318
 */
public class PokerTester {
    public static void main(String[] args){
        
        //Cards cards = new Cards(); //トランプ1セット用意
        List<Cards> cards = Cards.newDeck();
        Table table = new Table();
        
        Collections.shuffle(cards);
        Scanner stdIn = new Scanner(System.in);
        

        
        Player akiyama  = new HumanPlayer("AKIyama",100);
        Player computer = new  ComputerPlayer("Com",100);
        
        
        for(int i = 0;i < 5;i++){
            akiyama.drawIn(cards);
            computer.drawIn(cards);
        }
        

        
        //akiyama.ShowList();
        System.out.println("aki");
        akiyama.sortCard();
        for(int i = 0;i < 5;i++)
            System.out.println(akiyama.ShowSuit(i) + ":" + akiyama.ShowRank(i));
        System.out.println("");
        computer.sortCard();
         //for(int i = 0;i < 5;i++)
            //System.out.println(computer.ShowSuit(i) + ":" + computer.ShowRank(i));
         
         int ch = 1;
         int chenge = 0;
         int retry= 0; 
         int betcoin = 0;
         do{
             System.out.println("何枚コインをかけますか？");
             betcoin = stdIn.nextInt();
             table.setCoin(akiyama.bet(betcoin) + computer.bet(betcoin));
            do{
               do{
                   System.out.println("交換しますか Yes:1  No:0");
                   ch =stdIn.nextInt();
               }while(ch != 1 && ch != 0);
                if(ch == 0)
                    break;


               System.out.println("何枚目を交換しますか？");
               chenge = stdIn.nextInt();


                akiyama.drawOutIn(chenge - 1,cards);
                //akiyama.drawIn(cards);

               /*for(int i = 0;i < 5;i++)
                   System.out.println(akiyama.ShowSuit(i) + ":" + akiyama.ShowRank(i));
                System.out.println();
                */

            }while(ch != 0);




            akiyama.sortCard();
            computer.sortCard();

            akiyama.setResult(table.check(akiyama.hand()));
            computer.setResult(table.check(computer.hand()));


            System.out.println(akiyama.getName());
            for(int i = 0;i < 5;i++)
                   System.out.println(akiyama.ShowSuit(i) + ":" + akiyama.ShowRank(i));
            System.out.println();

            System.out.println(computer.getName());
            for(int i = 0;i < 5;i++)
                   System.out.println(computer.ShowSuit(i) + ":" + computer.ShowRank(i));
            System.out.println();


           System.out.println("player:" + table.string(akiyama.getResult()) + "   com:" + table.string(computer.getResult()));


           if(akiyama.getResult() < computer.getResult()){
               System.out.println("あなたの勝ちです。");
               akiyama.setCoints(table.getCoin());
           }
           else if(akiyama.getResult()  > computer.getResult()){
               computer.setCoints(table.getCoin());
               System.out.println("コンピュータの勝ちです。");
           }
           else{
               System.out.println("引き分けです。");
           }
           
           System.out.println("もう一度やりますか？ Yes:1  No0");
           retry = stdIn.nextInt();
           table.reSetCoin();
           
        }while(retry == 1);
      
        System.out.println("player:"+akiyama.getCoin() + "computer:" + computer.getCoin());
        
        
        
        
    }
}
