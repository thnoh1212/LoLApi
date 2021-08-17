package com.practice.web.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.web.Utils;
import com.practice.web.dto.User;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


@Service
public class UserServiceImpl implements UserService{


    @Override
    public String addData(String nickName) {
        BufferedReader br;
        ObjectMapper mapper = new ObjectMapper();
        JSONObject responseJson;
        User user;
        String requestUrl = Utils.nicknameToInfo + nickName + "?api_key=" + Utils.apiKey;
        System.out.println("requestUrl = " + requestUrl);
        try{
            URL url = new URL(requestUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            if(responseCode == 200){
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            }
            else{
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuilder response = new StringBuilder();
            while((inputLine = br.readLine()) != null){
                response.append(inputLine);
            }
            br.close();
            responseJson = new JSONObject(response.toString());
            user = mapper.readValue(responseJson.toString(), User.class);
            System.out.println("user = " + user);

            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }

    }
}
