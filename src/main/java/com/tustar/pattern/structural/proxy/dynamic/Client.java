package com.tustar.pattern.structural.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        IUserDao userDao = new UserDao();
        InvocationHandler handler = new DaoLogHandler(userDao);

        IUserDao proxy = (IUserDao)Proxy.newProxyInstance(IUserDao.class.getClassLoader(),
                new Class[]{IUserDao.class}, handler);
        proxy.findUserById("张无忌");
        System.out.println("-----------------------------");


        IDocDao docDao = new DocDao();
        handler = new DaoLogHandler(docDao);
        IDocDao docProxy = (IDocDao)Proxy.newProxyInstance(IDocDao.class.getClassLoader(),
                new Class[]{IDocDao.class}, handler);
        docProxy.deleteById("D002");
    }
}
