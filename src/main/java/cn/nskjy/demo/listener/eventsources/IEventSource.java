package cn.nskjy.demo.listener.eventsources;

import cn.nskjy.demo.listener.event.IEvent;
import cn.nskjy.demo.listener.eventlistener.IEventListener;

/**
 * 定义事件源
 */
public interface IEventSource {

    // 为事件源注册监听器
    void setEventListener(IEventListener iEventListener);

    // 靠事件源触发监听器
    void triggerListener(IEvent iEvent);
}
