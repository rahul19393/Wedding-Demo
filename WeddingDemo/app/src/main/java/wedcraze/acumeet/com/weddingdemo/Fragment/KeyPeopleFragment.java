package wedcraze.acumeet.com.weddingdemo.Fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.schibsted.spain.parallaxlayerlayout.ParallaxLayerLayout;
import com.schibsted.spain.parallaxlayerlayout.SensorTranslationUpdater;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import wedcraze.acumeet.com.weddingdemo.Activity.KeyPeopleActivity;
import wedcraze.acumeet.com.weddingdemo.R;

/**
 * Created by LENOVO on 5/24/2017.
 */
public class KeyPeopleFragment extends Fragment {
    private ArrayList<adapterItem> adapterItems = new ArrayList<>();
    private ContactAdapter contactAdapter;
    private TextView team;
    private ParallaxLayerLayout parallaxLayout;

    private SensorTranslationUpdater translationUpdater;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.keypeople_fragment,container,false);
        final ViewPager viewPager = (ViewPager)view.findViewById(R.id.keycontactpager);
        team = (TextView)view.findViewById(R.id.team);
        team.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"font/Back to Black Demo.ttf"));
        //noinspection ConstantConditions
        translationUpdater = new SensorTranslationUpdater(getActivity());
        translationUpdater.registerSensorManager();
       parallaxLayout = (ParallaxLayerLayout) view.findViewById(R.id.parallax);
        parallaxLayout.setTranslationUpdater(translationUpdater);

        //   holder.parallaxLayout.setTranslationUpdater(translationUpdater);
        // Resets orientation when clicked
        parallaxLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                translationUpdater.reset();
            }
        });
        view.findViewById(R.id.right).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(viewPager.getCurrentItem()-1);
                contactAdapter.notifyDataSetChanged();
            }
        });
        view.findViewById(R.id.left).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                contactAdapter.notifyDataSetChanged();


            }
        });

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                if(position == 0)
                    team.setText("Team Bride");
                else  if(position == 1)
                    team.setText("Team Groom");
                else  if(position == 2)
                    team.setText("Team Friends");
               // contactAdapter.notifyDataSetChanged();
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        ArrayList<Item> lists = new ArrayList<>();
        lists.add(new Item("", "",R.drawable.keydummy, true));
        lists.add(new Item("", "",R.drawable.keydummytwo, false));
        lists.add(new Item("", "",R.drawable.keydummy, true));
        lists.add(new Item("", "",R.drawable.photo, false));
        lists.add(new Item("", "",R.drawable.keydummy, true));
        lists.add(new Item("", "",R.drawable.keydummytwo, false));
        lists.add(new Item("", "",R.drawable.photo, true));
        lists.add(new Item("", "",R.drawable.keydummytwo, false));
        adapterItems.add(new adapterItem("Bride",lists));

        ArrayList<Item> listst = new ArrayList<>();
        listst.add(new Item("", "",R.drawable.gsone, true));
        listst.add(new Item("", "",R.drawable.gstwo, false));
        listst.add(new Item("", "",R.drawable.gsthree, true));
        listst.add(new Item("", "",R.drawable.photo, false));
        listst.add(new Item("", "",R.drawable.keydummy, true));
        listst.add(new Item("", "",R.drawable.keydummytwo, false));
        listst.add(new Item("", "",R.drawable.photo, true));
        listst.add(new Item("", "",R.drawable.keydummytwo, false));
        adapterItems.add(new adapterItem("Groom",listst));

        listst = new ArrayList<>();
        listst.add(new Item("", "",R.drawable.photo, true));
        listst.add(new Item("", "",R.drawable.keydummytwo, false));
        listst.add(new Item("", "",R.drawable.gsone, true));
        listst.add(new Item("", "",R.drawable.gstwo, false));
        listst.add(new Item("", "",R.drawable.keydummy, true));
        listst.add(new Item("", "",R.drawable.photo, false));
        listst.add(new Item("", "",R.drawable.keydummy, true));
        listst.add(new Item("", "",R.drawable.keydummytwo, false));
        adapterItems.add(new adapterItem("Groom",listst));


        contactAdapter = new ContactAdapter(adapterItems);
        viewPager.setAdapter(contactAdapter);
       // contactAdapter.notifyDataSetChanged();
        viewPager.setCurrentItem(0);
      //  Toast.makeText(getActivity(),"current item"+viewPager.getCurrentItem(),Toast.LENGTH_LONG).show();
        return view;
    }


    private class ContactAdapter extends PagerAdapter {

        Context context;
        ListView contactList;
        private ArrayList<adapterItem> pagerItemList;
        private ArrayList<Item> lists = new ArrayList<>();

        public ContactAdapter(ArrayList<adapterItem> pagerItemList) {
            this.pagerItemList = pagerItemList;
        }
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

            final View viewItem = inflater.inflate(R.layout.key_contact_list, container, false);
            //final ImageView imageView = (ImageView) viewItem.findViewById(R.id.imageView3);
            contactList = (ListView) viewItem.findViewById(R.id.contactlist);
            // gpName.setText(pagerItemList.get(position).groupName);

                KeyPeopleAdapter keyPeopleAdapter = new KeyPeopleAdapter(pagerItemList.get(position).listItem);
                contactList.setAdapter(keyPeopleAdapter);
            ((ViewPager) container).addView(viewItem);
            return viewItem;
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return 3;
        }

       /* @Override
        public boolean isViewFromObject(View view, Object object) {
            // TODO Auto-generated method stub

            return view == ((View) object);
        }*/


        @Override
        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }
        @Override
        public boolean isViewFromObject(View view, Object object) {
            return object == view;
        }
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            // TODO Auto-generated method stub
            ((ViewPager) container).removeView((View) object);
        }




        private class KeyPeopleAdapter extends BaseAdapter {
            // View Type for Separators
            private static final int SEND = 0;
            // View Type for Regular rows
            private static final int RECEIVE = 1;
            // Types of Views that need to be handled
            // -- Separators and Regular rows --
            private static final int ITEM_VIEW_TYPE_COUNT = 2;
            private ArrayList<Item> list;

            @Override
            public int getViewTypeCount() {
                return ITEM_VIEW_TYPE_COUNT;
            }

            @Override
            public int getItemViewType(int position) {
                boolean isSection = getItem(position).isSend;
                if (isSection) {
                    return SEND;
                } else {
                    return RECEIVE;
                }
            }

            public KeyPeopleAdapter(ArrayList<Item> list) {
                this.list = list;
            }

            @Override
            public int getCount() {
                // return list.size();
                return 5;
            }

            public void clear() {
                this.list.clear();
                notifyDataSetChanged();
            }

            public void add(Item item) {
                this.list.add(item);
                notifyDataSetChanged();
            }

            @Override
            public Item getItem(int position) {
                return this.list.get(position);
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View view, ViewGroup parent) {
                Holder holder = null;

                final Item item = getItem(position);
                int itemViewType = getItemViewType(position);
                if (view == null) {
                    LayoutInflater inflater = getActivity().getLayoutInflater();
                    switch (itemViewType) {
                        case SEND:
                            view = inflater.inflate(R.layout.custom_key_people_right, null);
                            holder = new Holder();
                            holder.keyImg = (CircleImageView)view.findViewById(R.id.galleryimage);
                            holder.keyImg.setImageResource(item.drawable);
                            holder.hotelname = (TextView) view.findViewById(R.id.hotelname);
                            holder.hotelname.setTypeface(Typeface.createFromAsset(getActivity().getAssets(), "font/Marguaritas.ttf"));
                            break;
                        case RECEIVE:
                            view = inflater.inflate(R.layout.custom_keypople_left, null);
                            holder = new Holder();
                            holder.keyImg = (CircleImageView)view.findViewById(R.id.galleryimage);
                            holder.keyImg.setImageResource(item.drawable);
                            holder.hotelname = (TextView) view.findViewById(R.id.hotelname);
                            holder.hotelname.setTypeface(Typeface.createFromAsset(getActivity().getAssets(), "font/Marguaritas.ttf"));
                            break;
                    }
                    view.setTag(holder);

                } else {
                    holder = (Holder) view.getTag();
                }

                //  holder.msg.setText(item.message);
                // holder.time.setText(DateUtils.getRelativeTimeSpanString(C.getDateInMillis(item.time), Calendar.getInstance().getTimeInMillis()-19800000, DateUtils.SECOND_IN_MILLIS));
               view.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       startActivity(new Intent(getActivity(), KeyPeopleActivity.class));
                       getActivity().overridePendingTransition(R.anim.enter_from_right, R.anim.exit_to_left);

                   }
               });
                return view;
            }
        }

        class Holder {
            TextView hotelname;
            CircleImageView keyImg;
        }
    }
    private class adapterItem {
        public String groupName;
        public ArrayList<Item> listItem;
        public adapterItem(String groupName,ArrayList<Item> listItem) {
            this.groupName = groupName;
            this.listItem = listItem;
        }
    }
    private class Item {
        boolean isSend = false;
        String message, time;
        int drawable;

        public Item(String time, String message,int drawable, boolean isSend) {
            this.message = message;
            this.isSend = isSend;
            this.time = time;
            this.drawable = drawable;
        }
    }
}
