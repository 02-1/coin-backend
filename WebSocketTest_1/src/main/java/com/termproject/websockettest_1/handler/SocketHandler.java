package com.termproject.websockettest_1.handler;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class SocketHandler extends TextWebSocketHandler {

    // 모든 활성 WebSocket 세션을 저장하기 위한 컨테이너
    private final Set<WebSocketSession> sessions = Collections.newSetFromMap(new ConcurrentHashMap<>());

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("WebSocket Connection Established");
        sessions.add(session); // 세션을 컬렉션에 추가
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        if (message instanceof TextMessage) {
            String payload = ((TextMessage) message).getPayload();
            System.out.println("Received message: " + payload);

            // 모든 세션에 메시지를 에코
            for (WebSocketSession s : sessions) {
                if (s.isOpen()) {
                    s.sendMessage(new TextMessage("Echo: " + payload));
                }
            }
        }
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        System.out.println("WebSocket Transport Error");
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        System.out.println("WebSocket Connection Closed");
        sessions.remove(session); // 세션을 컬렉션에서 제거
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
