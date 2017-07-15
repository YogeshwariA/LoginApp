package com.fulllearn.helper;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.Scanner;

public class Constants {
public static final String client_id="29354-ad35e115205caf42fd0c391bf226ea70";
public static final String client_secret="xUff61qr__N0ay9sMSrdrcea16ChFYM1EDIf9md7";
public static final String redirectUrl = "http://localhost:8888/oauth/callback";
public static final String gettingAccessTokenUrl="https://fullcreative-dot-full-auth.appspot.com/o/oauth2/v1/token";
public static final String urlForApi="https://api-dot-live-fullspectrum.appspot.com/api/v1/user/me";

public static void getConstantDetails(HttpURLConnection urlConn){
	
	/*//urlConn = (HttpURLConnection) url.openConnection();
	
	Scanner scanner = new Scanner(new InputStreamReader(urlConn.getInputStream()));
	String outputJson = "";
	while (scanner.hasNext()) {
		outputJson += scanner.nextLine();
	}
	System.out.println(outputJson);
	scanner.close();
}*/
}
}
