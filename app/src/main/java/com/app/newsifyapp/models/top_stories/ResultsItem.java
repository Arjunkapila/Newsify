package com.app.newsifyapp.models.top_stories;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResultsItem implements Parcelable {

	@SerializedName("per_facet")
	private List<Object> perFacet;

	@SerializedName("subsection")
	private String subsection;

	@SerializedName("item_type")
	private String itemType;

	@SerializedName("org_facet")
	private List<String> orgFacet;

	@SerializedName("section")
	private String section;

	@SerializedName("abstract")
	private String jsonMemberAbstract;

	@SerializedName("title")
	private String title;

	@SerializedName("des_facet")
	private List<String> desFacet;

	@SerializedName("uri")
	private String uri;

	@SerializedName("url")
	private String url;

	@SerializedName("short_url")
	private String shortUrl;

	@SerializedName("material_type_facet")
	private String materialTypeFacet;

	@SerializedName("multimedia")
	private List<MultimediaItem> multimedia;

	@SerializedName("geo_facet")
	private List<String> geoFacet;

	@SerializedName("updated_date")
	private String updatedDate;

	@SerializedName("created_date")
	private String createdDate;

	@SerializedName("byline")
	private String byline;

	@SerializedName("published_date")
	private String publishedDate;

	@SerializedName("kicker")
	private String kicker;

	protected ResultsItem(Parcel in) {
		subsection = in.readString();
		itemType = in.readString();
		orgFacet = in.createStringArrayList();
		section = in.readString();
		jsonMemberAbstract = in.readString();
		title = in.readString();
		desFacet = in.createStringArrayList();
		uri = in.readString();
		url = in.readString();
		shortUrl = in.readString();
		materialTypeFacet = in.readString();
		multimedia = in.createTypedArrayList(MultimediaItem.CREATOR);
		geoFacet = in.createStringArrayList();
		updatedDate = in.readString();
		createdDate = in.readString();
		byline = in.readString();
		publishedDate = in.readString();
		kicker = in.readString();
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(subsection);
		dest.writeString(itemType);
		dest.writeStringList(orgFacet);
		dest.writeString(section);
		dest.writeString(jsonMemberAbstract);
		dest.writeString(title);
		dest.writeStringList(desFacet);
		dest.writeString(uri);
		dest.writeString(url);
		dest.writeString(shortUrl);
		dest.writeString(materialTypeFacet);
		dest.writeTypedList(multimedia);
		dest.writeStringList(geoFacet);
		dest.writeString(updatedDate);
		dest.writeString(createdDate);
		dest.writeString(byline);
		dest.writeString(publishedDate);
		dest.writeString(kicker);
	}

	@Override
	public int describeContents() {
		return 0;
	}

	public static final Creator<ResultsItem> CREATOR = new Creator<ResultsItem>() {
		@Override
		public ResultsItem createFromParcel(Parcel in) {
			return new ResultsItem(in);
		}

		@Override
		public ResultsItem[] newArray(int size) {
			return new ResultsItem[size];
		}
	};

	public void setPerFacet(List<Object> perFacet){
		this.perFacet = perFacet;
	}

	public List<Object> getPerFacet(){
		return perFacet;
	}

	public void setSubsection(String subsection){
		this.subsection = subsection;
	}

	public String getSubsection(){
		return subsection;
	}

	public void setItemType(String itemType){
		this.itemType = itemType;
	}

	public String getItemType(){
		return itemType;
	}

	public void setOrgFacet(List<String> orgFacet){
		this.orgFacet = orgFacet;
	}

	public List<String> getOrgFacet(){
		return orgFacet;
	}

	public void setSection(String section){
		this.section = section;
	}

	public String getSection(){
		return section;
	}

	public void setJsonMemberAbstract(String jsonMemberAbstract){
		this.jsonMemberAbstract = jsonMemberAbstract;
	}

	public String getJsonMemberAbstract(){
		return jsonMemberAbstract;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setDesFacet(List<String> desFacet){
		this.desFacet = desFacet;
	}

	public List<String> getDesFacet(){
		return desFacet;
	}

	public void setUri(String uri){
		this.uri = uri;
	}

	public String getUri(){
		return uri;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setShortUrl(String shortUrl){
		this.shortUrl = shortUrl;
	}

	public String getShortUrl(){
		return shortUrl;
	}

	public void setMaterialTypeFacet(String materialTypeFacet){
		this.materialTypeFacet = materialTypeFacet;
	}

	public String getMaterialTypeFacet(){
		return materialTypeFacet;
	}

	public void setMultimedia(List<MultimediaItem> multimedia){
		this.multimedia = multimedia;
	}

	public List<MultimediaItem> getMultimedia(){
		return multimedia;
	}

	public void setGeoFacet(List<String> geoFacet){
		this.geoFacet = geoFacet;
	}

	public List<String> getGeoFacet(){
		return geoFacet;
	}

	public void setUpdatedDate(String updatedDate){
		this.updatedDate = updatedDate;
	}

	public String getUpdatedDate(){
		return updatedDate;
	}

	public void setCreatedDate(String createdDate){
		this.createdDate = createdDate;
	}

	public String getCreatedDate(){
		return createdDate;
	}

	public void setByline(String byline){
		this.byline = byline;
	}

	public String getByline(){
		return byline;
	}

	public void setPublishedDate(String publishedDate){
		this.publishedDate = publishedDate;
	}

	public String getPublishedDate(){
		return publishedDate;
	}

	public void setKicker(String kicker){
		this.kicker = kicker;
	}

	public String getKicker(){
		return kicker;
	}
}