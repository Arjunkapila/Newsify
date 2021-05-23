package com.app.newsifyapp.network;

import com.app.newsifyapp.models.most_popular.MostPopularResponseModel;
import com.app.newsifyapp.models.top_stories.TopStoriesResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ApiInterface {

    @GET
    Call<TopStoriesResponseModel> getTopStories(@Url String url);

    @GET
    Call<MostPopularResponseModel> getMostPopularStories(@Url String url);

}
