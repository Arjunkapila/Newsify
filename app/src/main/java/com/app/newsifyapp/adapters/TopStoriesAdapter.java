package com.app.newsifyapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.newsifyapp.databinding.ItemTopStoriesBinding;
import com.app.newsifyapp.models.top_stories.ResultsItem;
import com.app.newsifyapp.utils.Constants;
import com.bumptech.glide.Glide;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class TopStoriesAdapter extends RecyclerView.Adapter<TopStoriesAdapter.TopStoriesViewHolder> {

    private Context context;
    private ArrayList<ResultsItem> dataList;
    private TopStoriesAdapterCallback callback;

    public TopStoriesAdapter(Context context, ArrayList<ResultsItem> dataList, TopStoriesAdapterCallback callback){
        this.context = context;
        this.dataList = dataList;
        this.callback = callback;
    }

    @NonNull
    @NotNull
    @Override
    public TopStoriesViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        ItemTopStoriesBinding binding = ItemTopStoriesBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent,false);

        return new TopStoriesViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull TopStoriesViewHolder holder, int position) {
        holder.binding.tvArticleTitle.setText(dataList.get(position).getTitle());
        holder.binding.tvArticleDate.setText(Constants.getCurrentTimeStamp(dataList.get(position).getPublishedDate()));

        Glide.with(context)
                .load(dataList.get(position).getMultimedia().get(0).getUrl())
                .into(holder.binding.ivArticleImage);

        holder.binding.getRoot().setOnClickListener(v -> callback.onClickTopStoryItem(dataList.get(position)));

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    static class TopStoriesViewHolder extends RecyclerView.ViewHolder{

        ItemTopStoriesBinding binding;

        public TopStoriesViewHolder(@NonNull @NotNull ItemTopStoriesBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

    }

    public interface TopStoriesAdapterCallback {
        void onClickTopStoryItem(ResultsItem data);
    }
}
