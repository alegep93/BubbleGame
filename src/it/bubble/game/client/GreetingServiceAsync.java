package it.bubble.game.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {
	void salvaPunteggio(String nome, int punteggio, AsyncCallback<Void> callback);
	void greetServer(String input, AsyncCallback<String> callback) throws IllegalArgumentException;
}
