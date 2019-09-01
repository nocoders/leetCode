package com.run.mooc.charpt1.charpt11;

public class StopThread extends Thread {

    private int i=0;
    private int j=0;

    @Override
    public void run() {
        synchronized (this){
            ++i;
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println("抛出中断异常");
                e.printStackTrace();
            }
            ++j;
        }
    }
    public void print(){
        System.out.println(i+"   "+j);
    }
}
