package id.co.blogbasbas.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Server on 18/11/2017.
 */

public class MapFragment extends Fragment {

    public MapFragment() {
        // Required empty public constructor
    }



    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.activity_maps, container, false);

        return v;
    }
}
