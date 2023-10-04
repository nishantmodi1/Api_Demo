package com.example.restapi;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;


public class MainAPIDemo {
	public static void main(String[] args) {
		String apiUrl = "https://reqres.in/api/users?page=2";

		try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
			HttpGet request = new HttpGet(apiUrl);
			CloseableHttpResponse response = httpClient.execute(request);

			try (InputStream inputStream = response.getEntity().getContent();
					Scanner scanner = new Scanner(inputStream)) {



				String jsonResponse = scanner.useDelimiter("\\A").next();
				System.out.println("JSON Response: " + jsonResponse);
				
			
			}

		} catch (IOException e) {
			e.printStackTrace();
		}



	}
}
