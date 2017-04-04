package it.bubble.game.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {
	public void salvaPunteggio(String nome, int punteggio);
	String greetServer(String name) throws IllegalArgumentException;
}
