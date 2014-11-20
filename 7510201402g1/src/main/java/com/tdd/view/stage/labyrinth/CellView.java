package com.tdd.view.stage.labyrinth;

import com.tdd.model.helpers.XMLConstants;
import com.tdd.model.stageAbstractions.Cell;
import com.tdd.view.abstractions.View;
import com.tdd.view.helpers.ViewConstants;
import com.tdd.view.windowElements.GameContainer;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import javax.swing.ImageIcon;

/**
 *
 *
 */
public class CellView extends View {

    // STATIC
    private static final double RIGHT_POW = 0.0;
    private static final double UP_POW = 1.0;
    private static final double LEFT_POW = 2.0;
    private static final double DOWN_POW = 3.0;
    private static final Map<Integer, String> RESOURCES = createResources();

    private static int getPowValue(double theDouble) {
        return (int) Math.pow(2, theDouble);
    }

    private static int boolToInt(boolean bool) {
        if (bool) {
            return 0;
        }
        return 1;
    }

    // TO DO: COMPLETAR PATHS A IMAGENES
    private static Map<Integer, String> createResources() {
        Map<Integer, String> theResources = new HashMap<Integer, String>();
        theResources.put(0, ViewConstants.CLEAN_CELL);

        // UN BORDE
        theResources.put(getPowValue(RIGHT_POW), ViewConstants.RIGHT_CELL);
        theResources.put(getPowValue(UP_POW), ViewConstants.UP_CELL);
        theResources.put(getPowValue(LEFT_POW), ViewConstants.LEFT_CELL);
        theResources.put(getPowValue(DOWN_POW), ViewConstants.DOWN_CELL);

        // DOS BORDES
        theResources.put(getPowValue(RIGHT_POW) + getPowValue(UP_POW), ViewConstants.UP_RIGHT_CELL);
        theResources.put(getPowValue(RIGHT_POW) + getPowValue(LEFT_POW), ViewConstants.LEFT_RIGHT_CELL);
        theResources.put(getPowValue(RIGHT_POW) + getPowValue(DOWN_POW), ViewConstants.DOWN_RIGHT_CELL);
        theResources.put(getPowValue(UP_POW) + getPowValue(LEFT_POW), ViewConstants.UP_LEFT_CELL);
        theResources.put(getPowValue(UP_POW) + getPowValue(DOWN_POW), ViewConstants.UP_DOWN_CELL);
        theResources.put(getPowValue(LEFT_POW) + getPowValue(DOWN_POW), ViewConstants.DOWN_LEFT_CELL);

        // TRES BORDES
        theResources.put(getPowValue(RIGHT_POW) + getPowValue(UP_POW) + getPowValue(LEFT_POW), ViewConstants.UP_LEFT_RIGHT_CELL);
        theResources.put(getPowValue(RIGHT_POW) + getPowValue(UP_POW) + getPowValue(DOWN_POW), ViewConstants.UP_RIGHT_DOWN_CELL);
        theResources.put(getPowValue(RIGHT_POW) + getPowValue(LEFT_POW) + getPowValue(DOWN_POW), ViewConstants.DOWN_LEFT_RIGHT_CELL);
        theResources.put(getPowValue(UP_POW) + getPowValue(LEFT_POW) + getPowValue(DOWN_POW), ViewConstants.UP_LEFT_DOWN_CELL);

        // CUATRO BORDES
        theResources.put(getPowValue(RIGHT_POW) + getPowValue(UP_POW) + getPowValue(LEFT_POW) + getPowValue(DOWN_POW), ViewConstants.COMPLETE_CELL);

        return theResources;
    }

    // INSTANCE
    private String resourcePath;

    public CellView(Cell cell,GameContainer container) {
        super(container);
        this.observable = cell;
        int index = this.getImageIndex(cell);
        this.resourcePath = RESOURCES.get(index);
        this.img = new ImageIcon(this.resourcePath);
        this.setViewPosition(cell.getColumn(), cell.getRow());
    }

    @Override
    public void update(Observable o, Object arg) {

    }

    private int getImageIndex(Cell cell) {
        int index = getPowValue(RIGHT_POW) * boolToInt(cell.hasNeighbour(XMLConstants.DIRECTION_RIGHT));
        index += getPowValue(UP_POW) * boolToInt(cell.hasNeighbour(XMLConstants.DIRECTION_UP));
        index += getPowValue(LEFT_POW) * boolToInt(cell.hasNeighbour(XMLConstants.DIRECTION_LEFT));
        index += getPowValue(DOWN_POW) * boolToInt(cell.hasNeighbour(XMLConstants.DIRECTION_DOWN));
        return index;
    }

}
