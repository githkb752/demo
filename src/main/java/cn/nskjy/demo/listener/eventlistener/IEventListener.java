package cn.nskjy.demo.listener.eventlistener;

import cn.nskjy.demo.listener.event.IEvent;

/**
 * 定义监听器
 */
public interface IEventListener {

    // 监听器监测到事件，处理事件
    public void doThing(IEvent iEvent);
}
