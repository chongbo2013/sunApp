package sunlearning.model.app;

import java.sql.Timestamp;

/**
 * Created by chenny on 2018/4/8.
 */

public class AskEntity {
    private int knowQuestionId;
    private String title;
    private int answerTotal;
    private int isAuthor;
    private String knowStatus;
    private int goldCoins;
    private Timestamp createDate;
    private UserEntity userEntity;

    public AskEntity(int knowQuestionId, String title, int answerTotal, int isAuthor, String knowStatus, int goldCoins, Timestamp createDate) {
        this.knowQuestionId = knowQuestionId;
        this.title = title;
        this.answerTotal = answerTotal;
        this.isAuthor = isAuthor;
        this.knowStatus = knowStatus;
        this.goldCoins = goldCoins;
        this.createDate = createDate;
    }

    public int getKnowQuestionId() {
        return knowQuestionId;
    }

    public void setKnowQuestionId(int knowQuestionId) {
        this.knowQuestionId = knowQuestionId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAnswerTotal() {
        return answerTotal;
    }

    public void setAnswerTotal(int answerTotal) {
        this.answerTotal = answerTotal;
    }

    public int getIsAuthor() {
        return isAuthor;
    }

    public void setIsAuthor(int isAuthor) {
        this.isAuthor = isAuthor;
    }

    public String getKnowStatus() {
        return knowStatus;
    }

    public void setKnowStatus(String knowStatus) {
        this.knowStatus = knowStatus;
    }

    public int getGoldCoins() {
        return goldCoins;
    }

    public void setGoldCoins(int goldCoins) {
        this.goldCoins = goldCoins;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
