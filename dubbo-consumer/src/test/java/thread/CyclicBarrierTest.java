package thread;

import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier
 * 主要功能是实现线程的等待，应用场景偏向于，所有进程等待，都完成任务后同时执行某些代码【都执行】
 * 同时barrier对象可以重用
 * Created by moekosu on 2018/3/21.
 */
public class CyclicBarrierTest {

	public static void main(String[] args)
	{
		int count = 10;

		final CyclicBarrier barrier = new CyclicBarrier(count, new Runnable() {
			@Override
			public void run() {
				// TODO 当所有进程都到达了barrier状态后，选择其中一个进程执行本方法（只执行一次）
				System.out.println("当前进程："+Thread.currentThread().getName());
			}
		});

		for (int i= 0; i< count; i++)
		{
			new Thread(new Runnable() {
				@Override
				public void run() {
					System.out.println("线程 "+Thread.currentThread().getId()+" 开始写入");
					try {
						Thread.sleep(1000);
						System.out.println("线程 "+Thread.currentThread().getId()+ " 写入完毕");
						// TODO 卡点，当10个进程都执行到await()方法这里同时都变为barrier状态之后，才释放锁
						// TODO PS 进程都成为barrier状态后，下次可以再次调用，可重用
						barrier.await();
					}
					catch (Exception e){
						e.printStackTrace();
					}
					System.out.println("所有进程写入完毕");
				}
			}).start();
		}
	}

}
