public class User {
	private static String name;
	private static int score;
	private static int HPNum;

	public static String getName() {
		return name;
	}

	public static void setName(String name) {
		User.name = name;
	}

	public static int getScore() {
		return score;
	}

	public static void setScore(int score) {
		User.score = score;
	}

	public static int getHPNum() {
		return HPNum;
	}

	public static void setHPNum(int HPNum) {
		User.HPNum = HPNum;
	}
}