package com.tdd.configuracion;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Configuracion {

    private final URL filePath;
    private final Map<String, String> transiciones;
    private static Configuracion configuracion = null;

    private Configuracion() {
        this.transiciones = new TreeMap<>();
        this.filePath = getClass().getResource("configure.json");
    }

    static public Configuracion getConfiguracion() {
        if (configuracion == null) {
            configuracion = new Configuracion();
            JSONParser parser = new JSONParser();

            try {
                FileReader fileReader = new FileReader(configuracion.getFilePath());
                JSONObject jsonConfigure = (JSONObject) parser.parse(fileReader);
                Iterator iter = jsonConfigure.entrySet().iterator();
                while (iter.hasNext()) {
                    Map.Entry entry = (Map.Entry) iter.next();
                    String key = (String) entry.getKey();
                    String value = (String) entry.getValue();
                    configuracion.getTransiciones().put(key, value);
                }

            } catch (FileNotFoundException ex) {
                Logger.getLogger(Configuracion.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException | ParseException ex) {
                Logger.getLogger(Configuracion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return configuracion;
    }

    private Map<String, String> getTransiciones() {
        return configuracion.transiciones;
    }

    private String getFilePath() {
        return configuracion.filePath.getPath();
    }
    
    public String getTransicion(String transicion){
        return configuracion.getTransiciones().get(transicion);
    }
    
    public String getTicks(){
        return configuracion.getTransiciones().get("ticks");
    }
}