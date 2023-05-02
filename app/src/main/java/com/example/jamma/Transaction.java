package com.example.jamma;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import javax.json.JSON;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Transaction {
    private static int id=0;
    private String name;
    private int authorID;
    private Date date;
    private double value;
    private List<Item> itemList=new ArrayList<>();

    public Transaction(String name, int authorID, Date date, double value){
        this.name=name;
        this.authorID=authorID;
        this.date=date;
        this.value=value;
    }

    //turn object into JSON string for saving
    public JSONObject toJSON(){
        JSONObject jo = new JSONObject();
        try {
            jo.put("name", name);
            jo.put("authorID", id);
            jo.put("date",date.toString());
            jo.put("value",value);
            if(!itemList.isEmpty()){
                JSONArray jItemList=new JSONArray();
                for(Item i:itemList){
                    jItemList.put(i.getID());
                }
                jo.put("itemList",jItemList);
            }
        }catch(JSONException e){
        }
        return jo;
    }
}
