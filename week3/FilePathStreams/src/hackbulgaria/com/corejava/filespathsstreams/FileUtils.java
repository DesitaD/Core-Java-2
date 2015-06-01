package hackbulgaria.com.corejava.filespathsstreams;

import java.awt.List;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class FileUtils {
    private FileUtils(){
        
    }
    
    public static String readFrom(File file) throws IOException{   
       StringBuilder container=new StringBuilder();
            FileReader fr=new FileReader(file); 
           
            BufferedReader br=new BufferedReader(fr);
            String line;
            while ((line=br.readLine())!=null){
                System.out.println(line);
                container.append(line);
            }
            br.close(); 
            
            return container.toString();
    }
    
    public static String readFrom(Path path) throws IOException {
        File file= new File(path.toString());
        return readFrom(file);
    }
    
    public static void writeIn(String content, File outputFile) throws IOException{
        if(outputFile.exists()){
            FileWriter fw= new FileWriter(outputFile);
            BufferedWriter writer= new BufferedWriter(fw);
            writer.write(content);
            writer.close();
        }
        else{
            outputFile.createNewFile();
            FileWriter fw= new FileWriter(outputFile);
            BufferedWriter writer= new BufferedWriter(fw);
            writer.write(content);
            writer.close();
        }
        
        
    }
    public static void writeIn(String content, Path outputFilePath) throws IOException{
        File file= new File(outputFilePath.toString());
        writeIn(content, file);
    }
    
    
    public static Map<String, String> parseProperties(File file) throws IOException{
        Map<String,String> map= new HashMap<String,String>();
        FileReader fr=new FileReader(file); 
        BufferedReader br=new BufferedReader(fr);
        StringBuilder contentKey = new StringBuilder();
        StringBuilder contentValue = new StringBuilder();
        String line;
        int i=0;
        int t=0;
        while((line=br.readLine())!=null){
           
            if(!line.startsWith("#")){
                if(line.indexOf("#")==-1){
                int k=line.indexOf('=');
                contentKey.append(line.substring(0, k));
                contentValue.append(line.substring(k+1, line.length() ));
                System.out.println("L   "+line.toString());  
                map.put(contentKey.toString(), contentValue.toString());
            }else{
                int k=line.indexOf('=');
                contentKey.append(line.substring(0, k));
                contentValue.append(line.substring(k+1, line.indexOf("#") ));
                System.out.println("L   "+line.toString());  
                map.put(contentKey.toString(), contentValue.toString());
            }
            }
           // System.out.println(contentValue.toString());
            
            contentKey.setLength(0);
            contentValue.setLength(0);
            t=0;
           
        }    
        System.out.println(map.toString());
        return map;
        
    }
    
    public static void wordCount(Path path) throws IOException{
        File file= new File(path.toString());
        wordCount(file);
    }
    
    public static void wordCount(File file) throws IOException{
        StringBuilder container=new StringBuilder();
        FileReader fr=new FileReader(file); 
       
        BufferedReader br=new BufferedReader(fr);
        String line;
        int wordsCounter=0;
        int characterCounter=0;
        int lineCounter=0;
        while ((line=br.readLine())!=null){
           lineCounter++;
           int count = 0;
           for(int e = 0; e < line.length(); e++){
               if(line.charAt(e) != ' '){
                   count++;
                   while(line.charAt(e) != ' ' && e < line.length()-1){
                       e++;
                   }
               }
           }
           wordsCounter+=count;
           container.append(line.trim());
           System.out.println(container.toString());
           characterCounter+=container.length();
           container.delete(0, container.length());
        }
        
        System.out.println("Lines: "+lineCounter+" Words: "+ wordsCounter+ " Cherackters: "+characterCounter);
    }
    public static Path reduceFilePath(String path){
        Path newPath= Paths.get(path);
        return newPath.normalize();
    }
    
    public static void fixEncoding(Path path) throws IOException {
        byte[] bis=Files.readAllBytes(path);
        bis=new String(bis,"windows-1251").getBytes("UTF-8");
        Path destPath= Paths.get("D:/test.txt");
        Files.write(destPath, bis);
       
       }
    
    public static void linkChecker(Path path) throws IOException{
          File file = new File(path.toString());
            if (Files.isSymbolicLink(path) && file.isFile() && file.isDirectory()) {
                System.out.println(Files.readSymbolicLink(path));
                System.out.println(path);
            }
            else if (file.isDirectory()) {            
                String[] children = file.list(); 
                for (String child : children) {
                    linkChecker((new File(file, child)).toPath());
               } 
            
        }
    }

    

    public static void compress(Path filePath) throws IOException{
        File file= new File(filePath.toString());
        FileWriter fiWhi= new FileWriter("D:/proba.txt");
        HashMap hm =new HashMap ();
        StringBuilder container=new StringBuilder();
        FileReader fr=new FileReader(file); 
        BufferedWriter writer= new BufferedWriter(fiWhi);
   
        List listOfWords =new List();
        BufferedReader br=new BufferedReader(fr);
        String line;
        int index=0;
        hm.put(" ", "~");
        while ((line=br.readLine())!=null){
             
                for(int e = 0; e < line.length(); e++){
                     while(line.charAt(e) != ' ' && e < line.length()-1){
                            container.append(line.charAt(e));
                            e++;
                        }

                     if (line.length()-1==e){
                         container.append(line.charAt(e));
                     }
                        if(!hm.containsKey(container.toString())){
                        hm.put(container.toString(),index);
                        index++;
                        }
                        container.delete(0, container.length());
                        
                     }
                writer.write("Legend:"+hm.toString());
                writer.write(System.getProperty("line.separator"));
               String [] array=line.split(" ");
               for(int i=0;i<array.length;i++){
                  if( hm.containsKey(array[i])){
                     // writer.write(hm.get(" ").toString());
                     writer.write(hm.get(array[i]).toString());
                     writer.write(hm.get(" ").toString());
                     
                  }
               }
               writer.close();
             
                System.out.println(hm.toString());
            System.out.println(line);   
        }           
    }
    
    public static void deCompress(Path filePath) throws IOException{
        File file= new File(filePath.toString());
        HashMap hm =new HashMap<String, String> ();
        StringBuilder container=new StringBuilder();
        StringBuilder contain=new StringBuilder();
        String allContent= readFrom(file);
        FileWriter fiWhi= new FileWriter("D:/ABABA.txt");
        BufferedWriter writer= new BufferedWriter(fiWhi);
        container.append(allContent.substring(allContent.indexOf('{')+1, allContent.indexOf('}')));
        container.append(',');
        
        for(int i=2;i<container.length();i++){
            if(container.charAt(i)== ' '){
                container.deleteCharAt(i);
            }
        }
       
        
        for(int index=0; index<container.length();index++){
           if(container.charAt(index) != ','){
               contain.append(container.charAt(index));
           }
           else{             
          hm.put(contain.substring(contain.indexOf("=")+1,contain.length()),contain.substring(0, contain.indexOf("=")));
          contain.delete(0, contain.length());
           }       
      }
        
       
       container.delete(0,container.length());
        container.append(allContent.substring(allContent.indexOf('}')+1, allContent.length()));
     
        for(int k=0; k<container.length();k++){
            writer.write(hm.get(container.charAt(k)+"").toString());
         
        }
        writer.close();
    }
  
    public static void main(String[] args) throws IOException {
        File f= new File("D:/try.txt");
       parseProperties(f);
        System.out.println(readFrom(f));
        wordCount(f);
        System.out.println("The content of file000000   "+readFrom(f));
        System.out.println(reduceFilePath("/../"));
        File fw=new File("D:/lost.s04e11.hdtv.xvid-2hd.srt");
        fixEncoding(fw.toPath());
        File filew=new File("D:/testCompress.txt");
        
       compress(filew.toPath());
       
        
        
    }

}
