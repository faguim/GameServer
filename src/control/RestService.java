package control;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.json.JSONWithPadding;

import dao.MedicalCaseDAO;
import model.MedicalCase;

@Path("")
public class RestService {

	MedicalCaseDAO caseDAO = new MedicalCaseDAO();
	
	@GET
	@Path("/casejsonp")
	@Produces(MediaType.APPLICATION_JSON)
	public MedicalCase getCaseJSONP() {
		Integer id = 1;
		
		MedicalCase medicalCase = caseDAO.findById(MedicalCase.class, id);
		return medicalCase;
	}
	
	@GET
	@Path("/case")
    @Produces({ "application/x-javascript", MediaType.APPLICATION_JSON + ";charset=utf-8" })
	public JSONWithPadding getCase(@QueryParam("callback") String callback) {
		Integer id = 1;
		
		MedicalCase medicalCase = caseDAO.findById(MedicalCase.class, id);
        return new JSONWithPadding(new GenericEntity<MedicalCase>(medicalCase) {}, callback);
	}
}
