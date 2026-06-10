public class Noh {
    private Item elemento;
    private Noh pai;
    private Noh esquerdo;
    private Noh direito;

    public Noh(Noh p, Item ele){
        this.pai = p;
        this.elemento = ele; 
        this.esquerdo = null;
        this.direito = null;
    }

    public void setEsq(Noh ele){
        this.esquerdo = ele;
    }

    public void setDir(Noh ele){
        this.direito = ele;
    }

    public Noh getEsq(){
        return esquerdo;
    }

    public Noh getDir(){
        return direito;
    }
    
    public Item getElemento(){
        return elemento;
    }

    public Noh getPai(){
        return pai;
    }

    public void setPai(Noh pai){
        this.pai = pai;
    }

    public void setElemento(Item o){
        this.elemento = o;
    }
}
