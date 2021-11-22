package cn.nskjy.demo.listener.start;

import cn.nskjy.demo.listener.event.Event;
import cn.nskjy.demo.listener.event.IEvent;
import cn.nskjy.demo.listener.eventlistener.EventListener;
import cn.nskjy.demo.listener.eventlistener.IEventListener;
import cn.nskjy.demo.listener.eventsources.EventSource;
import cn.nskjy.demo.listener.eventsources.IEventSource;

public class StartListener {
    public static void main(String[] args) {
        // 创建监听器
        IEventListener iEventListener = new EventListener();

        // 创建事件源
        EventSource eventSource = new EventSource();

        // 创建事件
//        IEvent iEvent = new Event(iEventSource, "addUser");

        // 注册监听器
        eventSource.setEventListener(iEventListener);

        eventSource.addUser();
        eventSource.getUser();
        eventSource.updateUser();
        eventSource.deleteUser();

        // 触发监听器
//        iEventSource.triggerListener(iEvent);
    }
}
