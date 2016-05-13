package com.lingobarter.socketclient;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import org.json.JSONObject;

import java.io.*;
import java.net.URISyntaxException;

/**
 * Created by lihe on 5/13/16.
 * @author He Li
 */
public class WebsocketClient {
    private Socket socket;

    public WebsocketClient(String url, String authToken, boolean reconnection) throws URISyntaxException {
        IO.Options opts = new IO.Options();
        opts.reconnection = reconnection;
        opts.query = "auth_token=" + authToken;
        this.socket = IO.socket(url, opts);
    }

    public void requestNewParter(String to_id) {
        JSONObject object = new JSONObject();
        object.put("to_id", to_id);
        this.emit("request new partner", object);
    }

    public void addPartner(String from_id) {
        JSONObject object = new JSONObject();
        object.put("from_id", from_id);
        this.emit("add partner", object);
    }

    public void rejectPartner(String from_id) {
        JSONObject object = new JSONObject();
        object.put("from_id", from_id);
        this.emit("reject partner", object);
    }

    public void browseRequests() {
        this.emit("browse requests");
    }

    public void browsePartners() {
        this.emit("browse partners");
    }

    public void browseChats() {
        this.emit("browse chats");
    }

    public void sendTextMessage(String payload, String to_chat) {
        JSONObject object = new JSONObject();
        object.put("payload", payload);
        object.put("to_chat", to_chat);
        object.put("type", "text");
        this.emit("send message", object);
    }

    public void sendVoiceMessage(String file_path, String to_chat) throws IOException {
        JSONObject object = new JSONObject();
        object.put("to_chat", to_chat);
        object.put("type", "voice");

        FileInputStream fileInputStream = new FileInputStream(file_path);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        byte[] data = new byte[4096];
        int count = fileInputStream.read(data);
        while (count != -1) {
            dataOutputStream.write(data, 0, count);
            count = fileInputStream.read(data);
        }
        byte[] payload = byteArrayOutputStream.toByteArray();
        object.put("payload", payload);

        this.emit("send message", object);
    }

    public void sendImageMessage(String file_path, String to_chat) throws IOException {
        JSONObject object = new JSONObject();
        object.put("to_chat", to_chat);
        object.put("type", "image");

        FileInputStream fileInputStream = new FileInputStream(file_path);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        byte[] data = new byte[4096];
        int count = fileInputStream.read(data);
        while (count != -1) {
            dataOutputStream.write(data, 0, count);
            count = fileInputStream.read(data);
        }
        byte[] payload = byteArrayOutputStream.toByteArray();
        object.put("payload", payload);

        this.emit("send message", object);
    }

    public void browseMessages(String page_size, String page_id, String to_chat) {
        JSONObject object = new JSONObject();
        object.put("page_size", page_size);
        object.put("page_id", page_id);
        object.put("to_chat", to_chat);
        this.emit("browse messages", object);
    }

    public void fetchUndeliveredMessages() {
        this.emit("browse chats");
    }

    public void connect() {
        this.socket.connect();
    }

    public void emit(String eventName, Object... objects) {
        this.socket.emit(eventName, objects);
    }

    public void on(String eventName, Emitter.Listener listener) {
        this.socket.on(eventName, listener);
    }
}
