package org.apio3;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

public class http {
	public static String Get(String URL) {
		URLConnection connection = null;
		try {
			connection = new URL(URL).openConnection();
			connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/126.0.0.0 Safari/537.36");

			try (BufferedReader reader = new BufferedReader(
					new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
				StringBuilder sb = new StringBuilder();
				char[] buffer = new char[8192];
				int charsRead;
				while ((charsRead = reader.read(buffer)) != -1) {
					sb.append(buffer, 0, charsRead);
				}
				return sb.toString();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
