package cn.nskjy.demo.watchmodel.observers;

public class SecondObserver implements IObserver {
    @Override
    public void handleMess(String message) {
        System.out.println("二号观察者接收信息" + message + "正在处理。。。");
    }
}
