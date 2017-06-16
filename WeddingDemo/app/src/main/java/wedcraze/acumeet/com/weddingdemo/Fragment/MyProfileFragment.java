package wedcraze.acumeet.com.weddingdemo.Fragment;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import wedcraze.acumeet.com.weddingdemo.Activity.EditProfileActivity;
import wedcraze.acumeet.com.weddingdemo.R;

/**
 * Created by LENOVO on 5/28/2017.
 */
public class MyProfileFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.from(getActivity()).inflate(R.layout.my_profile,container,false);
        TextView name = (TextView)view.findViewById(R.id.name);
        Button edit = (Button)view.findViewById(R.id.edit);
        name.setTypeface(Typeface.createFromAsset(getActivity().getAssets(), "font/coffee+teademo-Regular.ttf"));
        edit.setTypeface(Typeface.createFromAsset(getActivity().getAssets(), "font/coffee+teademo-Regular.ttf"));

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), EditProfileActivity.class));
                getActivity().overridePendingTransition(R.anim.enter_from_right, R.anim.exit_to_left);

            }
        });
        return view;
    }
}
