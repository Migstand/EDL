public interface Lista{
    public int size();
    public boolean isEmpty();

    public boolean isFirst(DubNo n); // V
    public boolean isLast(DubNo n); // V

    public DubNo first(); // V
    public DubNo last(); // V
    public DubNo before(DubNo p); // V
    public DubNo after(DubNo p); // V
    public Object replaceElement(DubNo n, Object o); // V
    
    public void swapElements(DubNo n, DubNo o); // V
    
    public DubNo insertBefore(DubNo n, Object o); // V 
    public DubNo insertAfter(DubNo n, Object o); // V
    
    public void insertFirst(Object o); // V

    public void insertLast(Object o); // V

    public Object remove(DubNo n); // 
}