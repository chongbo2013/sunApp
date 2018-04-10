package sunlearning.sunlearningdemo.app;

import android.app.Application;

import com.lzy.okgo.OkGo;

import okhttp3.OkHttpClient;

/**
 * 初始化整个App，Activity配置中心
 */

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //网络
        initOkHttp();
    }

    private void initOkHttp() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        OkGo.getInstance().init(this)                       //必须调用初始化
                .setOkHttpClient(builder.build())
                .setRetryCount(3);//重试次数
    }
}
