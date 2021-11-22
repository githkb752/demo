package cn.nskjy.demo;

public class HttpReqBasic<T> { // 定义一个泛型类

    private T params; // 泛型参数

    public T getParams() {
        return params;
    }

    public void setParams(T params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "HttpReqBasic{" +
                "params=" + params +
                '}';
    }
}
