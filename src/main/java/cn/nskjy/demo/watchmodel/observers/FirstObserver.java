package cn.nskjy.demo.watchmodel.observers;


public class FirstObserver implements IObserver{
    @Override
    public void handleMess(String message) {
        System.out.println("一号观察者接收信息" + message + "正在处理...");
    }
}
