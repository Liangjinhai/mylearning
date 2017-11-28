package com.potato.config;

import org.I0Itec.zkclient.ZkClient;

/**
 * Created by potato on 2017/10/10.
 */
public class ZookeeperUtil {


    public static final String configZnode="/config/useconfig";

    public static ZkClient getZkClient(){
        return new ZkClient("localhost:2180");
    }



}
