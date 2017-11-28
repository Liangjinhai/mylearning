package com.potato.config;

import java.util.concurrent.TimeUnit;

/**
 * Created by potato on 2017/10/10.
 */
public class TestConfigManager {

    public static void main (String[] args) throws  InterruptedException{

        ConfigManager configManager=new ConfigManager();

        ClientAPP clientAPP=new ClientAPP();

        System.out.println("ConfigManager 初始化配置到zookeeper ");
        configManager.getOriginConfig();
        configManager.sentToZook();

        Thread client=new Thread(clientAPP);
        client.start();

        TimeUnit.SECONDS.sleep(5);
        System.out.println("ConfigManager 更新配置 ");
        configManager.updateConfig();
        configManager.sentToZook();

        TimeUnit.SECONDS.sleep(50);
    }
}
