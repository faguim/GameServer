package control;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import com.sun.jersey.api.json.JSONWithPadding;

import dao.MedicalCaseDAO;
import model.Action;
import model.MedicalCase;
import model.State;

@Path("")
public class RestService {

	MedicalCaseDAO caseDAO = new MedicalCaseDAO();
	
	@GET
	@Path("/case/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCase(@PathParam("id") int id) {
		MedicalCase medicalCase = caseDAO.findById(MedicalCase.class, id);
		
		return Response.ok()
				.entity(medicalCase)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	
	@GET
	@Path("/cases")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCases() {
		List<MedicalCase> cases = new ArrayList<>();

		cases = caseDAO.findAll(MedicalCase.class);
		GenericEntity< List<MedicalCase> > casesReturn = new GenericEntity<List<MedicalCase>>(cases){};
		
		return Response.ok()
				.entity(casesReturn)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();

//		return medicalCase;
	}
	
	public Response getAlternativeStates(@PathParam("text") String text) {
		List<String> altStates = new ArrayList<>();

		
		
		GenericEntity<List<String>> altStatesReturn = new GenericEntity<List<String>>(altStates){};
		
		return Response.ok()
				.entity(altStatesReturn)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
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
		medicalCase.setWon_text(medicalcaseJSON.getString("won_text"));
		medicalCase.setLost_text(medicalcaseJSON.getString("lost_text"));
		medicalCase.setRandomize_actions(medicalcaseJSON.getBoolean("randomize_actions"));
		medicalCase.setAllow_negative_score(medicalcaseJSON.getBoolean("allow_negative_score"));
		medicalCase.setTimeout(medicalcaseJSON.getInt("timeout"));

		JSONArray states = medicalcaseJSON.getJSONArray("states");
        for (int i = 0; i < states.length(); i++) {
        	State state = new State();
        	
        	state.setTitle(states.getJSONObject(i).getString("title"));
        	state.setDescription(states.getJSONObject(i).getString("description"));
        	state.setFeedback(states.getJSONObject(i).getString("feedback"));
//        	state.setIdent(states.getJSONObject(i).getInt("ident"));
        	
            JSONArray actions = states.getJSONObject(i).getJSONArray("actions");
            
            for (int j = 0; j < actions.length(); j++) {
            	Action action = new Action();
            	action.setCorrect(actions.getJSONObject(j).getBoolean("correct"));
            	action.setProceed(actions.getJSONObject(j).getBoolean("proceed"));
            	action.setText(actions.getJSONObject(j).getString("text"));
            	action.setTarget(actions.getJSONObject(j).getInt("target"));
            	
            	state.getActions().add(action);
            	action.setState(state);
			}
            
            medicalCase.getStates().add(state);
            state.setMedicalCase(medicalCase);
        }
        
//        for (int i = 0; i < states.length(); i++) {
//            JSONArray actions = states.getJSONObject(i).getJSONArray("actions");
//            for (int j = 0; j < actions.length(); j++) {
//            	State target = medicalCase.getStates().get();
//            	medicalCase.getStates().get(i).getActions().get(j).setTarget(target);
//			}
//        }
        
        System.out.println(medicalCase);
        
		caseDAO.save(medicalCase);
		caseDAO.stopOperation(true);
//		caseDAO.closeConnection();
		return Response.ok()
				.entity(medicalCaseParam)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}
	@GET
	@Path("/casejsonp")
    @Produces({ "application/x-javascript", MediaType.APPLICATION_JSON + ";charset=utf-8" })
	public JSONWithPadding getCaseJSONP(@QueryParam("callback") String callback) {
		Integer id = 1;
		
		MedicalCase medicalCase = caseDAO.findById(MedicalCase.class, id);

        return new JSONWithPadding(new GenericEntity<MedicalCase>(medicalCase) {}, callback);
	}

}
