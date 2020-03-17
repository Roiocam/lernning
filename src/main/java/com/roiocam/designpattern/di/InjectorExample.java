package com.roiocam.designpattern.di;

import java.util.Set;

/**
 * 注入器
 * @author Andy Chen
 * @date 2020/3/17 下午9:15
 */
public class InjectorExample {
    /**
     * main方法注入
     * @param args
     */
    public static void main(String[] args) {
        OutputService os = new OutputServiceImpl();
        Client client = new Client(os);
        client.useOutputServicePrint();
    }

    /**
     * 使用类注入
     */
    class OutputServiceInjector{
        private Set<Client> clients;
        public void inject(Client client){
            clients.add(client);
            client.setOutputService(getOutputService());
        }
        private OutputService getOutputService(){
            return new OutputServiceImpl();
        }
    }
}
