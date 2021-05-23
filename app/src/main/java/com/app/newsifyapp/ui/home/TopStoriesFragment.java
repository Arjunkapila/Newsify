package com.app.newsifyapp.ui.home;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.app.newsifyapp.R;
import com.app.newsifyapp.adapters.MostPopularAdapter;
import com.app.newsifyapp.adapters.TopStoriesAdapter;
import com.app.newsifyapp.databinding.FragmentTopStoriesBinding;
import com.app.newsifyapp.models.most_popular.MostPopularResponseModel;
import com.app.newsifyapp.models.top_stories.ResultsItem;
import com.app.newsifyapp.models.top_stories.TopStoriesResponseModel;
import com.app.newsifyapp.network.RetrofitClient;
import com.app.newsifyapp.utils.ApiUrl;
import com.app.newsifyapp.utils.Constants;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

        
public class TopStoriesFragment extends Fragment {

    private FragmentTopStoriesBinding binding = null;
    private final String TAG = "TopStoriesFragment";

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        if(binding==null){
            binding = FragmentTopStoriesBinding.inflate(inflater,container,false);
            initViews();
        }

        return binding.getRoot();
    }
    

    private void initViews(){

        if(Constants.isInternetConnected(getContext())){
            binding.ivInternetOff.setVisibility(View.GONE);
            binding.btnRefresh.setVisibility(View.GONE);
            getTopStories();
        }
        else{
            binding.ivInternetOff.setVisibility(View.VISIBLE);
            binding.btnRefresh.setVisibility(View.VISIBLE);
            Toast.makeText(getContext(), "Unable to connect to the internet", Toast.LENGTH_SHORT).show();
        }

        binding.btnRefresh.setOnClickListener(v -> {
            if(Constants.isInternetConnected(getContext())){
                binding.ivInternetOff.setVisibility(View.GONE);
                binding.btnRefresh.setVisibility(View.GONE);
                getTopStories();
            }
            else{
                binding.ivInternetOff.setVisibility(View.VISIBLE);
                binding.btnRefresh.setVisibility(View.VISIBLE);
                Toast.makeText(getContext(), "Unable to connect to the internet", Toast.LENGTH_SHORT).show();
            }
        });

    }


    private void getTopStories(){
        RetrofitClient.getAPIService().getTopStories(ApiUrl.storiesUrl).enqueue(new Callback<TopStoriesResponseModel>() {
            @Override
            public void onResponse(Call<TopStoriesResponseModel> call, Response<TopStoriesResponseModel> response) {
                if(isAdded()){
                    if(response.code() == 200){
                        if(response.body().getStatus().equals("OK")){
                            if(response.body()!=null){
                                if(response.body().getResults()!=null){

                                    binding.rvTopStories.setAdapter(new TopStoriesAdapter(requireContext(),
                                            (ArrayList<com.app.newsifyapp.models.top_stories.ResultsItem>) response.body().getResults(),new TopStoriesAdapter.TopStoriesAdapterCallback(){
                                        @Override
                                        public void onClickTopStoryItem(ResultsItem data) {
                                            Bundle bundle = new Bundle();
                                            bundle.putParcelable(Constants.BUNDLE_TOP_DATA,data);
                                            bundle.putString("from",TAG);
                                            DetailsFragment frag = new DetailsFragment();
                                            frag.setArguments(bundle);

                                            getActivity().getSupportFragmentManager().beginTransaction()
                                                    .replace(R.id.fragmentContainer2,frag)
                                                    .addToBackStack(null)
                                                    .commit();
                                        }
                                    }));

                                }
                            }
                        }
                        else{
                            Toast.makeText(getContext(), "Unable to connect to the server", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(getContext(), "Unable to connect to the server", Toast.LENGTH_SHORT).show();
                    }
                }

            }

            @Override
            public void onFailure(Call<TopStoriesResponseModel> call, Throwable t) {
                if(isAdded()){
                    Toast.makeText(getContext(), "Unable to connect to the server", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
