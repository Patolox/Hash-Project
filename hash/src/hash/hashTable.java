
package hash;

import java.io.IOException;



public class hashTable {
    
    private toArchive arq;
    private Node[] table; //TABELA HASH
    private boolean check;
    
    
    //INSTANCIA TABELA HASH
    public hashTable(int n){
        this.arq = new toArchive();
        this.table = new Node [n];
    }
    
    public hashTable(int i, int j){ // I = NUMEROS DISTINTOS (APROXIMADO)  , J = TOTAL (APROXIMADO)
        //CALCULAR O TAMANHO
        
        double t = (double)i/j;
        double p = (t*i + i) + 0.1*i; //Admite 10%
        System.out.println("TAMANHO DO VETOR: " + (int) p);
        this.table = new Node [(int) p];
        this.arq = new toArchive();
        
    }
    
    //INSERE DO ARQUIVO
    public void insert() throws IOException{
        readFromArchive ra = new readFromArchive();
        int x = ra.getNumberInNextLine(0);
        int i = 0;
        Node srch = new Node(null);
        Node srchList = new Node(null);
        
        while(x != -1 && ra.isNotNull){
            
        srch = search(x);
        if(srch != null){
        srchList = srch.nodeList.search(x);
        
        }else{
            srchList = null;
        }
        
        if (srch != null && srch.getInfo().compareTo(x) == 0){
                
            srch.setQtd(srch.getQtd() + 1);
                
            }else if(srchList != null && srchList.getInfo().compareTo(x) == 0){
                   
            srchList.setQtd(srchList.getQtd() + 1);
            
            }else{
            insert(x);
            }
            
            i++;
            x = ra.getNumberInNextLine(i);
            
            }
        
        
        System.out.println("VALORES DO ARQUIVO INSERIDOS NA HASH");
        save();
        System.out.println("");
    }
    
    public void save(){
 
        this.arq.Save(table);
        
    }
    
    private void insert(int x){
        Node n = new Node(x);
        Node aux = search(x);
        
        if(aux == null && this.check == true){
            this.table[hashFunction(x)] = n;
            n.setQtd(1);
            this.check = false;
            
        }else{
    //INSERE NA LISTA ENCADEADA
            this.table[hashFunction(x)].nodeList.insert(x);
            System.out.println(x);
            this.table[hashFunction(x)].nodeList.search(x).setQtd(1);
            
        }
    }
    
    //FUNCAO HASH CLASSICA
    private int hashFunction(int x){
        
        if(x == 0){
            return x;
        }
        
        return (x%this.table.length);
        
    }
    
    
    //PROCURA NA INSERCAO
    private Node search(int x){
        
        Node k = this.table[hashFunction(x)];
        
        if(k == null){
            
            this.check = true;
            return null;
            
        }else if(k.getInfo().compareTo(x) == 0){
            
            return k;
        }
    
        return k;
    
    }
    
    
    //RETORNA VALOR
    public void searchValue(int x){
        
        Node search = this.table[hashFunction(x)];
        Node s = search.nodeList.search(x);
       
        if(search == null){
            System.out.println("VALOR NAO ENCONTRADO NA TABELA");
        }else if(search.getInfo().compareTo(x) == 0){
            System.out.println(search.getInfo());
        }else{
            
            if(s == null){
                System.out.println("VALOR NAO ENCONTRADO NA TABELA");
            }else{
                System.out.println(s.getInfo());
            }
            
        }
        
        
        
    }
    
    //MOSTRA VALORES ARMAZENADOS NA LISTA
    public void show(){
        for(int x = 0; x < this.table.length; x++){
            if(this.table[x] != null){
            System.out.println("TABLE: " + this.table[x].getInfo() + " QTD " + this.table[x].getQtd());
            this.table[x].nodeList.show(); //NUMEROS DA LISTA
        }
      }
    }
    
}
