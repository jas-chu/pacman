package com.tdd.view.manager;

import com.tdd.controller.playerController.KeyboardPlayerController;
import com.tdd.model.stageAbstractions.Cell;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.MovingItem;
import com.tdd.model.stageAbstractions.Protagonist;
import com.tdd.model.stageAbstractions.StaticItem;
import com.tdd.view.abstractions.View;
import com.tdd.view.messages.DynamicMessage;
import com.tdd.view.viewFactory.ViewFactory;
import com.tdd.view.windowElements.GameContainer;
import com.tdd.view.audio.AudioFactory;
import com.tdd.view.helpers.ViewConstants;
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
        this.window = this.viewFactory.createWindow(name);
        this.window.add(panel);
    }

    public void reset() {
        this.panel.clear();
    }

    public void showWindow() {
        this.window.setVisible(true);
    }

    public void updateViews() {
        this.panel.update();

    }

    public void createCellsView(List<List<Cell>> cellsStage) {
        for (List<Cell> cells : cellsStage) {
            for (Cell cell : cells) {
                this.createCell(cell);
            }
        }
        this.window.changeSize(this.width * this.nodeWidth, this.height * this.nodeHeight + ViewConstants.LABEL_HEIGHT);
    }

    public void setConfigValues(Integer width, Integer height, Integer nodeWidth, Integer nodeHeight) {
        this.width = width;
        this.height = height;
        this.nodeHeight = nodeHeight;
        this.nodeWidth = nodeWidth;
    }

    public void gameOver() {
        this.reset();
        this.panel.addLabel(this.viewFactory.createGameOverView());
        this.panel.repaint();
		this.panel.revalidate();
    }

    public void createItemViews(List<StaticItem> staticItems, List<MovingItem> movingItems) {
        this.createStaticItemViews(staticItems);
        this.createMovingItemViews(movingItems);
    }

    public void reLoadItemsViews(List<StaticItem> staticItems) {
        this.panel.resetVolatileViews();
        this.createStaticItemViews(staticItems);
    }

    public void createProtagonist(Protagonist protagonist) {
        this.createObserver(protagonist);
    }

    public void createEnemy(Enemy enemy) {
        this.createObserver(enemy);
    }

    public void createScore(Protagonist protagonist) {
        DynamicMessage scoreView = this.viewFactory.createScoreView();
        protagonist.addObserver(scoreView);
        this.panel.addLabel(scoreView);
    }

    private static class ViewManagerHolder {
        private static final ViewManager INSTANCE = new ViewManager();
    }

    private void createStaticItemViews(List<StaticItem> staticItems) {
        staticItems.stream().forEach((item) -> {
            this.createObserver(item);
        });
    }

    private void createMovingItemViews(List<MovingItem> movingItems) {
        movingItems.stream().forEach((item) -> {
            this.createObserver(item);
        });
    }

    private void createCell(Cell cell) {
        View observer = this.createView(cell);
        cell.addObserver(observer);
        panel.addBackgroundView(observer);
    }

    private void createObserver(Enemy enemy) {
        View observer = this.createView(enemy);
        enemy.addObserver(observer);
        panel.addStableView(observer);
    }

    private void createObserver(StaticItem staticItem) {
        View observer = this.createView(staticItem);
        staticItem.addObserver(observer);
        panel.addVolatileView(observer);
    }

    private void createObserver(MovingItem movingItem) {
        View observer = this.createView(movingItem);
        movingItem.addObserver(observer);
        observer.addSound(this.audioFactory.getPacmanEatFruit());
        panel.addStableView(observer);
    }

    private void createObserver(Protagonist protagonist) {
        View observer = this.createView(protagonist);
        protagonist.addObserver(observer);
        observer.addSound(this.audioFactory.getPacmanChomp());
        panel.addStableView(observer);
    }

    private View createView(Cell cell) {
        return this.viewFactory.createView(cell);
    }

    private View createView(Enemy enemy) {
        return this.viewFactory.createView(enemy);
    }

    private View createView(StaticItem staticItem) {
        return this.viewFactory.createView(staticItem);
    }

    private View createView(MovingItem movingItem) {
        return this.viewFactory.createView(movingItem);
    }

    private View createView(Protagonist protagonist) {
        return this.viewFactory.createView(protagonist);
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
