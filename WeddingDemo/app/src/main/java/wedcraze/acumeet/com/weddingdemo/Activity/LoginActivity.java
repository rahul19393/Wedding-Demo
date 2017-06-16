package wedcraze.acumeet.com.weddingdemo.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import wedcraze.acumeet.com.weddingdemo.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_login);
        Button facebook = (Button)findViewById(R.id.facebook);
        Button google = (Button)findViewById(R.id.google);
        facebook.setTypeface(Typeface.createFromAsset(getAssets(),"font/coffee+teademo-Regular.ttf"));
        google.setTypeface(Typeface.createFromAsset(getAssets(),"font/coffee+teademo-Regular.ttf"));
        facebook.setOnClickListener(this);
        google.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.facebook:
                startActivity(new Intent(LoginActivity.this,SelectTeamActivity.class));
               overridePendingTransition(R.anim.enter_from_right, R.anim.exit_to_left);
                break;
            case R.id.google:
                startActivity(new Intent(LoginActivity.this,SelectTeamActivity.class));
                overridePendingTransition(R.anim.enter_from_right, R.anim.exit_to_left);
                break;
        }
    }
}
