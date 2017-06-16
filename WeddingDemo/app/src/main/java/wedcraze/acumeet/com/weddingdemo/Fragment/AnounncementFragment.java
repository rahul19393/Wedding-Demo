package wedcraze.acumeet.com.weddingdemo.Fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import wedcraze.acumeet.com.weddingdemo.R;

/**
 * Created by LENOVO on 5/29/2017.
 */
public class AnounncementFragment extends Fragment {
    private RecyclerView anouncelist;
    private List<Items> lists = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.anouncement,container,false);
        anouncelist = (RecyclerView)view.findViewById(R.id.anounccelist);
        lists.add(new Items("John",R.drawable.photo));
        lists.add(new Items("John",R.drawable.photo));
        lists.add(new Items("John",R.drawable.photo));
        lists.add(new Items("John",R.drawable.photo));
        setCommentAdapter();
        return view;
    }

    private void setCommentAdapter(){
        CommentAdapter  adapter = new CommentAdapter(lists);
        anouncelist.setItemAnimator(new DefaultItemAnimator());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        anouncelist.setLayoutManager(layoutManager);
        anouncelist.setAdapter(adapter);
    }


    private class CommentAdapter extends RecyclerView.Adapter<MyViewHolder>{
        private List<Items> source;

        public CommentAdapter(List<Items> source) {
            this.source = source;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_announcement, parent, false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            Items items = source.get(position);
            holder.userName.setTypeface(Typeface.createFromAsset(getActivity().getAssets(), "font/coffee+teademo-Regular.ttf"));
            holder.message.setTypeface(Typeface.createFromAsset(getActivity().getAssets(), "font/coffee+teademo-Regular.ttf"));
            holder.date.setTypeface(Typeface.createFromAsset(getActivity().getAssets(), "font/coffee+teademo-Regular.ttf"));
        }

        @Override
        public int getItemCount() {
            return source.size();
        }
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {
        TextView userName,message,date;
        CircleImageView userImage;
        public MyViewHolder(View itemView) {
            super(itemView);
            userName = (TextView)itemView.findViewById(R.id.user_name);
            date = (TextView)itemView.findViewById(R.id.date);
            message = (TextView)itemView.findViewById(R.id.message);
            userImage = (CircleImageView)itemView.findViewById(R.id.userimage);
        }
    }

    private class Items{
        public String eventName;
        int eventImage;

        public Items(String eventName,int eventImage) {
            this.eventName = eventName;
            this.eventImage = eventImage;
        }
    }
}
