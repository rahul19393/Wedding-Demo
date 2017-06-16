package wedcraze.acumeet.com.weddingdemo.Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import wedcraze.acumeet.com.weddingdemo.R;

public class ImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_image);

        TextView story = (TextView)findViewById(R.id.text);
        ImageView eventimg = (ImageView)findViewById(R.id.eventimage);
        story.setTypeface(Typeface.createFromAsset(getAssets(),"font/coffee+teademo-Regular.ttf"));

     /*   Intent intent = getIntent();
        Bitmap bitmap = (Bitmap) intent.getParcelableExtra("BitmapImage");
*/
        Bundle extras = getIntent().getExtras();
        if (extras == null)
        {
            return;
        }
        int res = extras.getInt("resourseInt");
        eventimg.setImageResource(res);
       // eventimg.setImageResource(R.drawable.gfour);

    }
}
