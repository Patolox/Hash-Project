
package hash;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Hash {


    public static void main(String[] args) {
       //TESTES
       readFromArchive ra = new readFromArchive();
       hashTable ht = new hashTable(6, 11);
       
        try {
            ht.insert();
        } catch (IOException ex) {
            Logger.getLogger(Hash.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        ht.show();

    }
    
}
