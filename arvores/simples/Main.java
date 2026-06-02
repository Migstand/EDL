import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Arvore mr_tree = new Arvore("Mokey");
        System.out.println(mr_tree.isEmpty());

        System.out.println((mr_tree.root().getElemento()));

        // mr_tree.addFilho(mr_tree.root(), "Krima");

        // mr_tree.addFilho(mr_tree.root(), "Grovy");

        System.out.println(" ");
        System.out.println(" ");
        

        for (int i = 0; i < 3; i++){
            Object pri = sc.nextLine();
            mr_tree.addFilho(mr_tree.root(), pri);
        }


        System.out.println("---------------------------------------");
        System.out.println(" ");
        
        System.out.println(mr_tree.height(mr_tree.root()));
        System.out.println(mr_tree.size());

        Iterator<No> fil = mr_tree.children(mr_tree.root());
        No fly = fil.next();
        fil = mr_tree.children(mr_tree.root());
        while (fil.hasNext()){
            No meu_fi = fil.next();
            for (int i = 0; i < 2; i++){
                Object pri = sc.nextLine();
                mr_tree.addFilho(meu_fi, pri);
            }
            

        }

        System.out.println("---------------------------------------");
        System.out.println(" ");

        for (int i = 0; i < 5; i++){
            ArrayList<No> down = fly.getFilhos();
            fly = down.get(0);
            Object pri = sc.nextLine();
            mr_tree.addFilho(fly, pri);
                        
        }
        Iterator<Object> ite = mr_tree.elements();
        
        while (ite.hasNext()){
            Object mod = ite.next();
            System.out.println(mod);
        }
        System.out.println("---------------------------------------");
        System.out.println(" ");

        System.out.println(mr_tree.height(mr_tree.root()));
        System.out.println(mr_tree.size());

        System.out.println("---------------------------------------");
        System.out.println(" ");

        
        // Iterator<No> remo = mr_tree.nos();
        
        // remo.next();
        // mr_tree.removeFilho(remo);

        mr_tree.replace(mr_tree.root(), "PACU");
        
        ArrayList<No> cai = mr_tree.root().getFilhos();
        mr_tree.removeFilho(cai.get(1));
        
        Iterator<No> it = mr_tree.nos();
        while (it.hasNext()){
            No mod = it.next();
            No pai = mod.getPai();//mr_tree.parent(mod);
            if (pai == null){
                System.out.println(mod.getElemento() + " O pai: " + "não existe" + ", É externo?: " + mr_tree.isExternal(mod) + ", É interno?: " + mr_tree.isInternal(mod) + ", É raiz?: " + mr_tree.isRoot(mod) + ", É fundo?: " + mr_tree.depth(mod));
            } else{
                System.out.println(mod.getElemento() + " O pai: " + pai.getElemento() + ", É externo?: " + mr_tree.isExternal(mod) + ", É interno?: " + mr_tree.isInternal(mod) + ", É raiz?: " + mr_tree.isRoot(mod) + ", É fundo?: " + mr_tree.depth(mod));
            }
            
        }
    }
}