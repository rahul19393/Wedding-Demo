package wedcraze.acumeet.com.weddingdemo.Activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import wedcraze.acumeet.com.weddingdemo.R;

public class ChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_chat);
         ArrayList<Item> lists = new ArrayList<>();
        findViewById(R.id.bactto).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.enter_from_left, R.anim.exit_to_right);
            }
        });

        TextView title = (TextView)findViewById(R.id.title);
        title.setTypeface(Typeface.createFromAsset(getAssets(),"font/Back to Black Demo.ttf"));
        ChatAdapter keyPeopleAdapter = new ChatAdapter(lists);
       ListView chatList = (ListView)findViewById(R.id.chatlist);
        // gpName.setText(pagerItemList.get(position).groupName);
        keyPeopleAdapter.add(new Item("", "",R.drawable.keydummy, true));
        keyPeopleAdapter.add(new Item("", "",R.drawable.keydummytwo, false));
        keyPeopleAdapter.add(new Item("", "",R.drawable.keydummy, true));
        keyPeopleAdapter.add(new Item("", "",R.drawable.photo, false));
        keyPeopleAdapter.add(new Item("", "",R.drawable.keydummy, true));
        keyPeopleAdapter.add(new Item("", "",R.drawable.keydummytwo, false));
        keyPeopleAdapter.add(new Item("", "",R.drawable.photo, true));
        keyPeopleAdapter.add(new Item("", "",R.drawable.keydummytwo, false));
        chatList.setAdapter(keyPeopleAdapter);

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

    private class ChatAdapter extends BaseAdapter {
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

        public ChatAdapter(ArrayList<Item> list) {
            this.list = list;
        }

        @Override
        public int getCount() {
            // return list.size();
            return 4;
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
                LayoutInflater inflater = getLayoutInflater();
                switch (itemViewType) {
                    case SEND:
                        view = inflater.inflate(R.layout.chat_right, null);
                        holder = new Holder();
                        holder.message = (TextView)view.findViewById(R.id.message);
                        holder.message.setTypeface(Typeface.createFromAsset(getAssets(), "font/coffee+teademo-Regular.ttf"));
                        break;
                    case RECEIVE:
                        view = inflater.inflate(R.layout.chat_left, null);
                        holder = new Holder();

                        holder.message = (TextView)view.findViewById(R.id.message);
                        holder.message.setTypeface(Typeface.createFromAsset(getAssets(), "font/coffee+teademo-Regular.ttf"));
                        // holder.time = (TextView)view.findViewById(R.id.time);
                        break;
                }
                view.setTag(holder);

            } else {
                holder = (Holder) view.getTag();
            }
            //  holder.msg.setText(item.message);
            // holder.time.setText(DateUtils.getRelativeTimeSpanString(C.getDateInMillis(item.time), Calendar.getInstance().getTimeInMillis()-19800000, DateUtils.SECOND_IN_MILLIS));

            return view;
        }
    }

    class Holder {
        TextView message;
        CircleImageView keyImg;
    }
}

