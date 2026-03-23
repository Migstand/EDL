public class PilhaArrayDouble implements PilhaDouble{
    private int capacidade;
    private Object [] el;
    private int tv;
    private int tb;
    
    // Init //
    public PilhaArrayDouble(int capacidade){
        this.capacidade = capacidade;
        tv = -1;
        tb = capacidade;
        el = new Object[capacidade];
    }

    // * MÉTODOS * //
    public void pushred(Object o){
        if (tv  >= tb + 1){
            int minus = sizeblack();
            capacidade*=2;

            Object b[] = new Object[capacidade];
            for (int f = 0; f<(tv+1); f++){
                b[f] = el[f];
            }
            int new_black = capacidade - minus;
            for (int f = 0; f < el.length-(tv+1); f++){
                b[new_black+f] = el[tb+f];
            }
            tb = new_black;
            el = b;
        }
        el[++tv] = o;
    }

    public Object popred() throws PilhaVaziaException{
        if(isEmptyred()){
            throw new PilhaVaziaException("A pilha está vazia");
        }
        Object r = el[tv--];
        return r;
    }

    public Object topred() throws PilhaVaziaException{
        if(isEmptyred()){
            throw new PilhaVaziaException("A pilha está vazia");
        }
        return el[tv];
    }

    public boolean isEmptyred(){
        return tv == -1;
    }

    public boolean isEmptyblack(){
        return tb == capacidade;
    }

    public int size(){
        return tv+1 + capacidade - tb;
    }

    public int sizered(){
        return tv+1;
    }

    public int sizeblack(){
        return capacidade - tb;
    }
    // * MÉTODOS black* //

    public void pushblack(Object o){
        if (tb <= tv + 1){
            int minus = sizeblack();
            capacidade*=2;


            Object b[] = new Object[capacidade];
            for (int f = 0; f<(tv+1); f++){
                b[f] = el[f];
            }
            int new_black = capacidade - minus;
            for (int f = 0; f < el.length-(tv+1); f++){
                b[new_black+f] = el[tb+f];
            }
            tb = new_black;
            el = b;
        }
        el[--tb] = o;
    }

    public Object popblack() throws PilhaVaziaException{
        if(isEmptyblack()){
            throw new PilhaVaziaException("A pilha está vazia");
        }
        Object r = el[tb++];
        return r;
    }

    public Object topblack() throws PilhaVaziaException{
        if(isEmptyblack()){
            throw new PilhaVaziaException("A pilha está vazia");
        }
        return el[tb];
    }
}   