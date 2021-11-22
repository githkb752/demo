package cn.nskjy.demo.staticenum;

public enum StaticEnum {

    EXIST("101","已存在"),
    NOT_EXIST("402","不存在"),
    OPERATION_SUCCESS("200","操作成功"),
    OPERATION_FAIL("404","操作失败");

    StaticEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
