# WordCount
程序处理用户需求的模式为：
wc.exe [parameter] [file_name]
基本功能列表：
  wc.exe -c file.c     //返回文件 file.c 的字符数
  wc.exe -w file.c    //返回文件 file.c 的词的数目  
  wc.exe -l file.c      //返回文件 file.c 的行数

扩展功能：
  -s   递归处理目录下符合条件的文件。
  -a   返回更复杂的数据（代码行 / 空行 / 注释行）。
