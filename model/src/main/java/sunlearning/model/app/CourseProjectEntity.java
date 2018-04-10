package sunlearning.model.app;

import java.io.Serializable;

/**
 * Created by chenny on 2018/4/3.
 */

public class CourseProjectEntity  implements Serializable {
    private int id;
    private String name;
    private int img;

    public CourseProjectEntity() {
        this.id = id;
    }

    public CourseProjectEntity(int id, String name, int img) {
        this.id = id;
        this.name = name;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
