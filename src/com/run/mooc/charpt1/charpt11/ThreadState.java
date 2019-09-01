package com.run.mooc.charpt1.charpt11;
/**
* @Description:    线程状态
* @Author:         linmeng
* @CreateDate:     2019/8/30 15:56
* @UpdateUser:     linmeng
* @UpdateDate:     2019/8/30 15:56
* @UpdateRemark:   修改内容

* @Version:        1.0

*/
public class ThreadState {
    /**
     * 线程状态：
     *  1.NEW :刚刚 创建出来的线程 ，尚未启动
     *  2.RUNNABLE:可运行状态，一种情况是cpu正在执行当前线程 ，另一个是 还未被执行，随时可以 被执行。
     *  3.BLOCKED：线程阻塞，等待监视器锁定的状态，就是当前线程被锁定，需要解锁的状态
     *  4.WAITING：等待状态，当前线程 不执行，被其他状态唤醒后，才能继续执行
     *  5.TIMED_WAITING：带超时时间的等待，等待固定时间后，抛出异常或继续执行。
     *  6。TERMINATED：线程执行完毕：抛出异常或者正常执行完毕
     * @param args
     */
    public static Thread thread;

    public static ThreadState threadState;

    public static void main(String[] args) throws Exception{
        // 线程状态切换 第一种：新建 -> 运行 -> 终止
        System.out.println("#######第一种状态切换  - 新建 -> 运行 -> 终止################################");
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程 1当前运行状态："+Thread.currentThread().getState().toString());
                System.out.println("线程1  执行了");
            }
        });
        System.out.println("未调用start方法前线程状态："+thread1.getState().toString());
        // 线程调用start方法后，就进入运行状态。
        thread1.start();
        // 该等待是主线程 等待 线程1 执行
        Thread.sleep(2000L);
        System.out.println("线程等待两秒，再次查看线程状态："+thread1.getState().toString());

        System.out.println();
        System.out.println("############第二种：新建 -> 运行 -> 等待 -> 运行 -> 终止(sleep方式)###########################");
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                // 将线程运行到等待状态
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程2  当前运行状态"+Thread.currentThread().getState().toString());
                System.out.println("线程2 执行了");
            }
        });
        System.out.println("没调用start方法，thread2当前状态：" + thread2.getState().toString());
        thread2.start();
        System.out.println("调用start方法，thread2当前状态：" + thread2.getState().toString());
        // 等待200毫秒，再看状态（主线程等待两百毫秒，线程2已经运行并且运行到sleep 一秒 ，所以现在是等待状态）
        Thread.sleep(200L);
        System.out.println("等待200毫秒，再看thread2当前状态：" + thread2.getState().toString());
        Thread.sleep(1000L);
        System.out.println("等待1秒，再看thread2当前状态：" + thread2.getState().toString());

        System.out.println();
        System.out.println("############第三种：新建 -> 运行 -> 阻塞 -> 运行 -> 终止###########################");
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (ThreadState.class){
                    System.out.println("线程3当前运行状态"+Thread.currentThread().getState().toString());
                    System.out.println("线程3执行了");
                }
            }
        });
        // 这个地方  线程锁一直被主线程持有,同步锁中不能线程3是一直 被 阻塞的，出了同步锁才线程3才能拿到锁 。进入运行状态
        synchronized (ThreadState.class){
            System.out.println("未调用start方法，线程3当前状态："+thread3.getState().toString());
            thread3.start();
            System.out.println("调用start方法，thread3当前状态：" + thread3.getState().toString());
            Thread.sleep(200L);
            System.out.println("等待200毫秒，再看thread3当前状态：" + thread3.getState().toString());

        }
        // 再等待3秒，让thread3执行完毕，再看状态
        Thread.sleep(3000L);
        System.out.println("等待3秒，让thread3抢到锁，再看thread3当前状态：" + thread3.getState().toString());

    }
}
