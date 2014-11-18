package com.tdd.view.stage.enemy;

import com.tdd.model.helpers.XMLConstants;
import com.tdd.view.helpers.ViewConstants;
import java.util.HashMap;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 *
 */
public class GhostViewFactory {

    private HashMap<Integer, HashMap<String, ImageIcon>> images;
    
    public GhostViewFactory() {
        this.images = new HashMap<>();
        this.images.put(0, this.getGhostBluePaths());
        this.images.put(1, this.getGhostRedPaths());
        this.images.put(2, this.getGhostYellowPaths());
    }

    public HashMap<String, ImageIcon> getGhostImages() {
        int index = getRandomNumber(0, images.size() - 1);
        return this.images.get(index);
    }

    private int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    private HashMap<String, ImageIcon> getGhostBluePaths() {
        HashMap<String, ImageIcon> ghostBluePaths = new HashMap<>();
        ghostBluePaths.put(XMLConstants.DIRECTION_LEFT, new ImageIcon(ViewConstants.GHOST_BLUE_RIGHT));
        ghostBluePaths.put(XMLConstants.DIRECTION_RIGHT, new ImageIcon(ViewConstants.GHOST_BLUE_LEFT));
        ghostBluePaths.put(XMLConstants.DIRECTION_UP, new ImageIcon(ViewConstants.GHOST_BLUE_UP));
        ghostBluePaths.put(XMLConstants.DIRECTION_DOWN, new ImageIcon(ViewConstants.GHOST_BLUE_DOWN));
        return ghostBluePaths;
    }

    private HashMap<String, ImageIcon> getGhostRedPaths() {
        HashMap<String, ImageIcon> ghostRedPaths = new HashMap<>();
        ghostRedPaths.put(XMLConstants.DIRECTION_LEFT, new ImageIcon(ViewConstants.GHOST_RED_RIGHT));
        ghostRedPaths.put(XMLConstants.DIRECTION_RIGHT, new ImageIcon(ViewConstants.GHOST_RED_LEFT));
        ghostRedPaths.put(XMLConstants.DIRECTION_UP, new ImageIcon(ViewConstants.GHOST_RED_UP));
        ghostRedPaths.put(XMLConstants.DIRECTION_DOWN, new ImageIcon(ViewConstants.GHOST_RED_DOWN));
        return ghostRedPaths;
    }

    private HashMap<String, ImageIcon> getGhostYellowPaths() {
        HashMap<String, ImageIcon> yellowGhostPaths = new HashMap<>();
        yellowGhostPaths.put(XMLConstants.DIRECTION_LEFT, new ImageIcon(ViewConstants.GHOST_YELLOW_RIGHT));
        yellowGhostPaths.put(XMLConstants.DIRECTION_RIGHT, new ImageIcon(ViewConstants.GHOST_YELLOW_LEFT));
        yellowGhostPaths.put(XMLConstants.DIRECTION_UP, new ImageIcon(ViewConstants.GHOST_YELLOW_UP));
        yellowGhostPaths.put(XMLConstants.DIRECTION_DOWN, new ImageIcon(ViewConstants.GHOST_YELLOW_DOWN));
        return yellowGhostPaths;
    }

    public ImageIcon getGhostDeathImage() {
        return new ImageIcon(ViewConstants.GHOST_DEATH);
    }
    
    public ImageIcon getGhostPreyImage() {
        return new ImageIcon(ViewConstants.GHOST_PREY);
    }

}
