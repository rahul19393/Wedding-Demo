package wedcraze.acumeet.com.weddingdemo.Fragment;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import wedcraze.acumeet.com.weddingdemo.Activity.CommentsActivity;
import wedcraze.acumeet.com.weddingdemo.Activity.LikesActivity;
import wedcraze.acumeet.com.weddingdemo.Constant.MenuItemData;
import wedcraze.acumeet.com.weddingdemo.Constant.SimpleTextAdapter;
import wedcraze.acumeet.com.weddingdemo.R;
import wedcraze.acumeet.com.weddingdemo.WheelView.SimpleTextCursorWheelLayout;

/**
 * Created by LENOVO on 5/24/2017.
 */
public class HomeFragment extends android.support.v4.app.Fragment {
    private WedingAdapter adapter;
    private RecyclerView postList;
    private ArrayList<Items> lists = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.home_fragment,container,false);
        postList = (RecyclerView)view.findViewById(R.id.weddinglist);
        setWeddingAdapter();
        return view;
    }
    private void setWeddingAdapter(){
        adapter = new WedingAdapter(lists);
        postList.setItemAnimator(new DefaultItemAnimator());
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        postList.setLayoutManager(mLayoutManager);
        postList.setAdapter(adapter);
    }
    private class WedingAdapter extends RecyclerView.Adapter<MyViewHolder>{
        private List<Items> source;

        public WedingAdapter(List<Items> source) {
            this.source = source;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_custom_layout, parent, false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, final int position) {

            holder.userName.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"font/coffee+teademo-Regular.ttf"));
           // final Items items = source.get(position);
            holder.likeClick.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getActivity(), LikesActivity.class));
                    getActivity().overridePendingTransition(R.anim.enter_from_right, R.anim.exit_to_left);
                }
            });  holder.comments.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getActivity(), CommentsActivity.class));
                    getActivity().overridePendingTransition(R.anim.enter_from_right, R.anim.exit_to_left);
                }
            });
            holder.commentslist.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getActivity(), CommentsActivity.class));
                    getActivity().overridePendingTransition(R.anim.enter_from_right, R.anim.exit_to_left);
                }
            });
        }

        @Override
        public int getItemCount() {
            return 10;
        }
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {
        TextView userName,comments,date,postDescription,commentsCount,postDate,likeTextView,userCommentName,userComment,commentDate,allComment;
        LinearLayout likeClick,likePost,commentslist;
        ImageView imageEvent,userImage,userCommentImage,likeIcon;
        RelativeLayout eventImageLayout;


        public MyViewHolder(View itemView) {
            super(itemView);
                userName = (TextView)itemView.findViewById(R.id.username);
            likeClick = (LinearLayout)itemView.findViewById(R.id.likeclick);
            comments = (TextView) itemView.findViewById(R.id.commentscount);
            commentslist = (LinearLayout)itemView.findViewById(R.id.comments);
        }
    }

    private class Items{
        public String userName,date,functionName,functionImage,userImage,postId,commentCounts,likeCounts,message;
        boolean postLike;

        public Items(String postId,String userName, String date, String functionName, String functionImage, String userImage,String commentCounts,String likeCounts,boolean postLike) {
            this.userName = userName;
            this.date = date;
            this.functionName = functionName;
            this.functionImage = functionImage;
            this.postId = postId;
            this.userImage = userImage;
            this.commentCounts = commentCounts;
            this.likeCounts = likeCounts;
            this.postLike = postLike;
        }
    }
}
