package it.bubble.game.client;

import com.google.web.bindery.event.shared.Event;

public class BollaScappataEvent  extends Event<BollaScappataEvent.Handler> {
	public static final Type<BollaScappataEvent.Handler> TYPE = new Type<>();
	private Bubble bubble;
	
	public interface Handler {
		public void onBubbleScappata(BollaScappataEvent bce);
	}

	public BollaScappataEvent(Bubble bubble) {
		this.bubble = bubble;
	}
	
	@Override
	public Type<BollaScappataEvent.Handler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(Handler handler) {
		handler.onBubbleScappata(this);
	}
}
