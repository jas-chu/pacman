package com.tdd.configuracion;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.parser.ContainerFactory;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Configuracion {

    private final URL filePath;
    private final Map transiciones;
    private static Configuracion configuracion = null;

    private Configuracion() {
        this.transiciones = new TreeMap<>();
        this.filePath = getClass().getResource("configure.json");
    }

    static public Configuracion getConfiguracion() {
        if (configuracion == null) {
            configuracion = new Configuracion();
            JSONParser parser = new JSONParser();
            ContainerFactory containerFactory = configuracion.createContainer();
            try {
                FileReader fileReader = new FileReader(configuracion.getFilePath());
                Map json = (Map) parser.parse(fileReader, containerFactory);
                Iterator iter = json.entrySet().iterator();
                while (iter.hasNext()) {
                    Map.Entry entry = (Map.Entry) iter.next();
                    configuracion.getTransiciones().put(entry.getKey(), entry.getValue());
                }

            } catch (FileNotFoundException ex) {
                Logger.getLogger(Configuracion.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException | ParseException ex) {
                Logger.getLogger(Configuracion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return configuracion;
    }

    private Map getTransiciones() {
        return configuracion.transiciones;
    }

    private String getFilePath() {
        return configuracion.filePath.getPath();
    }

    public Collection<Long> getTiemposCazador() {
        return (Collection<Long>) configuracion.getTransiciones().get("tiemposCazador");
    }

    public Long getTiempoMuerto() {
        return (Long) configuracion.getTransiciones().get("tiempoMuerto");
    }

    public Long getTiempoPresa() {
        return (Long) configuracion.getTransiciones().get("tiempoPresa");
    }

    private ContainerFactory createContainer() {
        ContainerFactory containerFactory;
        containerFactory = new ContainerFactory() {
            @Override
            public List creatArrayContainer() {
                return new LinkedList();
            }

            @Override
            public Map createObjectContainer() {
                return new LinkedHashMap();
            }

        };
        return containerFactory;
    }
}