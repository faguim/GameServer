package control;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.MedicalCaseDAO;
import model.MedicalCase;

@Path("")
public class RestService {

	MedicalCaseDAO caseDAO = new MedicalCaseDAO();
	
	@GET
	@Path("/case")
	@Produces(MediaType.APPLICATION_JSON)
	public MedicalCase getCase() {
		Integer id = 1;
		
		MedicalCase medicalCase = caseDAO.findById(MedicalCase.class, id);
		return medicalCase;
	}
}
