package wedcraze.acumeet.com.weddingdemo.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import wedcraze.acumeet.com.weddingdemo.Constant.MenuItemData;
import wedcraze.acumeet.com.weddingdemo.Interface.CallBackDialog;
import wedcraze.acumeet.com.weddingdemo.R;
import wedcraze.acumeet.com.weddingdemo.WheelView.CursorWheelLayout;
import wedcraze.acumeet.com.weddingdemo.WheelView.SimpleTextCursorWheelLayout;

/**
 * Created by LENOVO on 5/10/2017.
 */

public class MenuDialog extends Dialog {
    private Context context;
    private SimpleTextCursorWheelLayout mTestCircleMenuLeft;
    private CallBackDialog callBackDialog;

    public MenuDialog(@NonNull Context context,CallBackDialog callBackDialog) {
        super(context, R.style.DialogSlideAnim);
        this.context = context;
        this.callBackDialog = callBackDialog;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Window window = this.getWindow();
        WindowManager.LayoutParams wlp = window.getAttributes();
        wlp.gravity = Gravity.CENTER;
        window.setAttributes(wlp);
        setCanceledOnTouchOutside(true);
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mTestCircleMenuLeft = (SimpleTextCursorWheelLayout)findViewById(R.id.circlemenu);
       // CircleImageView userimg = (CircleImageView)findViewById(R.id.userimg);

        initRadialData();
    }
    private void initRadialData() {
        String[] res = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "OFF"};
        List<MenuItemData> menuItemDatas = new ArrayList<MenuItemData>();
        for (int i = 0; i < 1; i++) {
            menuItemDatas.add(new MenuItemData(res[i]));
        }
        SimpleTextAdapterMenu simpleTextAdapter = new SimpleTextAdapterMenu(context, menuItemDatas, Gravity.BOTTOM | Gravity.CENTER_VERTICAL);
        mTestCircleMenuLeft.setAdapter(simpleTextAdapter);
    }
    public class SimpleTextAdapterMenu extends CursorWheelLayout.CycleWheelAdapter {
        private List<MenuItemData> mMenuItemDatas;
        private LayoutInflater mLayoutInflater;
        private Context mContext;
        public static final int INDEX_SPEC = 9;
        private int mGravity;
        private Context ctx;

        public SimpleTextAdapterMenu(Context context, List<MenuItemData> menuItemDatas, int gravity) {
            mContext = context;
            mLayoutInflater = LayoutInflater.from(context);
            mMenuItemDatas = menuItemDatas;
            mGravity = gravity;
        }

        @Override
        public int getCount() {
            return mMenuItemDatas == null ? 0 : mMenuItemDatas.size();
        }

        @Override
        public View getView(View parent, int position) {
            MenuItemData item = getItem(position);
            View root = mLayoutInflater.inflate(R.layout.wheel_menu_item, null, false);
            ImageView home = (ImageView)root.findViewById(R.id.home);
            ImageView story = (ImageView)root.findViewById(R.id.ourstory);
            ImageView gallery = (ImageView)root.findViewById(R.id.gallery);
            ImageView event = (ImageView)root.findViewById(R.id.event);
            ImageView people = (ImageView)root.findViewById(R.id.keypeople);
            ImageView gest = (ImageView)root.findViewById(R.id.guestlist);

            home.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callBackDialog.callBack("home");
                    dismiss();
                }
            });
            story.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callBackDialog.callBack("story");
                    dismiss();
                }
            });
            gallery.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callBackDialog.callBack("gallery");
                    dismiss();
                }
            });
            event.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callBackDialog.callBack("event");
                    dismiss();
                }
            });
            people.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callBackDialog.callBack("people");
                    dismiss();
                }
            });
            gest.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callBackDialog.callBack("gest");
                    dismiss();
                }
            });

            return root;
        }

        @Override
        public MenuItemData getItem(int position) {
            return mMenuItemDatas.get(position);
        }
    }
}
