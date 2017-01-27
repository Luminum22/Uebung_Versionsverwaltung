package com.example.mediamarkt.uebung_versionsverwaltung.Anna;

/**
 * Created by Mediamarkt on 27.01.2017.
 */

public class TblGpsData {
    public static final String TABLE_NAME="GpsData";

    public final static String GpsDataId="GpsDataId";
    public final static String Longitude="Longitude";
    public final static String Latitude="Latitude";
    public final static String Date="Date";

    public static final String SQL_DROP="DROP TABLE IF EXISTS "+TABLE_NAME;
    public static final String SQL_CREATE=
            "CREATE TABLE "+TABLE_NAME+
            "("+
                    GpsDataId + " INTEGER PRIMARY KEY, "+
                    Longitude + " DOUBLE NOT NULL, "+
                    Latitude  + " DOUBLE NOT NULL, "+
                    Date      + " VARCHAR2 NOT NULL"+
            ")";
    public static final String STMT_INSERT="INSERT INTO "+TABLE_NAME+" VALUES (?,?,?, ?)";



}
