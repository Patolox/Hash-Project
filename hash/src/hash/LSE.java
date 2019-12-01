package hash;

public class LSE<T extends Comparable<T>> {
    
    private Node<T> first;
    private Node<T> last;
    private int qtd;
    
    
    public boolean isEmpty(){
        if(this.first == null){
            return true;
        }
        return false;
    }
    
    public void insert(T info){
        Node nNode = new Node(info);
        
        if(this.isEmpty() == true){
            
            this.first = nNode;
            this.last = nNode;
            this.qtd = 1;
            
        }else{
            
            if(this.first.getInfo().compareTo(info) > 0){
                
                nNode.setNext(this.first);
                this.first = nNode;
                this.qtd++;
                
            }else if(this.last.getInfo().compareTo(info) < 0){
                
                this.last.setNext(nNode);
                this.last = nNode;
                this.qtd++;
                
            }else{
                
                Node aux = this.first;
                Node aux2 = aux.getNext();
                
                while(aux2 != null){
                    
                    if(aux2.getInfo().compareTo(info) > 0){
                        aux.setNext(nNode);
                        nNode.setNext(aux2);
                        this.qtd++;
                        return;
                    }
                    
                    aux = aux.getNext();
                    aux2 = aux2.getNext();
                    
                }
                
            }
            
        }
    }
    
    public void remove(T info){
        
        if(this.isEmpty() == true){
            return;
        }else{
            
            if(this.qtd == 1){
                
                this.first = null;
                this.last = null;
                this.qtd--;
                
            }else if(this.first.getInfo().compareTo(info) == 0){
                
                this.first = this.first.getNext();
                this.qtd--;
                
            }else if(this.last.getInfo().compareTo(info) == 0){
                
                Node aux = this.first;
                Node aux2 = aux.getNext();
                
                while(aux2 != this.last){
                    aux2 = aux2.getNext();
                    aux = aux.getNext();
                }
                
                aux.setNext(null);
                this.last = aux;
            }else{
                
                
                Node aux = this.first;
                Node aux2 = aux.getNext();
                
                while(aux2 != null){
                    
                    if(aux2.getInfo().compareTo(info) > 0){
                        return;
                    }else if(aux2.getInfo().compareTo(info) == 0){
                        
                        aux.setNext(aux2.getNext());
                        this.qtd--;
                        return;
                        
                    }else
                    aux2 = aux2.getNext();
                    aux = aux.getNext();
                }
            }
            
        }
    }
    
    public Node search(T n){
        
        Node aux = this.first;
        
        if(this.isEmpty() == false){
        while(aux != null){
            
            if(aux.getInfo().compareTo(n) > 0){
                return null;
            }else if(aux.getInfo().compareTo(n) == 0){
                return aux;
            }
            
            aux = aux.getNext();
            }
        }
        return null;
    }
    
    public void show(){
        Node aux = this.first;
        if(this.isEmpty() == false){
        while(aux != null){
            System.out.println("LIST: " + aux.getInfo() + " QTD: " + aux.getQtd());
            aux = aux.getNext();
        }
        }
    }
    
    public int getQuantity(int x){
        if(this.isEmpty() == false){
        Node aux = this.first;
        int count = 0;
        
        while(aux != null){
            if(aux.getInfo().compareTo(x) == 0){
                count++;
            }
            aux = aux.getNext();
            }
        return count;
        }
        
        return 0;
    }
    
}
