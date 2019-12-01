package hash;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class toArchive {

    public void Save(Node table[]){
        
        File f = new File("resultados.txt");
        
        if(!f.exists()){
            try {
                f.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(toArchive.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
          for(int i = 0; i < table.length; i++){
            if(table[i] != null){
            bw.write(table[i].toString());
            bw.newLine();
            bw.write("--------------------");
            bw.newLine();
            }
            }
            bw.close();
            fw.close();
            
            
        } catch (IOException ex) {
            Logger.getLogger(toArchive.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
}
