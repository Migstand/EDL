public class MainPTeste{
    public static void main(String[] args){
        //PilhaArray lista = new PilhaArray(10, 1);

        //System.out.print(lista.size());
        
        //lista.push(10);

        //System.out.print(lista.size());

        //lista.pop();
        
        //System.out.print(lista.size());

        PilhaArrayDouble redblack = new PilhaArrayDouble(5);

        redblack.pushred(10);
        redblack.pushred(20);
        redblack.pushblack(40);
        redblack.pushblack(40);
        redblack.pushblack(40);

        System.out.print(redblack.size());
        System.out.print(redblack.sizered());
        System.out.println(redblack.sizeblack());
        System.out.println(redblack.topred());
        System.out.println(redblack.topblack());

        redblack.pushblack(1);

        System.out.print(redblack.size() + "Tamanho");
        System.out.print(redblack.sizered());
        System.out.println(redblack.sizeblack());
        System.out.println(redblack.topred());
        System.out.println(redblack.topblack());

        redblack.pushred(10);
        redblack.pushred(20);
        redblack.pushblack(40);
        redblack.pushblack(40);
        redblack.pushblack(40);

        System.out.print(redblack.size() + "tamanho");
        System.out.print(redblack.sizered());
        System.out.println(redblack.sizeblack());
        System.out.println(redblack.topred());
        System.out.println(redblack.topblack());
    }
}