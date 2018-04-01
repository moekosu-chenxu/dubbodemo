package thread;

import java.util.concurrent.Semaphore;

/**
 * Semaphore
 * 主要功能类似锁，应用场景一般是控制对某些资源的访问权限
 * Created by moekosu on 2018/3/21.
 */
public class SemaphoreTest {

	public static void main(String[] args)
	{
		/**
		 * 情景：假设工厂有5台机器，却有8个工人，每次只能等一个工人使用完了机器才能给下个人使用
		 */
		int machine = 5;
		int person = 8;

		final Semaphore sem = new Semaphore(machine);

		for (int i= 0; i< person; i++)
		{
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						// TODO 类似锁，等待获取一个许可，未获取到就等待
						sem.acquire();
						System.out.println("工人占用一台机器");
						Thread.sleep(1000);
						System.out.println("工人释放机器");
						// TODO 完成工作后，释放当前许可，让别人可以获取到许可
						sem.release();
					}
					catch (Exception e){
						e.printStackTrace();
					}
				}
			}).start();
		}
	}

}
