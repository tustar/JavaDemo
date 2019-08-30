package com.tustar.java7.rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class HelloServer {
    public static void main(String[] args) {
        try {
            IHello rhello = new HelloImpl();
            LocateRegistry.createRegistry(8888);
            System.setProperty("java.rmi.server.hostname", "127.0.0.1");
            Naming.bind("rmi://localhost:8888/RHello", rhello);
            System.out.println(">>>INFO:远程IHello绑定成功!");
        } catch (RemoteException e) {
            System.out.println("创建远程对象发生异常!");
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            System.out.println("重复绑定对象异常");
            e.printStackTrace();
        } catch (MalformedURLException e) {
            System.out.println("URL异常");
            e.printStackTrace();
        }
    }
}
