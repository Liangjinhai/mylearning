package com.potato.lock;

import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.serialize.BytesPushThroughSerializer;

import java.util.concurrent.TimeUnit;

/**
 * Created by potato on 2017/10/9.
 */
public class TestDistributedLock {

    public static void main(String[] args){


        final ZkClient ZkClient1 = new ZkClient("localhost:2180", 5000, 5000, new BytesPushThroughSerializer());
        final SimpleDistributedLockMutex mutex1 = new SimpleDistributedLockMutex(ZkClient1, "/Mutex");

        try {
            mutex1.acquire();
            System.out.println(" TestDistributedLock2 Client get  locked at "+System.currentTimeMillis());
            Thread.sleep(5000);
            mutex1.release();
            System.out.println("locked release at "+ System.currentTimeMillis());
        } catch (Exception e) {
            e.printStackTrace();
        }


/*

        final ZkClient ZkClient1 = new ZkClient("localhost:2180", 5000, 5000, new BytesPushThroughSerializer());
        final SimpleDistributedLockMutex mutex1 = new SimpleDistributedLockMutex(ZkClient1, "/Mutex");

        final ZkClient ZkClient2 = new ZkClient("localhost:2180", 5000, 5000, new BytesPushThroughSerializer());
        final SimpleDistributedLockMutex mutex2 = new SimpleDistributedLockMutex(ZkClient2, "/Mutex");

        try {
            mutex1.acquire();
            System.out.println("Client1 locked");
            Thread client2Thd = new Thread(new Runnable() {

                public void run() {
                    try {
                        mutex2.acquire(5, TimeUnit.SECONDS);
                        System.out.println( System.currentTimeMillis()+"Client2 locked");
                        mutex2.release();
                        System.out.println( System.currentTimeMillis()+"Client2 released lock");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            client2Thd.start();
            Thread.sleep(500000);
            mutex1.release();
            System.out.println( "time:"+System.currentTimeMillis()+"Client1 released lock");
            client2Thd.join();

        } catch (Exception e) {
            e.printStackTrace();
        }
*/

    }

}
