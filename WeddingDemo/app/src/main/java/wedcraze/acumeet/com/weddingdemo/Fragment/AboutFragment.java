package wedcraze.acumeet.com.weddingdemo.Fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import wedcraze.acumeet.com.weddingdemo.R;

/**
 * Created by LENOVO on 5/30/2017.
 */

public class AboutFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.about_fragment,container,false);
        TextView abouttext = (TextView)view.findViewById(R.id.abouttext);
        TextView desc = (TextView)view.findViewById(R.id.desptext);
        TextView madeby = (TextView)view.findViewById(R.id.madetext);
        TextView acumeet = (TextView)view.findViewById(R.id.acumeet);
        abouttext.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"font/Back to Black Demo.ttf"));
        desc.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"font/coffee+teademo-Regular.ttf"));
        madeby.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"font/rockwell.ttf"));
        acumeet.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"font/rockwell.ttf"));



        return view;
    }
}
