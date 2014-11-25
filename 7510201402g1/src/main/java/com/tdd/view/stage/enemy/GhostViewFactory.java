package com.tdd.view.stage.enemy;

import com.tdd.model.helpers.RandomNumberGenerator;
import com.tdd.model.helpers.XMLConstants;
import com.tdd.view.helpers.ViewConstants;
import java.util.HashMap;
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
        int index = RandomNumberGenerator.getRandomNumber(0, images.size() - 1);
        return this.images.get(index);
    }

    private HashMap<String, ImageIcon> getGhostBluePaths() {
        return getGhostColorPaths(ViewConstants.GHOST_BLUE_RIGHT, ViewConstants.GHOST_BLUE_LEFT,
								  ViewConstants.GHOST_BLUE_UP, ViewConstants.GHOST_BLUE_DOWN);
    }

    private HashMap<String, ImageIcon> getGhostRedPaths() {
        return getGhostColorPaths(ViewConstants.GHOST_RED_RIGHT, ViewConstants.GHOST_RED_LEFT,
								  ViewConstants.GHOST_RED_UP, ViewConstants.GHOST_RED_DOWN);
    }

    private HashMap<String, ImageIcon> getGhostYellowPaths() {
        return getGhostColorPaths(ViewConstants.GHOST_YELLOW_RIGHT, ViewConstants.GHOST_YELLOW_LEFT,
								  ViewConstants.GHOST_YELLOW_UP, ViewConstants.GHOST_YELLOW_DOWN);
    }
	
	private HashMap<String, ImageIcon> getGhostColorPaths(String rightPath, String leftPath, String upPath, String downPath) {
		HashMap<String, ImageIcon> colorGhostPaths = new HashMap<>();
        colorGhostPaths.put(XMLConstants.DIRECTION_LEFT, new ImageIcon(rightPath));
        colorGhostPaths.put(XMLConstants.DIRECTION_RIGHT, new ImageIcon(leftPath));
        colorGhostPaths.put(XMLConstants.DIRECTION_UP, new ImageIcon(upPath));
        colorGhostPaths.put(XMLConstants.DIRECTION_DOWN, new ImageIcon(downPath));
        return colorGhostPaths;
	}

    public ImageIcon getGhostDeathImage() {
        return new ImageIcon(ViewConstants.GHOST_DEATH);
    }
    
    public ImageIcon getGhostPreyImage() {
        return new ImageIcon(ViewConstants.GHOST_PREY);
    }

}
