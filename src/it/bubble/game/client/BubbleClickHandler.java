package it.bubble.game.client;

import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

public class BubbleClickHandler implements ClickHandler{
	private Bubble bubble;
	private List<Bubble> bubbles;
	private Board board;
	
	public BubbleClickHandler(Bubble bubble, List<Bubble> bubbles, Board board) {
		this.bubble = bubble;
		this.bubbles = bubbles;
		this.board = board;
	}
	
	@Override
	public void onClick(ClickEvent event) {
		bubbles.remove(bubble); 
		board.remove(bubble);
	}
	
}
