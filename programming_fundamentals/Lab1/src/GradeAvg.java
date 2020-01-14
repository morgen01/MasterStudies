// ***********************************************************************
// GradeAvg.java			Author: Christina
//
// Computation of average examination scores.
// **********************************************************************

public class GradeAvg {

	// -----------------------------------------------------------------
	// Computes the average quiz and test scores.
	// -----------------------------------------------------------------

	public static void main(String[] args) {

		double quizScore1, quizScore2, quizScore3, testScore1, testScore2, quizScoreAvg, testScoreAvg;

		quizScore1 = 10;
		quizScore2 = 10;
		quizScore3 = 10;
		testScore1 = 10;
		testScore2 = 10;

		quizScoreAvg = (quizScore1 + quizScore2 + quizScore3) / 3;
		testScoreAvg = (testScore1 + testScore2) / 2;

		System.out.println("The average quiz score is: " + quizScoreAvg);
		System.out.println("The average test score is: " + testScoreAvg);

	}

}
