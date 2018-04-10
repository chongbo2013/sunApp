package sunlearning.model.app;

import java.io.Serializable;

/**
 * Created by chenny on 2018/4/8.
 */

public class ExamineProjectEntity  implements Serializable {
    private int id;
    private int img;
    private String name;

    public ExamineProjectEntity() {
    }

    public ExamineProjectEntity(int id, int img, String name) {
        this.id = id;
        this.img = img;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
