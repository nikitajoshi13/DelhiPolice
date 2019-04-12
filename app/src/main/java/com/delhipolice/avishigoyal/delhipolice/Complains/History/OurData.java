package com.delhipolice.avishigoyal.delhipolice.Complains.History;

public class OurData {
    public String complainID;
    public String location;
    public String latitude,longitude;
    public String status;
    public String date;
    public String LocationId;
    public String Vendor;
    public String trafficId;

    public void setDate(String date)
    {
        this.date=date;
    }

    public String getDate(){ return date;}

    public String getComplainID() {
        return complainID;
    }

    public void setComplainID(String complainID) {
        this.complainID = complainID;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocationId() {
        return LocationId;
    }

    public void setLocationId(String locationId) {
        LocationId = locationId;
    }

    public String getVendor() {
        return Vendor;
    }

    public void setVendor(String vendor) {
        Vendor = vendor;
    }

    public String getTrafficId() {
        return trafficId;
    }

    public void setTrafficId(String trafficId) {
        this.trafficId = trafficId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    };
}
