package com.tustar.pattern.structural.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DaoLogHandler implements InvocationHandler {

    private Object object;

    public DaoLogHandler() {

    }

    public DaoLogHandler(Object object) {
        this.object = object;
    }

    public void berforeInvoke() {
        String time = new SimpleDateFormat("hh:MM:ss").format(new Date(System.currentTimeMillis()));
        System.out.println("调用时间:" + time);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        berforeInvoke();
        Object result = method.invoke(object, args);
        afterInvoke();
        return result;
    }

    public void afterInvoke() {
        System.out.println("方法调用结束");
    }
}
