package com.learn.tuling.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者
 */
public class ObserverTest {
    public static void main(String[] args) {
        Subject subject = new Subject();
        Task1 task1 = new Task1();
        subject.addObserver(task1);
        Task2 task2 = new Task2();
        subject.addObserver(task2);

        subject.notifyContainer("666666666");
        subject.remove(task1);

        System.out.println("-------------->");

        subject.notifyContainer("888");

    }
}

class Subject {

    //容器
    private List<Observer> container = new ArrayList<>();


    public List<Observer> getContainer() {
        return container;
    }

    public void setContainer(List<Observer> container) {
        this.container = container;
    }

    //add
    public void addObserver(Observer observer) {
        container.add(observer);
    }

    //remove
    public void remove(Observer observer) {
        container.remove(observer);
    }

    public void notifyContainer(Object object) {
        for (Observer item : container) {
            item.update(object);
        }
    }
}

interface Observer {
    void update(Object object);
}

class Task1 implements Observer{

    @Override
    public void update(Object object) {
        System.out.println("Task1 "+object);
    }
}

class Task2 implements Observer{

    @Override
    public void update(Object object) {
        System.out.println("Task2 "+object);
    }
}