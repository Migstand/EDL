public class FilaInverteTeste{
    public static void main(String[] args){
        
        FilaInverte check = new FilaInverte(5);

        System.out.println(check.size());
        
        check.switche();
        
        
        check.enqueue("Pai");
        System.out.println(check.size());
        
        
        check.enqueue("chupa cabra");
        System.out.println(check.size());
        
        
        check.enqueue(" Catarro");
        System.out.println(check.size());
        
        
        check.enqueue("Cabum");
        System.out.println(check.size());
        
        
        check.switche();

        check.enqueue("Carlinhos");
        System.out.println(check.size());
        

        check.enqueue("Papyrus");
        System.out.println(check.size());
        

        check.switche();
        
        check.enqueue("Sanes");
        System.out.println(check.size());
        

        System.out.println(check.dequeue());
        System.out.println(check.size());
        

        System.out.println(check.dequeue());
        System.out.println(check.size());
        

        System.out.println(check.dequeue());
        System.out.println(check.size());

        check.switche();
        
        System.out.println(check.dequeue());
        System.out.println(check.size());
        

        System.out.println(check.dequeue());
        System.out.println(check.size());
        

        System.out.println(check.dequeue());
        System.out.println(check.size());
        
    }
}