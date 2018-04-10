package sunlearning.sunlearningdemo.utils.enums;

/**
 * Created by chenny on 2018/4/8.
 */

public enum AskType {
    ALL("全部"),MY_QUIZ("我的提问"),MY_ANSWER("我的回答"),ALREADY_SOLVED("已解决"),WAIT_SOLVED("待解决");
    private String name;

    AskType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String[] getNames(){
        String names[] = new String[AskType.values().length];
        int i=0;
        for(AskType element: AskType.values()){
            names[i++]=element.getName();
        }
        return names;
    }

    public static AskType getInstance(String name){
        for(AskType element:AskType.values()){
            if(element.getName().equals(name)){
                return element;
            }
        }
        return null;
    }
}
