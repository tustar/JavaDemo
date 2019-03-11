package com.tustar.rxjava.ch5;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

import java.util.ArrayList;
import java.util.List;

public class FlatMap {

    public static void main(String[] args) {
        Student student = new Student();
        student.name = "zhangsan";
        student.courses = new ArrayList<>();
        Course ennglish = new Course();
        ennglish.name = "English";
        ennglish.teacher = "Shilei";
        student.courses.add(ennglish);
        Course math = new Course();
        math.name = "Math";
        math.teacher = "Leijun";
        student.courses.add(math);

        Observable.just(student)
                .flatMap(new Function<Student, ObservableSource<Course>>() {
                    @Override
                    public ObservableSource<Course> apply(Student student) throws Exception {
                        return Observable.fromIterable(student.courses);
                    }
                })
                .map(new Function<Course, String>() {
                    @Override
                    public String apply(Course course) {
                        return course.name;
                    }
                })
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        System.out.println("onNext :: " + s);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        System.out.println("onError :: " + throwable.getMessage());
                    }
                }, new Action() {
                    @Override
                    public void run() throws Exception {
                        System.out.println("onComplete :: ");
                    }
                }, new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        System.out.println("onSubscribe :: " + disposable);
                    }
                });
    }

    static class Student {
        public String name;
        public List<Course> courses;
    }

    static class Course {
        public String name;
        public String teacher;
    }
}


