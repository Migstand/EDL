public class Teste{
    public static void main(String[] args){
        Item it = new Item(3, "pvc");
        HeapArray hop = new HeapArray(it);

        Item pod = hop.elemento(1);
        System.out.println(pod.getChave());
        System.out.println(hop.size());
    }   
}