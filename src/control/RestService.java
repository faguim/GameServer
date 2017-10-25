package control;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import com.sun.jersey.api.json.JSONWithPadding;

import dao.MedicalCaseDAO;
import model.Answer;
import model.MedicalCase;
import model.Question;

@Path("")
public class RestService {

	MedicalCaseDAO caseDAO = new MedicalCaseDAO();
	
	@GET
	@Path("/case")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCase() {
		System.out.println("asdasudyasdyuasud");
		Integer id = 1;
		MedicalCase medicalCase = caseDAO.findById(MedicalCase.class, id);
		
		return Response.ok()
				.entity(medicalCase)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();

//		return medicalCase;
	}
	
	@GET
	@Path("/casejsonp")
    @Produces({ "application/x-javascript", MediaType.APPLICATION_JSON + ";charset=utf-8" })
	public JSONWithPadding getCaseJSONP(@QueryParam("callback") String callback) {
		Integer id = 1;
		
		MedicalCase medicalCase = caseDAO.findById(MedicalCase.class, id);
        return new JSONWithPadding(new GenericEntity<MedicalCase>(medicalCase) {}, callback);
	}
	
	@POST
	@Path("/case/save")
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveCase(String medicalCaseParam) {
		caseDAO.startOperation();

		System.out.println(medicalCaseParam);
		JSONObject medicalcaseJSON = new JSONObject(medicalCaseParam);
		MedicalCase medicalCase = new MedicalCase();
		
		medicalCase.setName(medicalcaseJSON.getString("name"));
		medicalCase.setConclusion_won_text(medicalcaseJSON.getString("won_text"));
		medicalCase.setConclusion_lost_text(medicalcaseJSON.getString("lost_text"));
		medicalCase.setRandomize_answer_order(medicalcaseJSON.getBoolean("randomize_answer"));
		medicalCase.setRandomize_question_order(medicalcaseJSON.getBoolean("randomize_question"));
		medicalCase.setAllow_negative_score(medicalcaseJSON.getBoolean("allow_negative_score"));
		medicalCase.setTimeout(10);

		JSONArray questions = medicalcaseJSON.getJSONArray("questions");
        for (int i = 0; i < questions.length(); i++) {
        	Question question = new Question();
        	
        	question.setTitle(questions.getJSONObject(i).getString("title"));
        	question.setDescription(questions.getJSONObject(i).getString("description"));

        	question.setRight_score(questions.getJSONObject(i).getInt("right_score"));
            question.setSemi_right_score(questions.getJSONObject(i).getInt("semi_right_score"));
            question.setWrong_score(questions.getJSONObject(i).getInt("wrong_score"));

            question.setIncorrect_feedback_text(questions.getJSONObject(i).getString("incorrect_feedback"));
            question.setCorrect_feedback_text(questions.getJSONObject(i).getString("correct_feedback"));
            
            JSONArray jsonArray = questions.getJSONObject(i).getJSONArray("answers");
            
            for (int j = 0; j < jsonArray.length(); j++) {
            	Answer answer = new Answer();
            	answer.setCorrectness(jsonArray.getJSONObject(j).getInt("correctness"));
            	answer.setFeedback_text(jsonArray.getJSONObject(j).getString("feedback_text"));
            	answer.setText(jsonArray.getJSONObject(j).getString("text"));
            	
            	question.getAnswers().add(answer);
            	answer.setQuestion(question);
			}
            
            medicalCase.getQuestions().add(question);
            question.setMedicalCase(medicalCase);
        }
        
        System.out.println(medicalCase);
        
		caseDAO.save(medicalCase);
		caseDAO.stopOperation(true);
		
		return Response.ok()
				.entity(medicalCaseParam)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
}
