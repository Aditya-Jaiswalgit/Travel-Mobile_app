package com.easytrip.android.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class ItemModel implements Parcelable {
    private static final long serialVersionUID = 1L;
    private String title;
    private String address;
    private String description;
    private String duration;
    private String timeTour;
    private String dateTour;
    private int price;
    private int bed;
    private String distance;
    private double score;
    private ArrayList<String> pic;


    private int imageResId;
    private boolean isLiked;

    public ItemModel(int imageResId, boolean isLiked) {
        this.imageResId = imageResId;
        this.isLiked = isLiked;
    }

    public int getImageResId() {
        return imageResId;
    }

    public boolean isLiked() {
        return isLiked;
    }

    public void setLiked(boolean liked) {
        isLiked = liked;
    }


    public ItemModel(){}

    protected ItemModel(Parcel in) {
        title = in.readString();
        address = in.readString();
        description = in.readString();
        duration = in.readString();
        timeTour = in.readString();
        dateTour = in.readString();
        price = in.readInt();
        bed = in.readInt();
        distance = in.readString();
        score = in.readDouble();
        pic = in.createStringArrayList();
    }


    public static final Creator<ItemModel> CREATOR = new Creator<ItemModel>() {
        @Override
        public ItemModel createFromParcel(Parcel in) {
            return new ItemModel(in);
        }

        @Override
        public ItemModel[] newArray(int size) {
            return new ItemModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(address);
        dest.writeString(description);
        dest.writeString(duration);
        dest.writeString(timeTour);
        dest.writeString(dateTour);
        dest.writeInt(price);
        dest.writeInt(bed);
        dest.writeString(distance);
        dest.writeDouble(score);
        dest.writeStringList(pic);
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getTimeTour() {
        return timeTour;
    }

    public void setTimeTour(String timeTour) {
        this.timeTour = timeTour;
    }

    public String getDateTour() {
        return dateTour;
    }

    public void setDateTour(String dateTour) {
        this.dateTour = dateTour;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getBed() {
        return bed;
    }

    public void setBed(int bed) {
        this.bed = bed;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public ArrayList<String> getPic() {
        return pic;
    }

    public void setPic(ArrayList<String> pic) {
        this.pic = pic;
    }

}
