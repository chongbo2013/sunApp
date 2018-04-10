package sunlearning.model.app;

/**
 * Created by chenny on 2018/4/8.
 */

public class UserEntity {
    private int userId;
    private String userName;
    private String nickName;
    private String userImg;
    private String password;

    public UserEntity() {
    }

    public UserEntity(int userId, String userName, String nickName, String userImg) {
        this.userId = userId;
        this.userName = userName;
        this.nickName = nickName;
        this.userImg = userImg;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
