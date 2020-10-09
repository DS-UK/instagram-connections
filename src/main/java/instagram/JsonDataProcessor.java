package instagram;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class JsonDataProcessor {

    private static final Logger logger = LoggerFactory.getLogger(JsonDataProcessor.class);

    public JsonElement getConnections(String dataNode) {
        JsonObject jsonObject = new JsonObject();
        try {
            InputStreamReader isr = null;
            BufferedReader br = null;
            InputStream in = JsonDataProcessor.class.getClassLoader().getResourceAsStream("connections.json");

            StringBuilder sb = new StringBuilder();
            String content;
            try {
                isr = new InputStreamReader(in);
                br = new BufferedReader(isr);
                while ((content = br.readLine()) != null) {
                    sb.append(content);
                }
            } catch (IOException ioe) {
                logger.error("IO Exception occurred");
                ioe.printStackTrace();
            } finally {
                isr.close();
                br.close();
            }
            String mystring = sb.toString();
            jsonObject = new JsonParser().parse(mystring).getAsJsonObject();

            logger.info("Connections File read. Data size: " + jsonObject.size());


        } catch (
                Exception e) {
            e.printStackTrace();
        }

        return (jsonObject.get(dataNode) == null) ? new JsonParser().parse("{'No data found'}") : jsonObject.get(dataNode);
    }

    public String getDifference() {
        JsonElement followersJson = getConnections("followers");
        JsonElement followingJson = getConnections("following");

        ArrayList<String> followers = getKeys(followersJson);
        ArrayList<String> following = getKeys(followingJson);

        HashSet<String> usersNotFollowing = new HashSet<>(following);
        usersNotFollowing.removeAll(followers);

        return String.valueOf(usersNotFollowing);
    }

    public ArrayList<String> getKeys(JsonElement jsonElement) {
        ArrayList<String> map = new ArrayList<>();
        JsonObject obj = jsonElement.getAsJsonObject();
        Set<Map.Entry<String, JsonElement>> entries = obj.entrySet();

        for (Map.Entry<String, JsonElement> entry : entries) {
            map.add(entry.getKey());
        }
        return map;
    }
}
