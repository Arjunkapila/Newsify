package com.app.newsifyapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.app.newsifyapp.R;
import com.app.newsifyapp.adapters.MostPopularAdapter;
import com.app.newsifyapp.databinding.FragmentMostPopularBinding;
import com.app.newsifyapp.models.most_popular.MostPopularResponseModel;
import com.app.newsifyapp.models.most_popular.ResultsItem;
import com.app.newsifyapp.network.RetrofitClient;
import com.app.newsifyapp.utils.ApiUrl;
import com.app.newsifyapp.utils.Constants;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MostPopularFragment extends Fragment {

    private FragmentMostPopularBinding binding = null;
    private final String TAG = "MostPopularFragment";

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        if(binding==null){
            binding = FragmentMostPopularBinding.inflate(inflater,container,false);
            initViews();
        }
        
        return binding.getRoot();
    }
    

    private void initViews(){
        
        if(Constants.isInternetConnected(getContext())){
            binding.ivInternetOff.setVisibility(View.GONE);
            binding.btnRefresh.setVisibility(View.GONE);
            getMostPopular();
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
                getMostPopular();
            }
            else{
                binding.ivInternetOff.setVisibility(View.VISIBLE);
                binding.btnRefresh.setVisibility(View.VISIBLE);
                Toast.makeText(getContext(), "Unable to connect to the internet", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void getMostPopular(){

        RetrofitClient.getAPIService().getMostPopularStories(ApiUrl.mostPopularUrl).enqueue(new Callback<MostPopularResponseModel>() {
            @Override
            public void onResponse(Call<MostPopularResponseModel> call, Response<MostPopularResponseModel> response) {
                if(isAdded()){
                    if(response.code() == 200){
                        if(response.body().getStatus().equals("OK")){
                            if(response.body()!=null){
                                if(response.body().getResults()!=null){

                                    binding.rvMostPopular.setAdapter(new MostPopularAdapter(requireContext(),
                                            response.body().getResults(),new MostPopularAdapter.MostPopularAdapterCallback(){
                                        @Override
                                        public void onClickItem(ResultsItem data) {
                                            Bundle bundle = new Bundle();
                                            bundle.putParcelable(Constants.BUNDLE_MOST_DATA,data);
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
            public void onFailure(Call<MostPopularResponseModel> call, Throwable t) {
                if(isAdded()){
                    Toast.makeText(getContext(), "Unable to connect to the server", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
