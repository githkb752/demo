package cn.nskjy.demo.watchmodel.observerable;

import cn.nskjy.demo.watchmodel.observers.IObserver;

import java.util.HashSet;
import java.util.Set;

/**
 * 定义一个被观察者
 */
public class Watched implements IObserverable {
    // 定义一个容器
    private Set<IObserver> set;

    public Watched(){
        set = new HashSet();
    }

    /**
     * 添加观察者
     * @param iObserver
     */
//    @Override
    public void addObservers(IObserver iObserver) {
        set.add(iObserver);
    }

    /**
     * 删除观察者
     * @param iObserver
     */
//    @Override
    public void delObservers(IObserver iObserver) {
        set.remove(iObserver);
    }

    /**
     * 被观察者向观察者发送消息
     * @param ontifyMess
     */
//    @Override
    public void notifyMess(String ontifyMess) {
        for (IObserver iObserver : set) {
            iObserver.handleMess(ontifyMess);
        }
    }
}
