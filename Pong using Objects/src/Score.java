//
public class Score {
	private int left;
	private int right;
	private int num = 0;
	
	public int getLeftScore() {
		return left;
	}
	public int getRightScore() {
		return right;
	}
	public int getNumRounds() {
		return num;
	}
	public void leftScores() {
		this.num += 1;
		this.left += 1;
	}
	public void rightScores() {
		this.num += 1;
		this.right += 1;
	}
	public void resetRight() {
		this.right = 0;
	}
	public void resetLeft() {
		this.left = 0;
	}
	public Score() {
		left = 0;
		right = 0;
	}
	public Score(int newL, int newR) {
		left = newL;
		right = newR;
	}
}
