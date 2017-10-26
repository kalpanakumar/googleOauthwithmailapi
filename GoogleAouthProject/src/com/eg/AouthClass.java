package com.eg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

public class AouthClass extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
	String code = req.getParameter("code");
	String URLParams = "code="+code+
			"&client_id=440087998284-7m668tavo8bul3q7ki208vhtr5p27sr8.apps.googleusercontent.com"+
			"&client_secret=cfYWzvcJRcECVlD2W-Fmo7Ak"+
			"&redirect_uri=http://localhost:8888/googleRedirect"+
			"&grant_type=authorization_code";
	System.out.println(URLParams);
	
	String url1		=	"https://accounts.google.com/o/oauth2/token?";
	
	URL url = new URL(url1);
	URLConnection urlConn = url.openConnection();
	urlConn.setDoOutput(true);
    OutputStreamWriter writer = new OutputStreamWriter(
             urlConn.getOutputStream());
     writer.write(URLParams);
     writer.flush();
     
     String line, outputString = "";
     BufferedReader reader = new BufferedReader(new InputStreamReader(
             urlConn.getInputStream()));
     while ((line = reader.readLine()) != null) {
         outputString += line;
     }
     try {
		String accesstoken = getParamfromJSON(outputString,"access_token");
		
		String url2		=	"https://www.googleapis.com/oauth2/v1/userinfo?access_token=";
		url = new URL(url2+ accesstoken);
		urlConn = url.openConnection();
        outputString = "";
        
        reader = new BufferedReader(new InputStreamReader(
                urlConn.getInputStream()));
        while ((line = reader.readLine()) != null) {
            outputString += line;
        }
        
        String username = getParamfromJSON(outputString,"name");
        String loginId 	= getParamfromJSON(outputString,"email");

        System.out.println("Username = "+username + "  loginId"+ loginId);


		
		
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	String getParamfromJSON(String input, String param) throws JSONException{
		JSONObject JSON = new JSONObject(input);
		return JSON.getString(param);
	}
	
}
