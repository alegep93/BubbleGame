package it.bubble.game.client;

import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.ui.HTML;

@SuppressWarnings("unused")
public class ScoreBoard extends HTML{
	private int score, vite;
	private SimpleEventBus bus;
	
	public ScoreBoard(SimpleEventBus bus){
		this.bus = bus;
		bus.addHandler(BollaClickataEvent.TYPE, b -> setScore(getScore() + 10));
		bus.addHandler(BollaScappataEvent.TYPE, b -> setVite(getVite() - 1));
	}

	public void setScore(int score){
		this.getElement().getStyle().setFontSize(30, Unit.PX);
		this.getElement().getStyle().setTextAlign(TextAlign.CENTER);
		this.score = score;
		setHTML("" + score + " punti" + vite + " vite");
	}
	
	public void setVite(int vite){
		this.getElement().getStyle().setFontSize(30, Unit.PX);
		this.getElement().getStyle().setTextAlign(TextAlign.CENTER);
		this.vite = vite;
		setHTML("" + score + " punti " + vite + " vite");
	}
	
	public void setScore(SimpleEventBus bus){
		this.bus = bus;
	}

	public int getScore(){
		return this.score;
	}

	public int getVite() {
		return vite;
	}
}
