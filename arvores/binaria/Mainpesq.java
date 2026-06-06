import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Mainpesq {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        BinariaPesq achad = new BinariaPesq(600);
        System.out.println(achad.isEmpty());

        System.out.println((achad.root().getElemento()));

        System.out.println(" ");
        System.out.println(" ");
    
        for (int i = 0; i < 10; i++){
            Object pri = sc.nextInt();
            achad.insert(pri);
        }

        System.out.println("---------------------------------------");
        System.out.println(" ");
        
        System.out.println(achad.height(achad.root()));
        System.out.println(achad.size());
        System.out.println(achad.find(4));
        
        System.out.println("---------------------------------------");
        System.out.println(" ");

        Iterator<No> it = achad.nos();
        while (it.hasNext()){
            No mod = it.next();
            No pai = mod.getPai();//achad.parent(mod);
            if (pai == null){
                System.out.println(mod.getElemento() + " O pai: " + "não existe" + ", É externo?: " + achad.isExternal(mod) + ", É interno?: " + achad.isInternal(mod) + ", É raiz?: " + achad.isRoot(mod) + ", É fundo?: " + achad.depth(mod));
            } else{
                System.out.println(mod.getElemento() + " O pai: " + pai.getElemento() + ", É externo?: " + achad.isExternal(mod) + ", É interno?: " + achad.isInternal(mod) + ", É raiz?: " + achad.isRoot(mod) + ", É fundo?: " + achad.depth(mod));
            }
            
        }
        System.out.println("---------------------------------------");
        System.out.println(" ");


        achad.mostrar();

        System.out.println("---------------------------------------");
        System.out.println(" ");

        
        int ac = achad.size();
        for (int i = 0; i < ac; i++){
            achad.remove(achad.root());
        }
        

        System.out.println("---------------------------------------");
        System.out.println(" ");
        
        System.out.println(achad.height(achad.root()));
        System.out.println(achad.size());

        it = achad.nos();
        System.out.println(achad.isEmpty());
        while (it.hasNext()){
            No mod = it.next();
            No pai = mod.getPai();//achad.parent(mod);
            if (pai == null){
                System.out.println(mod.getElemento() + " O pai: " + "não existe" + ", É externo?: " + achad.isExternal(mod) + ", É interno?: " + achad.isInternal(mod) + ", É raiz?: " + achad.isRoot(mod) + ", É fundo?: " + achad.depth(mod));
            } else{
                System.out.println(mod.getElemento() + " O pai: " + pai.getElemento() + ", É externo?: " + achad.isExternal(mod) + ", É interno?: " + achad.isInternal(mod) + ", É raiz?: " + achad.isRoot(mod) + ", É fundo?: " + achad.depth(mod));
            }
            
        }
    }
}
