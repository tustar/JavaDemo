package com.tustar.headfirst.designpatterns.proxy.gumball;

import java.net.MalformedURLException;
import java.rmi.*;

public class GumballMonitorTestDrive {

    public static void main(String[] args) {
        String location = "127.0.0.1:8888";
        try {
            GumballMachineRemote machine =
                    (GumballMachineRemote) Naming.lookup("rmi://" + location + "/gumballmachine");
            GumballMonitor monitor = new GumballMonitor(machine);
            monitor.report();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
}
