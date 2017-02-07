package com.example.mediamarkt.uebung_versionsverwaltung.Anna;

import java.io.Serializable;

/**
 * Created by Mediamarkt on 07.02.2017.
 */

public class GpsData implements Serializable {
    public double longitude;
    public double latitude;
    public String date;

    public GpsData() {
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
