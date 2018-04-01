package basic;

import java.io.*;

/**
 * Created by Administrator on 2018/3/21.
 */
public class IoTest {

	public static void main(String[] args) throws Exception
	{
		File file = new File("");
		FileInputStream fi = new FileInputStream(file);
		BufferedInputStream buffer = new BufferedInputStream(fi);
	}

}
