package com.run.mooc.charpt1.charpt11;

/**
 * 线程错误中止:stopThread中有 i,j 两个变量，并使用同步锁保持其原子性，但是中途停止线程的时候，
 *  使用stop，并不能保持i，j的原子性，所以说 使用stop是错误的。
 * 线程 正确中止：interupt，通过标志位进行中止。
 */
public class ThreadStop {
    /**
     * 使用标志位判断线程是否中止
     */
    public volatile static boolean flag = true;
    public static void main(String[] args) throws InterruptedException {
        StopThread stopThread = new StopThread();
        stopThread.start();
        Thread.sleep(100);
//        stopThread.stop();
        stopThread.interrupt();
        while (stopThread.isAlive()){

        }
        stopThread.print();

        System.out.println("===================通过标志位对线程进行中止=========================");

        new Thread(()->{
            try {
                while (flag){
                    System.out.println("线程运行中");
                    Thread.sleep(1000L);
                }
            }catch (InterruptedException e){

            }
        }).start();
        Thread.sleep(3000);
        System.out.println("线程随眠3秒 ，之后将标志位改为false，用于中断线程");
        flag = false;
        System.out.println("线程运行结束");

    }
}
