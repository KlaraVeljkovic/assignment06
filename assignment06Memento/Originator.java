package assignment06Memento;
  
import assignment06MEM.Board;

public class Originator {
	public Memento getMemento(Board board, int iccf) {
		return new MoveMemento(board, iccf);
	}	
	
	public void reset(Board board, Memento mem) {
        MoveMemento mmem = (MoveMemento) mem;
        int from = mmem.getIccf() / 100; // Extract "from" location
        int to = mmem.getIccf() % 100; // Extract "to" location
        board.setPiece(from, mmem.getFromPiece()); // Restore "from" piece
        board.setPiece(to, mmem.getToPiece()); // Restore "to" piece
    }
}
