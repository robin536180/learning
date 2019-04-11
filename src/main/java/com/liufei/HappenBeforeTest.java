package com.liufei;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

/**
 * @author:liufei
 * @create_time:2018/11/20
 */
public class HappenBeforeTest {

  private volatile  Integer c = 3000;
  private Integer a = 1000;
  private Integer b = 2000;


   class execThread implements Runnable{

    @Override
    public void run() {
      for (int i = 0; i <10 ; i++) {
        a +=1;
        b +=2;
        c +=3;

        System.out.println(currentThread().getName()+":"+a+","+b+","+c);

        try {
          sleep(10);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }

    }
  }

  public static void main(String[] args) {
    for(int i= 0;i<2;i++){
      new Thread(new HappenBeforeTest().new execThread()).start();
    }
  }

}