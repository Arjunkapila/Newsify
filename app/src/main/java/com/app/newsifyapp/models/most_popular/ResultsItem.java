package com.app.newsifyapp.models.most_popular;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResultsItem implements Parcelable {

	@SerializedName("per_facet")
	private List<String> perFacet;

	@SerializedName("eta_id")
	private int etaId;

	@SerializedName("subsection")
	private String subsection;

	@SerializedName("org_facet")
	private List<String> orgFacet;

	@SerializedName("nytdsection")
	private String nytdsection;

	@SerializedName("column")
	private Object column;

	@SerializedName("section")
	private String section;

	@SerializedName("asset_id")
	private long assetId;

	@SerializedName("source")
	private String source;

	@SerializedName("abstract")
	private String jsonMemberAbstract;

	@SerializedName("media")
	private List<MediaItem> media;

	@SerializedName("type")
	private String type;

	@SerializedName("title")
	private String title;

	@SerializedName("des_facet")
	private List<String> desFacet;

	@SerializedName("uri")
	private String uri;

	@SerializedName("url")
	private String url;

	@SerializedName("adx_keywords")
	private String adxKeywords;

	@SerializedName("geo_facet")
	private List<String> geoFacet;

	@SerializedName("id")
	private long id;

	@SerializedName("published_date")
	private String publishedDate;

	@SerializedName("updated")
	private String updated;

	@SerializedName("byline")
	private String byline;

	protected ResultsItem(Parcel in) {
		perFacet = in.createStringArrayList();
		etaId = in.readInt();
		subsection = in.readString();
		orgFacet = in.createStringArrayList();
		nytdsection = in.readString();
		section = in.readString();
		assetId = in.readLong();
		source = in.readString();
		jsonMemberAbstract = in.readString();
		type = in.readString();
		title = in.readString();
		desFacet = in.createStringArrayList();
		uri = in.readString();
		url = in.readString();
		adxKeywords = in.readString();
		geoFacet = in.createStringArrayList();
		id = in.readLong();
		publishedDate = in.readString();
		updated = in.readString();
		byline = in.readString();
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeStringList(perFacet);
		dest.writeInt(etaId);
		dest.writeString(subsection);
		dest.writeStringList(orgFacet);
		dest.writeString(nytdsection);
		dest.writeString(section);
		dest.writeLong(assetId);
		dest.writeString(source);
		dest.writeString(jsonMemberAbstract);
		dest.writeString(type);
		dest.writeString(title);
		dest.writeStringList(desFacet);
		dest.writeString(uri);
		dest.writeString(url);
		dest.writeString(adxKeywords);
		dest.writeStringList(geoFacet);
		dest.writeLong(id);
		dest.writeString(publishedDate);
		dest.writeString(updated);
		dest.writeString(byline);
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

	public void setPerFacet(List<String> perFacet){
		this.perFacet = perFacet;
	}

	public List<String> getPerFacet(){
		return perFacet;
	}

	public void setEtaId(int etaId){
		this.etaId = etaId;
	}

	public int getEtaId(){
		return etaId;
	}

	public void setSubsection(String subsection){
		this.subsection = subsection;
	}

	public String getSubsection(){
		return subsection;
	}

	public void setOrgFacet(List<String> orgFacet){
		this.orgFacet = orgFacet;
	}

	public List<String> getOrgFacet(){
		return orgFacet;
	}

	public void setNytdsection(String nytdsection){
		this.nytdsection = nytdsection;
	}

	public String getNytdsection(){
		return nytdsection;
	}

	public void setColumn(Object column){
		this.column = column;
	}

	public Object getColumn(){
		return column;
	}

	public void setSection(String section){
		this.section = section;
	}

	public String getSection(){
		return section;
	}

	public void setAssetId(long assetId){
		this.assetId = assetId;
	}

	public long getAssetId(){
		return assetId;
	}

	public void setSource(String source){
		this.source = source;
	}

	public String getSource(){
		return source;
	}

	public void setJsonMemberAbstract(String jsonMemberAbstract){
		this.jsonMemberAbstract = jsonMemberAbstract;
	}

	public String getJsonMemberAbstract(){
		return jsonMemberAbstract;
	}

	public void setMedia(List<MediaItem> media){
		this.media = media;
	}

	public List<MediaItem> getMedia(){
		return media;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
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

	public void setAdxKeywords(String adxKeywords){
		this.adxKeywords = adxKeywords;
	}

	public String getAdxKeywords(){
		return adxKeywords;
	}

	public void setGeoFacet(List<String> geoFacet){
		this.geoFacet = geoFacet;
	}

	public List<String> getGeoFacet(){
		return geoFacet;
	}

	public void setId(long id){
		this.id = id;
	}

	public long getId(){
		return id;
	}

	public void setPublishedDate(String publishedDate){
		this.publishedDate = publishedDate;
	}

	public String getPublishedDate(){
		return publishedDate;
	}

	public void setUpdated(String updated){
		this.updated = updated;
	}

	public String getUpdated(){
		return updated;
	}

	public void setByline(String byline){
		this.byline = byline;
	}

	public String getByline(){
		return byline;
	}
}