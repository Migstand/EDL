import java.util.Scanner;

public class Listas {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        ListaArray esculacho = new ListaArray(1);
        //esculacho.remove(0); Elemento não existente
        
        Object pri = sc.nextLine();
        esculacho.insertBefore(1, pri);
        esculacho.insertFirst("Noob");
        System.out.println(esculacho.first());
        for (int loop = 0; loop < 5; loop++){
            pri = sc.nextLine();
            esculacho.insertAfter(loop, pri);

            esculacho.insertLast("Eu amo Atlis");
        }

        esculacho.swapElements(3, 1);
        esculacho.replaceElement(2, "Luiz");
        esculacho.insertLast("Davy nooob");
        System.out.println(esculacho.last());
        
        System.out.println("----------------------------");
        
        for (int loop = 0; loop < esculacho.size(); loop++){
            System.out.println(esculacho.before(loop + 1));    
        }
        
        System.out.println("----------------------------");
        
        for (int i = 0; i<4; i++){
            System.out.println(esculacho.remove(0));
        }
            

        ListaLig robado = new ListaLig();
        

        // DubNo removed = robado.last();
        //robado.remove(removed);
        
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