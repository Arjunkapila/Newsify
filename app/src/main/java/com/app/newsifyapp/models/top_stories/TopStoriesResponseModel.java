package com.app.newsifyapp.models.top_stories;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class TopStoriesResponseModel{

	@SerializedName("copyright")
	private String copyright;

	@SerializedName("last_updated")
	private String lastUpdated;

	@SerializedName("section")
	private String section;

	@SerializedName("results")
	private List<ResultsItem> results;

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

	public void setLastUpdated(String lastUpdated){
		this.lastUpdated = lastUpdated;
	}

	public String getLastUpdated(){
		return lastUpdated;
	}

	public void setSection(String section){
		this.section = section;
	}

	public String getSection(){
		return section;
	}

	public void setResults(List<ResultsItem> results){
		this.results = results;
	}

	public List<ResultsItem> getResults(){
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