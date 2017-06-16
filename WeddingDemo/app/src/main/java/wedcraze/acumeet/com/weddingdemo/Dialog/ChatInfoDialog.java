package wedcraze.acumeet.com.weddingdemo.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import wedcraze.acumeet.com.weddingdemo.R;

/**
 * Created by LENOVO on 5/25/2017.
 */
public class ChatInfoDialog extends Dialog {
    private Context cts;
    public ChatInfoDialog(Context context) {
        super(context, R.style.DialogSlideAnim);
        this.cts = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_info);
        Window window = this.getWindow();
        WindowManager.LayoutParams wlp = window.getAttributes();
        wlp.gravity = Gravity.CENTER;
        window.setAttributes(wlp);
        setCanceledOnTouchOutside(true);

        TextView name = (TextView)findViewById(R.id.name);
        TextView mail = (TextView)findViewById(R.id.mail);
        TextView mobile = (TextView)findViewById(R.id.mobile);
        TextView team = (TextView)findViewById(R.id.team);
        TextView cahtText = (TextView)findViewById(R.id.chattext);

        name.setTypeface(Typeface.createFromAsset(cts.getAssets(),"font/coffee+teademo-Regular.ttf"));
        mail.setTypeface(Typeface.createFromAsset(cts.getAssets(),"font/coffee+teademo-Regular.ttf"));
        mobile.setTypeface(Typeface.createFromAsset(cts.getAssets(),"font/coffee+teademo-Regular.ttf"));
        cahtText.setTypeface(Typeface.createFromAsset(cts.getAssets(),"font/coffee+teademo-Regular.ttf"));

        findViewById(R.id.close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }
}
