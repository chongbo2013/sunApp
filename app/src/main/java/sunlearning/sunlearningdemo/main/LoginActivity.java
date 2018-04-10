package sunlearning.sunlearningdemo.main;

import android.app.Activity;
import android.os.Bundle;

import sunlearning.sunlearningdemo.R;

public class LoginActivity extends Activity {
    private String loginName="rachel";
    private String password="YyNsLDSlIpE=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
}
