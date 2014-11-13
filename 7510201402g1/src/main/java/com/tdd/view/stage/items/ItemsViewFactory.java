package com.tdd.view.stage.items;

import com.tdd.model.helpers.XMLConstants;
import com.tdd.view.helpers.ViewConstants;
import java.util.HashMap;
import javax.swing.ImageIcon;

/**
 *
 * @author agu
 */
public class ItemsViewFactory {

    HashMap<String, ImageIcon> images;

    private ItemsViewFactory() {
        this.images = new HashMap<>();
        this.images.put(XMLConstants.BIG_DOT, new ImageIcon(ViewConstants.BIG_DOT));
        this.images.put(XMLConstants.DOT, new ImageIcon(ViewConstants.DOT));
        this.images.put(XMLConstants.FRUIT, new ImageIcon(ViewConstants.FRUIT));
    }

    public ImageIcon getBigDotImage() {
        return this.images.get(XMLConstants.BIG_DOT);
    }

    public ImageIcon getDotImage() {
        return this.images.get(XMLConstants.DOT);
    }

    public ImageIcon getFruitImage() {
        return this.images.get(XMLConstants.FRUIT);
    }

    public static ItemsViewFactory getInstance() {
        return ItemsViewFactoryHolder.INSTANCE;
    }

    private static class ItemsViewFactoryHolder {

        private static final ItemsViewFactory INSTANCE = new ItemsViewFactory();
    }
}
