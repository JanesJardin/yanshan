package com.wangdakeji.wongder.core.constant;

/**
 * description for this class
 * Created by wangda
 * on 17-12-1
 */
public enum WebSocketState {

    MAX_CONN_NUMBER("5");

    String value;

    WebSocketState(String value) {
        this.value = value;
    }
}
