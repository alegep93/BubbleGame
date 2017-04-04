package it.bubble.game.client;


import com.google.web.bindery.event.shared.Event;

@SuppressWarnings("unused")
public class BollaClickataEvent extends Event<BollaClickataEvent.Handler> {
	
	public static final Type<BollaClickataEvent.Handler> TYPE = new Type<>();
	private Bubble bubble;
	
	public interface Handler {
		public void onBubbleClickata(BollaClickataEvent bce);
	}

	public BollaClickataEvent(Bubble bubble) {
		this.bubble = bubble;
	}
	
	@Override
	public Type<BollaClickataEvent.Handler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(Handler handler) {
		handler.onBubbleClickata(this);
	}
}
