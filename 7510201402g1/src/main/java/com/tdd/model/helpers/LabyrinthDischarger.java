package com.tdd.model.helpers;

/**
 *
 *
 */
public class LabyrinthDischarger {

    private static boolean initialized = false;
    private static LabyrinthDischarger labyrinthDischarger = null;
    private static String path;
    private LabyrinthDischarger(String xmlPath) {
        LabyrinthDischarger.path = xmlPath;
    }
    /**
     * 
     * @param XMLpath
     * @return 
     */
    public static LabyrinthDischarger getLabyrinthDischarger(String XMLpath) {
        if (!LabyrinthDischarger.initialized) {
            LabyrinthDischarger.labyrinthDischarger = new LabyrinthDischarger(XMLpath);
            LabyrinthDischarger.initialized = true;
        }
        return LabyrinthDischarger.labyrinthDischarger;
    }

}
