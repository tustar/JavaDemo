package com.tustar.lbw;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by tustar on 17-5-2.
 */
public class CompletionTest {

    public static void main(String[] args) {
        futureTest();
        completionTest();
    }

    private static void futureTest() {
        System.out.println("main thread begin:");
        ExecutorService executor = Executors.newCachedThreadPool();
        List<Future<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Future<Integer> future = executor.submit(new HandleFuture<>(i));
            resultList.add(future);
        }
        executor.shutdown();
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("返回结果: " + resultList.get(i).get());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("main Thread end:");
    }

    private static void completionTest() {
        System.out.println("main thread begin:");
        ExecutorService executor = Executors.newCachedThreadPool();
        // 构建完成服务
        CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(executor);
        for (int i = 0; i < 10; i++) {
            completionService.submit(new HandleFuture<>(i));
        }
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("返回结果: " + completionService.take().get());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("main Thread end:");
    }
}

class HandleFuture<Integer> implements Callable<Integer> {

    private Integer num;

    public HandleFuture(Integer num) {
        this.num = num;
    }

    @Override
    public Integer call() throws Exception {
        Thread.sleep(3 * 100);
        System.out.println(Thread.currentThread().getName());
        return num;
    }

}
