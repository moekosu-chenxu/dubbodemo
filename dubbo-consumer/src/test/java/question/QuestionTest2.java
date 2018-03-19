package question;

/**
 * 打印出5,6,7,8所有可能组合的数字
 * Created by Administrator on 2018/3/13.
 */
public class QuestionTest2 {

	public static void main(String[] args) {
		String s = "12345";// 这里是要用到的所有数组成的一个字符串,其它字符同样适用
		char[] c = s.toCharArray();
		new QuestionTest2().zuhe(c,c.length,0);
		System.out.println("可能的组合数：" + kk);
	}
	static int kk = 0;
	private void zuhe(char[] array,int n,int k)
	{
		if (n == k) {
			String str = new String(array);
			System.out.println(str);
			++kk;
		}
		else {
			for (int i = k; i < n; i++) {
				swap(array,k,i);
				zuhe(array,n,k + 1);
				swap(array,i,k);
			}
		}
	}
	// a数组中调换x与y位置的值
	private void swap(char[] a,int x,int y)
	{
		char temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}

}
