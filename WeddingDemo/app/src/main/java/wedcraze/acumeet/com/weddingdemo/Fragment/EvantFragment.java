package wedcraze.acumeet.com.weddingdemo.Fragment;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;
import wedcraze.acumeet.com.weddingdemo.Activity.EventRsvpActivity;
import wedcraze.acumeet.com.weddingdemo.R;

/**
 * Created by LENOVO on 5/22/2017.
 */

public class EvantFragment extends Fragment{
    private RecyclerView commentList;
    private List<Items> lists = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.event,container,false);
        commentList = (RecyclerView)view.findViewById(R.id.eventlist);
        lists.add(new Items("Mehendi","June 21st 2017 / 11:00 AM",R.drawable.mehendi,"Jodha Bai Mahal"));
        lists.add(new Items("Tilak","June 22st 2017 / 8:00 AM",R.drawable.tilak,"Tansen Hall"));
        lists.add(new Items("Sangeet","June 23st 2017 / 9:00 AM",R.drawable.sangeet,"Jodha Bai Mahal"));
        lists.add(new Items("Reception","June 21st 2017 / 11:00 AM",R.drawable.sangeet,"Tansen Hall"));
        setEventAdapter();
        return view;
    }

    private void setEventAdapter(){
        CommentAdapter  adapter = new CommentAdapter(lists);
        commentList.setItemAnimator(new DefaultItemAnimator());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        commentList.setLayoutManager(layoutManager);
        commentList.setAdapter(adapter);
    }


    private class CommentAdapter extends RecyclerView.Adapter<MyViewHolder>{
        private List<Items> source;

        public CommentAdapter(List<Items> source) {
            this.source = source;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_event, parent, false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
           Items items = source.get(position);
            holder.eventName.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"font/Marguaritas.ttf"));
            holder.map.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"font/coffee+teademo-Regular.ttf"));
            holder.rsvp.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"font/coffee+teademo-Regular.ttf"));
            holder.eventName.setText(items.eventName);
            holder.eventDate.setText(items.eventDate);
            holder.eventPlace.setText(items.eventPlace);
            holder.eventImage.setImageResource(items.eventImage);
            holder.eventDate.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"font/rockwell.ttf"));
            holder.eventPlace.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"font/rockwell.ttf"));

            holder.rsvp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getActivity(), EventRsvpActivity.class));
                    getActivity().overridePendingTransition(R.anim.enter_from_right, R.anim.exit_to_left);
                }
            });
            holder.map.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String uri = String.format(Locale.ENGLISH, "geo:%f,%f", 28.7041, 77.1025);
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                    startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return source.size();
        }
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {
        TextView eventDate,eventName,date;
        TextView eventPlace;
        Button map,rsvp;
        CircleImageView eventImage;
        public MyViewHolder(View itemView) {
            super(itemView);
            eventDate = (TextView)itemView.findViewById(R.id.eventdate);
            eventName = (TextView)itemView.findViewById(R.id.user_name);
            eventPlace = (TextView)itemView.findViewById(R.id.eventplace);
            map = (Button)itemView.findViewById(R.id.map);
            rsvp = (Button)itemView.findViewById(R.id.rsvp);
            eventImage = (CircleImageView)itemView.findViewById(R.id.eventimage);
        }
    }

    private class Items{
        public String eventName,eventDate,eventPlace;
        int eventImage;

        public Items(String eventName, String eventDate, int eventImage, String eventPlace) {
            this.eventName = eventName;
            this.eventDate = eventDate;
            this.eventImage = eventImage;
            this.eventPlace = eventPlace;
        }
    }
}
