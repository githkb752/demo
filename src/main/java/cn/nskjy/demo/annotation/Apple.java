package cn.nskjy.demo.annotation;

/**
 * 使用注解
 * @auth YINTINGTING001
 */
public class Apple {

    @FruitProvider(id = 1, name = "陕西红富士集团", address = "陕西省西安市延安路")
    private String appleProvider;
    public String getAppleProvider() {
        return appleProvider;
    }

    public void setAppleProvider(String appleProvider) {
        
        this.appleProvider = appleProvider;
    }
}
