package cn.nskjy.demo.watchmodel.obdemo;

import cn.nskjy.demo.watchmodel.observerable.IObserverable;
import cn.nskjy.demo.watchmodel.observerable.Watched;
import cn.nskjy.demo.watchmodel.observers.FirstObserver;
import cn.nskjy.demo.watchmodel.observers.IObserver;
import cn.nskjy.demo.watchmodel.observers.SecondObserver;

public class ObDemo {
    public static void main(String[] args) {
        // 实例化观察者
        IObserver firstObserver = new FirstObserver();
        IObserver secondObserver = new SecondObserver();

        // 实例化被观察者
        IObserverable watched = new Watched();

        // 添加观察者
        watched.addObservers(firstObserver);
        watched.addObservers(secondObserver);

        // 向观察者发送消息
        watched.notifyMess(" “全体注意，准备出发” ");

        System.out.println("=================");
        // 删除观察者
        watched.delObservers(secondObserver);

        // 向观察者发送消息
        watched.notifyMess(" “全体注意，人员减少” ");
    }
}
