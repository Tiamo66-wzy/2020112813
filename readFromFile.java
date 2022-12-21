import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class readFromFile {
    public static String readTxtFile(String filePath){
    try {
        String encoding="GBK";
        File file=new File(filePath);
        if(file.isFile() && file.exists()){ 
        InputStreamReader read = new InputStreamReader(
        new FileInputStream(file),encoding);
        BufferedReader bufferedReader = new BufferedReader(read);
        String lineTxt = null;
        String lineText="";
        while((lineTxt = bufferedReader.readLine()) != null)
            {
            lineText+=(lineTxt);
            }
        read.close();
        return lineText;
        }
        else
            {
            System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
        System.out.println("读取文件内容出错");
        e.printStackTrace();
        }
        return null;
    }
    public static void daochu(String a) throws IOException
    {
        File file=new File("b.txt");
        FileOutputStream fos=new FileOutputStream(file);
        OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
        osw.append(a);
        osw.close();
        fos.close();
    }
}