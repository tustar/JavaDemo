package com.tustar.lbw;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * Created by tustar on 17-5-2.
 */
class MyTask implements Callable<Integer> {
    private String name;

    public MyTask(String name) {
        this.name = name;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("task " + name + "开始进行计算");
        Thread.sleep(3000);
        int sum = new Random().nextInt(300);
        int result = 0;
        for (int i = 0; i < sum; i++) {
            result += i;
        }
        return result;
    }
}
