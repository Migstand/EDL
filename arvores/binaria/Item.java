public class Item{
    private int chave;
    private Object elemento;

    public Item(int cha, Object ele){
        chave = cha;
        elemento = ele;
    }

    public int getChave(){
        return chave;
    }

    public Object getElemento(){
        return elemento;
    }
}