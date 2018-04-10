package sunlearning.sunlearningdemo.utils.enums;

/**
 * Created by chenny on 2018/4/8.
 */

public enum AskStatusEnum {
    PENDING("待解决"),SOLVED("已解决");
    private String desc;

    AskStatusEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static String getDesc(String enumName) {
        for (AskStatusEnum element : values()) {
            if (element.name().equals(enumName)) {
                return element.getDesc();
            }
        }
        return null;
    }
}
