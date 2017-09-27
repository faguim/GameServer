package control;

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
			Question question1 = new Question("Start", "<b>Question 1 title</b> <br/> Female patient, 54 years old, with shortness of breath in the last 5 hours.");
			Question question2 = new Question("Meio", "Blablablabla.");

			Answer answer1 = new Answer("Provide oxygen by a mask", "The patient feels better", Answer.CORRECT);
			Answer answer2 = new Answer("Immediate assessment", "Patient conscious.<br/> Regular abdominal movements. <br/> Breathing by mouth", Answer.SEMI_CORRECT);
			Answer answer3 = new Answer("Provide mechanical ventilation", "An oxygen mask is enough");
			Answer answer4 = new Answer("Provide an oxygen catheter", "The patient is still with shortness of breath");
//			Answer answer5 = new Answer("Examine the patient", "Your patient does not have conditions to be examined");
//			Answer answer6 = new Answer("Point of care ultrasound", "The patient is still with shortness of breath");
//			Answer answer7 = new Answer("Diagnose", "If you consider that you have all elements to emit a final diagnosis, please select one of the options");

			question1.getAnswers().add(answer1);question1.getAnswers().add(answer2);question1.getAnswers().add(answer3);
			question1.getAnswers().add(answer4);
//			state.getAnswers().add(answer5);state.getAnswers().add(answer6);
//			state.getAnswers().add(answer7);
			
			question1.setRight_score(10);
			question1.setSemi_right_score(5);
			question1.setWrong_score(-5);
			
			question2.getAnswers().add(answer1);question2.getAnswers().add(answer3);
			question2.setRight_score(8);
			question2.setSemi_right_score(3);
			question2.setWrong_score(-7);
			
			
			Case case1 = new Case();
			case1.getQuestions().add(question1);
			case1.getQuestions().add(question2);
			case1.setTimeout(10);

			return case1;
		} catch (Exception e) {
			throw new WebApplicationException(e, 500);
		}
	}
}
