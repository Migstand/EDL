import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class TesteBin{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArvoreBinaria os_dois = new ArvoreBinaria("Hazard");
        System.out.println(os_dois.isEmpty());

        System.out.println((os_dois.root().getElemento()));

        // os_dois.addFilho(os_dois.root(), "Krima");

        // os_dois.addFilho(os_dois.root(), "Grovy");

        System.out.println(" ");
        System.out.println(" ");
        
        No el = os_dois.root();
        for (int i = 0; i < 2; i++){
            Object pri = sc.nextLine();
            os_dois.addLeft(el, pri);
            pri = sc.nextLine();
            os_dois.addRight(el, pri);
            el = el.getEsq();
        }


        System.out.println("---------------------------------------");
        System.out.println(" ");
        
        System.out.println(os_dois.height(os_dois.root()));
        System.out.println(os_dois.size());

        // Iterator<No> ite = os_dois.nos();
        // while (ite.hasNext()){
        //     No prin = ite.next();
        //     System.out.println(prin.getElemento());
        // }
        os_dois.replace(os_dois.root(), "Bastion");
        os_dois.removeFilho((os_dois.root()).getDir());

        System.out.println("---------------------------------------");
        System.out.println(" ");
        
        System.out.println(os_dois.height(os_dois.root()));
        System.out.println(os_dois.size());

        Iterator<No> it = os_dois.nos();
        while (it.hasNext()){
            No mod = it.next();
            No pai = mod.getPai();//os_dois.parent(mod);
            if (pai == null){
                System.out.println(mod.getElemento() + " O pai: " + "não existe" + ", É externo?: " + os_dois.isExternal(mod) + ", É interno?: " + os_dois.isInternal(mod) + ", É raiz?: " + os_dois.isRoot(mod) + ", É fundo?: " + os_dois.depth(mod));
            } else{
                System.out.println(mod.getElemento() + " O pai: " + pai.getElemento() + ", É externo?: " + os_dois.isExternal(mod) + ", É interno?: " + os_dois.isInternal(mod) + ", É raiz?: " + os_dois.isRoot(mod) + ", É fundo?: " + os_dois.depth(mod));
            }
            
        }
    }
}