package question;

import org.junit.Test;

import java.io.File;
import java.util.Scanner;

/**
 * 输入目录，输出所有的子文件夹与子文件
 * @System.in G:\360驱动大师目录
 * Created by Administrator on 2018/3/12.
 */
public class QuestionTest {

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		String str1 = scanner.nextLine();

		sout(str1);
	}

	private static void sout(String path)
	{
		File file = new File(path);
		if(file.isDirectory()){
			System.out.println(file.getPath());
			String[] names =file.list();
			for (int i= 0; i< names.length; i++){
				sout(path + "\\" + names[i]);
			}
		}
		else if(file.isFile()){
			System.out.println(file.getPath());
		}
	}

}
