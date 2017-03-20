package com.example.admin.lecture08.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.lecture08.Model.SeasonAccessorMutator;
import com.example.admin.lecture08.R;

import java.util.List;

/**
 * Created by Admin on 3/20/2017.
 */

public class myOwnAdapter extends RecyclerView.Adapter<myOwnAdapter.mySeasonData>{
    private List<SeasonAccessorMutator> seasonDataArrayList;
    private LayoutInflater inflater;
    private OnItemClickCallback itemClickCallback;

    public interface OnItemClickCallback{
        void onClick(int p);
    }

    //method to show in mainActivity for wiget.setOnItemClick
    public void setItemClickCallback(OnItemClickCallback onItemClickCallback){
        this.itemClickCallback=onItemClickCallback;
    }

    public myOwnAdapter(Context context, List<SeasonAccessorMutator> seasonArrayList) {
        this.inflater=LayoutInflater.from(context);
        this.seasonDataArrayList=seasonArrayList;

    }

    @Override
    public mySeasonData onCreateViewHolder(ViewGroup parent, int viewType) {
        View rowView=inflater.inflate(R.layout.my_own_layout, parent, false);
        return new mySeasonData(rowView);
    }

    @Override
    public void onBindViewHolder(mySeasonData holder, int position) {
        SeasonAccessorMutator seasonAccessorMutator=seasonDataArrayList.get(position);
        holder.displaySeasonName.setText(seasonAccessorMutator.getSeasonName());
        holder.displaySeasonImage.setImageResource(seasonAccessorMutator.getSeasonImage());
    }

    @Override
    public int getItemCount() {
        return seasonDataArrayList.size();
    }

    //display all widget IDs on mySeasonData class
    public class mySeasonData extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView displaySeasonImage;
        private TextView displaySeasonName;
        private View container;
        public mySeasonData(View itemView) {
            super(itemView);

            displaySeasonName=(TextView)itemView.findViewById(R.id.display_season_names);
            displaySeasonImage=(ImageView)itemView.findViewById(R.id.display_season_image);
            container=itemView.findViewById(R.id.container_root);
            container.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            if(v.getId()==R.id.container_root){
                itemClickCallback.onClick(getAdapterPosition());
            }
        }
    }

}
