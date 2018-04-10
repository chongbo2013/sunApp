package sunlearning.sunlearningdemo.utils.enums;

/**
 * Created by chenny on 2018/4/8.
 */

public enum ExamineSurveyStatusEnum {
    C("已提交"), NOTSTART("待填写");
    private String desc;

    ExamineSurveyStatusEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }


    public static String getDesc(String enumName) {
        for (ExamineSurveyStatusEnum element : values()) {
            if (element.name().equals(enumName)) {
                return element.getDesc();
            }
        }
        return null;
    }
}
