package repfind;

import java.io.*;
import java.net.*;
import java.util.Iterator;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class BuscaProjetoGH implements BuscaProjeto {

    

    BuscaProjetoGH() throws Exception {
    
       
    }

    public URL busca(String keyWords) throws Exception {

        URL url = new URL("https://api.github.com/search/repositories?q=" + keyWords);
        
        URLConnection connection = url.openConnection();
        

        BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
        

        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(in);
        JSONArray items = (JSONArray) jsonObject.get("items");
        Iterator i = items.iterator();
        while (i.hasNext()) {
            JSONObject innerObj = (JSONObject) i.next();
            System.out.println(innerObj.get("name"));
            System.out.println();
        }
        JSONObject selected = (JSONObject) items.get(0);
        URL result = new URL((String) selected.get("url"));
        return result;
    }
}
