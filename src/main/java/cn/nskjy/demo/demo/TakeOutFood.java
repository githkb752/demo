package cn.nskjy.demo.demo;

public class TakeOutFood {

    /**
     * 平台
     */
    private String platform;

    /**
     * 卖家
     */
    private String seller;

    /**
     * 菜名
     */
    private String foodName;

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    @Override
    public String toString() {
        return "TakeOutFood{" +
                "platform='" + platform + '\'' +
                ", seller='" + seller + '\'' +
                ", foodName='" + foodName + '\'' +
                '}';
    }
}
