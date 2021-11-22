package cn.nskjy.demo.listener.eventlistener;

import cn.nskjy.demo.listener.event.IEvent;

/**
 * 定义一个监听器
 */
public class EventListener implements IEventListener{
    /**
     * 监听器处理事件
     * @param iEvent
     */
    @Override
    public void doThing(IEvent iEvent) {
        String eventType = iEvent.getEventType();
        if (IEvent.CRE_EVENT.equals(eventType)) {
            System.out.println("事件源执行了添加操作");
        } else if(IEvent.RET_EVENT.equals(eventType)) {
            System.out.println("事件源执行了查询操作");
        } else if (IEvent.UPD_EVENT.equals(eventType)) {
            System.out.println("事件源执行了更新操作");
        } else if (IEvent.DEL_EVENT.equals(eventType)) {
            System.out.println("事件源执行了删除操作");
        } else {
            System.out.println("事件源没有执行任何crud操作");
        }
    }
}
