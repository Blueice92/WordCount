import java.io.*;
import java.util.regex.*;

/**
 * @author 92
 */
public class Count {
    public void charCount(String path) throws IOException {
        int count = 0;
        File file = new File(path);
        if (file.exists()) {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String str;
            while ((str = br.readLine()) != null) {
                //循环处理每一行
                str = str.replace(" ", "");
                //去除多余的空格
                count += str.length();
            }
            System.out.println("char number is " + count);
            br.close();
        } else {
            System.out.println("file is not exist");
        }
    }


    public void wordCount(String path) throws IOException {
        int count = 0;
        File file = new File(path);
        if (file.exists()) {
            String regex = "\\b[a-zA-Z]+\\b",str;
            //匹配单词
            BufferedReader br = new BufferedReader(new FileReader(file));
            Pattern p = Pattern.compile(regex);
            while ((str=br.readLine()) != null) {
                //循环匹配每一行
                Matcher matcher = p.matcher(str);
                while (matcher.find()) {
                    count++;
                }
            }
            System.out.println("word number is " + count);
            br.close();
        } else {
            System.out.println("file is not exist");
        }
    }

    public void lineCount(String path) throws IOException {
        int count = 0;
        File file = new File(path);
        if (file.exists()) {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while (br.readLine() != null) {
                //循环处理每一行
                count++;
            }
            System.out.println("Line number is " + count);
            br.close();
        } else {
            System.out.println("file is not exist");
        }
    }

    public void specialLine(String path) throws IOException {
        int blankcount = 0, commentcount =0, codecount = 0;
        String str;
        String regex1 = "(\\{|\\})?\\s*";
        //匹配空行
        String regex2 = "\\s*(\\{|\\})?\\s*//.*";
        //匹配单行注释
        String regex3 = "\\s*(\\{|\\})?/\\*.*";
        //匹配多行注释的开头
        String regex4 = ".*\\*/";
        //匹配多行注释的结尾
        boolean tag = false;
        File file = new File(path);
        if (file.exists()) {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while((str=br.readLine())!=null){
                if(str.matches(regex1)){
                    blankcount++;
                }
                else if (str.matches(regex2)){
                    commentcount++;
                }
                else if(str.matches(regex3)){
                    commentcount++;
                    tag = true;
                }
                else if (str.matches(regex4)){
                    commentcount++;
                    tag = false;
                }
                else if(tag){
                    commentcount++;
                }
                else {
                    codecount++;
                    //如果不是空行或者注释行则为代码行
                }

            }
            System.out.println("Blank line number is " + blankcount);
            System.out.println("Comment line number is " + commentcount);
            System.out.println("Code line number is " + codecount);
            br.close();
        }
    }

        public void readFile (String path) throws IOException{
            File file = new File(path);
            if (file.isDirectory()){
                File[] files = file.listFiles();
                if (files==null){
                    System.out.println("files is not exist");
                }
                else if (files.length==0){
                    System.out.println("The file folder is empty");
                }
                else{
                    for (File f : files){
                        if(f.isDirectory()){
                            readFile(f.getPath());
                            //如果是文件夹则递归
                        }
                        else if(f.isFile()){
                            System.out.println("-------"+f.getName()+"-------");
                            this.charCount(f.getPath());
                            this.wordCount(f.getPath());
                            this.lineCount(f.getPath());
                            this.specialLine(f.getPath());
                        }
                    }
                }
                }
            else if(file.isFile()&&file.exists()){
                this.charCount(file.getPath());
                this.wordCount(file.getPath());
                this.lineCount(file.getPath());
                this.specialLine(file.getPath());
            }
    }
}