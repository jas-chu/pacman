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
    private List<View> stableViewsToBePainted;
    /**
     * List of volatile views (Eg. dot,bigDot)
     */
    private List<View> volatileViewsToBePainted;

    private List<View> backgroundViewsToBePainted;
	private Map<String,View> backgroundViewsMap;

    private List<Message> labels;

    public GameContainer() {
        this.stableViewsToBePainted = new ArrayList<>();
        this.volatileViewsToBePainted = new ArrayList<>();
        this.labels = new ArrayList<>();
        this.backgroundViewsToBePainted = new ArrayList<>();
		this.backgroundViewsMap = new HashMap<>();
    }

    public void update() {
        Graphics2D g2d = (Graphics2D) this.getGraphics();
		
        this.backgroundViewsToBePainted.stream().forEach(backgroundView -> backgroundView.paint(g2d));
        this.volatileViewsToBePainted.stream().forEach(volatileView -> volatileView.paint(g2d));
        this.stableViewsToBePainted.stream().forEach(stableView -> stableView.paint(g2d));
        this.labels.stream().forEach(label -> label.paint(g2d));
		this.clearLists();
    }
	
	private void clearLists() {
		this.stableViewsToBePainted.clear();
        this.volatileViewsToBePainted.clear();
        this.backgroundViewsToBePainted.clear();
	}
	
    public void clear() {
        this.removeAll();
        this.clearLists();
    }

    public void addLabel(JLabel label) {
        this.add(label);
    }

    public void loadBeginningSong(Sound pacmanBeginning) {
        pacmanBeginning.playSound();
    }

    public void addBackgroundView(View observer) {
        this.backgroundViewsToBePainted.add(observer);
		this.backgroundViewsMap.put(observer.getViewPosition().toString(), observer);
    }
	
	public void orderCellRepaint(Position position) {
		String key = position.toString();
		if (this.backgroundViewsMap.containsKey(key)) {
			this.backgroundViewsMap.get(key).orderRepaint();
		}
	}
	
	public void mustPaintBackgroundView(View view) {
		this.backgroundViewsToBePainted.add(view);
	}
	
	public void mustPaintStableView(View view) {
        this.stableViewsToBePainted.add(view);
    }
	
	public void mustPaintVolatileView(View view) {
        this.volatileViewsToBePainted.add(view);
    }
}
