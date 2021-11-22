package cn.nskjy.demo.listener.event;

import cn.nskjy.demo.listener.eventsources.IEventSource;

/**
 * 创建一个事件
 */
public class Event implements IEvent{
    private IEventSource iEventSource;
    private String methodName;

    /**
     * 实例化事件的时候，传一个数据源对象
     * @param iEventSource
     */
    public Event(IEventSource iEventSource, String methodName) {
        this.iEventSource = iEventSource;
        this.methodName = methodName;
    }

    // 获取事件源
    @Override
    public IEventSource getIEventSource() {
        return iEventSource;
    }

    // 获取事件源类型
    @Override
    public String getEventType() {
        String type = null;
        if (methodName.startsWith("add")) {
            type = CRE_EVENT;
        } else if(methodName.startsWith("get")) {
            type = RET_EVENT;
        } else if(methodName.startsWith("update")) {
            type = UPD_EVENT;
        } else if (methodName.startsWith("delete")) {
            type = DEL_EVENT;
        } else {
            type = " not data";
        }
        return type;
    }
}
