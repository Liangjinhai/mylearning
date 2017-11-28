package com.potato.lock;

import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.serialize.BytesPushThroughSerializer;

import java.util.concurrent.TimeUnit;

/**
 * Created by potato on 2017/10/19.
 */
public class TestDistributedLock2 {
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

    }

}
