package cn.nskjy.demo.watchmodel.observers;

/**
 * 定义观察者
 */
public interface IObserver {

    // 观察者可以接收被观察者的信息
    public void handleMess(String message);
}
