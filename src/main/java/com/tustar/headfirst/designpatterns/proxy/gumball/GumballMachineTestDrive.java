package com.tustar.headfirst.designpatterns.proxy.gumball;
import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;

public class GumballMachineTestDrive {
 
	public static void main(String[] args) {
		GumballMachineRemote gumballMachine = null;
		String location = "127.0.0.1:8888";
		int count = 100;

		try {
			gumballMachine = new GumballMachine(location, count);
			LocateRegistry.createRegistry(8888);
			System.setProperty("java.rmi.server.hostname", "127.0.0.1");
			Naming.bind("//" + location + "/gumballmachine", gumballMachine);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			e.printStackTrace();
		}
	}
}
