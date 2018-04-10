package sunlearning.sunlearningdemo.utils.enums;

/**
 * Created by chenny on 2018/4/8.
 */

public enum ExamTestStatusEnum {
    ASSESSING("评卷中"),NOTSTART("待填写");
    private String desc;

    ExamTestStatusEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static String getDesc(String enumName){
        for(ExamTestStatusEnum element:values()){
            if(element.name().equals(enumName)){
                return element.getDesc();
            }
        }
        return null;
    }
}
