package org.unlimint.scanners;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


@Component
public class CsvFileScanner extends SuperScanner{

    public static final String delimiter = ",";

    @Override
    public void run() {
        synchronized (lock) {
            read(fileName);
        }
    }

    public static void read(String csvFile) {
        try {
            File file = new File(csvFile);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            String[] tempArr;
            int i=0;
            while((line = br.readLine()) != null) {
                if(i != 0) {
                    tempArr = line.split(delimiter);
                    JSONObject obj = new JSONObject();
                    File f = new File(csvFile);
                    obj.put("id",number);
                    obj.put("orderId",tempArr[0].indexOf(".") >= 0 ? Float.parseFloat(tempArr[0]) : Integer.valueOf(tempArr[0]));
                    obj.put("amount",tempArr[1].indexOf(".") >= 0 ? Float.parseFloat(tempArr[1]) : Integer.valueOf(tempArr[1]));
                    obj.put("comment",tempArr[3]);
                    obj.put("filename",f.getName());
                    obj.put("line",i);
                    obj.put("result","OK");
                    System.out.print(obj.toJSONString());
                }
                i++;
                number++;
                System.out.println();
            }
            br.close();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
