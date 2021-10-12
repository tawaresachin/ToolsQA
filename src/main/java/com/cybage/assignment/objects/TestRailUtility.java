package com.cybage.assignment.objects;


import com.cybage.assignment.gurock.APIClient;
import com.cybage.assignment.gurock.APIException;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class TestRailUtility {
    private static final String TESTRAIL_USERNAME = "sachintaware.2551988@gmail.com";
    private static final String TESTRAIL_PASSWORD = "Asmita@2025";
    private static final String RAILS_ENGINE_URL = "https://cybagespace.testrail.io/";
//    private static final String TESTRAIL_PROJECT = "TestProject";


    public void addResult(String testRunId,String testCaseId, int status, String error,
                                            String screenshotPath) throws IOException, APIException {
        String version="001";
        APIClient client= new APIClient(RAILS_ENGINE_URL);
        client.setUser(TESTRAIL_USERNAME);
        client.setPassword(TESTRAIL_PASSWORD);
        Map<String,Object> data = new HashMap<>();
        data.put("status_id", status);
        data.put("Version",001);
        if(status==5) {
            data.put("comment", "Executed Selenium test "+testCaseId+" is FAILED \n" + error);
            Object addResult = client.sendPost("add_result_for_case/" + testRunId + "/" + testCaseId + "", data);
            JSONObject obj = (JSONObject) addResult;
            Object resultID = obj.get("id");
            client.sendPost("add_attachment_to_result/" + resultID.toString(), screenshotPath);
        }
        else if (status==1)
        {
            data.put("comment", "Executed Selenium test "+testCaseId+" is PASSED");
            client.sendPost("add_result_for_case/" + testRunId + "/" + testCaseId + "", data);
        }

    }

}
