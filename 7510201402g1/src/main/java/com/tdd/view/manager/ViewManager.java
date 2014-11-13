package com.tdd.view.manager;

import com.tdd.model.stageAbstractions.Cell;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.MovingItem;
import com.tdd.model.stageAbstractions.Protagonist;
import com.tdd.model.stageAbstractions.StaticItem;
import com.tdd.view.Observador;
import com.tdd.view.viewFactory.ViewFactory;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author agu
 */
public class ViewManager {

    private JFrame window;
    private ViewFactory factory;
    protected List<Observador> observers;

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
        Observador observer = this.getView(enemy);
        enemy.addObserver(observer);
        this.observers.add(observer);
        this.window.add(observer);
    }

    public void addObserver(Cell cell) {
        Observador observer = this.getView(cell);
        cell.addObserver(observer);
        this.observers.add(observer);
    }

    public void addObserver(StaticItem staticItem) {
        Observador observer = this.getView(staticItem);
        staticItem.addObserver(observer);
        this.observers.add(observer);
    }

    public void addObserver(MovingItem movingItem) {
        Observador observer = this.getView(movingItem);
        movingItem.addObserver(observer);
        this.observers.add(observer);
    }

    public void addObserver(Protagonist protagonist) {
        Observador observer = this.getView(protagonist);
        protagonist.addObserver(observer);
        this.observers.add(observer);
        
    }

    public void updateViews() {
       
        observers.stream().forEach((Observador observer) -> {
            observer.update();
            observer.paintComponents(this.window.getGraphics());
        });
        
    }

    private static class ViewManagerHolder {

        private static final ViewManager INSTANCE = new ViewManager();
    }

    private Observador getView(Cell cell) {
        return this.factory.getView(cell);
    }

    private Observador getView(Enemy enemy) {
        return this.factory.getView(enemy);
    }

    private Observador getView(StaticItem staticItem) {
        return this.factory.getView(staticItem);
    }

    private Observador getView(MovingItem movingItem) {
        return this.factory.getView(movingItem);
    }

    private Observador getView(Protagonist protagonist) {
        return this.factory.getView(protagonist);
    }
}
