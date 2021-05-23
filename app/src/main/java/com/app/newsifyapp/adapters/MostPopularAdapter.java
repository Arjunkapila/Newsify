package com.app.newsifyapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.newsifyapp.databinding.ItemTopStoriesBinding;
import com.app.newsifyapp.models.most_popular.ResultsItem;
import com.app.newsifyapp.utils.Constants;
import com.bumptech.glide.Glide;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class MostPopularAdapter extends RecyclerView.Adapter<MostPopularAdapter.MostPopularViewHolder> {

    private Context context;
    private ArrayList<ResultsItem> dataList;
    private MostPopularAdapterCallback callback;

    public MostPopularAdapter(Context context, ArrayList<ResultsItem> dataList, MostPopularAdapterCallback callback){
        this.context = context;
        this.dataList = dataList;
        this.callback = callback;
    }

    @NonNull
    @NotNull
    @Override
    public MostPopularViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        ItemTopStoriesBinding binding = ItemTopStoriesBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent,false);

        return new MostPopularViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MostPopularViewHolder holder, int position) {
        holder.binding.tvArticleTitle.setText(dataList.get(position).getTitle());
        holder.binding.tvArticleDate.setText(Constants.getCurrentTimeStamp3(dataList.get(position).getPublishedDate()));

        Glide.with(context)
                .load(dataList.get(position).getMedia().get(0).getMediaMetadata().get(2).getUrl())
                .into(holder.binding.ivArticleImage);

        holder.binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onClickItem(dataList.get(position));
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    static class MostPopularViewHolder extends RecyclerView.ViewHolder{

        ItemTopStoriesBinding binding;

        public MostPopularViewHolder(@NonNull @NotNull ItemTopStoriesBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

    }

    public interface MostPopularAdapterCallback {
        void onClickItem(ResultsItem data);
    }

}
