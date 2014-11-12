package com.tdd.view.manager;

import com.tdd.model.stageAbstractions.Cell;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.MovingItem;
import com.tdd.model.stageAbstractions.Protagonist;
import com.tdd.model.stageAbstractions.StaticItem;
import com.tdd.view.Sample;
import com.tdd.view.viewFactory.ViewFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import javax.swing.JFrame;

/**
 *
 * @author agu
 */
public class ViewManager {

    private JFrame window;
    private ViewFactory factory;
    protected List<Observer> observers;

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
        Sample sample = new Sample();
        this.window.add(sample);
        this.window.pack();
        this.window.setVisible(true);
    }

    public void addObserver(Enemy enemy) {
        Observer observer = this.getView(enemy);
        enemy.addObserver(observer);
        this.observers.add(observer);
    }

    public void addObserver(Cell cell) {
        Observer observer = this.getView(cell);
        cell.addObserver(observer);
        this.observers.add(observer);
    }

    public void addObserver(StaticItem staticItem) {
        Observer observer = this.getView(staticItem);
        staticItem.addObserver(observer);
        this.observers.add(observer);
    }

    public void addObserver(MovingItem movingItem) {
        Observer observer = this.getView(movingItem);
        movingItem.addObserver(observer);
        this.observers.add(observer);
    }

    public void addObserver(Protagonist protagonist) {
        Observer observer = this.getView(protagonist);
        protagonist.addObserver(observer);
        this.observers.add(observer);
    }

    public void updateViews() {
        observers.stream().forEach((observer) -> {
            observer.update(null, this);
        });

    }

    private static class ViewManagerHolder {

        private static final ViewManager INSTANCE = new ViewManager();
    }

    private Observer getView(Cell cell) {
        return this.factory.getView(cell);
    }

    private Observer getView(Enemy enemy) {
        return this.factory.getView(enemy);
    }

    private Observer getView(StaticItem staticItem) {
        return this.factory.getView(staticItem);
    }

    private Observer getView(MovingItem movingItem) {
        return this.factory.getView(movingItem);
    }

    private Observer getView(Protagonist protagonist) {
        return this.factory.getView(protagonist);
    }
}
