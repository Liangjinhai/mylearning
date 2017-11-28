package com.potato.zkclient;

import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.serialize.BytesPushThroughSerializer;


import java.util.List;

/**
 * Created by potato on 2017/10/19.
 */
public class SubscibeDataChange {

    public static String host="127.0.0.1:2180";
    public static int  session_time=5000;

    public static void main(String[] args) throws InterruptedException{
      /*  ZkClient zkClient=new ZkClient(host,session_time,session_time,
        new BytesPushThroughSerializer());
        zkClient.subscribeDataChanges("/notice", new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {
                byte[] ms=(byte[])o;
                System.out.println("g变更节点为"+s+"变更数据为"+new String (ms));
            }

            @Override
            public void handleDataDeleted(String s) throws Exception {
                System.out.println("删除节点"+s);
            }
        });

        zkClient.subscribeChildChanges("/", new IZkChildListener() {
            @Override
            public void handleChildChange(String s, List<String> list) throws Exception {
                System.out.println("s:"+s);
                System.out.println(list.toString());
            }
        });

        Thread.sleep(Integer.MAX_VALUE);
*/
    }

}
