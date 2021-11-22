package cn.nskjy.demo.enums;

public enum DpEnum {

    BASE_COLUMN("1", "ygzj"),
    BASE_COLUMN_02("2", "ygzj02"),
    BASE_COLUMN_03("3", "ygzj03");

    public String key;

    public String code;

    DpEnum(String key, String code) {
        this.key = key;
        this.code = code;
    }

    public static String getCodeToKey(String key) {
        for (DpEnum dpEnum : DpEnum.values()) {
            if (key.equals(dpEnum.getKey())) {
                return dpEnum.getCode();
            }
        }
        return null;
    }

    public String getKey() {
        return key;
    }

    public String getCode() {
        return code;
    }
}
