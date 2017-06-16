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
 * Created by LENOVO on 5/22/2017.
 */

public class ShagunFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.shagun,container,false);
        TextView item = (TextView)view.findViewById(R.id.item);
        TextView sendmoney = (TextView)view.findViewById(R.id.sendmony);
        TextView ortext = (TextView)view.findViewById(R.id.or);
        item.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"font/coffee+teademo-Regular.ttf"));
        sendmoney.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"font/coffee+teademo-Regular.ttf"));
        ortext.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"font/coffee+teademo-Regular.ttf"));
        return view;
    }
}
