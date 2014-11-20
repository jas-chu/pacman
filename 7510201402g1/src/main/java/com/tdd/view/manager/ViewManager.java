package com.tdd.view.manager;

import com.tdd.controller.playerController.KeyboardPlayerController;
import com.tdd.model.stageAbstractions.Cell;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.MovingItem;
import com.tdd.model.stageAbstractions.Protagonist;
import com.tdd.model.stageAbstractions.StaticItem;
import com.tdd.view.abstractions.View;
import com.tdd.view.messages.DinamycMessage;
import com.tdd.view.viewFactory.ViewFactory;
import com.tdd.view.windowElements.GameContainer;
import com.tdd.view.audio.AudioFactory;
import com.tdd.view.windowElements.WindowView;
import java.util.List;

/**
 *
 * @author agu
 */
public class ViewManager {

    private WindowView window;
    private GameContainer panel;
    private ViewFactory viewFactory;
    private AudioFactory audioFactory;

    private int nodeWidth;
    private int nodeHeight;
    private int width;
    private int height;

    private ViewManager() {
        this.panel = new GameContainer();
        this.viewFactory = new ViewFactory(this.panel);
        this.audioFactory = AudioFactory.getInstance();
        this.panel.loadBeginningSong(this.audioFactory.getPacmanBeginning());

    }

    public static ViewManager getInstance() {
        return ViewManagerHolder.INSTANCE;
    }

    public void createWindow(String name) {
        this.window = this.viewFactory.getWindow(name);
        this.window.add(panel);
    }

    public void reset() {
        this.panel.clear();
    }

    public void showWindow() {

        this.window.setVisible(true);

    }

    public void updateViews() {
        this.panel.repaint();

    }

    public void createCellsView(List<List<Cell>> cellsStage) {
        for (List<Cell> cells : cellsStage) {
            for (Cell cell : cells) {
                this.createCell(cell);

            }
        }
       this.window.changeSize(this.width*this.nodeWidth,this.height*this.nodeHeight);
    }

    public void setConfigValues(Integer width, Integer height, Integer nodeWidth, Integer nodeHeight) {
        this.width = width;
        this.height = height;
        this.nodeHeight = nodeHeight;
        this.nodeWidth = nodeWidth;
    }

    public void gameOver() {
        this.reset();
        this.panel.addLabel(this.viewFactory.getGameOverView());
        this.panel.repaint();
    }

    public void createItemViews(List<StaticItem> staticItems, List<MovingItem> movingItems) {
        for (StaticItem item : staticItems) {
            this.addObserver(item);
        }
        for (MovingItem item : movingItems) {
            if (!item.isConsumed()){
                this.addObserver(item);
            }
        }

    }

    public void reLoadItemsViews(List<StaticItem> staticItems, List<MovingItem> movingItems) {
        this.panel.resetVolatileViews();
        this.createItemViews(staticItems, movingItems);
    }

    public void createProtagonist(Protagonist protagonist) {
        this.addObserver(protagonist);
    }

    public void createEnemy(Enemy enemy) {
        this.addObserver(enemy);
    }

    public void createScore(Protagonist protagonist) {
        DinamycMessage scoreView = this.viewFactory.getScoreView();
        protagonist.addObserver(scoreView);
        this.panel.addLabel(scoreView);
    }

    private static class ViewManagerHolder {

        private static final ViewManager INSTANCE = new ViewManager();
    }

    private void addObserver(Enemy enemy) {
        View observer = this.getView(enemy);
        enemy.addObserver(observer);
        panel.addStableView(observer);
    }

    private void createCell(Cell cell) {
        View observer = this.getView(cell);
        cell.addObserver(observer);
        panel.addStableView(observer);
    }

    private void addObserver(StaticItem staticItem) {
        View observer = this.getView(staticItem);
        staticItem.addObserver(observer);
        panel.addVolatileView(observer);
    }

    private void addObserver(MovingItem movingItem) {
        View observer = this.getView(movingItem);
        movingItem.addObserver(observer);
        observer.addSound(this.audioFactory.getPacmanEatFruit());
        panel.addVolatileView(observer);
    }

    private void addObserver(Protagonist protagonist) {
        View observer = this.getView(protagonist);
        protagonist.addObserver(observer);
        observer.addSound(this.audioFactory.getPacmanChomp());
        panel.addStableView(observer);

    }

    private View getView(Cell cell) {
        return this.viewFactory.getView(cell);
    }

    private View getView(Enemy enemy) {
        return this.viewFactory.getView(enemy);
    }

    private View getView(StaticItem staticItem) {
        return this.viewFactory.getView(staticItem);
    }

    private View getView(MovingItem movingItem) {
        return this.viewFactory.getView(movingItem);
    }

    private View getView(Protagonist protagonist) {
        return this.viewFactory.getView(protagonist);
    }

    /**
     * Assign KeyBoard controller to window
     *
     * @param controller
     */
    public void addController(KeyboardPlayerController controller) {
        this.panel.addKeyListener(controller);
        this.panel.setFocusable(true);

    }
}
