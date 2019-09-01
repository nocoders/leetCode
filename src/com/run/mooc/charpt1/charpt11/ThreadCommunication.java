package com.run.mooc.charpt1.charpt11;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.concurrent.locks.LockSupport;

/**
* @Description:    线程通信：实现多个线程之间的协同，线程执行先后顺序，获取线程执行结果 。
 *      通信方式：文件共享，网络共享 ，共享变量，jdk提供api
* @Author:         linmeng
* @CreateDate:     2019/8/31 16:16
* @UpdateUser:     linmeng
* @UpdateDate:     2019/8/31 16:16
* @UpdateRemark:   修改内容

* @Version:        1.0

*/
public class ThreadCommunication {
    /**
     * 三种线程 协作通信的方式：suspend/resume  wait/notify park/unpark
     */
    /**包子店 */
    private static Object baozidian = null;

    public static void main(String[] args) throws Exception {

        ThreadCommunication threadCommunication = new ThreadCommunication();
        threadCommunication.parkUnparkTest();

    }

    /**
     * park/unpark  调用park则 等待许可，但是并不释放锁 ，只是该线程进入一个挂起状态 ，unpark执行后相当于给与许可证
     *  线程就可以 进行向下运行
     */

    /**
     * 死锁  park/unpark
     */
    public void parkUnparkDeadLockTest() throws InterruptedException {
        // 启动线程
        Thread consumerThread = new Thread(()->{
            while (baozidian ==null){
                System.out.println("1、 没有包子，进入等待 ");
                synchronized (this){

                    LockSupport.park();
                }
            }
            System.out.println("2、买到包子，回家");
        });
        consumerThread.start();
        // 睡眠3秒 ，3秒后生产一个包子
        Thread.sleep(3000);
        baozidian = new Object();
        synchronized (this){

            LockSupport.unpark(consumerThread);
        }
        System.out.println("通知消费者");
    }
    /**
     * 正常  park/unpark
     */
    public void parkUnparkTest() throws InterruptedException {
        // 启动线程
        Thread consumerThread = new Thread(()->{
            while (baozidian ==null){
                try {
                    Thread.sleep(9000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("1、 没有包子，进入等待 ");
                LockSupport.park();
            }
            System.out.println("2、买到包子，回家");
        });
        consumerThread.start();
        // 睡眠3秒 ，3秒后生产一个包子
        Thread.sleep(3000);
        baozidian = new Object();
        LockSupport.unpark(consumerThread);
        System.out.println("通知消费者");
    }
    /**
     * wait/notify :只能由同一对象锁的持有者线程调用，需要写在同步代码块里 ，但是对执行顺序有要求
     *      如果notify的调用在 wait之前的话，那就不能唤醒线程，线程最后只能进入 WAITTING 状态
     */

    /**造成程序 永久等待的 wait、notify，因为notify 在wait 之前执行*/
    public void waitNotifyDeadLockTest() throws InterruptedException {
        new Thread(()->{

                while (baozidian==null){
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (this){
                    System.out.println("1、包子店没有包子，进入等待");

                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("3.买到包子 回家");
            }
        }).start();
        System.out.println("主线程");
        Thread.sleep(2000);
        System.out.println("主线程睡眠2秒");
        baozidian = new Object();

        synchronized (this){
            System.out.println("进入唤醒");
            this.notifyAll();
            System.out.println("2.通知消费者");
        }
    }

    /**正常 wait、notify*/
    public void waitNotifyTest() throws InterruptedException {
        new Thread(()->{
            synchronized (this){
                while (baozidian==null){
                    System.out.println("1、包子店没有包子，进入等待");
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("3.买到包子 回家");
            }
        }).start();

        Thread.sleep(2000);
        baozidian = new Object();

        synchronized (this){
            this.notify();
            System.out.println("2.通知消费者");
        }
    }
    /**
     * 因为执行顺序问题 导致线程永久挂起
     */
    public  void suspendResumeDeadLock2Test() throws Exception{
        Thread consumerThread = new Thread(()->{
            while (baozidian == null){
                System.out.println("1 店里 没有包子，进入等待");
                try {
                    Thread.sleep(5000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Thread.currentThread().suspend();
            }
            System.out.println("2买到包子，回家");
        });

        consumerThread.start();
        //  3秒后，生产一个包子
        Thread.sleep(3000);
        baozidian = new Object();
        consumerThread.resume();
        System.out.println("3通知消费者包子已经圣餐好了");
    }

    /**
     * suspend/resume 使用时，要求必须 先suspend，再resume才可以 ，否则就会造成死锁，使用 同步锁也会造成死锁。
     */
    public void suspendResumeDeadLock1Test() throws InterruptedException {
        Thread consumerThread = new Thread(()->{
            while (baozidian ==null){
                System.out.println("1、店里没有 包子 ，进入等待");
                synchronized (this){
                    Thread.currentThread().suspend();
                }
            }
            System.out.println("3 买到包子 回家");
        });
        consumerThread.start();
        Thread.sleep(3000);
        baozidian = new Object();
        synchronized (this){
            consumerThread.resume();
        }
        System.out.println("2  包子生产完毕，通知消费者");
    }
    /**
     * 正常的 suspend/resume
     */
    public  void suspendResumeTest() throws Exception{
        Thread consumerThread = new Thread(()->{
           while (baozidian == null){
               System.out.println("1 店里 没有包子，进入等待");
               Thread.currentThread().suspend();
           }
            System.out.println("2买到包子，回家");
        });

        consumerThread.start();
        //  3秒后，生产一个包子
        Thread.sleep(3000);
        baozidian = new Object();
        consumerThread.resume();
        System.out.println("3通知消费者包子已经圣餐好了");
    }

    public void fileCommunication(){
        /**
         * 线程文件共享
         *  线程一：写入数据
         *  线程二：读取数据
         */
        new Thread(()->{
            try {
                while (true){
                    Files.write(Paths.get("test.log"),
                            Collections.singleton(("当前时间" + String.valueOf(System.currentTimeMillis()).getBytes())));
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                while (true){
                    Thread.sleep(1000L);
                    byte[] allBytes = Files.readAllBytes(Paths.get("test.log"));
                    System.out.println(new String(allBytes));
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }).start();
    }
}
