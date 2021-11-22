package cn.nskjy.demo.queue.ex;

import com.alibaba.fastjson.JSONObject;

public class Task extends Throwable {
    /**
     * 任务名称
     */
    private String taskName = "";

    /**
     * 任务结束方式(此字段用于标识任务是否为毒丸任务)
     */
    private EnumTaskEndType taskEndType = EnumTaskEndType.NA;

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public EnumTaskEndType getTaskEndType() {
        return taskEndType;
    }

    public void setTaskEndType(EnumTaskEndType taskEndType) {
        this.taskEndType = taskEndType;
    }

    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
