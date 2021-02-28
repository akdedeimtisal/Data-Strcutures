
public class AvlNode<T> {
    T element;
    AvlNode<T> left;
    AvlNode<T> right;
    int height;

     AvlNode(T theElement) {
        this(theElement, null, null);
                   
    }

    public AvlNode(T theElement, AvlNode<T> l, AvlNode<T> r ) {
        element = theElement;
        left = l;
        right = r;
        height = 0;
    }
     
    
    
    
    
    
    
}
