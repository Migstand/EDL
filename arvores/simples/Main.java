import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Arvore mr_tree = new Arvore("Mokey");

        System.out.println((mr_tree.root().getElemento()));

        // mr_tree.addFilho(mr_tree.root(), "Krima");

        // mr_tree.addFilho(mr_tree.root(), "Grovy");

        System.out.println(" ");
        System.out.println(" ");
        

        for (int i = 0; i < 2; i++){
            Object pri = sc.nextLine();
            mr_tree.addFilho(mr_tree.root(), pri);
        }


        System.out.println("---------------------------------------");
        System.out.println(" ");
        
        Iterator<No> fil = mr_tree.children(mr_tree.root());
        while (fil.hasNext()){
            No meu_fi = fil.next();
            for (int i = 0; i < 2; i++){
                Object pri = sc.nextLine();
                mr_tree.addFilho(meu_fi, pri);
            }
            

        }

        System.out.println("---------------------------------------");
        System.out.println(" ");
        
        // Iterator<Object> it = mr_tree.elements();
        
        // while (it.hasNext()){
        //     Object mod = it.next();
        //     System.out.println(mod);
        // }

        Iterator<No> it = mr_tree.nos();
        
        while (it.hasNext()){
            No mod = it.next();
            System.out.println(mod.getElemento());
        }
    }
}