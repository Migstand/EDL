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

    public void setEsq(No ele){
        this.esquerdo = ele;
    }

    public void setDir(No ele){
        this.direito = ele;
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

    public void setPai(No pai){
        this.pai = pai;
    }

    public void setElemento(Object o){
        this.elemento = o;
    }
}
