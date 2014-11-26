package com.tdd.view.abstractions;

import com.tdd.model.stageAbstractions.Position;
import com.tdd.model.stageAbstractions.StageElement;
import com.tdd.view.audio.Sound;
import com.tdd.view.helpers.ViewConstants;
import com.tdd.view.manager.ViewManager;
import com.tdd.view.windowElements.GameContainer;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;

/**
 *
 *
 * 
 */
public abstract class View implements Observer {

    protected Observable observable;
    protected int x, y, width, heigth;
    protected ImageIcon img;
    protected GameContainer container;
    protected Sound audio;
    protected boolean visible;
	private boolean repaintOrdered;

    public View(GameContainer container) {
        this.x = 0;
        this.y = 0;
        this.width = ViewConstants.IMAGE_WIDTH_DEFAULT;
        this.heigth = ViewConstants.IMAGE_HEIGHT_DEFAULT;
        this.container = container;
        this.visible = true;
		this.repaintOrdered = true;
    }

    public void setViewPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
	
	public Position getViewPosition() {
		return new Position(this.x, this.y);
	}

    public void paint(Graphics graphics) {
		if (this.repaintOrdered) {
			graphics.drawImage(img.getImage(), getXRender(), getYRender(), width, heigth, null);
			this.repaintOrdered = false;
		}
    }

    private int getXRender() {
        return x * width;
    }

    private int getYRender() {
        return y * heigth + 30;
    }

    public void addSound(Sound audio) {
        this.audio = audio;
    }

    public void setVisible(boolean b) {
        this.visible = b;
    }
    
    public boolean isVisible(){
        return this.visible;
    }
	
	public boolean shouldRepaint() {
		return this.repaintOrdered;
	}
	
	public void orderRepaint() {
		this.repaintOrdered = true;
	}
	
	@Override
    public void update(Observable o, Object arg) {
        StageElement element = (StageElement) o;
		
		Position lastPosition = this.getViewPosition();
		Position newPosition = element.getPosition();
		if (!newPosition.equals(lastPosition)){
			this.otherUpdates();
			this.orderCellRepaint(lastPosition);
		}
		this.setViewPosition(newPosition.getX(), newPosition.getY());
		this.orderRepaint();
		this.orderCellRepaint(newPosition);
    }
	
	private void orderCellRepaint(Position position) {
		ViewManager vm = ViewManager.getInstance();
		vm.orderCellRepaint(position);
	}
	
	protected void otherUpdates() { }
}
