package IO;

import java.io.File;
import java.io.IOException;

public class FileOpDemo {

    public static void main(String[] args) throws IOException {
//        FileOp();
        DirOp();
    }

    //文件操作
    public static void FileOp() throws IOException {
        String filePath = "./demo.txt";

        File newFile = new File(filePath);
        if(!newFile.exists()){
            if(newFile.createNewFile()){
                System.out.println("新文件创建成功");
            }
        }else{
            System.out.println(filePath+"文件已存在");
        }

        if(newFile.isFile()){
            System.out.println(filePath+"是文件");
        }

        //获取文件信息
        System.out.println("文件名"+newFile.getName());
        System.out.println("文件绝对路径"+newFile.getAbsolutePath());
        System.out.println("父目录"+newFile.getParent());
        System.out.println("父目录"+newFile.getPath());
        System.out.println("文件是否可读："+newFile.canRead());
        System.out.println("文件是否可执行："+newFile.canExecute());

        //删除文件
        //newFile.delete();
    }

    //目录操作
    public static void DirOp() throws IOException {
        String filePath = "src/IO";

        File newDir = new File(filePath);
        if(!newDir.exists()){
            if(newDir.mkdir()){
                System.out.println("新目录 创建成功");
            }
        }else{
            System.out.println(filePath+"目录 已存在");
        }

        if(newDir.isFile()){
            System.out.println(filePath+"是文件");
        }else if(newDir.isDirectory()){
            System.out.println(filePath+"是目录");
        }

        //获取目录信息
        System.out.println("文件名"+newDir.getName());
        System.out.println("文件绝对路径"+newDir.getAbsolutePath());
        System.out.println("父目录"+newDir.getParent());
        System.out.println("父目录"+newDir.getPath());
        System.out.println("文件是否可读："+newDir.canRead());
        System.out.println("文件是否可执行："+newDir.canExecute());

        //显示目录下的文件列表信息
        for(String v:newDir.list()){
            System.out.println("子文件名："+ v);
        }

        //删除文件
        //newFile.delete();
    }

}
