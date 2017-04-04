package it.bubble.game.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.RepeatingCommand;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootLayoutPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class BubbleGame implements EntryPoint {
	
	@Override
	public void onModuleLoad() {
		List<Bubble> bubbles = new ArrayList<>();
		Board board = new Board();

		for(int i=0; i<10; i++) {	
			Bubble bubble = new Bubble((int)(Math.random() * 55), (int)(Math.random() * 1720), -100);

			bubble.addClickHandler(new BubbleClickHandler(bubble,bubbles,board));
			bubbles.add(bubble);
		}

		DockLayoutPanel dlp = new DockLayoutPanel(Unit.PX);
		dlp.addNorth(new HTML(), 100);
		dlp.addSouth(new HTML(), 100);
		dlp.addEast(new HTML(), 100);
		dlp.addWest(new HTML(), 100);
		
		dlp.add(board);

		RootLayoutPanel.get().add(dlp);
		
		//Agiungo le bubble alla Board
		for(Bubble b : bubbles) {
			board.add(b);			
		}

		//Muove le bubble
		Scheduler.get().scheduleFixedDelay(new RepeatingCommand() {
					@Override
					public boolean execute() {
						for(Bubble b : bubbles) {
							//b.moveBy((int)((Math.random() - 0.5 ) * 3), (int)((Math.random() + 1) * 3)); //Movimento più lento e laggoso			
							b.moveBy(0, (int)(Math.random() + 1));			
						}
						return true;
					}
				}, 10);

		//Fa nascere nuove bubble
		Scheduler.get().scheduleFixedDelay(new RepeatingCommand() {
					@Override
					public boolean execute() {
						Bubble bubble = new Bubble((int)(Math.random() * 55), (int)(Math.random() * 1720), -100);
						
						bubble.addClickHandler(new BubbleClickHandler(bubble,bubbles,board));
						bubbles.add(bubble);
						board.add(bubble);
						
						return true;
					}
				}, 10);
	}
}
