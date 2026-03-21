public class MainPTeste{
    public static void main(String[] args){
        PilhaArray lista = new PilhaArray(10, 1);

        System.out.print(lista.size());
        
        lista.push(10);

        System.out.print(lista.size());

        lista.top();
        
        System.out.println(lista.size());
    }
}