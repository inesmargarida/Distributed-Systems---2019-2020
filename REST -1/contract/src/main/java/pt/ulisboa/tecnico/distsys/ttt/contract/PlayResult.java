package pt.ulisboa.tecnico.distsys.ttt.contract;

public enum PlayResult {
	UNKNOWN(0),
    OUT_OF_BOUNDS(1),
    SQUARE_TAKEN(2),
    WRONG_TURN(3),
    GAME_FINISHED(4),
    SUCCESS(5);
    
    public int _result;
    PlayResult(int result) {
        _result = result;
    }
}
