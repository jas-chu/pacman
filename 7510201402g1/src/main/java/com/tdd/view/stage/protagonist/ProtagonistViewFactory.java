package com.tdd.view.stage.protagonist;

import com.tdd.model.helpers.XMLConstants;
import com.tdd.view.helpers.ViewConstants;
import java.util.HashMap;
import javax.swing.ImageIcon;

/**
 *
 * @author agu
 */
public class ProtagonistViewFactory {

    HashMap<String, ImageIcon> images;

    private ProtagonistViewFactory() {
        this.images = new HashMap<>();
        this.images.put(XMLConstants.DIRECTION_UP, new ImageIcon(ViewConstants.PACMAN_UP));
        this.images.put(XMLConstants.DIRECTION_DOWN, new ImageIcon(ViewConstants.PACMAN_DOWN));
        this.images.put(XMLConstants.DIRECTION_RIGHT, new ImageIcon(ViewConstants.PACMAN_RIGHT));
        this.images.put(XMLConstants.DIRECTION_LEFT, new ImageIcon(ViewConstants.PACMAN_LEFT));
    }

    public ImageIcon getImage(String direction) {
        return this.images.get(direction);
    }

    public static ProtagonistViewFactory getInstance() {
        return ProtagonistViewFactoryHolder.INSTANCE;
    }

    ImageIcon getDefault() {
        return this.images.get(XMLConstants.DIRECTION_LEFT);
    }

    private static class ProtagonistViewFactoryHolder {

        private static final ProtagonistViewFactory INSTANCE = new ProtagonistViewFactory();
    }
}
