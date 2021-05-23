package com.app.newsifyapp.models.most_popular;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class MostPopularResponseModel{

	@SerializedName("copyright")
	private String copyright;

	@SerializedName("results")
	private ArrayList<ResultsItem> results;

	@SerializedName("num_results")
	private int numResults;

	@SerializedName("status")
	private String status;

	public void setCopyright(String copyright){
		this.copyright = copyright;
	}

	public String getCopyright(){
		return copyright;
	}

	public void setResults(ArrayList<ResultsItem> results){
		this.results = results;
	}

	public ArrayList<ResultsItem> getResults(){
		return results;
	}

	public void setNumResults(int numResults){
		this.numResults = numResults;
	}

	public int getNumResults(){
		return numResults;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}
}