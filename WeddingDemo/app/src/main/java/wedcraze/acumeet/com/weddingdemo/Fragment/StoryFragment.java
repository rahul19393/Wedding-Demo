package wedcraze.acumeet.com.weddingdemo.Fragment;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import me.kaelaela.verticalviewpager.VerticalViewPager;
import wedcraze.acumeet.com.weddingdemo.R;

/**
 * Created by LENOVO on 5/19/2017.
 */

public class StoryFragment extends android.support.v4.app.Fragment {
    private VerticalViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.from(getActivity()).inflate(R.layout.story, container, false);
     //   TextView title = (TextView) view.findViewById(R.id.titlestory);
      //  TextView storytext = (TextView) view.findViewById(R.id.storytext);
        TextView sideup = (TextView) view.findViewById(R.id.sideup);
        viewPager = (VerticalViewPager) view.findViewById(R.id.vertical_viewpager);

//        title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(), "font/Marguaritas.ttf"));
      //  storytext.setTypeface(Typeface.createFromAsset(getActivity().getAssets(), "font/coffee+teademo-Regular.ttf"));
        sideup.setTypeface(Typeface.createFromAsset(getActivity().getAssets(), "font/coffee+teademo-Regular.ttf"));
        ContactAdapter contactAdapter = new ContactAdapter();
        viewPager.setAdapter(contactAdapter);
        viewPager.setOverScrollMode(View.OVER_SCROLL_NEVER);
        return view;
    }

    private class ContactAdapter extends PagerAdapter {

        Context context;
        ListView contactList;

//int[] imageId = {R.drawable.image1, R.drawable.image1, R.drawable.image1, R.drawable.image1};
        // ArrayList<String> imageUrls = new ArrayList<>();

       /* public ContactAdapter(Context context){
            this.context = context;

            //this.imageUrls = imageUrls;
        }*/

        @Override
        public Object instantiateItem(ViewGroup container, final int position) {
            // TODO Auto-generated method stub

            LayoutInflater inflater = getActivity().getLayoutInflater();

            final View viewItem = inflater.inflate(R.layout.custom_story, container, false);
            //final ImageView imageView = (ImageView) viewItem.findViewById(R.id.imageView3);
                TextView title = (TextView) viewItem.findViewById(R.id.titlestory);
             TextView storytext = (TextView) viewItem.findViewById(R.id.storytext);
            ImageView storyImg = (ImageView)viewItem.findViewById(R.id.storyimg);

            title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(), "font/Marguaritas.ttf"));
             storytext.setTypeface(Typeface.createFromAsset(getActivity().getAssets(), "font/coffee+teademo-Regular.ttf"));

            if (position == 0) {
                title.setText("Jab Me Met");
                storyImg.setImageResource(R.drawable.dummyimage);
            }else if(position == 1){
                title.setText("My Story");
                storyImg.setImageResource(R.drawable.gsone);
                storytext.setText("Life is name of happenings. Life teaches many lessons. Each lesson has interesting and inspiration story. Read real life inspirational stories. For few, life is very easy. Such people are born with luck. But for the rest, life is real struggle. To them, life poses very difficult challenges for their own survival. Read short stories and poems based on motivation experiences of life. Few stories are based on real life heroes.");
            }else if(position == 2){
                title.setText("Friends Story");
                storyImg.setImageResource(R.drawable.gstwo);
                storytext.setText("Recently I read Ashley’s story. She tried to destroy her life, but failed. God Himself showed up. Ashley heard the life-transforming message of Jesus and everything changed. It is amazing! It’s stories like Ashley’s that I want to share with the world to help them see that God’s love extends to them too.");
            }else if(position == 3){
                title.setText("College Story");
                storytext.setText("Online collection of short stories of students, short stories from school and college days, and short stories from boys’ and girls’ hostels. Memory of school and college is ever lasting. This category provides such memories and unforgettable experiences from schools, colleges and hostels.");
                storyImg.setImageResource(R.drawable.gsix);
            }

            ((ViewPager) container).addView(viewItem);
            return viewItem;
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return 4;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            // TODO Auto-generated method stub

            return view == ((View) object);
        }


        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            // TODO Auto-generated method stub
            ((ViewPager) container).removeView((View) object);
        }

        private class Item {
            boolean isSend = false;
            String message, time;
            int drawable;

            public Item(String time, String message, int drawable, boolean isSend) {
                this.message = message;
                this.isSend = isSend;
                this.time = time;
                this.drawable = drawable;
            }
        }
    }
}
