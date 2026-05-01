import java.util.Scanner;

public class Listas {
    public static void main(String[] args){
        ListaLig robado = new ListaLig();
        
        // DubNo removed = robado.last();
        //robado.remove(removed);
        Scanner sc = new Scanner(System.in);
        Object primeiro = sc.nextLine();
        robado.insertFirst(primeiro);

        DubNo noob = robado.first();
        for (int i  = 0; i < 5; i++){
            Object ele = sc.nextLine();

            robado.insertAfter(noob, ele);
            noob = noob.getNext();
        }

        DubNo wap1 = (robado.first()).getNext();
        DubNo wap2 = ((robado.first()).getNext()).getNext();
        
        robado.swapElements(wap2, wap1);
        
        DubNo ini = robado.first();

        for (int i = 0; i<robado.size(); i++){
            System.out.println(ini.getElemento());
            ini = ini.getNext();
        }

        System.out.println("----------------------------");
        
        DubNo removed = robado.last();
        robado.remove(removed);

        ini = robado.first();
        for (int i = 0; i<robado.size(); i++){
            System.out.println(ini.getElemento());
            ini = ini.getNext();
        }
        // System.out.println((robado.first().getElemento()));
        // System.out.println((robado.last().getElemento()));
    }
} 