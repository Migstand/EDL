public class MainPTeste{
    public static void main(String[] args){
        //PilhaArray lista = new PilhaArray(10, 1);

        //System.out.print(lista.size());
        
        //lista.push(10);

        //System.out.print(lista.size());

        //lista.pop();
        
        //System.out.print(lista.size());

        PilhaArrayDouble redblack = new PilhaArrayDouble(7);

        redblack.pushred(10);
        redblack.pushred(20);
        redblack.pushblack(30);
        redblack.pushblack(40);
        redblack.pushblack(50);

        System.out.println(redblack.size() + " Total");
        System.out.println(redblack.sizered() + " Vermelhos");
        System.out.println(redblack.sizeblack() + " Blacks");
        System.out.println(redblack.topred() + " Topo Vermelho");
        System.out.println(redblack.topblack() + " Topo Black");

        redblack.pushred(60);
        System.out.println(redblack.topred() + " Topo Red");
        redblack.pushred(70);
        System.out.println(redblack.topred() + " Topo Red");

        System.out.println(redblack.size() + " Total");
        System.out.println(redblack.sizered() + " Vermelhos");
        System.out.println(redblack.sizeblack() + " Blacks");
        System.out.println(redblack.topred() + " Topo Vermelho");
        System.out.println(redblack.topblack() + " Topo Black");
    }
}