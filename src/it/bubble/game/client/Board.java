package it.bubble.game.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.ui.FlowPanel;

public class Board extends FlowPanel {
	private List<Bubble> bubbles = new ArrayList<>();
	private SimpleEventBus bus;
	
	public Board(SimpleEventBus bus) {
		this.bus = bus;
		this.getElement().getStyle().setWidth(100, Unit.PCT);
		this.getElement().getStyle().setHeight(100, Unit.PCT);
		this.getElement().getStyle().setBackgroundColor("cyan");
		this.getElement().getStyle().setBorderColor("green");
	}
	
	public void addBubble(Bubble b){
		bubbles.add(b);
		this.add(b);
		b.addClickHandler(new BubbleClickHandler(b, this, bus));
	}
	
	public void removeBubble(Bubble b){
		bubbles.remove(b);
		this.remove(b);
	}

	public void moveBubbles() {
		int boardHeight = this.getOffsetHeight();
		
		for(Bubble b : bubbles) {
			b.moveBy((int)((Math.random() - 0.5)), (int)(Math.random() + 1));
			
			if(b.getPositionY() > boardHeight){
				this.removeBubble(b);
				bus.fireEvent(new BollaScappataEvent(b));
			}
		}
	}
	
	public int size(){
		return bubbles.size();
	}
}
