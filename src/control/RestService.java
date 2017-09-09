package control;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.json.JSONWithPadding;

import model.Case;
import model.State;
import model.Transition;

@Path("/intern")
public class RestService {

	@GET
	@Path("/case/{id}")
	@Produces({ "application/x-javascript", MediaType.APPLICATION_JSON + ";charset=utf-8" })
	public JSONWithPadding getRotaDaLinha(@QueryParam("callback") String callback, @PathParam("id") Integer id) {
		try {
			Transition transition1 = new Transition("provide suplementary oxygen", "_DgftMJQEEeeeCKuK8FE38Q", "_sKdeEJQHEeeeCKuK8FE38Q");
			Transition transition2 = new Transition("other", "_DgftMJQEEeeeCKuK8FE38Q", "_4UcPAJQEEeeeCKuK8FE38Q");
			Transition transition3 = new Transition("check history", "_sKdeEJQHEeeeCKuK8FE38Q", "_dTzWYJQIEeeeCKuK8FE38Q");
			Transition transition4 = new Transition("_dTzWYJQIEeeeCKuK8FE38Q", "_sKdeEJQHEeeeCKuK8FE38Q");
			Transition transition5 = new Transition("_sKdeEJQHEeeeCKuK8FE38Q", "_AIF0sJQJEeeeCKuK8FE38Q");
			Transition transition6 = new Transition("_AIF0sJQJEeeeCKuK8FE38Q", "_sKdeEJQHEeeeCKuK8FE38Q");
			Transition transition7 = new Transition("edema diagnosis", "_sKdeEJQHEeeeCKuK8FE38Q", "_bRE0MJQJEeeeCKuK8FE38Q");
			Transition transition8 = new Transition("_sKdeEJQHEeeeCKuK8FE38Q", "_rRRhYJQJEeeeCKuK8FE38Q");
			Transition transition9 = new Transition("apply non invasive ventilation", "_bRE0MJQJEeeeCKuK8FE38Q", "_7MKQwJQJEeeeCKuK8FE38Q");
			
			List<Transition> transitions = new ArrayList<>();
			transitions.add(transition1);
			transitions.add(transition2);transitions.add(transition3);transitions.add(transition4);transitions.add(transition5);
			transitions.add(transition6);transitions.add(transition7);transitions.add(transition8);transitions.add(transition9);

			State state1 = new State("_DgftMJQEEeeeCKuK8FE38Q", "Start", "Female patient, 54 years old, with shortness of breath in the last 5 hours.");
			State state2 = new State("_4UcPAJQEEeeeCKuK8FE38Q", "Patient Dead");
			State state3 = new State("_sKdeEJQHEeeeCKuK8FE38Q", "Under Assessment");
			State state4 = new State("_dTzWYJQIEeeeCKuK8FE38Q", "Patient History");
			State state5 = new State("_AIF0sJQJEeeeCKuK8FE38Q", "Ultrasound");
			State state6 = new State("_bRE0MJQJEeeeCKuK8FE38Q", "Right Diagnosis");
			State state7 = new State("_rRRhYJQJEeeeCKuK8FE38Q", "Wrong Diagnosis");
			State state8 = new State("_7MKQwJQJEeeeCKuK8FE38Q", "Non Invasive Ventilation");

			List<State> states = new ArrayList<>();
			states.add(state1);
			states.add(state2);states.add(state3);states.add(state4);states.add(state5);
			states.add(state6);states.add(state7);states.add(state8);

			Case case1 = new Case();
			case1.setTransitions(transitions);
			case1.setStates(states);
			
			return new JSONWithPadding(new GenericEntity<Case>(case1) {
			}, callback);
		} catch (Exception e) {
			throw new WebApplicationException(e, 500);
		}
	}
}
