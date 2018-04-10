package sunlearning.model.app;


import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by chenny on 2018/4/2.
 */

public class CourseEntity implements Serializable{
    private int id;
    private String name;
    private String desc;
    private int img;
    private Timestamp createDate;
    private int viewNum;
    private int commentTotal;
    private int zanId;
    private int viewTotal;
    private int alreadyZan;
    private int zanTotal;
    private Timestamp modifiedDate;

    public CourseEntity() {
    }

    public CourseEntity(int id, String name, String desc, int img, Timestamp createDate, int viewNum) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.img = img;
        this.createDate = createDate;
        this.viewNum = viewNum;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public int getViewNum() {
        return viewNum;
    }

    public void setViewNum(int viewNum) {
        this.viewNum = viewNum;
    }

    public int getCommentTotal() {
        return commentTotal;
    }

    public void setCommentTotal(int commentTotal) {
        this.commentTotal = commentTotal;
    }

    public int getZanId() {
        return zanId;
    }

    public void setZanId(int zanId) {
        this.zanId = zanId;
    }

    public int getViewTotal() {
        return viewTotal;
    }

    public void setViewTotal(int viewTotal) {
        this.viewTotal = viewTotal;
    }

    public int getAlreadyZan() {
        return alreadyZan;
    }

    public void setAlreadyZan(int alreadyZan) {
        this.alreadyZan = alreadyZan;
    }

    public int getZanTotal() {
        return zanTotal;
    }

    public void setZanTotal(int zanTotal) {
        this.zanTotal = zanTotal;
    }

    public Timestamp getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Timestamp modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
