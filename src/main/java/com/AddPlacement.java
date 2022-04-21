package com;

import org.json.JSONObject;

import java.sql.SQLException;
import java.util.ArrayList;

public class AddPlacement {

    public ArrayList<String> requestLogs;
    JSONObject jsonObject;


    public AddPlacement(JSONObject jsonObject) throws SQLException {

        this.jsonObject=jsonObject;

        this.requestLogs= getAddPlacement();

    }

    public ArrayList<String> getAddPlacement(){

        CheckNewAd checkNewAd = new CheckNewAd(jsonObject);

        return checkNewAd.getRequestLogs();


    }





}
