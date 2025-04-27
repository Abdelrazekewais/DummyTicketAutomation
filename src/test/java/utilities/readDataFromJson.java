package utilities;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class readDataFromJson {

    // 4- Read data using JSONParser
    public static String readData (String requieredField) throws IOException {
        try ( FileReader reader = new FileReader(".\\testData\\testData.json" )){

            String[] parts = requieredField.split("\\.");
            String ObjectName = parts[0];
            String key = parts[1];

            // this line creates instance of JSONParser and convert the text in this JSON file to generic Object
            //After that I can convert this Object to JSONObject or JSONArray as needed
            JSONParser parser = new JSONParser();

            // convert the Object returned from JSONParser into a JSONObject
            JSONObject jsonObject = (JSONObject) parser.parse(reader);

            jsonObject.get(requieredField);
            //From this Object instance I can access the required field and read it
             JSONObject obj = (JSONObject) jsonObject.get(ObjectName);
            return (String) obj.get(key);

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }




}