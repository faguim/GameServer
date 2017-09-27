package control;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import model.Answer;
import model.Case;
import model.Question;

@Path("")
public class RestService {

	@GET
	@Path("/case/{id}")
	@Produces(MediaType.APPLICATION_JSON)

	public Case getCase(@PathParam("id") Integer id) {
		try {

			// Sets the title and description of a question
			Question q0 = new Question("Scenario: what is happening?",
					"Female patient, 54 years old, with shortness of breath in the last 5 hours.");

			// Sets the possible answers and respective feedbacks
			Answer q0A1 = new Answer("Take an immediate action", "Alright. Let us see what you can do", Answer.CORRECT);
			Answer q0A2 = new Answer("Examine the patient", "Your patient does not have conditions to be examined");
			Answer q0A3 = new Answer("Point of care ultrasound",
					"Your patient does not have conditions to be examined");
			Answer q0A4 = new Answer("Diagnose", "Better saving the patient than diagnosing the disease now");

			// Adds the possibles answers to the questions
			addAnswers(Arrays.asList(q0A1, q0A2, q0A3, q0A4), q0);
			// Adds the score values to the questions
			addScores(10, 5, -5, q0);

			Question q1 = new Question("Act I: Save the patient", "Which action are you going to take?");

			Answer q1A1 = new Answer("Provide oxygen by a mask", "The patient feels better", Answer.CORRECT);
			Answer q1A2 = new Answer("Immediate assessment",
					"Patient conscious. Regular abdominal movements. Breathing by mouth", Answer.SEMI_CORRECT);
			Answer q1A3 = new Answer("Provide mechanical ventilation", "An oxygen mask is enough");
			Answer q1A4 = new Answer("Provide an oxygen catheter", "The patient is still with shortness of breath");

			addAnswers(Arrays.asList(q1A1, q1A2, q1A3, q1A4), q1);
			addScores(10, 5, -5, q1);

			Case case1 = new Case();
			addQuestions(Arrays.asList(q0, q1), case1);

			return case1;
		} catch (Exception e) {
			throw new WebApplicationException(e, 500);
		}
	}

	public void addAnswers(List<Answer> answers, Question question) {
		for (Answer a : answers) {
			question.getAnswers().add(a);
		}
	}

	public void addScores(int right, int semiRight, int wrong, Question question) {
		question.setRight_score(right);
		question.setSemi_right_score(semiRight);
		question.setWrong_score(wrong);
	}

	public void addQuestions(List<Question> questions, Case c) {
		for (Question q : questions) {
			c.getQuestions().add(q);
		}
	}
}
