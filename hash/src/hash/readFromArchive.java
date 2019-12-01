package hash;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;


public class readFromArchive{

    private static final File data = new File("dados.txt");
    private FileReader fr;
    private BufferedReader br;
    protected boolean isNotNull = true;
    
    public int getNumberInNextLine(int line) throws IOException{
        
        fr = new FileReader(data);
        br = new BufferedReader(fr);
        int i = 0;
        int n = -1;
        while(i < line && br.ready()){
            br.readLine();
            i++;
        }
        
        if(br.ready()){
        String l = br.readLine();
      try{
        n = Integer.parseInt(l);
      }catch(Exception e){
          return -1;
      }finally{
        fr.close();
        br.close();
        return n;
      }
        
        }else{
            isNotNull = false;
            return -1;   
            
            }
        }
    }
    

