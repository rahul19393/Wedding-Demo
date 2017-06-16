package wedcraze.acumeet.com.weddingdemo.Activity;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import wedcraze.acumeet.com.weddingdemo.R;


public class GalleryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_gallery);
        TextView title = (TextView)findViewById(R.id.headertitle);
        title.setTypeface(Typeface.createFromAsset(getAssets(),"font/Marguaritas.ttf"));
    }
}
