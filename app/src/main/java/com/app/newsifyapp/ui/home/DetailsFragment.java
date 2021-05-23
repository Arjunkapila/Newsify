package com.app.newsifyapp.ui.home;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.app.newsifyapp.databinding.FragmentDetailsBinding;
import com.app.newsifyapp.models.top_stories.ResultsItem;
import com.app.newsifyapp.utils.Constants;
import com.bumptech.glide.Glide;

import org.jetbrains.annotations.NotNull;

public class DetailsFragment extends Fragment {

    private final String TAG = "DetailsFragment";
    private FragmentDetailsBinding binding;
    private String from = null;
    private ResultsItem data = null;
    private com.app.newsifyapp.models.most_popular.ResultsItem data2 = null;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        binding = FragmentDetailsBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            from = getArguments().getString("from");

            if (from != null) {

                if (from.equals("TopStoriesFragment")) {

                    data = getArguments().getParcelable(Constants.BUNDLE_TOP_DATA);

                    binding.tvDetailsTitle.setText(data.getTitle());
                    binding.tvDetailsDesc.setText(data.getJsonMemberAbstract());

                    if (data.getMultimedia() != null) {
                        Glide.with(requireContext())
                                .load(data.getMultimedia().get(0).getUrl())
                                .into(binding.viewPager);
                    }

                    binding.tvCreatedAt.setText("Created At: ${Constants.getCurrentTimeStamp(data?.created_date!!)}");
                    binding.tvUpdatedAt.setText("Updated At: ${Constants.getCurrentTimeStamp(data?.updated_date!!)}");
                    binding.tvPublishedAt.setText("Published At: ${Constants.getCurrentTimeStamp(data?.published_date!!)}");

                } else {

                    data2 = getArguments().getParcelable(Constants.BUNDLE_MOST_DATA);

                    binding.tvDetailsTitle.setText(data2.getTitle());
                    binding.tvDetailsDesc.setText(data2.getJsonMemberAbstract());

                    if (data2.getMedia() != null) {
                        Glide.with(requireContext())
                                .load(data2.getMedia().get(0).getMediaMetadata().get(2).getUrl())
                                .into(binding.viewPager);
                    }

                    binding.tvCreatedAt.setVisibility(View.GONE);
                    binding.tvUpdatedAt.setText("Updated At: " + (Constants.getCurrentTimeStamp3(data2.getUpdated())));
                    binding.tvPublishedAt.setText("Published At:" + Constants.getCurrentTimeStamp3(data2.getPublishedDate()));

                }

                binding.imageView2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (from.equals("TopStoriesFragment")) {
                            Intent browserIntent =
                                    new Intent(Intent.ACTION_VIEW, Uri.parse(data.getUrl()));
                            startActivity(browserIntent);
                        } else {
                            Intent browserIntent =
                                    new Intent(Intent.ACTION_VIEW, Uri.parse(data2.getUrl()));
                            startActivity(browserIntent);
                        }
                    }
                });
            }
        }

    }

}

