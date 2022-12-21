import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
public class Text {
static int N=5;
public static String StatList(String str) {
    StringBuffer sb = new StringBuffer();
    HashMap<String ,Integer> has = new HashMap<String ,Integer> (); 
    String[] slist = str.split("[^a-zA-Z\']+");
    for (int i = 0; i < slist.length; i++)
    {
        if (!has.containsKey(slist[i]))
        {
               has.put(slist[i], 1);
        }
        else
        {
               has.put(slist[i],has.get(slist[i])+1 );
        }
    }
    Iterator<String> iterator = has.keySet().iterator();
    String a[]=new String[100];
    int s[]=new int[100];
    int judge;
    int n;
    Scanner in=new Scanner(System.in);
    System.out.println("输入前n个最常出现的单词:");
    n=in.nextInt();
    for(int i=0;i<n;i++)
    {
        iterator = has.keySet().iterator();
        while(iterator.hasNext())
        {
            String word = (String) iterator.next();
            if(s[i]<has.get(word))
            {
                s[i]=has.get(word);
                a[i]=word;
            }
         }
        judge=woor(a[i]);
        if(judge==1)
        {
            n++;
            has.remove(a[i]);
        }
        else
        {
         sb.append("words:").append(a[i]).append(" times").append(has.get(a[i])).append("\r\n");
         has.remove(a[i]);
        }
    }
         return sb.toString();
    }


    public static void main(String[] args)
    {
        File file = new File("a");
        
        ArrayList<String> fil = getDirectory(file);
        for(int i=0;i<fil.size();i++)
        {
        String filePath = fil.get(i);
        String sz = writeFromFile.readTxtFile(filePath);
        zimu(filePath);
        String ltxt=null;
        System.out.println(ltxt=StatList(sz));
        try {
        writeFromFile.daochu(ltxt);
        } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        }
        }
    }
    public static int woor(String a)
    {
        int n=0;
        String[] biao= {"a","the","an"};
        for(int i=0;i<biao.length;i++)
        {
            if(biao[i].equals(a))
            {
                n=1;
            }
        }
        return n;
    }
    public static ArrayList<String> getFiles(String path) {
        ArrayList<String> files = new ArrayList<String>();
        File file = new File(path);
        File[] tempList = file.listFiles();
        for (int i = 0; i < tempList.length; i++) {
            if (tempList[i].isFile()) {
                files.add(tempList[i].toString());
            }
            if (tempList[i].isDirectory()) {
            }
        }
        return files;
    }
    private static ArrayList<String> getDirectory(File file) {
        ArrayList<String> files = new ArrayList<String>();
        ArrayList<String> files1 = new ArrayList<String>();
   
        File flist[] = file.listFiles();
        for (File f : flist) {
            if (f.isDirectory()) {
               
                files1=getFiles(f.getAbsolutePath());
                files.addAll(files1);

                getDirectory(f);
            } else {
           
                files.add(f.getAbsolutePath());
            }
        }
        return files;
    }
    public static void zimu(String path)
    {
        try {
        
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            DecimalFormat df = new DecimalFormat("#.00");
            HashMap<String, Integer> map = new HashMap<String, Integer>();

            String string =null;
            Integer count = 0;
            Integer total = 0;

            try {
                while ((string=br.readLine())!=null) {
                    char[] ch = string.toCharArray();

                    for (int i = 0; i < ch.length; i++) {
                        if (ch[i] > 'A' && ch[i]< 'z') {

                        total++;
                        ch[i] = Character.toLowerCase(ch[i]);
                        count = map.get(ch[i]+"");
                        if (count == null) {
                            count = 1;
                        }else {
                            count++;
                        }
                        map.put(ch[i]+"", count);
                    }
                    }
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
             ArrayList<String> list = new ArrayList<String>();
             list.addAll(map.keySet()); 
             NumberFormat numberFormat = NumberFormat.getInstance();

            

            numberFormat.setMaximumFractionDigits(2);

             for(int i = 0;i < list.size();i++)
             {

                 for(int j = 0;j < (list.size() - i-1);j++)     
                 {

                     if(map.get(list.get(j)) < map.get(list.get(j+1)))
                     {
                         String t = list.get(j);
                         list.set(j, list.get(j+1));
                         list.set( j+1, t);
                     }
                 }
             }
             for(int i = 0 ; i < list.size();i++)
                {

                    System.out.println(list.get(i) + ":" + map.get(list.get(i)) +"   "+ df.format(((float)map.get(list.get(i)))*100/total) + "%");
                }


        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }
    }



}