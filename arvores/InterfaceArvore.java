import java.util.Iterator;

public interface InterfaceArvore {
    
    // GENERIC METHODS \\

    public int size();
    public int height(No no);
    public boolean isEmpty();
    public Iterator<Object> elements();
    public Iterator<No> nos();

    // ACCESS METHODS \\

    public No root();
    public No parent(No no);
    public Iterator<No> children(No no);

    // CONSULT METHODS \\
    
    public boolean isInternal(No no);
    public boolean isExternal(No no);
    public boolean isRoot(No no);
    public int depth(No no);

    // UPDATE METHODS \\
    public Object replace(No no , Object o);

}