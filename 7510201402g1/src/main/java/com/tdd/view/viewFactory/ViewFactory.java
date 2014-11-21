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
import com.tdd.view.messages.DinamycMessage;
import com.tdd.view.messages.GameOverView;
import com.tdd.view.messages.LevelUpView;
import com.tdd.view.messages.Message;
import com.tdd.view.messages.ScoreView;
import com.tdd.view.stage.enemy.GhostView;
import com.tdd.view.stage.items.BigDotView;
import com.tdd.view.stage.items.DotView;
import com.tdd.view.stage.items.FruitView;
import com.tdd.view.stage.labyrinth.CellView;
import com.tdd.view.stage.protagonist.ProtagonistView;
import com.tdd.view.windowElements.GameContainer;
import com.tdd.view.windowElements.WindowView;

/**
 *
 *
 */
public class ViewFactory {
    GameContainer container;
    public ViewFactory(GameContainer container) {
        this.container = container;
    }

    public View getView(Enemy enemy) {
        return new GhostView(enemy,container);
    }

    public View getView(StaticItem staticItem) {
        String itemType = staticItem.getMapSerialization();
        View observer = null;
        if (itemType.equals(XMLConstants.BIG_DOT)) {
            observer = new BigDotView((BigDot) staticItem,container);
        } else {
            observer = new DotView((Dot) staticItem,container);
        }
        return observer;
    }

    public View getView(MovingItem movingItem) {
        return new FruitView(movingItem,container);
    }

    public View getView(Protagonist protagonist) {
        return new ProtagonistView(protagonist,container);
    }

    public View getView(Cell cell) {
        return new CellView(cell,container);
    }

    public WindowView getWindow(String name) {
        return new WindowView(name);
    }

    public Message getLevelUpView() {
        return new LevelUpView();
    }

    public Message getGameOverView() {
        return new GameOverView();
    }
    
    public DinamycMessage getScoreView() {
        return new ScoreView();
    }
}
