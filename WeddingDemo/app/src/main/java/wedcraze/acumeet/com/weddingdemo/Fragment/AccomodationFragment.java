package wedcraze.acumeet.com.weddingdemo.Fragment;

import android.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

import wedcraze.acumeet.com.weddingdemo.R;

/**
 * Created by LENOVO on 5/24/2017.
 */
public class AccomodationFragment extends android.support.v4.app.Fragment {
    private ListView itemList;
    private ArrayList<Item> adapterItemList = new ArrayList<Item>();
    private AccomodationAdapter accomodationAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.accomodation,container,false);
        itemList = (ListView)view.findViewById(R.id.listitem);
        accomodationAdapter = new AccomodationAdapter(adapterItemList);
        TextView hotelInfo = (TextView)view.findViewById(R.id.hotelinfo);
        hotelInfo.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"font/coffee+teademo-Regular.ttf"));

        itemList.setAdapter(accomodationAdapter);

        accomodationAdapter.add(new Item("","",true));
        accomodationAdapter.add(new Item("","",false));
        accomodationAdapter.add(new Item("","",true));
        accomodationAdapter.add(new Item("","",false));
        accomodationAdapter.add(new Item("","",true));
        accomodationAdapter.add(new Item("","",false));
        accomodationAdapter.add(new Item("","",true));
        accomodationAdapter.add(new Item("","",false));
        accomodationAdapter.add(new Item("","",true));
        accomodationAdapter.add(new Item("","",false));
        accomodationAdapter.add(new Item("","",true));
        accomodationAdapter.add(new Item("","",false));
        accomodationAdapter.notifyDataSetChanged();
        return view;
    }


    private class AccomodationAdapter extends BaseAdapter {
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

        public AccomodationAdapter(ArrayList<Item> list) {
            this.list = list;
        }

        @Override
        public int getCount() {
           // return list.size();
            return 10;
        }

        public void clear(){
            this.list.clear();
            notifyDataSetChanged();
        }

        public void add(Item item){
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

            final Item item =  getItem(position);
            int itemViewType = getItemViewType(position);
            if (view == null){
                LayoutInflater inflater = getActivity().getLayoutInflater();
                switch (itemViewType){
                    case SEND:
                        view = inflater.inflate(R.layout.custom_accomodation_right, null);
                        holder = new Holder();
                        holder.hotelname = (TextView) view.findViewById(R.id.hotelname);
                        holder.hotelname.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"font/Marguaritas.ttf"));

                        // holder.time = (TextView)view.findViewById(R.id.time);
                        break;
                    case RECEIVE:
                        view = inflater.inflate(R.layout.custom_accomodation_left, null);
                        holder = new Holder();
                        holder.hotelname = (TextView) view.findViewById(R.id.hotelname);
                        holder.hotelname.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"font/Marguaritas.ttf"));
                        // holder.time = (TextView)view.findViewById(R.id.time);
                        break;
                }

                view.setTag(holder);

            }else {
                holder = (Holder) view.getTag();
            }
          //  holder.msg.setText(item.message);
           // holder.time.setText(DateUtils.getRelativeTimeSpanString(C.getDateInMillis(item.time), Calendar.getInstance().getTimeInMillis()-19800000, DateUtils.SECOND_IN_MILLIS));
            return view;
        }
    }

    class Holder{
        TextView hotelname,hotelDesp;
    }
    private class Item{
        boolean isSend=false;
        String message,time;
        public Item(String time,String message,boolean isSend) {
            this.message = message;
            this.isSend = isSend;
            this.time = time;
        }
    }
}
