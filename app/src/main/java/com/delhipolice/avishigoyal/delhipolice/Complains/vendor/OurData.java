package com.delhipolice.avishigoyal.delhipolice.Complains.vendor;

import com.delhipolice.avishigoyal.delhipolice.Police.VendorData;

public class OurData {
    private String complaints,location,traffic,comments,vendor,ph;
    public String latitude,longitude;
    public String status,stat;

//   public OurData(String complaints,String location,String traffic, String comments, String vendor){
//       this.complaints=complaints;
//       this.location=location;
//       this.traffic=traffic;
//       this.comments=comments;
//       this.vendor=vendor;
//


    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }

    public String getComplaints() {
        return complaints;
    }

    public void setComplaints(String complaints) {
        this.complaints = complaints;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTraffic() {
        return traffic;
    }

    public void setTraffic(String traffic) {
        this.traffic = traffic;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
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

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }
}
