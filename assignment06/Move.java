package assignment06;

public class Move implements Command {
	int iccf; // from*100+to
	int undoICCF; // to*100+from
	Board board;
	public Move (Board brd, int i) {
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
		board.setPiece(to, p); // put the piece on the "to" square
	}

	@Override
	public void undo() {
		int from = undoICCF / 100; // Extract the original "from" position
		int to = undoICCF % 100; // Extract the original "to" position
		Piece p = board.getPiece(to); // Get the piece currently on the "to" square
		board.setPiece(to, board.piece.get("--")); // Replace it with a non-piece
		board.setPiece(from, p); // Move the piece back to the "from" square
	}

}
