package com.app.newsifyapp.models.top_stories;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class MultimediaItem implements Parcelable {

	@SerializedName("copyright")
	private String copyright;

	@SerializedName("subtype")
	private String subtype;

	@SerializedName("format")
	private String format;

	@SerializedName("width")
	private int width;

	@SerializedName("caption")
	private String caption;

	@SerializedName("type")
	private String type;

	@SerializedName("url")
	private String url;

	@SerializedName("height")
	private int height;

	protected MultimediaItem(Parcel in) {
		copyright = in.readString();
		subtype = in.readString();
		format = in.readString();
		width = in.readInt();
		caption = in.readString();
		type = in.readString();
		url = in.readString();
		height = in.readInt();
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(copyright);
		dest.writeString(subtype);
		dest.writeString(format);
		dest.writeInt(width);
		dest.writeString(caption);
		dest.writeString(type);
		dest.writeString(url);
		dest.writeInt(height);
	}

	@Override
	public int describeContents() {
		return 0;
	}

	public static final Creator<MultimediaItem> CREATOR = new Creator<MultimediaItem>() {
		@Override
		public MultimediaItem createFromParcel(Parcel in) {
			return new MultimediaItem(in);
		}

		@Override
		public MultimediaItem[] newArray(int size) {
			return new MultimediaItem[size];
		}
	};

	public void setCopyright(String copyright){
		this.copyright = copyright;
	}

	public String getCopyright(){
		return copyright;
	}

	public void setSubtype(String subtype){
		this.subtype = subtype;
	}

	public String getSubtype(){
		return subtype;
	}

	public void setFormat(String format){
		this.format = format;
	}

	public String getFormat(){
		return format;
	}

	public void setWidth(int width){
		this.width = width;
	}

	public int getWidth(){
		return width;
	}

	public void setCaption(String caption){
		this.caption = caption;
	}

	public String getCaption(){
		return caption;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setHeight(int height){
		this.height = height;
	}

	public int getHeight(){
		return height;
	}
}