package thread;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch
 * 主要功能是实现线程的等待，但应用场景偏向于等待所有进程完成后（锁住），再执行自己的另一些代码
 * 计数完成后，对象不能再重用了
 * Created by moekosu on 2018/3/20.
 */
public class CountDownLatchTest {

	public static void main(String[] args)
	{
		int threadCount = 10;

		// TODO 初始化计数为10
		final CountDownLatch cdl = new CountDownLatch(threadCount);

		for (int i=0; i< threadCount; i++)
		{
			new Thread(new Runnable() {
				@Override
				public void run() {
					System.out.println("线程 " +Thread.currentThread().getId() + " 开始");
					try {
						Thread.sleep(1000);
					}
					catch (Exception e){
						e.printStackTrace();
					}
					System.out.println("线程 " +Thread.currentThread().getId() + " 结束");
					// TODO cdl计数-1
					cdl.countDown();
				}
			}).start();
		}

		try {
			// TODO 计数到达0，释放锁
			// TODO PS 计数到达0之后，就结束，无法重新初始化计数
			cdl.await();
		}
		catch (Exception e){
			e.printStackTrace();
		}

		System.out.println("线程执行完毕，开始执行下个进程");
	}

}
