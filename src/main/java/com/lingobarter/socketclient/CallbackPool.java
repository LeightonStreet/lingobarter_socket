package com.lingobarter.socketclient;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by lihe on 5/13/16.
 * @author He Li, Xin Yang
 */
public interface CallbackPool {
    void onRequestNewParter(JSONObject object);

    void onNewPartnerRequest(JSONObject object);

    void onAddPartner(JSONObject object);

    void onPartnerAdd(JSONObject object);

    void onRejectPartner(JSONObject object);

    void onPartnerReject(JSONObject object);

    void onBrowseRequests(JSONObject object);

    void onBrowsePartners(JSONObject object);

    void onBrowseChats(JSONObject object);

    void onSendMessage(JSONObject object);

    void onMessageSend(JSONObject object);

    void onBrowseMessages(JSONObject object);

    void onFetchUndeliveredMessages(JSONObject object);
}

