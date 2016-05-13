import com.lingobarter.socketclient.CallbackPool;
import com.lingobarter.socketclient.WebsocketClient;
import io.socket.emitter.Emitter;
import org.json.JSONObject;

import java.net.URISyntaxException;

/**
 * Created by lihe on 5/13/16.
 * @author He Li
 */
// user1 WyI1NzM1N2E5YjY3YjYwYjEwODNiMDk2MzEiLCIxMzVjZTIwM2ZkMTkyY2JiZTUyNzBmMTQ5NmQ3YWY1MSJd.ChcM2g.4tz9i6M9AtqOAqY7H0FDXoVKz7U
// user2 WyI1NzM1N2E5YjY3YjYwYjEwODNiMDk2MzIiLCI2MmFjZGY1OTYxNDE5ZDY3N2Q1NjAyM2FlOTAwYjhhZSJd.ChcMgA.7x4kQijpr_GIYNoGtxBuUGpDSqU
public class TestSocketClient {
    public static void main(String[] args) throws URISyntaxException {
        CallbackPool pool = new CallbackPool() {
            public void onRequestNewParter(JSONObject object) {
                System.out.println(object);
            }

            public void onNewPartnerRequest(JSONObject object) {
                System.out.println(object);
            }

            public void onAddPartner(JSONObject object) {
                System.out.println(object);
            }

            public void onPartnerAdd(JSONObject object) {
                System.out.println(object);
            }

            public void onRejectPartner(JSONObject object) {
                System.out.println(object);
            }

            public void onPartnerReject(JSONObject object) {
                System.out.println(object);
            }

            public void onBrowseRequests(JSONObject object) {
                System.out.println(object);
            }

            public void onBrowsePartners(JSONObject object) {
                System.out.println(object);
            }

            public void onBrowseChats(JSONObject object) {
                System.out.println(object);
            }

            public void onSendMessage(JSONObject object) {
                System.out.println(object);
            }

            public void onMessageSend(JSONObject object) {
                System.out.println(object);
            }

            public void onBrowseMessages(JSONObject object) {
                System.out.println(object);
            }

            public void onFetchUndeliveredMessages(JSONObject object) {
                System.out.println(object);
            }
        };

        final WebsocketClient client = new WebsocketClient("http://192.168.0.4:8080", "WyI1NzM1N2E5YjY3YjYwYjEwODNiMDk2MzEiLCIxMzVjZTIwM2ZkMTkyY2JiZTUyNzBmMTQ5NmQ3YWY1MSJd.ChcM2g.4tz9i6M9AtqOAqY7H0FDXoVKz7U", true, pool);

        JSONObject object = new JSONObject();
        object.put("to_id", "57357a9b67b60b1083b09632");
        client.emit("request new partner", object);

        client.connect();

        System.out.println("hello");
        System.out.println("hello");
        System.out.println("hello");
        System.out.println("hello");
        System.out.println("hello");
        System.out.println("hello");
    }
}
