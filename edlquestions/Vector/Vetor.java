public interface Vetor{
    public abstract Object eleAtRank(int r);
    public abstract Object replaceAtrank(int r, Object o);
    public abstract void insertAtRank(int r, Object o);
    public abstract Object removeAtrank(int r) throws VetorVazioExcecao;
    public abstract int size();
    public abstract boolean isEmpty();
}