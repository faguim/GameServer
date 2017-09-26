package control;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import model.Answer;
import model.Case;
import model.State;

@Path("")
public class RestService {

	@GET
	@Path("/case/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Case getRotaDaLinha(@PathParam("id") Integer id) {
		try {
			State state = new State("Start", "Female patient, 54 years old, with shortness of breath in the last 5 hours.");
			State state2 = new State("Meio", "Blablablabla.");

			Answer answer1 = new Answer("Provide oxygen by a mask", "The patient feels better");
			Answer answer2 = new Answer("Immediate assessment", "Patient conscious. Regular abdominal movements. Breathing by mouth");
			Answer answer3 = new Answer("Provide mechanical ventilation", "An oxygen mask is enough");
			Answer answer4 = new Answer("Provide an oxygen catheter", "The patient is still with shortness of breath");
//			Answer answer5 = new Answer("Examine the patient", "Your patient does not have conditions to be examined");
//			Answer answer6 = new Answer("Point of care ultrasound", "The patient is still with shortness of breath");
//			Answer answer7 = new Answer("Diagnose", "If you consider that you have all elements to emit a final diagnosis, please select one of the options");

			state.getAnswers().add(answer1);state.getAnswers().add(answer2);state.getAnswers().add(answer3);
			state.getAnswers().add(answer4);
//			state.getAnswers().add(answer5);state.getAnswers().add(answer6);
//			state.getAnswers().add(answer7);
			state.setCorrect_answer(0);
			state2.getAnswers().add(answer1);state2.getAnswers().add(answer2);state2.getAnswers().add(answer3);

			
			Case case1 = new Case();
			case1.getStates().add(state);
			case1.getStates().add(state2);

			return case1;
		} catch (Exception e) {
			throw new WebApplicationException(e, 500);
		}
	}
}
