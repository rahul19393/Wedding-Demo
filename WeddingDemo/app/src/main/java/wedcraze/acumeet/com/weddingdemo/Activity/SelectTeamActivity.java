package wedcraze.acumeet.com.weddingdemo.Activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import wedcraze.acumeet.com.weddingdemo.R;

public class SelectTeamActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_select_team);
        TextView brideText = (TextView)findViewById(R.id.bridetext);
        TextView groomText = (TextView)findViewById(R.id.groomtext);
        TextView selectTeam = (TextView)findViewById(R.id.selectteam);
        TextView orText = (TextView)findViewById(R.id.or);


        brideText.setTypeface(Typeface.createFromAsset(getAssets(),"font/Back to Black Demo.ttf"));
        selectTeam.setTypeface(Typeface.createFromAsset(getAssets(),"font/Back to Black Demo.ttf"));
        groomText.setTypeface(Typeface.createFromAsset(getAssets(),"font/Back to Black Demo.ttf"));
        orText.setTypeface(Typeface.createFromAsset(getAssets(),"font/coffee+teademo-Regular.ttf"));

        findViewById(R.id.groom).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SelectTeamActivity.this,HomeActivity.class));
               overridePendingTransition(R.anim.enter_from_right, R.anim.exit_to_left);

            }
        });findViewById(R.id.bride).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SelectTeamActivity.this,HomeActivity.class));
                overridePendingTransition(R.anim.enter_from_right, R.anim.exit_to_left);

            }
        });
    }
}
