package ontologyenrichment;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

import dao.MedicalCaseDAO;
import model.MedicalCase;
import model.State;

public class Enrich {
	private static MedicalCaseDAO medicalCaseDAO = new MedicalCaseDAO();
	
	public static void main(String[] args) throws JSONException {
		medicalCaseDAO.startOperation();
		List<MedicalCase> medicalCases = medicalCaseDAO.findAll(MedicalCase.class);
		for (MedicalCase medicalCase : medicalCases) {
			
			for (State state : medicalCase.getStates()) {
				String params = "{text:'"+ state.getDescription() +"', similarity:0.7, ontology:hfo}";
				JSONObject jsonParams = new JSONObject(params);
				
				System.out.println(jsonParams);
				ClientConfig clientConfig = new DefaultClientConfig();
				clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
				
				Client client = Client.create(clientConfig);
				WebResource webResource = client.resource("http://ontomatch.lis.ic.unicamp.br/api/rest/resource");
				
				ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).post(ClientResponse.class, jsonParams);
				
				if (response.getStatus() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "+ response.getStatus());
				}
				String responseBody = response.getEntity(String.class);
				
				System.out.println("Response: " + responseBody);
				JSONObject responseJson = new JSONObject(responseBody);
				System.out.println("Response Json: "+ responseJson);
			}
			
			
			
			
		}
		medicalCaseDAO.stopOperation(false);
		medicalCaseDAO.closeConnection();
		
	}
}
