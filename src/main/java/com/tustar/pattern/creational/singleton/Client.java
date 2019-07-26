package com.tustar.pattern.creational.singleton;

public class Client {
    public static void main(String[] args) {
        LoadBalancer balancer1 = LoadBalancer.getInstance();
        LoadBalancer balancer2 = LoadBalancer.getInstance();
        LoadBalancer balancer3 = LoadBalancer.getInstance();
        LoadBalancer balancer4 = LoadBalancer.getInstance();

        if (balancer1 == balancer2 && balancer2 == balancer3
                && balancer3 == balancer4) {
            System.out.println("服务器负载均衡器具有唯一性!");
        }

        balancer1.addServer("Server 1");
        balancer1.addServer("Server 2");
        balancer1.addServer("Server 3");

        for (int i = 0; i < 10; i++) {
            String server = balancer1.getServer();
            System.out.println("请求被分发到服务器:" + server);
        }
    }
}
