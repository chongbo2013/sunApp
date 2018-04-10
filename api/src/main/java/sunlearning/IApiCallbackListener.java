package sunlearning;

/**
 * Created by chenny on 2018/4/10.
 */

/**
 *
 */
public interface IApiCallbackListener<T>{
    /**
     * 请求成功时调用
     * @param t 响应数据
     */
    public void success(T t);

    /**
     * 请求失败时调用
     * @param errorCode
     * @param errorMessage
     */
    public void onFailure(String errorCode, String errorMessage);
}
