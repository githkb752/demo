package cn.nskjy.demo.listener.eventsources;

import cn.nskjy.demo.listener.event.Event;
import cn.nskjy.demo.listener.event.IEvent;
import cn.nskjy.demo.listener.eventlistener.EventListener;
import cn.nskjy.demo.listener.eventlistener.IEventListener;

/**
 * 创建一个事件源
 */
public class EventSource implements IEventSource{
    private IEventListener iEventListener; // 声明一个监听器

    /**
     * 为事件源注册监听器
     * @param iEventListener
     */
    @Override
    public void setEventListener(IEventListener iEventListener) {
        this.iEventListener = iEventListener;
    }

    /**
     * 靠事件来
     * 触发监听器
     * @param iEvent
     */
    @Override
    public void triggerListener(IEvent iEvent) {
        iEventListener.doThing(iEvent);
    }

    public void addUser() {
        System.out.println("想db中插入了一条数据");
        IEvent iEvent = new Event(this, "addUser");
        triggerListener(iEvent);
    }
    public void getUser() {
        System.out.println("想db中查询了一条数据");
        IEvent iEvent = new Event(this, "addUser");
        triggerListener(iEvent);
    }
    public void updateUser() {
        System.out.println("想db中更新了一条数据");
        IEvent iEvent = new Event(this, "addUser");
        triggerListener(iEvent);
    }
    public void deleteUser() {
        System.out.println("想db中删除了一条数据");
        IEvent iEvent = new Event(this, "addUser");
        triggerListener(iEvent);
    }
}
