package wedcraze.acumeet.com.weddingdemo.Activity;

import android.graphics.Typeface;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import me.crosswall.lib.coverflow.core.CoverTransformer;
import me.crosswall.lib.coverflow.core.PagerContainer;
import wedcraze.acumeet.com.weddingdemo.R;

public class KeyPeopleActivity extends AppCompatActivity {

    private PagerContainer mContainer;
    private ViewPager pager;
    private HeaderPagerAdapter adapter;
    private TextView name;
    private ArrayList<PeopleInfo> peopleInfos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_key_people);
        mContainer = (PagerContainer)findViewById(R.id.pager_container);
        name = (TextView)findViewById(R.id.teamname);
        final TextView title = (TextView)findViewById(R.id.title);
        final TextView infoTo  = (TextView)findViewById(R.id.info);
        final TextView relation  = (TextView)findViewById(R.id.relation);
        name.setTypeface(Typeface.createFromAsset(getAssets(),"font/Back to Black Demo.ttf"));
        title.setTypeface(Typeface.createFromAsset(getAssets(),"font/Back to Black Demo.ttf"));
        infoTo.setTypeface(Typeface.createFromAsset(getAssets(),"font/coffee+teademo-Regular.ttf"));

        pager = mContainer.getViewPager();
        pager.setClipChildren(false);
        pager.setPageTransformer(false, new CoverTransformer(0.3f, 0f, 0f, 0f));
        Log.d("###", "pager1 width:" + 150 * getResources().getDisplayMetrics().density);

       /* pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                Toast.makeText(KeyPeopleActivity.this,"position"+position,Toast.LENGTH_LONG).show();


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });*/

        findViewById(R.id.bactto).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.enter_from_left, R.anim.exit_to_right);
            }
        });
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            private int index = 0;
            @Override
            public void onPageSelected(int position) {
                PeopleInfo info = peopleInfos.get(position);
                name.setText(info.name);
                infoTo.setText(info.info);
                relation.setText(info.relation);
            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                index = position;

            }


            @Override
            public void onPageScrollStateChanged(int state) {
                View v = pager.getChildAt(index);
                // v.setBackgroundResource(state == ViewPager.SCROLL_STATE_IDLE ? R.drawable.galleryframe : R.drawable.galleryframe);
                TextView t = (TextView) v.findViewById(R.id.text);
                //   t.setTextColor(state == ViewPager.SCROLL_STATE_IDLE ? getResources().getColor(R.color.red_lite) : getResources().getColor(R.color.white));
                Log.e("state", "" + state);

            }
        });

        findViewById(R.id.bactto).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        List<Item> array = new ArrayList<>();
        array.add(new Item("Wedding",R.drawable.photo));
        array.add(new Item("Wedding",R.drawable.keydummy));
        array.add(new Item("Wedding",R.drawable.keydummytwo));
         array.add(new Item("Wedding",R.drawable.photo));
        array.add(new Item("Wedding",R.drawable.keydummy));
        array.add(new Item("Wedding",R.drawable.keydummytwo));
         array.add(new Item("Wedding",R.drawable.photo));
        array.add(new Item("Wedding",R.drawable.keydummy));
        array.add(new Item("Wedding",R.drawable.keydummytwo));
        addInformation();
        adapter = new HeaderPagerAdapter(array);
        adapter = new HeaderPagerAdapter(array);
        pager.setAdapter(adapter);
        pager.setOffscreenPageLimit(adapter.getCount());
        PeopleInfo info = peopleInfos.get(0);
        name.setText(info.name);
        infoTo.setText(info.info);
        relation.setText(info.relation);

    }


    private void addInformation(){
         peopleInfos = new ArrayList<>();
        peopleInfos.add(new PeopleInfo("John","My Friend","Recently I read Ashley’s story. She tried to destroy her life, but failed. God Himself showed up. Ashley heard the life-transforming message of Jesus and everything changed. It is amazing! It’s stories like Ashley’s that I want to share with the world to help them see that God’s love extends to them too."));
        peopleInfos.add(new PeopleInfo("Adriel","College Friend","Everyone dreads a new place, new people, new skills, etc. Going to college was the same experience to me." +"It was a new place where there were no people from my past. So anyone would think I was dreading it even more because of it but the opposite was the case." + "I was glad no one knew me because i was the kind that always got a judgement from everyone."));
        peopleInfos.add(new PeopleInfo("Brovo","Brother","I am the kind of person who stands for what I am and represent only that." +"In my class there was a large percentage of guys and a small percentage of girls." +"Me being the minority, it did not sit well being frank and open minded." +"In my class I did make a few friends because of some common interests." +"I loved some common tv shows like vampire diaries , friends , how I met your mother and all the rest, you know what i am talking about.."));
        peopleInfos.add(new PeopleInfo("Marbom","Teacher","When I arrived at school, Miss Pemberton pulled me aside. She asked if I wanted her to postpone the spelling bee to another day because of my upset about the fire. I told her no. That day, I won the bee for my classroom."));
          peopleInfos.add(new PeopleInfo("John","My Friend","Recently I read Ashley’s story. She tried to destroy her life, but failed. God Himself showed up. Ashley heard the life-transforming message of Jesus and everything changed. It is amazing! It’s stories like Ashley’s that I want to share with the world to help them see that God’s love extends to them too."));
        peopleInfos.add(new PeopleInfo("Adriel","College Friend","Everyone dreads a new place, new people, new skills, etc. Going to college was the same experience to me." +"It was a new place where there were no people from my past. So anyone would think I was dreading it even more because of it but the opposite was the case." + "I was glad no one knew me because i was the kind that always got a judgement from everyone."));
        peopleInfos.add(new PeopleInfo("Brovo","Brother","I am the kind of person who stands for what I am and represent only that." +"In my class there was a large percentage of guys and a small percentage of girls." +"Me being the minority, it did not sit well being frank and open minded." +"In my class I did make a few friends because of some common interests." +"I loved some common tv shows like vampire diaries , friends , how I met your mother and all the rest, you know what i am talking about.."));
        peopleInfos.add(new PeopleInfo("Marbom","Teacher","When I arrived at school, Miss Pemberton pulled me aside. She asked if I wanted her to postpone the spelling bee to another day because of my upset about the fire. I told her no. That day, I won the bee for my classroom."));
    }

    /*Adapter for classes*/
    private class HeaderPagerAdapter extends PagerAdapter {
        private List<Item> list;

        public HeaderPagerAdapter(List<Item> list) {
            this.list = list;
        }

        @Override
        public Object instantiateItem(ViewGroup container, final int position) {
            View v = getLayoutInflater().inflate(R.layout.custom_people_info, null);
            Item item = getItem(position);
            CircleImageView img = (CircleImageView)v.findViewById(R.id.galleryimage);
            img.setImageResource(item.drawable);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    pager.setCurrentItem(position, true);
                }
            });
            container.addView(v);
            return v;

        }

        private Item getItem(int position) {
            return this.list.get(position);
        }

        @Override
        public int getCount() {
            return this.list.size();
        }


        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public CharSequence getPageTitle(int position) {

            return super.getPageTitle(position);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return (view == object);
        }


    }

    private class Item{
        public String name;
        public int drawable;

        public Item(String name,int drawable) {
            this.name = name;
            this.drawable = drawable;
        }
    }

    private class PeopleInfo{
        public String name,relation,info;
        public PeopleInfo(String name, String relation, String info) {
            this.name = name;
            this.relation = relation;
            this.info = info;
        }
    }
}
