public interface Lista{
    public int size();
    public boolean isEmpty();
    public void isFirst(DubNo n);
    public void isLast(DubNo n);
    public Object first();
    public Object last();
    public Object before(DubNo p);
    public Object after(DubNo p);
    public Object before(DubNo n);
    public Object replaceElement(n, o);
    public Object swapElements(n, o);
    public void insertBefore(n, o);
    public void insertAfter(n, o);
    public void insertFirst(o);
    public void insertLast(o);
    public Object revome(n);
}