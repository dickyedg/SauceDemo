package dataProvider;

import Util.JSONUtil;
import com.fasterxml.jackson.databind.JsonNode;
import model.UserDetails;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.List;

public class UserDataProvider {

    private JSONUtil jsonUtil;

    final String userFileName = "userDetails.json";

    public UserDataProvider() {
        jsonUtil = new JSONUtil();
    }

    @DataProvider(name = "UserDataProvider")
    public Object[][] getUserDataProvider() {
        JsonNode userJsonNode = jsonUtil.readJSONFromFile(userFileName).get("userDetails");

        List<UserDetails> userDetailsList = constructListOfUserDetails(userJsonNode);

        return constructUserDataProvider(userDetailsList);
    }

    private List<UserDetails> constructListOfUserDetails(JsonNode userJsonNode) {
        List<UserDetails> userDetailsList = new ArrayList<>();

        for (JsonNode userNode : userJsonNode) {
            UserDetails userDetails = new UserDetails();
            userDetails.setUsername(userNode.get("username").asText());
            userDetails.setPassword(userNode.get("password").asText());
            userDetails.setFirstName(userNode.get("firstName").asText());
            userDetails.setLastName(userNode.get("lastName").asText());
            userDetails.setZipcode(userNode.get("postalcode").asText());
            userDetailsList.add(userDetails);
        }

        return userDetailsList;
    }

    private Object[][] constructUserDataProvider(List<UserDetails> userDetailsList) {
        Object[][] dataProviderArray = new Object[userDetailsList.size()][1];
        for(int i = 0; i < userDetailsList.size(); i++) {
            dataProviderArray[i][0] = userDetailsList.get(i);
        }

        return dataProviderArray;
    }
}
