package com.tdd.view.manager;

import com.tdd.controller.playerController.KeyboardPlayerController;
import com.tdd.model.stageAbstractions.Cell;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.MovingItem;
import com.tdd.model.stageAbstractions.Protagonist;
import com.tdd.model.stageAbstractions.StaticItem;
import com.tdd.view.abstractions.View;
import com.tdd.view.viewFactory.ViewFactory;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author agu
 */
public class ViewManager {

    private JFrame window;
    private ViewFactory factory;
    protected List<View> observers;

    private ViewManager() {
        this.factory = new ViewFactory();
        this.observers = new ArrayList<>();

    }

    public static ViewManager getInstance() {
        return ViewManagerHolder.INSTANCE;
    }

    public void createWindow(String name) {
        this.window = this.factory.getWindow(name);
    }

    public void showWindow() {

        this.window.setVisible(true);

    }

    public void addObserver(Enemy enemy) {
        View observer = this.getView(enemy);
        enemy.addObserver(observer);
        this.observers.add(observer);
        this.window.add(observer);
    }

    public void createCell(Cell cell) {
        View observer = this.getView(cell);
        this.window.add(observer);
        observer.paintComponents(this.window.getGraphics());
    }

    public void addObserver(StaticItem staticItem) {
        View observer = this.getView(staticItem);
        staticItem.addObserver(observer);
        this.observers.add(observer);
        this.window.add(observer);
    }

    public void addObserver(MovingItem movingItem) {
        View observer = this.getView(movingItem);
        movingItem.addObserver(observer);
        this.observers.add(observer);
        this.window.add(observer);
    }

    public void addObserver(Protagonist protagonist) {
        View observer = this.getView(protagonist);
        protagonist.addObserver(observer);
        this.observers.add(observer);
        this.window.add(observer);

    }

    public void updateViews() {

        observers.stream().forEach((View observer) -> {
            observer.paintComponents(this.window.getGraphics());
        });

    }

    public void createCellsView(List<List<Cell>> cellsStage) {
        for (List<Cell> cells : cellsStage) {
            for (Cell cell : cells) {
                this.createCell(cell);
            }
        }
    }

    private static class ViewManagerHolder {

        private static final ViewManager INSTANCE = new ViewManager();
    }

    private View getView(Cell cell) {
        return this.factory.getView(cell);
    }

    private View getView(Enemy enemy) {
        return this.factory.getView(enemy);
    }

    private View getView(StaticItem staticItem) {
        return this.factory.getView(staticItem);
    }

    private View getView(MovingItem movingItem) {
        return this.factory.getView(movingItem);
    }

    private View getView(Protagonist protagonist) {
        return this.factory.getView(protagonist);
    }

    /**
     * Assign KeyBoard controller to window
     *
     * @param controller
     */
    public void addController(KeyboardPlayerController controller) {
		JPanel panel = new JPanel();
		panel.addKeyListener(controller);
        panel.setFocusable(true);
		this.window.add(panel);
    }
}
