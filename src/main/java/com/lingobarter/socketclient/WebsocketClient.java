package com.lingobarter.socketclient;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import org.json.JSONObject;

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
