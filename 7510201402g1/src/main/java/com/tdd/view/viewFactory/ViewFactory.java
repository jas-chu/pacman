package com.tdd.view.viewFactory;

import com.tdd.model.helpers.XMLConstants;
import com.tdd.model.stage.BigDot;
import com.tdd.model.stage.Dot;
import com.tdd.model.stageAbstractions.Cell;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.MovingItem;
import com.tdd.model.stageAbstractions.Protagonist;
import com.tdd.model.stageAbstractions.StaticItem;
import com.tdd.view.abstractions.View;
import com.tdd.view.stage.enemy.GhostView;
import com.tdd.view.stage.items.BigDotView;
import com.tdd.view.stage.items.DotView;
import com.tdd.view.stage.items.FruitView;
import com.tdd.view.stage.labyrinth.CellView;
import com.tdd.view.stage.protagonist.ProtagonistView;
import com.tdd.view.window.WindowView;

import java.util.Observer;
import javax.swing.JFrame;

/**
 *
 *
 */
public class ViewFactory {

    public ViewFactory() {

    }

    public View getView(Enemy enemy) {
        return new GhostView(enemy);
    }

    public View getView(StaticItem staticItem) {
        String itemType = staticItem.getMapSerialization();
        View observer = null;
        if (itemType.equals(XMLConstants.BIG_DOT))
			observer = new BigDotView((BigDot) staticItem);
        else
            observer = new DotView((Dot) staticItem);
        return observer;
    }

    public View getView(MovingItem movingItem) {
        return new FruitView(movingItem);
    }

    public View getView(Protagonist protagonist) {
        return new ProtagonistView(protagonist);
    }

    public View getView(Cell cell) {
        return new CellView(cell);
    }

    public JFrame getWindow(String name) {
        return new WindowView(name);
    }
}
