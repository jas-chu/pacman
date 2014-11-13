package com.tdd.view.viewFactory;

import com.tdd.model.stageAbstractions.Cell;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.MovingItem;
import com.tdd.model.stageAbstractions.Protagonist;
import com.tdd.model.stageAbstractions.StaticItem;
import com.tdd.view.Observador;
import com.tdd.view.stage.enemy.GhostView;
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

    public Observador getView(Enemy enemy) {
        return new GhostView(enemy);
    }

    public Observador getView(StaticItem staticItem) {
        //TODO por ahora retorno una bolita-> Ver como difereciar bolita/bolon
        return new DotView(staticItem);
    }

    public Observador getView(MovingItem movingItem) {
        return new FruitView(movingItem);
    }

    public Observador getView(Protagonist protagonist) {
        return new ProtagonistView(protagonist);
    }
    public Observador getView(Cell cell) {
        return new CellView(cell);
    }
    public JFrame getWindow(String name) {
        return new WindowView(name);
    }
}
