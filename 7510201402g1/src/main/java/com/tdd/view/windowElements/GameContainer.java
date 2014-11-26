package com.tdd.view.windowElements;

import com.tdd.model.stageAbstractions.Position;
import com.tdd.view.abstractions.View;
import com.tdd.view.audio.Sound;
import com.tdd.view.messages.Message;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 *
 */
public class GameContainer extends JPanel {

    /**
     * List of stable views (Eg. Protagonist,enemy,cell)
     */
    private List<View> stableViews;
    /**
     * List of volatile views (Eg. dot,bigDot)
     */
    private List<View> volatileViews;

    /**
     *
     */
    private List<View> backgroundViews;
	private Map<String,View> backgroundViewsMap;

    private List<Message> labels;

    public GameContainer() {
        this.stableViews = new ArrayList<>();
        this.volatileViews = new ArrayList<>();
        this.labels = new ArrayList<>();
        this.backgroundViews = new ArrayList<>();
		this.backgroundViewsMap = new HashMap<>();
    }

    public void addStableView(View view) {
        this.stableViews.add(view);
    }


    public void update() {
        Graphics2D g2d = (Graphics2D) this.getGraphics();

        this.backgroundViews.stream().forEach(backgroundView -> backgroundView.paint(g2d));
        this.volatileViews.stream().forEach(volatileView -> volatileView.paint(g2d));
        this.stableViews.stream().filter((stableView) -> (stableView.isVisible())).forEach((stableView) -> {
            stableView.paint(g2d);
        });
        this.labels.stream().forEach(label -> label.paint(g2d));
    }

    public void clear() {
        this.removeAll();
        this.stableViews.clear();
        this.volatileViews.clear();
        this.backgroundViews.clear();
    }

    public void addLabel(JLabel label) {
        this.add(label);
    }

    public void addVolatileView(View view) {
        this.volatileViews.add(view);
    }
	
	public void removeVolatileView(View view) {
        this.volatileViews.remove(view);
    }

    public void resetVolatileViews() {
        this.volatileViews.clear();
    }

    public void loadBeginningSong(Sound pacmanBeginning) {
        pacmanBeginning.playSound();
    }

    public void addBackgroundView(View observer) {
        this.backgroundViews.add(observer);
		this.backgroundViewsMap.put(observer.getViewPosition().toString(), observer);
    }
	
	public void orderCellRepaint(Position position) {
		String key = position.toString();
		if (this.backgroundViewsMap.containsKey(key)) {
			this.backgroundViewsMap.get(key).orderRepaint();
		}
	}
}
