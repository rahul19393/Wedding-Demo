package wedcraze.acumeet.com.weddingdemo.Constant;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import java.util.List;

import wedcraze.acumeet.com.weddingdemo.R;
import wedcraze.acumeet.com.weddingdemo.WheelView.CursorWheelLayout;

/**
 * Created by chensuilun on 16/4/24.
 */
public class SimpleTextAdapter extends CursorWheelLayout.CycleWheelAdapter {
    private List<MenuItemData> mMenuItemDatas;
    private LayoutInflater mLayoutInflater;
    private Context mContext;
    public static final int INDEX_SPEC = 9;
    private int mGravity;
    private Context ctx;

    public SimpleTextAdapter(Context context, List<MenuItemData> menuItemDatas, int gravity) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        mMenuItemDatas = menuItemDatas;
        mGravity = gravity;
       // this.callBackDialog = callBackDialog;
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

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(mContext,"heart", Toast.LENGTH_LONG).show();
                //((StartFragmentListner)ctx).startFragmentAt(new StoryFragment(callBackDialog));
            }
        });
        story.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(mContext,"home", Toast.LENGTH_LONG).show();
            //    mContext.startActivity(new Intent(mContext, AlertsActivity.class));
                //ctx.overridePendingTransition(R.anim.enter_from_right, R.anim.exit_to_left);
            }
        });
        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(mContext,"sound", Toast.LENGTH_LONG).show();
            }
        });
        event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //    mContext.startActivity(new Intent(ctx, KeyContactsActivity.class));

                // ctx.overridePendingTransition(R.anim.enter_from_right, R.anim.exit_to_left);

                //  Toast.makeText(mContext,"star", Toast.LENGTH_LONG).show();
            }
        });
        people.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  Toast.makeText(mContext,"star", Toast.LENGTH_LONG).show();
              //  ((StartFragmentListner)mContext).startFragmentAt(new GalerryFragment(mContext));

            }
        });

        return root;
    }

    @Override
    public MenuItemData getItem(int position) {
        return mMenuItemDatas.get(position);
    }

}