package wedcraze.acumeet.com.weddingdemo.Fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import me.crosswall.lib.coverflow.core.CoverTransformer;
import me.crosswall.lib.coverflow.core.PagerContainer;
import wedcraze.acumeet.com.weddingdemo.Activity.GalleryActivity;
import wedcraze.acumeet.com.weddingdemo.Activity.ImageActivity;
import wedcraze.acumeet.com.weddingdemo.R;

/**
 * Created by LENOVO on 5/19/2017.
 */

public class GalleryFragment extends Fragment {

    private Context context;
    private ItemAdapter itemAdapter;
    private PagerContainer mContainer;
    private ViewPager pager;
    private HeaderPagerAdapter adapter;


    public GalleryFragment(Context context) {
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.gallery,container,false);
        GridView gridView = (GridView)view.findViewById(R.id.galleryview);
        mContainer = (PagerContainer) view.findViewById(R.id.pager_container);
        pager = mContainer.getViewPager();
        pager.setClipChildren(false);
        itemAdapter = new ItemAdapter();
        itemAdapter.add(new Item("Wedding",R.drawable.gone));
        itemAdapter.add(new Item("Wedding",R.drawable.gtwo));
        itemAdapter.add(new Item("Wedding",R.drawable.gthree));
        itemAdapter.add(new Item("Wedding",R.drawable.gfour));
        itemAdapter.add(new Item("Wedding",R.drawable.gfive));
        itemAdapter.add(new Item("Wedding",R.drawable.gsix));
        itemAdapter.add(new Item("Wedding",R.drawable.gone));
        itemAdapter.add(new Item("Wedding",R.drawable.gtwo));
        itemAdapter.add(new Item("Wedding",R.drawable.gthree));
        itemAdapter.add(new Item("Wedding",R.drawable.gfour));
        gridView.setAdapter(itemAdapter);


        pager.setPageTransformer(false, new CoverTransformer(0.3f, 0f, 0f, 0f));
        Log.d("###", "pager1 width:" + 150 * getResources().getDisplayMetrics().density);

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            private int index = 0;

            @Override
            public void onPageSelected(int position) {

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

            /*    if (state == ViewPager.SCROLL_STATE_IDLE && adapter != null) {
                    ClassDetails cd = adapter.getItem(index);

                    String json = sp.getString(Keys.USER_DETAILS, "");
                    Gson gson = new Gson();
                    final Register.UserDetail userDetail = gson.fromJson(json, Register.UserDetail.class);
                    if (cd.getName().equalsIgnoreCase(sp.getString(Keys.CLASS_NAME,""))){
                        recyclerView.setVisibility(View.VISIBLE);
                        findViewById(R.id.no_result).setVisibility(View.GONE);
                    }else {
                        recyclerView.setVisibility(View.GONE);
                        no_result.setVisibility(View.VISIBLE);
                        no_result.setText("You are registered with Class "+sp.getString(Keys.CLASS_NAME,"")+", You can only view test questions from the registered class.");
                    }


                    setSubjects(cd.getSubjects());

                }*/
            }
        });
        List<Item> array = new ArrayList<>();
        array.add(new Item("Wedding",R.drawable.gsone));
        array.add(new Item("Wedding",R.drawable.gstwo));
        array.add(new Item("Wedding",R.drawable.gsthree));
        array.add(new Item("Wedding",R.drawable.gsone));
        array.add(new Item("Wedding",R.drawable.gstwo));
        array.add(new Item("Wedding",R.drawable.gsthree));
        adapter = new HeaderPagerAdapter(array);
        pager.setAdapter(adapter);
        pager.setOffscreenPageLimit(adapter.getCount());
        Item cd = adapter.getItem(0);
        return view;
    }

    private class ItemAdapter extends ArrayAdapter<Item> {

        private LayoutInflater inflater=null;
        public ItemAdapter() {
            super(context, R.layout.single_gallery);
            inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            Holder holder = null;
            View view = convertView;
            if(view == null){
                view = inflater.inflate(R.layout.single_gallery,parent,false);
                holder = new Holder();
                holder.collectionImage = (ImageView)view.findViewById(R.id.galleryimage);
                view.setTag(holder);
            }else {
                holder = (Holder) view.getTag();
            }
            final Item item = getItem(position);
           // holder.productName.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"font/Margueritas.ttf"));
            holder.collectionImage.setImageResource(item.drawable);
            final Holder finalHolder = holder;
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                  /*  finalHolder.collectionImage.buildDrawingCache();
                    Bitmap bitmap = finalHolder.collectionImage.getDrawingCache();

                    Intent intent = new Intent(getActivity(), ImageActivity.class);
                    intent.putExtra("BitmapImage", bitmap);
                    startActivity(intent);*/
                    Intent intent = new Intent(getActivity(), ImageActivity.class);
                    intent.putExtra("resourseInt", item.drawable);
                    startActivity(intent);
                    getActivity().overridePendingTransition(R.anim.enter_from_right, R.anim.exit_to_left);
                }
            });
            return view;
        }

        public class Holder{
            private ImageView collectionImage;
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

    private void sendDrawable(Drawable res){
        Bitmap bitmap = ((BitmapDrawable)res).getBitmap();
        Intent intent = new Intent(getActivity(),ImageActivity.class);
        intent.putExtra("Bitmap", bitmap);
        startActivity(intent);
    }

    /*Adapter for classes*/
    private class HeaderPagerAdapter extends PagerAdapter {
        private List<Item> list;

        public HeaderPagerAdapter(List<Item> list) {
            this.list = list;
        }

        @Override
        public Object instantiateItem(ViewGroup container, final int position) {
            View v = getActivity().getLayoutInflater().inflate(R.layout.custom_gallery, null);
            Item item = getItem(position);
            TextView name = (TextView)v.findViewById(R.id.galleryname);
            ImageView img = (ImageView)v.findViewById(R.id.galleryimage);
            img.setImageResource(item.drawable);
            name.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"font/Marguaritas.ttf"));
           // v.setBackgroundResource(pager.getCurrentItem() == position ? R.drawable.red_circle : R.drawable.blue_circle);
           // t.setTextColor(pager.getCurrentItem() == position ? getResources().getColor(R.color.red_lite) : getResources().getColor(R.color.white));
           // t.setTypeface(C.getMontserratSemiBoldTypeface(StartTest.this));
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

}
