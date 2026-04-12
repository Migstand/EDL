public class FilaInverteTeste{
    public static void main(String[] args){
        
        FilaInverte check = new FilaInverte(10);

        System.out.println(check.size());
        check.enqueue("chupa cabra");
        check.enqueue("chupa cabra");
        check.enqueue(" Catarro");
        check.enqueue("Cabum");
        System.out.println(check.size());
        check.switche();
        check.enqueue("Carlinhos");

        System.out.println(check.dequeue());
        System.out.println(check.dequeue());
    }
}