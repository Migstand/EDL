import java.util.Scanner;

public class Listas {
    public static void main(String[] args){
        ListaLig robado = new ListaLig();

        Scanner sc = new Scanner(System.in);
        int ele = sc.nextInt();

        robado.insertFirst(ele);

        System.out.println(robado.first());
    }
} 