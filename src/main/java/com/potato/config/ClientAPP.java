package com.potato.config;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;

import java.util.concurrent.TimeUnit;

/**
 * Created by potato on 2017/10/10.
 */
public class ClientAPP implements Runnable{

    private ConfigInfo configInfo;

    public ConfigInfo getConfigFromZoo(){
        if(configInfo==null){
            ZkClient zk=ZookeeperUtil.getZkClient();
            configInfo=(ConfigInfo) zk.readData(ZookeeperUtil.configZnode);

            zk.subscribeDataChanges(ZookeeperUtil.configZnode, new IZkDataListener() {
                public void handleDataChange(String s, Object o) throws Exception {
                    configInfo=(ConfigInfo) o;
                    System.out.println("ConfigInfo => " + configInfo);
                }
                public void handleDataDeleted(String s) throws Exception {
                    System.out.println("ConfigInfo is deleted !");
                    configInfo = null;
                }
            });
        }
        return configInfo;
    }

    public void doSomething() {
        while(true) {
            try {
                System.out.println("ClentApp is running.....");
                this.getConfigFromZoo();
                System.out.println("ClentApp use config ....." + configInfo.toString());
                TimeUnit.SECONDS.sleep(2);
                System.out.println("the task is end.....");
            } catch (InterruptedException e) {
                e.toString();
            }
        }
    }

    public void run() {
        this.doSomething();
    }
}
