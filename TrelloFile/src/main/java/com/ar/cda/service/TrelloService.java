package com.ar.cda.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.ar.cda.model.Trello;
import com.ar.cda.properties.TrelloProperties;

public class TrelloService {

    /**
     * @param file
     * @return
     * @throws IOException
     */
    public String leerArchivo(String file) throws IOException {    	
        FileReader fileReader = new FileReader(TrelloProperties.FILE_PATH + file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        try {
            StringBuilder stringBuilder = new StringBuilder();
            String line = bufferedReader.readLine();

            while (line != null) {
                stringBuilder.append(line);
                stringBuilder.append("\n");
                line = bufferedReader.readLine();
            }
            return stringBuilder.toString();
        }
        finally {
            bufferedReader.close();
        }
    }

    /**
     * @param file
     * @return
     * @throws Exception
     */
    public Map<String, String> leerArchivoJSON(String file) throws Exception {
        FileReader fileReader = new FileReader(TrelloProperties.FILE_PATH + file);
        JSONTokener jsonTokener = new JSONTokener(fileReader);
        JSONObject jsonObject = (JSONObject) jsonTokener.nextValue();
        Map<String, String> map = new HashMap();
        recorrerJSONObject(jsonObject);
        return map;
    }

    /**
     * @param obj
     * @throws Exception
     */
    private void recorrerJSONObject(JSONObject obj) throws Exception {
        Iterator keys = obj.keys();
        while (keys.hasNext()) {
            String key = String.valueOf(keys.next());
            Object object = obj.get(key);
            if ((object instanceof JSONObject)) {
                recorrerJSONObject((JSONObject) object);
            } else if ((object instanceof JSONArray)) {
                JSONArray array = (JSONArray) object;
                for (int i = 0; i < array.length(); i++) {
                    Object arrayObj = array.get(i);
                    if ((arrayObj instanceof JSONObject)) {
                        recorrerJSONObject((JSONObject) arrayObj);
                    }
                }
            }
        }
    }

    /**
     * @param file
     * @return
     * @throws JSONException
     * @throws IOException
     */
    public List<Trello> listaJSONFile(String file) throws JSONException, IOException {
        JSONArray jsonarray = new JSONArray(leerArchivo(file));
        List<Trello> trellos = new ArrayList();

        for (int i = 0; i < jsonarray.length(); i++) {
            Trello trello = new Trello(file, file, i);
            try {
                JSONObject jo = jsonarray.getJSONObject(i);
                trello.setNombre(jo.getString("nombre"));
                trello.setApellido(jo.getString("apellido"));
                trello.setEdad(Integer.valueOf(jo.getInt("edad")));
                trellos.add(trello);
            } catch (Exception e) {
                e.getMessage();
            }
        }
        return trellos;
    }
}
