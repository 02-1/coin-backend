package com.project.coinconnectionserver.controller.otherAPI.coinnewsAPI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CoinNewsApiService {
    String urlString;

    public CoinNewsApiService(String symbol, String offset, String limit) {
        urlString = "https://api.coinness.com/feed/v2/search/articles?keyword=" + symbol + "&offset=" + offset + "&limit=" + limit + "&isHot=false";
    }

    public String getNewsList() {
        String jsonResponse = "Null";
        try {
            // URL 객체 생성
            URL url = new URL(urlString);
            // HttpURLConnection 객체 생성
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // 응답 코드 확인
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // 성공 응답
                // 응답 데이터 읽기
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder content = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }

                // 스트림과 연결 해제
                in.close();
                connection.disconnect();

                // 응답 데이터 출력
                System.out.println(content.toString());

                // JSON 파싱 (수동 파싱)
                jsonResponse = content.toString();


            } else {
                System.out.println("GET 요청 실패: 응답 코드 " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonResponse;
    }
}
