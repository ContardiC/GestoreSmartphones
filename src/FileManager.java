import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileManager {
    RandomAccessFile randomAccessFile;
    File file;

    public FileManager(File file){
        this.file=file;
    }
    public void open(){
        try {
            randomAccessFile=new RandomAccessFile(file,"rw");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void writeString(String str){
        try {
            randomAccessFile.writeChars(str);
        }catch(IOException  ex){
            ex.printStackTrace();
        }
        for(int i=str.length();i<Smartphone.MAX_LENGTH;i++){
            try{
                randomAccessFile.writeChar('\0');
            }catch(IOException ex){
                ex.printStackTrace();
            }
        }
    }
    public String readString(){
        String str="";
        char c=' ';
        for(int i=0;i<Smartphone.MAX_LENGTH;i++){
            try {
                c=randomAccessFile.readChar();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(c!='\0'){
                str+=c;
            }
        }
        return str;




    }




}
