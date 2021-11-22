package cn.nskjy.demo.watchmodel.observerable;

import cn.nskjy.demo.watchmodel.observers.IObserver;

/**
 * 定义被观察者
 */
public interface IObserverable {

    // 被观察者可以添加观察者
    public void addObservers(IObserver iObserver);

    // 被观察者可以删除观察者
    public void delObservers(IObserver iObserver);

    // 被观察者向观察者发送信息
    public void notifyMess(String ontifyMess);
}
