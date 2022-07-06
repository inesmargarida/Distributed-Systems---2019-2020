package pt.ulisboa.tecnico.distsys.ttt.server;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import pt.ulisboa.tecnico.distsys.ttt.contract.PlayResult;
import pt.ulisboa.tecnico.distsys.ttt.contract.PlayRequest;

/**
 * Root resource (exposed at "game" path)
 */
@Path("game")
public class TTTResources {
	
	/**
	 * 
	 * TTTGame currently being played
	 * 
	 */
	static TTTGame game = new TTTGame();

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return Board that will be returned as a text/plain response.
     */ 
    @GET
    @Path("board")
    @Produces(MediaType.TEXT_PLAIN)
    public String getBoard() {
    	return game.toString();
    }
    
    
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return Board that will be returned as a text/plain response.
     */
    @GET
    @Path("board/reset")
    @Produces(MediaType.TEXT_PLAIN)
    public String resetBoard() {
        game.resetBoard();
        return game.toString();
    }

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return Winner loser.
     */
    @GET
    @Path("board/checkwinner")
    @Produces(MediaType.TEXT_PLAIN)
    public String checkWinner() {
        return Integer.toString(game.checkWinner());
    }


    @POST
    @Path("play")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PlayResult play(PlayRequest playRequest) {
        return game.play(playRequest.getRow(), playRequest.getColumn(), playRequest.getPlayer());
    }

    @GET
    @Path("play/{arg1}/{arg2}/{arg3}")
    @Produces(MediaType.APPLICATION_JSON)
    public PlayResult play(@PathParam("arg1") int arg1,
                                @PathParam("arg2") int arg2,
                                @PathParam("arg3") int arg3) {
        return game.play(arg1, arg2, arg3);
    }

    @GET
    @Path("trocaSimbolos")
    @Produces(MediaType.TEXT_PLAIN)
    public String trocaSimbolos(){
        game.trocaSimbolos();
        return game.toString();
    }
}
