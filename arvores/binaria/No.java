public class No {
    private Object elemento;
    private No pai;
    private No esquerdo;
    private No direito;

    public No(No p, Object ele){
        this.pai = p;
        this.elemento = ele; 
        this.esquerdo = null;
        this.direito = null;
    }

    public void setEsq(Object ele){
        this.esquerdo = new No(this, ele);
    }

    public void setDir(Object ele){
        this.direito = new No(this, ele);
    }

    public No getEsq(){
        return esquerdo;
    }

    public No getDir(){
        return direito;
    }
    
    public Object getElemento(){
        return elemento;
    }

    public No getPai(){
        return pai;
    }

    public void setElemento(Object o){
        this.elemento = o;
    }
}
