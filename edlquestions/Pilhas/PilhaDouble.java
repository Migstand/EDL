public interface PilhaDouble{
    public int size();

    // RED
    public int sizered();
    public boolean isEmptyred();
    public Object topred() throws PilhaVaziaException;
    public void pushred(Object o);
    public Object popred() throws PilhaVaziaException;

    // Black
    public int sizeblack();
    public boolean isEmptyblack();
    public Object topblack() throws PilhaVaziaException;
    public void pushblack(Object o);
    public Object popblack() throws PilhaVaziaException;
}