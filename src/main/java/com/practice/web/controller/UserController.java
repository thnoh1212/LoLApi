package com.practice.web.controller;

import com.practice.web.Utils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@RestController
public class UserController {

    Utils utils = new Utils();

    public String signUp(@PathVariable String summonerName){
        BufferedReader br;
        String requestUrl = utils.getNicknameToInfo() + summonerName
                + "?api_key=" + utils.getApiKey();
        System.out.println("requestUrl = " + requestUrl);
        try{
            URL url = new URL(requestUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-Riot-Token", utils.getApiKey());
            int responseCode = con.getResponseCode();
            if(responseCode == 200){
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            }
            else{
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while((inputLine = br.readLine()) != null){
                response.append(inputLine);
            }
            br.close();
            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "Fail";
        }
    }
}
