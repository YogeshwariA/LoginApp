package com.fulllearn.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fulllearn.helper.Constants;
import com.fulllearn.model.AWResponse;
import com.fulllearn.model.User;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@SuppressWarnings("serial")
public class Login extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if ((req.getRequestURI().contains("/oauth/callback"))) {
			try {
				signInwithAnywhereWorks(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@SuppressWarnings("unchecked")
	private void signInwithAnywhereWorks(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		String code = req.getParameter("code");
		String urlParameters = "code=" + code + "&client_id=" + Constants.client_id + "&scope=awapis.identity"
				+ "&client_secret=" + Constants.client_secret + "&access_type=offline" + "&redirect_uri="
				+ Constants.redirectUrl + "&grant_type=authorization_code";
		URL url = new URL(Constants.gettingAccessTokenUrl);

		HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
		urlConn.setDoOutput(true);
		OutputStreamWriter writer = new OutputStreamWriter(urlConn.getOutputStream());
		writer.write(urlParameters);
		writer.flush();

		BufferedReader in = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
		String decodedString;
		StringBuilder result = new StringBuilder();

		while ((decodedString = in.readLine()) != null) {
			result.append(decodedString);
		}
		in.close();
		
		JsonObject json = (JsonObject) new JsonParser().parse(result.toString());
		String access_token = json.get("access_token").getAsString();
		url = new URL(Constants.urlForApi);
		urlConn = (HttpURLConnection) url.openConnection();
		urlConn.setRequestProperty("Content-Type", "application/json");
		urlConn.setRequestProperty("Authorization", "Bearer " + access_token);
		urlConn.setRequestMethod("GET");
		urlConn.setDoOutput(true);
		Scanner scanner = new Scanner(new InputStreamReader(urlConn.getInputStream()));
		String outputJson = "";
		while (scanner.hasNext()) {
			outputJson += scanner.nextLine();
		}
		System.out.println(outputJson);
		scanner.close();
		AWResponse awResp = new Gson().fromJson(outputJson, AWResponse.class);
		Map<String, Object> data = awResp.getData();

		Map<String, Object> userMap = (Map<String, Object>) data.get("user");

		String userJson = new Gson().toJson(userMap);
		User user = new Gson().fromJson(userJson, User.class);
		HttpSession session = req.getSession();
		session.setAttribute("user", user);
		req.getRequestDispatcher("/dashboard").forward(req, resp);

	}

}
