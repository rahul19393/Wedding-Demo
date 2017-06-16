package wedcraze.acumeet.com.weddingdemo.Activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

import wedcraze.acumeet.com.weddingdemo.R;


public class EventRsvpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_event_rsvp);
        TextView title = (TextView)findViewById(R.id.title);
        TextView rsvpText = (TextView)findViewById(R.id.rsvptext);
        TextView hotelNmae = (TextView)findViewById(R.id.hotelname);
        TextView needAcc = (TextView)findViewById(R.id.needacctext);
        TextView yesText = (TextView)findViewById(R.id.yesytext);
        TextView notext = (TextView)findViewById(R.id.notext);
        Button map = (Button)findViewById(R.id.map);
        Button accept = (Button)findViewById(R.id.accept);
        Button decline = (Button)findViewById(R.id.decline);
        rsvpText.setTypeface(Typeface.createFromAsset(getAssets(),"font/coffee+teademo-Regular.ttf"));
        title.setTypeface(Typeface.createFromAsset(getAssets(),"font/Back to Black Demo.ttf"));
        map.setTypeface(Typeface.createFromAsset(getAssets(),"font/coffee+teademo-Regular.ttf"));
        accept.setTypeface(Typeface.createFromAsset(getAssets(),"font/coffee+teademo-Regular.ttf"));
        decline.setTypeface(Typeface.createFromAsset(getAssets(),"font/coffee+teademo-Regular.ttf"));
        hotelNmae.setTypeface(Typeface.createFromAsset(getAssets(),"font/Marguaritas.ttf"));
        needAcc.setTypeface(Typeface.createFromAsset(getAssets(),"font/coffee+teademo-Regular.ttf"));
        yesText.setTypeface(Typeface.createFromAsset(getAssets(),"font/rockwell.ttf"));
        notext.setTypeface(Typeface.createFromAsset(getAssets(),"font/rockwell.ttf"));

        findViewById(R.id.bactto).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.enter_from_left, R.anim.exit_to_right);
            }
        });

        findViewById(R.id.map).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // String map = "http://maps.google.co.in/maps?q=" + holder.address.getText().toString();

                 String uri = String.format(Locale.ENGLISH, "geo:%f,%f", 28.7041, 77.1025);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent);
            }
        });
    }
}
