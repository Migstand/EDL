import java.util.Scanner;

public class Sequencias{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        SequenciaLig seq = new SequenciaLig();
        
        
        for (int ind = 0; ind < 6; ind++){
            seq.insertAtRank(ind, "Ola" + ind);
        }

        seq.insertAtRank(0, "BOOOM");

        seq.replaceAtrank(5, "29");
        for (int i = 0; i < seq.size(); i++){
            System.out.println(seq.eleAtRank(i));
        }
        
        System.out.println("-----------------------------------------------");

        for (int i = 1; i<5; i++){
            System.out.println(seq.removeAtrank(1));
        }

        for (int i = 0; i < seq.size(); i++){
            System.out.println(seq.eleAtRank(i));
        }
    }
}