package wedcraze.acumeet.com.weddingdemo.Activity;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.VideoView;

import wedcraze.acumeet.com.weddingdemo.R;

public class LiveStreamingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_live_streaming);
        VideoView videoView =(VideoView)findViewById(R.id.videoView1);

        //Creating MediaController
        android.widget.MediaController mediaController= new android.widget.MediaController(this);
        mediaController.setAnchorView(videoView);
        String uri = "android.resource://" + getPackageName() + "/" + R.raw.sangeet;

        //specify the location of media file
        // Uri uri= Uri.parse(Environment.getExternalStorageDirectory().getPath()+"/media/1.mp4");


        //Setting MediaController and URI, then starting the videoView
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(Uri.parse(uri));
        videoView.requestFocus();
        videoView.start();
    }
}
