
package hash;

 class Node<T extends Comparable <T>> {
    
    private T info;
    private Node next;
    protected LSE nodeList;
    private int qtd;
    
    Node(T info){
        this.info = info;
        this.nodeList  = new LSE();
    }
    
    public void setInfo(T info){
        this.info = info;
    }
    
    public void setNext(Node n){
        this.next = n;
    }
    
    public void setQtd(int q){
        this.qtd = q;
    }
    
    public T getInfo(){
        return this.info;
    }
    
    public Node getNext(){
        return this.next;
    }
    
    public int getQtd(){
        return this.qtd;
    }
   
    public String toString(){
        return "" + this.info + "  " + this.qtd;
    }
   
}
