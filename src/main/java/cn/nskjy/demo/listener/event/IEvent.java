package cn.nskjy.demo.listener.event;

import cn.nskjy.demo.listener.eventsources.IEventSource;

/**
 * 定义事件
 * 通常，对于事件对象，我们需要从事件对象中找到事件源对象
 */
public interface IEvent {

    String CRE_EVENT = "create event";
    String RET_EVENT = "retrieve event";
    String UPD_EVENT = "update event";
    String DEL_EVENT = "delete event";

    // 获取事务源对象
    IEventSource getIEventSource();

    // 获取事件类型
    String getEventType();
}
