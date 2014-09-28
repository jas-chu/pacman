package com.tdd.model.configuration;

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
public class Configuration {

    private final String filePath;
    private final Map transitions;
    private static boolean initialized = false;
    private static Configuration configuration = null;
    private static final String prePath = "/src/main/java/com/tdd/model/configuration/";

    /**
     * Constructor privado para aplicar el patron singleton
     */
    private Configuration() {
        this.transitions = new TreeMap<>();
        this.filePath = new File("").getAbsolutePath() + prePath + "configure.json";
	Configuration.initialized = true;
        System.out.println(this.filePath);
    }

    /**
     * Metodo que retorna la instancia
     *
     * @return nueva instancia de configuration
     */
    static public Configuration getConfiguration() {
        if (!Configuration.initialized) {
            configuration = new Configuration();
            JSONParser parser = new JSONParser();
            ContainerFactory containerFactory = configuration.createContainer();
            try {
                FileReader fileReader = new FileReader(configuration.getFilePath());
                System.out.print(fileReader.toString());
                Map json = (Map) parser.parse(fileReader, containerFactory);
                Iterator iter = json.entrySet().iterator();
                while (iter.hasNext()) {
                    Map.Entry entry = (Map.Entry) iter.next();
                    configuration.getTransitions().put(entry.getKey(), entry.getValue());
                }

            } catch (FileNotFoundException ex) {
                Logger.getLogger(Configuration.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException | ParseException ex) {
                Logger.getLogger(Configuration.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return configuration;
    }

    private Map getTransitions() {
        return configuration.transitions;
    }

    private String getFilePath() {
        return configuration.filePath;
    }

    public Collection<Long> getHunterTimes() {
        return (Collection<Long>) configuration.getTransitions().get("hunterTimes");
    }

    public Long getDeadTime() {
        return (Long) configuration.getTransitions().get("deadTime");
    }

    public Long getPreyTime() {
        return (Long) configuration.getTransitions().get("preyTime");
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
