package com.potato.zk;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.apache.zookeeper.server.ServerCnxn;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Created by potato on 2017/10/10.
 */
public class ZooClient implements Watcher {

    private ZooKeeper zk=null;
    private static CountDownLatch connectedSignal = new CountDownLatch(1);


    public static void main(String[] args){
        try {

            ZooKeeper zk= new ZooKeeper("localhost:2181",9000,new ZooClient());
            String path="/test1";
            Stat stat=null;
            zk.getData(path, new Watcher() {
                public void process(WatchedEvent watchedEvent) {
                    System.out.println(" 触发 exists 方法 getType " + watchedEvent.getType());
                    System.out.println(" 触发 exists 方法 getState " + watchedEvent.getState());
                    System.out.println(" 触发 exists 方法 getPath " + watchedEvent.getPath());
                }
            },null);

            Thread.sleep(500000);

        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public void process(WatchedEvent watchedEvent) {
        System.out.println(" 触发 process getType "+watchedEvent.getType());
        System.out.println(" 触发 process getState "+watchedEvent.getState());
        System.out.println(" 触发 process getState "+watchedEvent.getState());
    }
}
