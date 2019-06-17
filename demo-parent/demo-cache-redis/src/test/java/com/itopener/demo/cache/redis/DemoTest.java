package com.itopener.demo.cache.redis;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**  
 * @author fuwei.deng
 * @date 2018年3月3日 下午12:54:26
 * @version 1.0.0
 */
public class DemoTest {

	private CyclicBarrier cb = new CyclicBarrier(4);
    private Random rnd = new Random();
     
    class TaskDemo implements Runnable{
        private String id;
        TaskDemo(String id){
            this.id = id;
        }
        @Override
        public void run(){
            try {
                Thread.sleep(rnd.nextInt(1000));
                System.out.println("Thread " + id + " will wait");
                cb.await();
                Thread.sleep(3000);
                System.out.println("-------Thread " + id + " is over");
            } catch (InterruptedException e) {
            } catch (BrokenBarrierException e) {
            } catch (RuntimeException e) {
            	e.printStackTrace();
            }
        }
    }
     
    public static void main(String[] args) throws InterruptedException{
    	DemoTest cbd = new DemoTest();
        ExecutorService es = Executors.newCachedThreadPool();
        es.submit(cbd.new TaskDemo("a"));
        es.submit(cbd.new TaskDemo("b"));
        es.submit(cbd.new TaskDemo("c"));
        es.submit(cbd.new TaskDemo("d"));
        es.shutdown();
        Thread.sleep(10000);
    }
}
