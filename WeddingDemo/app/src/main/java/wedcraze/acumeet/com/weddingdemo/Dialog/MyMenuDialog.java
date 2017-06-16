package wedcraze.acumeet.com.weddingdemo.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import wedcraze.acumeet.com.weddingdemo.Activity.LiveStreamingActivity;
import wedcraze.acumeet.com.weddingdemo.Constant.MenuItemData;
import wedcraze.acumeet.com.weddingdemo.Interface.CallBackDialog;
import wedcraze.acumeet.com.weddingdemo.R;
import wedcraze.acumeet.com.weddingdemo.WheelView.CursorWheelLayout;
import wedcraze.acumeet.com.weddingdemo.WheelView.SimpleTextCursorWheelLayout;

/**
 * Created by LENOVO on 5/29/2017.
 */
public class MyMenuDialog extends Dialog {
    private SimpleTextCursorWheelLayout outer,inner;
    private Context context;
    private CallBackDialog callBackDialog;
    public MyMenuDialog(Context context,CallBackDialog callBackDialog) {
        super(context, R.style.DialogFadeInOutAnim);
        this.context = context;
        this.callBackDialog = callBackDialog;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_menu);
        Window window = this.getWindow();
        WindowManager.LayoutParams wlp = window.getAttributes();
        wlp.gravity = Gravity.CENTER;
        window.setAttributes(wlp);
        setCanceledOnTouchOutside(true);
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        outer = (SimpleTextCursorWheelLayout)findViewById(R.id.outermenu);
        inner = (SimpleTextCursorWheelLayout)findViewById(R.id.circlemenu);
        outerRadialData();
        inertRadialData();
    }

    public class OutertAdapterMenu extends CursorWheelLayout.CycleWheelAdapter {
        private List<MenuItemData> mMenuItemDatas;
        private LayoutInflater mLayoutInflater;
        private Context mContext;
        public static final int INDEX_SPEC = 9;
        private int mGravity;
        private Context ctx;

        public OutertAdapterMenu(Context context, List<MenuItemData> menuItemDatas, int gravity) {
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
            View root = mLayoutInflater.inflate(R.layout.wheel_menu_outer, null, false);
            ImageView shagun = (ImageView)root.findViewById(R.id.shagun);
            ImageView logout = (ImageView)root.findViewById(R.id.logout);
            ImageView profile = (ImageView)root.findViewById(R.id.myprofile);
            ImageView aboutapp = (ImageView)root.findViewById(R.id.aboutmyapp);
            ImageView livestreame = (ImageView)root.findViewById(R.id.livestreame);

            shagun.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callBackDialog.callBack("shagun");
                    dismiss();
                }
            });
            logout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                  //  callBackDialog.callBack("story");
                    dismiss();
                }
            });
            profile.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callBackDialog.callBack("profile");
                    dismiss();
                }
            });
            aboutapp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callBackDialog.callBack("about");
                    dismiss();
                }
            });
            livestreame.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   // callBackDialog.callBack("people");
                    context.startActivity(new Intent(context, LiveStreamingActivity.class));
                    //dismiss();
                }
            });

            return root;
        }

        @Override
        public MenuItemData getItem(int position) {
            return mMenuItemDatas.get(position);
        }
    }
    private void inertRadialData() {
        String[] res = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "OFF"};
        List<MenuItemData> menuItemDatas = new ArrayList<MenuItemData>();
        for (int i = 0; i < 1; i++) {
            menuItemDatas.add(new MenuItemData(res[i]));
        }
        OutertAdapterMenu simpleTextAdapter = new OutertAdapterMenu(context, menuItemDatas, Gravity.BOTTOM | Gravity.CENTER_VERTICAL);
        outer.setAdapter(simpleTextAdapter);
    }
    private void outerRadialData() {
        String[] res = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "OFF"};
        List<MenuItemData> menuItemDatas = new ArrayList<MenuItemData>();
        for (int i = 0; i < 1; i++) {
            menuItemDatas.add(new MenuItemData(res[i]));
        }
        InnerAdapterMenu simpleTextAdapter = new InnerAdapterMenu(context, menuItemDatas, Gravity.BOTTOM | Gravity.CENTER_VERTICAL);
        inner.setAdapter(simpleTextAdapter);
    }
    public class InnerAdapterMenu extends CursorWheelLayout.CycleWheelAdapter {
        private List<MenuItemData> mMenuItemDatas;
        private LayoutInflater mLayoutInflater;
        private Context mContext;
        public static final int INDEX_SPEC = 9;
        private int mGravity;
        private Context ctx;

        public InnerAdapterMenu(Context context, List<MenuItemData> menuItemDatas, int gravity) {
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
            View root = mLayoutInflater.inflate(R.layout.wheelmenuinner, null, false);
            ImageView home = (ImageView)root.findViewById(R.id.home);
            ImageView keypeople = (ImageView)root.findViewById(R.id.keypeople);
            ImageView story = (ImageView)root.findViewById(R.id.ourstory);
            ImageView event = (ImageView)root.findViewById(R.id.events);
            ImageView gallery = (ImageView)root.findViewById(R.id.gallery);
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
            keypeople.setOnClickListener(new View.OnClickListener() {
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
