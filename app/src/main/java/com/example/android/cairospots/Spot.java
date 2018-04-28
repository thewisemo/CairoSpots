package com.example.android.cairospots;

import android.os.Parcel;
import android.os.Parcelable;

public class Spot implements Parcelable {
    private String mSpotName;
    private int mShortDescription;
    private String mImageUrl;
    private int mImageResourceId;
    private String mOpeningHours;
    private int mTicketPrice;
    private String mMapLocation;

    // Constructor for web URL image resource
    public Spot (String spotName, int shortDescription, String imageUrl, String openingHours, int ticketPrice, String mapLocation) {
        mSpotName = spotName;
        mShortDescription = shortDescription;
        mImageUrl = imageUrl;
        mOpeningHours = openingHours;
        mTicketPrice = ticketPrice;
        mMapLocation = mapLocation;
    }

    // Constructor for drawable image resource
    public Spot(String spotName, int shortDescription, int imageResourceId, String openingHours, int ticketPrice, String mapLocation) {
        mSpotName = spotName;
        mShortDescription = shortDescription;
        mImageResourceId = imageResourceId;
        mOpeningHours = openingHours;
        mTicketPrice = ticketPrice;
        mMapLocation = mapLocation;
    }

    public String getSpotName() {
        return mSpotName;
    }

    public int getShortDescription() {
        return mShortDescription;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    /*
     * This method is the constructor, called on the receiving activity, where we will be collecting values.
     * constructor used for parcel.
     */
    public Spot(Parcel parcel) {
        mSpotName = parcel.readString();
        mShortDescription = parcel.readInt();
        mImageUrl = parcel.readString();
        mImageResourceId = parcel.readInt();
        mOpeningHours = parcel.readString();
        mTicketPrice = parcel.readInt();
        mMapLocation = parcel.readString();
    }

    public String getOpeningHours() { return mOpeningHours;}

    public int getTicketPrice() { return mTicketPrice;}

    public String getMapLocation() {return mMapLocation;}

    /*
    * In this method we add all the Spot class properties to the parcel
    * in preparation for transfer.
    * write object values to parcel for storage
    */

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public void writeToParcel(Parcel dest, int flags){
        dest.writeString(mSpotName);
        dest.writeInt(mShortDescription);
        dest.writeString(mImageUrl);
        dest.writeInt(mImageResourceId);
        dest.writeString(mOpeningHours);
        dest.writeInt(mTicketPrice);
        dest.writeString(mMapLocation);
    }

    //creator - used when un-parceling our parcle (creating the object)
    public static final Parcelable.Creator<Spot> CREATOR = new Parcelable.Creator<Spot>(){

        @Override
        public Spot createFromParcel(Parcel parcel) {
            return new Spot(parcel);
        }

        @Override
        public Spot[] newArray(int size) {
            return new Spot[0];
        }
    };

    //return hashcode of object
    public int describeContents() {
        return hashCode();
    }
}
