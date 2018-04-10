package sunlearning.sunlearningdemo.main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.multidex.MultiDex;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import sunlearning.sunlearningdemo.R;

public class SplashActivity extends Activity {
    private ImageView ivMainAppWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏标题栏
        setContentView(R.layout.activity_splash);
        ivMainAppWelcome = findViewById(R.id.mainAppWelcome);
        //跳转至首页Activity
        jumpActivity();
    }

    private void jumpActivity() {
        ivMainAppWelcome.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(),MainMenuActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                finish();
            }
        },2000);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
        MultiDex.install(this);
    }
}
