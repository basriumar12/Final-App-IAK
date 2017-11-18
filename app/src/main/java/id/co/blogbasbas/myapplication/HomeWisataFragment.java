package id.co.blogbasbas.myapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.co.blogbasbas.myapplication.adapter.AdapterRecycler;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeWisataFragment extends Fragment {

    //deklarasi recyclerview
    RecyclerView recyclerView;


    public HomeWisataFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_home_wisata, container, false);
        //inisialisasi recyclerview
        recyclerView = (RecyclerView) v.findViewById(R.id.recycler);
        //recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 1));

        //set adapterrecycler dan fragment
        AdapterRecycler adapter = new AdapterRecycler(getActivity());
        recyclerView.setAdapter(adapter);

        return v;

    }

}
