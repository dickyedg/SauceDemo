package dataProvider;

import Util.JSONUtil;
import com.fasterxml.jackson.databind.JsonNode;
import org.testng.annotations.DataProvider;

public class UserDataProvider {

    private JSONUtil jsonUtil;

    final String userFileName = "userDetails.json";

    public UserDataProvider() {
        jsonUtil = new JSONUtil();
    }

    @DataProvider(name = "UserDataProvider")
    public Object[][] getUserDataProvider() {
        JsonNode userJsonNode = jsonUtil.readJSONFromFile(userFileName).get("userDetails");
        // Create DataProvider array
        Object[][] dataProviderArray = new Object[userJsonNode.size()][2];

        // Iterate over JSON array and populate DataProvider array
        int index = 0;
        for (JsonNode userNode : userJsonNode) {
            String username = userNode.get("username").asText();
            String password = userNode.get("password").asText();
            dataProviderArray[index][0] = username;
            dataProviderArray[index][1] = password;
            index++;
        }

        return dataProviderArray;
    }
}
