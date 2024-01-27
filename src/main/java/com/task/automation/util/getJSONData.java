package com.task.automation.util;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class getJSONData {

    public static JSONObject getJsonData() throws ParseException, FileNotFoundException, IOException {

        File f = new File("resources//testdata//myntraTestData.json");
        String json = FileUtils.readFileToString(f, "UTF-8");
        Object obj = new JSONParser().parse(json);
        JSONObject jsonObject = (JSONObject) obj;
        return jsonObject;
    }
}
