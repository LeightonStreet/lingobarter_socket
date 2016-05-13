package com.lingobarter.socketclient;

import org.json.JSONObject;

/**
 * Created by lihe on 5/13/16.
 * @author He Li, Xin Yang
 */
public interface CallbackPool {
    void onRequestNewParter(JSONObject object);

    void onNewPartnerRequest(JSONObject object);
}
