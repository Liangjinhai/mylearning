package com.potato.curator;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.*;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

import java.util.List;

/**
 * Created by potato on 2017/10/19.
 */

public class CuratorClient {

    public  static void main(String[] args){

//        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
//        CuratorFramework client = CuratorFrameworkFactory.builder()
//                                .connectString("localhost:2180")
//                                .sessionTimeoutMs(5000)
//                                .connectionTimeoutMs(5000)
//                                .retryPolicy(retryPolicy)
//                                .build();
//
//        client.start();
//        try {
//            if(client.checkExists().forPath("/curator").equals(null)){
//                client.create()
//                        .withMode(CreateMode.PERSISTENT)
//                        .forPath("/curator", "curator" .getBytes());
//            }
//            List<String> chiilds= client.getChildren().forPath("/");
//            System.out.println("/ get childs "+chiilds);
//
//            byte[] bytes=client.getData().forPath("/curator");
//            System.out.println("/curator get data is  "+new String(bytes));
//
//            PathChildrenCache cache = new PathChildrenCache(client, "/notice", true);
//
//            PathChildrenCacheListener cacheListener=new PathChildrenCacheListener() {
//                @Override
//                public void childEvent(CuratorFramework curatorFramework, PathChildrenCacheEvent event)
//                        throws Exception {
//                    System.out.println("事件类型：" + event.getType());
//                    if (null != event.getData()) {
//                        System.out.println("节点数据：" + event.getData().getPath() + " = "
//                                + new String(event.getData().getData()));
//                    }
//                }
//            };
//            cache.start();
//            cache.getListenable().addListener(cacheListener);
//
////            for (ChildData data : cache.getCurrentData()) {
////                System.out.println("getCurrentData:" + data.getPath() + " = " + new String(data.getData()));
////            }
//
//
//            NodeCache cache1 = new NodeCache(client, "/notice");
//            NodeCacheListener nodeCacheListener=new NodeCacheListener() {
//                @Override
//                public void nodeChanged() throws Exception {
//                    ChildData data = cache1.getCurrentData();
//                    if (null != data) {
//                        System.out.println(" NodeCache 节点数据：" + new String(cache1.getCurrentData().getData()));
//                    } else {
//                        System.out.println("节点被删除!");
//                    }
//                }
//            };
//            cache1.start();
//            cache1.getListenable().addListener(nodeCacheListener);
//
//            Thread.sleep(1000000);
//            cache.close();
//            cache1.close();
//            client.close();
//
//        }catch (Exception e){
//            e.toString();
//        }


    }

}
