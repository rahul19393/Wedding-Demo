package wedcraze.acumeet.com.weddingdemo.Activity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import de.hdodenhof.circleimageview.CircleImageView;
import wedcraze.acumeet.com.weddingdemo.Dialog.InfoDialog;
import wedcraze.acumeet.com.weddingdemo.Interface.CallBackDialog;
import wedcraze.acumeet.com.weddingdemo.R;

public class EditProfileActivity extends Activity {
    private int REQUEST_CAMERA = 1;
    private int SELECT_FILE = 2;
    private CircleImageView userImg;
    private final int PERMISSION_REQUEST_CODE = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_edit_profile);
        TextView name = (TextView)findViewById(R.id.name);
        Button save = (Button)findViewById(R.id.save);
        TextView title = (TextView) findViewById(R.id.title);
        userImg = (CircleImageView)findViewById(R.id.userimage);
        name.setTypeface(Typeface.createFromAsset(getAssets(), "font/coffee+teademo-Regular.ttf"));
        save.setTypeface(Typeface.createFromAsset(getAssets(), "font/coffee+teademo-Regular.ttf"));
        title.setTypeface(Typeface.createFromAsset(getAssets(), "font/Back to Black Demo.ttf"));

        findViewById(R.id.bactto).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.enter_from_left, R.anim.exit_to_right);
            }
        });
        findViewById(R.id.camera).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= 23) {
                    if (!checkPermission()) {
                        ActivityCompat.requestPermissions(EditProfileActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.CAMERA,Manifest.permission.MEDIA_CONTENT_CONTROL}, PERMISSION_REQUEST_CODE);
                    }else
                        new InfoDialog(EditProfileActivity.this,callBackDialog).show();
                }
            }
        });
    }
    private boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        return result == PackageManager.PERMISSION_GRANTED;
    }
    CallBackDialog callBackDialog = new CallBackDialog() {
        @Override
        public void callBack(String selection) {

            if(selection.equals("camera"))
                cameraIntent();
                else if(selection.equals("gallery"))
                galleryIntent();

        }
    };


    private void cameraIntent()
    {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQUEST_CAMERA);
    }

    private void galleryIntent()
    {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
        intent.setAction(Intent.ACTION_GET_CONTENT);//
        startActivityForResult(Intent.createChooser(intent, "Select File"),SELECT_FILE);
    }
    private void onCaptureImageResult(Intent data) {
        Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        thumbnail.compress(Bitmap.CompressFormat.JPEG, 90, bytes);
        File destination = new File(Environment.getExternalStorageDirectory(),
                System.currentTimeMillis() + ".jpg");
        FileOutputStream fo;
        try {
            destination.createNewFile();
            fo = new FileOutputStream(destination);
            fo.write(bytes.toByteArray());
            fo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //ProductImagePathArray.add(destination.getPath());
       // imagePath = destination.getPath();
       // setImageInLayout(thumbnail,false,null);
        userImg.setImageBitmap(thumbnail);
    }

    private void onSelectFromGalleryResult(Intent data) {
        Bitmap bm=null;
        if (data != null) {
            try {
                bm = MediaStore.Images.Media.getBitmap(EditProfileActivity.this.getContentResolver(), data.getData());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Uri selectedImage = data.getData();
        // ProductImagePathArray.add(getPath(AddProductActivity.this,selectedImage));
        //setTag = setTag + 1;
       // imagePath = getPath(CreatePostActivity.this,selectedImage);
       // setImageInLayout(bm,false,null);
        userImg.setImageURI(selectedImage);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data != null){
            if(requestCode == REQUEST_CAMERA){
                onCaptureImageResult(data);
            }else if(requestCode == SELECT_FILE){
                onSelectFromGalleryResult(data);
            }
        }

    }
}
