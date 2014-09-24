package com.tdd.modelo.configuracion;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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

/**
 * Clase encargada de administrar los valores configurables
 */
public class Configuracion {

    private final String filePath;
    private final Map transiciones;
    private static Configuracion configuracion = null;
    private static final String prePath = "/src/main/java/com/tdd/configuracion/";

    /**
     * Constructor privado para aplicar el patron singleton
     */
    private Configuracion() {
        this.transiciones = new TreeMap<>();
        this.filePath = new File("").getAbsolutePath() + prePath + "configure.json";
        System.out.println(this.filePath);
    }

    /**
     * Metodo que retorna la instancia
     *
     * @return nueva instancia de configuracion
     */
    static public Configuracion getConfiguracion() {
        if (configuracion == null) {
            configuracion = new Configuracion();
            JSONParser parser = new JSONParser();
            ContainerFactory containerFactory = configuracion.createContainer();
            try {
                FileReader fileReader = new FileReader(configuracion.getFilePath());
                System.out.print(fileReader.toString());
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
        return configuracion.filePath;
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
