public class FilaInverteTeste{
    public static void main(String[] args){
        
        FilaInverte check = new FilaInverte(5);

        System.out.println(check.size());
        check.enqueue("Pai");
        check.enqueue("chupa cabra");
        check.enqueue(" Catarro");
        check.enqueue("Cabum");
        check.switche();
        check.enqueue("Carlinhos");
        check.enqueue("Papyrus");
        System.out.println(check.size());
        check.switche();
        
        check.enqueue("Sanes");
        
        System.out.println(check.dequeue());
        System.out.println(check.dequeue());
        System.out.println(check.dequeue());
        check.switche();
        System.out.println(check.dequeue());
        System.out.println(check.dequeue());
        System.out.println(check.dequeue());
    }
}