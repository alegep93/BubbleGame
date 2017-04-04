package it.bubble.game.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.RepeatingCommand;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootLayoutPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class BubbleGame implements EntryPoint {
	
	@Override
	public void onModuleLoad() {
		
		//Consente di comunicare in modo asincrono con il Server
		GreetingServiceAsync serv = GWT.create(GreetingService.class);
		serv.salvaPunteggio("Alessandro", 1000, new AsyncCallback<Void>() {
			
			@Override
			public void onSuccess(Void result) {
				
			}
			
			@Override
			public void onFailure(Throwable caught) {
				
			}
		});
		
		int score = 0;
		int vite = 10;
		SimpleEventBus bus = new SimpleEventBus();
		Board board = new Board(bus);

		ScoreBoard sb = new ScoreBoard(bus);
		sb.setScore(score);
		sb.setVite(vite);
		
		DockLayoutPanel dlp = new DockLayoutPanel(Unit.PX);
		dlp.addNorth(sb, 100);
		dlp.addSouth(new HTML(), 100);
		dlp.addEast(new HTML(), 100);
		dlp.addWest(new HTML(), 100);
		
		dlp.add(board);

		RootLayoutPanel.get().add(dlp);

		//Muove le bubble
		Scheduler.get().scheduleFixedDelay(new RepeatingCommand() {
					@Override
					public boolean execute() {
						board.moveBubbles();
						return true;
					}
				}, 10);

		//Fa nascere nuove bubble
		Scheduler.get().scheduleFixedDelay(new RepeatingCommand() {
					@Override
					public boolean execute() {
						int dimensione = (int)((Math.random() * 80) + 20);
						int posX = (int)(Math.random() * (board.getOffsetWidth() - 100));
						int posY = -100;
						
						if(board.size() < 300) {
							Bubble bubble = new Bubble(dimensione, posX, posY);
							board.addBubble(bubble);
						}
						return true;
					}
				}, 80);
	}
}
