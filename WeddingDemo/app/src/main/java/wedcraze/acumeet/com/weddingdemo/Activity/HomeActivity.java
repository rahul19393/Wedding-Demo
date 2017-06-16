package wedcraze.acumeet.com.weddingdemo.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import wedcraze.acumeet.com.weddingdemo.Dialog.MenuDialog;
import wedcraze.acumeet.com.weddingdemo.Dialog.MyMenuDialog;
import wedcraze.acumeet.com.weddingdemo.Fragment.AboutFragment;
import wedcraze.acumeet.com.weddingdemo.Fragment.AccomodationFragment;
import wedcraze.acumeet.com.weddingdemo.Fragment.AnounncementFragment;
import wedcraze.acumeet.com.weddingdemo.Fragment.EvantFragment;
import wedcraze.acumeet.com.weddingdemo.Fragment.GalleryFragment;
import wedcraze.acumeet.com.weddingdemo.Fragment.GuestListFragment;
import wedcraze.acumeet.com.weddingdemo.Fragment.HomeFragment;
import wedcraze.acumeet.com.weddingdemo.Fragment.KeyPeopleFragment;
import wedcraze.acumeet.com.weddingdemo.Fragment.MyProfileFragment;
import wedcraze.acumeet.com.weddingdemo.Fragment.ShagunFragment;
import wedcraze.acumeet.com.weddingdemo.Fragment.StoryFragment;
import wedcraze.acumeet.com.weddingdemo.Interface.CallBackDialog;
import wedcraze.acumeet.com.weddingdemo.R;

public class HomeActivity extends AppCompatActivity {

    private FragmentTransaction transaction;
    private TextView title;
    private ImageView menu;
    private LinearLayout homeBackground;
    private RelativeLayout headerBackground;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home);

        title = (TextView)findViewById(R.id.title);
        menu = (ImageView)findViewById(R.id.menu);
        headerBackground = (RelativeLayout)findViewById(R.id.headerbackground);
        homeBackground = (LinearLayout)findViewById(R.id.homebg);
        title.setTypeface(Typeface.createFromAsset(getAssets(),"font/Back to Black Demo.ttf"));
        title.setText("Aayushi & Saanvi");
        homeBackground.setBackgroundDrawable(getResources().getDrawable(R.drawable.backgroundwall));
        replaceFragment(new HomeFragment());
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MyMenuDialog(HomeActivity.this,callBackDialog).show();
                //new MenuDialog(HomeActivity.this,callBackDialog).show();
            }
        });
        findViewById(R.id.notification).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                headerBackground.setBackgroundColor(Color.TRANSPARENT);
                homeBackground.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                title.setText("Announcements");
                replaceFragment(new AnounncementFragment());
            }
        });

        findViewById(R.id.shagun).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title.setText("Shagun");
                headerBackground.setBackgroundColor(Color.TRANSPARENT);
                homeBackground.setBackgroundDrawable(getResources().getDrawable(R.drawable.shagunbg));
                replaceFragment(new ShagunFragment());
            }
        });
        findViewById(R.id.live).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,LiveStreamingActivity.class));
            }
        });

    }

     CallBackDialog callBackDialog = new CallBackDialog() {
         @Override
         public void callBack(String selection) {
             if(selection.equals("home")){
                 headerBackground.setBackgroundColor(Color.parseColor("#95ffffff"));
                 title.setText("Aayushi & Saanvi");
                 homeBackground.setBackgroundDrawable(getResources().getDrawable(R.drawable.backgroundwall));
                 replaceFragment(new HomeFragment());
             }else if(selection.equals("event")){
                 headerBackground.setBackgroundColor(Color.TRANSPARENT);
                 title.setText("Event");
                 homeBackground.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                 replaceFragment(new EvantFragment());
             }else if(selection.equals("gallery")){
                 headerBackground.setBackgroundColor(Color.TRANSPARENT);
                 title.setText("Gallery");
                 homeBackground.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                 replaceFragment(new GalleryFragment(HomeActivity.this));
             }else if(selection.equals("story")){
                 headerBackground.setBackgroundColor(Color.TRANSPARENT);
                 title.setText("Our Story");
                 homeBackground.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                 replaceFragment(new StoryFragment());
             }else if(selection.equals("people")){
                 headerBackground.setBackgroundColor(Color.TRANSPARENT);
                 homeBackground.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                 title.setText("Key People");
                replaceFragment(new KeyPeopleFragment());
             }else if(selection.equals("gest")){
                 headerBackground.setBackgroundColor(Color.TRANSPARENT);
               title.setText("Guest List");
                 homeBackground.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                 replaceFragment(new GuestListFragment());
             }else if(selection.equals("profile")){
                 title.setText("My Profile");
                 headerBackground.setBackgroundColor(Color.TRANSPARENT);
                 homeBackground.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                 replaceFragment(new MyProfileFragment());
             }else if(selection.equals("shagun")){
                 headerBackground.setBackgroundColor(Color.TRANSPARENT);
                 title.setText("Shagun");
                 homeBackground.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                 replaceFragment(new ShagunFragment());
             }
             else if(selection.equals("about")){
                 headerBackground.setBackgroundColor(Color.TRANSPARENT);
                 title.setText("About");
                 homeBackground.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
                 replaceFragment(new AboutFragment());
             }
         }
     };


    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.commit();
    }
}
