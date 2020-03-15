import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Count  c = new Count();
        boolean a = true;
        //控制循环
        String path;
        String choice;
        System.out.println("-----------------------------------");
        System.out.println("欢迎使用此程序(by 3118005051)");
        System.out.println("程序功能");
        System.out.println("-c：返回文件的字段数");
        System.out.println("-w：返回文件的词的数");
        System.out.println("-l：返回文件的行数");
        System.out.println("-s：递归处理目录下符合条件的文件");
        System.out.println("-a：返回文件的代码行数/空行数/注释数");
        System.out.println("输入其他任意字符退出程序");
        System.out.println("------------------------------------");
        while (a){
            System.out.println("请输入命令（格式：[parameter] [file_name]）");
            Scanner scanner1 = new Scanner(System.in);
            choice = scanner1.next();
            path = scanner1.next();
            switch (choice){
                case "-c":c.charCount(path); break;
                //选择返回文件的字段数
                case "-w":c.wordCount(path); break;
                //选择返回文件的单词数
                case "-l":c.lineCount(path); break;
                //选择返回文件的行数
                case "-s":c.readFile(path); break;
                //选择递归处理文件
                case "-a":c.specialLine(path); break;
                //选择返回文件的代码行数/空行数/注释数
                default: a=false;break;
                //输入其他指令则退出循环，程序结束
            }
    }
    }
}
