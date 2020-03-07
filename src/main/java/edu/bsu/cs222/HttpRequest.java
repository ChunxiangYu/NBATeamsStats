package edu.bsu.cs222;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import okhttp3.*;
import java.io.*;

public class HttpRequest {
    private static double data;
    public double getData() {
        return data;
    }

    public void setData(double data) {
        this.data = data;
    }

    public double getTeamsData(int teamNumber,String dataName){
        HttpRequest httpRequest =new HttpRequest();
        String url = "http://data.chingsoft.com/api/v1/sports/team_range_all?year=2019&type=1";
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        try (Response response = okHttpClient.newCall(request).execute()) {
            JSONObject jsonObject =JSON.parseObject(response.body().string(),JSONObject.class);
            JSONArray jsonArray =jsonObject.getJSONArray("data");
            JSONObject jsonObject1 =jsonArray.getJSONObject(teamNumber);
            httpRequest.setData(Double.parseDouble(jsonObject1.get(dataName).toString()));
            data = httpRequest.getData();
            return data;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}





