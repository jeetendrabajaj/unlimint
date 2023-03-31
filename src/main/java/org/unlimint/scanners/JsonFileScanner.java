package org.unlimint.scanners;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.*;
import org.json.simple.parser.*;
@Component
public class JsonFileScanner extends SuperScanner{

    @Override
    public void run() {
        synchronized (lock) {
            read(fileName);
        }
    }

    public static void read(String jsonFile) {
        JSONParser parser = new JSONParser();
        File f = new File(jsonFile);
        try {
          JSONArray a = (JSONArray) parser.parse(new FileReader(jsonFile));
            int i=1;
            for (Object o : a)
            {
                JSONObject rec = (JSONObject) o;
                rec.put("id",number);
                rec.put("filename",f.getName());
                rec.put("line",i++);
                rec.put("result","OK");
                rec.remove("currency");
                System.out.println(rec.toJSONString());
                number++;
            }
        }catch(Exception ioe) {
            ioe.printStackTrace();
        }
    }
}
