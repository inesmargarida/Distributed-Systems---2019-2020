package pt.ulisboa.tecnico.distsys.ttt.contract;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PlayRequest {
	private int row;
	private int column;
	private int player;
	
	public PlayRequest() {}
	
	public PlayRequest(int row, int column, int player) {
		this.row = row;
		this.column = column;
		this.player = player;
	}
	
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	public int getPlayer() {
		return player;
	}
	public void setPlayer(int player) {
		this.player = player;
	}
	
}

