package assignment06;

public class Capture implements Command {
	int iccf;
	int undoICCF;
	Piece lost;
	Board board;
	public Capture (Board brd, int i) {
		iccf = i;
		board = brd;
		undoICCF = 100*(iccf % 100) + iccf/100;
	}

	@Override
	public void execute() {
		int from = iccf/100;
		int to = iccf%100;
		Piece p = board.getPiece(from); // get the piece currently on the "from" square
		board.setPiece(from, board.piece.get("--")); // replace it with a non-piece
		lost = board.getPiece(to); // store the piece that is taken in the command
		board.setPiece(to, p); // put the "from-piece" on the "to" square
	}

		@Override
	public void undo() {
		int from = undoICCF / 100; // Extract the original "from" position
		int to = undoICCF % 100; // Extract the original "to" position
		Piece p = board.getPiece(to); // Get the piece currently on the "to" square
		board.setPiece(to, lost); // Restore the lost piece to its original position
		board.setPiece(from, p); // Move the capturing piece back to the "from" square
	}

}