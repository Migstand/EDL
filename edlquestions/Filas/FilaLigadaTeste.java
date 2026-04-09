public class FilaLigadaTeste{
    public static void main(String[] args){

        FilaLigada rapido = new FilaLigada();
        
        System.out.println(rapido.size());
        rapido.enqueue("chupa cabra");
        System.out.println(rapido.size());

    }
}