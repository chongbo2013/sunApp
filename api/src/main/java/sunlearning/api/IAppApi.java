package sunlearning.api;

/**
 * Created by chenny on 2018/4/10.
 */

public interface IAppApi {
    // 登录
    public final static String API_LOGIN = "interfaceapi/userintmgt/user!login.action?";


    void login(String userName,String password);
}
