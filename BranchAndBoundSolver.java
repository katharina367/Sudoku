
public class BranchAndBoundSolver implements SolvingStrategy {

	
	@Override
	public boolean solve(Sudoku b, int index) {
		if(index == b.getBoardSize() * b.getBoardSize()) return b.checkBoard();
		if(b.getBoardEntry(index) == 0) {
			for(int j = 1; j <= b.getBoardSize(); j++) {
				b.setBoardEntry(index, j);
				if(b.checkBoard()) {
					if(solve(b, index + 1)) return true;
				}
			}
			b.setBoardEntry(index, 0);
			return false;
		}
		return solve(b, index + 1);

	}
	
}
