package com.potato.config;

import org.I0Itec.zkclient.ZkClient;

/**
 * Created by potato on 2017/10/10.
 */
public class ConfigManager {

    private ConfigInfo configInfo;


    public void getOriginConfig(){
        configInfo=new ConfigInfo("potato","112357abc");
    }

    public void updateConfig(){
        if(configInfo==null){
            configInfo=new ConfigInfo();
        }
        configInfo.setUser("apache zoo");
        configInfo.setPsd("--++++**");
    }

    public void sentToZook(){

        ZkClient zk = ZookeeperUtil.getZkClient();
        if (!zk.exists(ZookeeperUtil.configZnode)) {
            zk.createPersistent(ZookeeperUtil.configZnode, true);
        }
        zk.writeData(ZookeeperUtil.configZnode, configInfo);
        zk.close();
    }


}
