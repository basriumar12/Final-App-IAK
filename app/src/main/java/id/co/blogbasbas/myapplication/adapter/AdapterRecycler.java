package id.co.blogbasbas.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import id.co.blogbasbas.myapplication.DetailActivity;
import id.co.blogbasbas.myapplication.R;

/**
 * Created by Server on 18/11/2017.
 */

public class AdapterRecycler extends RecyclerView.Adapter<AdapterRecycler.MyHolder> {
   //deklarasi varibel
    LayoutInflater layoutInflater;
    Context context;

    //tambahkan array data

    String namaWisata [] = {"Otanaha Benteng",
                            "Pantai A",
                            "Pantai B",
                            "Benteng A",
                            "Benteng C",
                            "Benteng D"};
    int gambar [] = {R.drawable.pulau_cinta,
                    R.drawable.pulau_cinta,
                    R.drawable.boliyohutuo,
                    R.drawable.boliyohutuo,
                    R.drawable.botutonuo,
                    R.drawable.botutonuo};
    String lat [] ={"-6.2172017", "-6.2172017", "-6.2172017", "-6.2172017", "-6.2172017", "-6.2172017"};

    String log [] ={"106.8262304","106.8262304","106.8262304","106.8262304","106.8262304","106.8262304"};
    String detailWisata [] = {"madmadm admamda famfma admamdam da dma",
            "madmamda amdamdma dmadmadm  fkamfkakfjeji",
            "madmamda amdamdma dmadmadm  fkamfkakfjeji",
            "madmamda amdamdma dmadmadm  fkamfkakfjeji madmamda amdamdma dmadmadm  fkamfkakfjeji",
            "madmamda amdamdma dmadmadm  fkamfkakfjeji",
            "madmamda amdamdma dmadmadm  fkamfkakfjeji"};
    //constructor
    public AdapterRecycler(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public AdapterRecycler.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate( R.layout.item_list, parent, false);
        MyHolder holder = new MyHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(AdapterRecycler.MyHolder holder, final int position) {
        holder.txtWIsata.setText(namaWisata[position]);
        holder.imgWisata.setImageResource(gambar[position]);
        //event klik item
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //buat intent utk parse data
                Intent intentkirim = new Intent(context, DetailActivity.class);
                intentkirim.putExtra("NM",namaWisata[position]);
                intentkirim.putExtra("GMB", gambar[position]);
                intentkirim.putExtra("DET", detailWisata[position]);
                intentkirim.putExtra("LAT", lat[position]);
                intentkirim.putExtra("LOG", log[position]);
                context.startActivity(intentkirim);

            }
        });
    }

    @Override
    public int getItemCount() {
        return namaWisata.length;
    }

    public class MyHolder extends RecyclerView.ViewHolder {
       //dekalrasi isi widget yang ada dalam item_list
        ImageView imgWisata;
        TextView txtWIsata;

        public MyHolder(View itemView) {
            super(itemView);

            //inisialisasi
            imgWisata = (ImageView) itemView.findViewById(R.id.imgWisata);
            txtWIsata = (TextView) itemView.findViewById(R.id.txtNamaWisata);




        }
    }
}
