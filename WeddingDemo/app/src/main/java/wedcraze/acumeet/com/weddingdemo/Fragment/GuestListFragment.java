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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import wedcraze.acumeet.com.weddingdemo.Activity.ChatActivity;
import wedcraze.acumeet.com.weddingdemo.Activity.KeyPeopleActivity;
import wedcraze.acumeet.com.weddingdemo.Dialog.ChatInfoDialog;
import wedcraze.acumeet.com.weddingdemo.R;

/**
 * Created by LENOVO on 5/25/2017.
 */
public class GuestListFragment extends Fragment {
    private ArrayList<adapterItem> adapterItems = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.guest_fragment, container, false);
        final ViewPager viewPager = (ViewPager)view.findViewById(R.id.keycontactpager);
        TextView team = (TextView)view.findViewById(R.id.team);
        team.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"font/Marguaritas.ttf"));

        view.findViewById(R.id.right).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(viewPager.getCurrentItem()-1);

            }
        });
        view.findViewById(R.id.left).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(viewPager.getCurrentItem()+1);

            }
        });
        view.findViewById(R.id.chat).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),ChatActivity.class));
                getActivity().overridePendingTransition(R.anim.enter_from_right, R.anim.exit_to_left);
            }
        });

        adapterItems.add(new adapterItem(""));
        adapterItems.add(new adapterItem(""));
        adapterItems.add(new adapterItem(""));
        adapterItems.add(new adapterItem(""));
        adapterItems.add(new adapterItem(""));

        ContactAdapter contactAdapter = new ContactAdapter(adapterItems);
        viewPager.setAdapter(contactAdapter);
        contactAdapter.notifyDataSetChanged();
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
            KeyPeopleAdapter keyPeopleAdapter = new KeyPeopleAdapter(lists);
            contactList = (ListView) viewItem.findViewById(R.id.contactlist);
            // gpName.setText(pagerItemList.get(position).groupName);

            for(int i = 0; i<20;i++){
                keyPeopleAdapter.add(new Item("", ""));
            }

            contactList.setAdapter(keyPeopleAdapter);

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
    }

    private class KeyPeopleAdapter extends BaseAdapter {
        // View Type for Separators
        // View Type for Regular rows
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
            return super.getItemViewType(position);
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

                        view = inflater.inflate(R.layout.custom_guestlist, null);
                        holder = new Holder();
                        holder.userName = (TextView) view.findViewById(R.id.user_name);
                        holder.side = (TextView) view.findViewById(R.id.side);
                        holder.userName.setTypeface(Typeface.createFromAsset(getActivity().getAssets(), "font/coffee+teademo-Regular.ttf"));
                        holder.side.setTypeface(Typeface.createFromAsset(getActivity().getAssets(), "font/coffee+teademo-Regular.ttf"));

                holder.chat = (ImageView)view.findViewById(R.id.chat);
                view.setTag(holder);

            } else {
                holder = (Holder) view.getTag();
            }
            //  holder.msg.setText(item.message);
            // holder.time.setText(DateUtils.getRelativeTimeSpanString(C.getDateInMillis(item.time), Calendar.getInstance().getTimeInMillis()-19800000, DateUtils.SECOND_IN_MILLIS));
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new ChatInfoDialog(getActivity()).show();
                }
            });
            holder.chat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getActivity(), ChatActivity.class));
                    getActivity().overridePendingTransition(R.anim.enter_from_right, R.anim.exit_to_left);
                }
            });
            return view;
        }
    }

    class Holder {
        TextView userName, side;
        ImageView chat;
    }
    private class Item {
        String message, time;

        public Item(String time, String message) {
            this.message = message;
            this.time = time;
        }
    }

    private class adapterItem {
        public String groupName;
        public adapterItem(String groupName) {
            this.groupName = groupName;
        }
    }
}
