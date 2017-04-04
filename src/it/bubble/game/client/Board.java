package it.bubble.game.client;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.FlowPanel;

public class Board extends FlowPanel{
	public Board() {
		this.getElement().getStyle().setWidth(100, Unit.PCT);
		this.getElement().getStyle().setHeight(100, Unit.PCT);
		this.getElement().getStyle().setBackgroundColor("cyan");
		this.getElement().getStyle().setBorderColor("black");
	}
}
