package wedcraze.acumeet.com.weddingdemo.Activity;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import wedcraze.acumeet.com.weddingdemo.R;

public class LikesActivity extends AppCompatActivity {
    private RecyclerView commentList;
    private List<Items> lists = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_likes);
        commentList = (RecyclerView)findViewById(R.id.likeslist);
        TextView title = (TextView)findViewById(R.id.title);
        title.setTypeface(Typeface.createFromAsset(getAssets(),"font/Back to Black Demo.ttf"));

        findViewById(R.id.bactto).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.enter_from_left, R.anim.exit_to_right);
            }
        });
        lists.add(new Items("John",R.drawable.photo));
        lists.add(new Items("John",R.drawable.photo));
        lists.add(new Items("John",R.drawable.photo));
        lists.add(new Items("John",R.drawable.photo));
        lists.add(new Items("John",R.drawable.photo));

        setLikesAdapter();
    }

    private void setLikesAdapter(){
        CommentAdapter  adapter = new CommentAdapter(lists);
        commentList.setItemAnimator(new DefaultItemAnimator());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
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
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_likes, parent, false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            Items items = source.get(position);
            holder.userName.setTypeface(Typeface.createFromAsset(getAssets(), "font/coffee+teademo-Regular.ttf"));
        }

        @Override
        public int getItemCount() {
            return source.size();
        }
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {
        TextView userName;
        CircleImageView userImage;
        public MyViewHolder(View itemView) {
            super(itemView);
            userName = (TextView)itemView.findViewById(R.id.user_name);
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
