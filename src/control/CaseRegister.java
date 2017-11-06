package control;

import java.util.Arrays;
import java.util.List;

import dao.MedicalCaseDAO;
import model.Action;
import model.MedicalCase;
import model.State;

public class CaseRegister {
	MedicalCaseDAO caseDAO = new MedicalCaseDAO();

	public static void main(String[] args) {
		CaseRegister caseRegister = new CaseRegister();
		caseRegister.register();
	}

	public void register() {
		// Sets the title and description of a question
		State q0 = new State("",
				"Female patient, 54 years old, with shortness of breath in the last 5 hours.");

		// Sets the possible answers and respective feedbacks
		Action q0A1 = new Action("Take an immediate action", "Alright. Let us see what you can do", Action.CORRECT);
		Action q0A2 = new Action("Examine the patient", "Your patient does not have conditions to be examined");
		Action q0A3 = new Action("Point of care ultrasound",
				"Your patient does not have conditions to be examined");
		Action q0A4 = new Action("Diagnose", "Better saving the patient than diagnosing the disease now");

		// Adds the possibles answers to the questions
		addAnswers(Arrays.asList(q0A1, q0A2, q0A3, q0A4), q0);
		// Adds the score values to the questions
		addScores(10, 5, -5, q0);

		State q1 = new State("", "Which action are you going to take?");

		Action q1A1 = new Action("Provide oxygen by a mask", "The patient feels better", Action.CORRECT);
		Action q1A2 = new Action("Immediate assessment",
				"Patient conscious. Regular abdominal movements. Breathing by mouth", Action.SEMI_CORRECT);
		Action q1A3 = new Action("Provide mechanical ventilation", "An oxygen mask is enough");
		Action q1A4 = new Action("Provide an oxygen catheter", "The patient is still with shortness of breath");

		addAnswers(Arrays.asList(q1A1, q1A2, q1A3, q1A4), q1);
		addScores(10, 5, -5, q1);

		// Sets the title and description of a question
		State q2 = new State("", "What now? *-*");

		// Sets the possible answers and respective feedbacks
		Action q2A1 = new Action("Take an immediate action", "Again?");
		Action q2A2 = new Action("Examine the patient", "Alright. Let us see what you can do", Action.CORRECT);
		Action q2A3 = new Action("Point of care ultrasound",
				"Your patient does not have conditions to be examined");
		Action q2A4 = new Action("Diagnose", "Better saving the patient than diagnosing the disease now");

		// Adds the possibles answers to the questions
		addAnswers(Arrays.asList(q2A1, q2A2, q2A3, q2A4), q2);
		// Adds the score values to the questions
		addScores(10, 5, -5, q2);

		State q3 = new State("", "What kind of exam?");

		Action q3A1 = new Action("Physical exam", "No cough, sputum, chest pain or fever", Action.CORRECT);
		Action q3A2 = new Action("History exam", "History of arterial hypertension with irregular treatment",
				Action.CORRECT);
		Action q3A3 = new Action("Vital signs exam",
				"BP = 224 x 122 mmHg. HR = 108 b/min. RR = 33 r/min. O2 Sat =93%", Action.CORRECT);
		Action q3A4 = new Action("Diabetes exam", "Really? Why did you think that?");

		addAnswers(Arrays.asList(q3A1, q3A2, q3A3, q3A4), q3);
		addScores(10, 5, -5, q3);

		State q4 = new State("", "Investigate more");

		Action q4A1 = new Action("Physical exam", "No cough, sputum, chest pain or fever", Action.CORRECT);
		Action q4A2 = new Action("History exam", "History of arterial hypertension with irregular treatment",
				Action.CORRECT);
		Action q4A3 = new Action("Vital signs exam",
				"BP = 224 x 122 mmHg. HR = 108 b/min. RR = 33 r/min. O2 Sat =93%", Action.CORRECT);
		Action q4A4 = new Action("Guthrie exam", "Really? Why did you think that?");

		addAnswers(Arrays.asList(q4A1, q4A2, q4A3, q4A4), q4);
		addScores(10, 5, -5, q4);

		State q5 = new State("", "Investigate even more");

		Action q5A1 = new Action("Physical exam", "No cough, sputum, chest pain or fever", Action.CORRECT);
		Action q5A2 = new Action("History exam", "History of arterial hypertension with irregular treatment",
				Action.CORRECT);
		Action q5A3 = new Action("Vital signs exam",
				"BP = 224 x 122 mmHg. HR = 108 b/min. RR = 33 r/min. O2 Sat =93%", Action.CORRECT);
		Action q5A4 = new Action("Urine exam", "Really? Why did you think that?");

		addAnswers(Arrays.asList(q5A1, q5A2, q5A3, q5A4), q5);
		addScores(10, 5, -5, q5);

		// Sets the title and description of a question
		State q6 = new State("", "What now? *-*");

		// Sets the possible answers and respective feedbacks
		Action q6A1 = new Action("Take an immediate action", "Again?");
		Action q6A2 = new Action("Examine the patient", "Once more?");
		Action q6A3 = new Action("Point of care ultrasound", "Alright. Let us see what you can do", Action.CORRECT);
		Action q6A4 = new Action("Diagnose", "Better saving the patient than diagnosing the disease now");

		// Adds the possibles answers to the questions
		addAnswers(Arrays.asList(q6A1, q6A2, q6A3, q6A4), q6);
		// Adds the score values to the questions
		addScores(10, 5, -5, q6);

		State q7 = new State("", "Which US combination do you want to see?");

		Action q7A1 = new Action("Pulmonary + cardiac?", "Pulmonary US shows diffuse B lines. Cardiac US is normal",
				Action.CORRECT);
		Action q7A2 = new Action("Cardiac + foot?", "Nope. Do not do it with yourself");
		Action q7A3 = new Action("Head + foot?", "Nope. Do not do it with yourself");
		Action q7A4 = new Action("Brain + hand?", "Nope. Do not do it with yourself");

		addAnswers(Arrays.asList(q7A1, q7A2, q7A3, q7A4), q7);
		addScores(10, 5, -5, q7);

		State q8 = new State("", "Which one is the correct diagnosis?");

		Action q8A1 = new Action("Cardiogenic pulmonary edema", "Nice! Go ahead", Action.CORRECT);
		Action q8A2 = new Action("Left side heart failure", "You are so wrong, child!");
		Action q8A3 = new Action("Pulmonary hipertension", "You are so wrong, child!");
		Action q8A4 = new Action("Pneumothorax", "You are so wrong, child!");

		addAnswers(Arrays.asList(q8A1, q8A2, q8A3, q8A4), q8);
		addScores(10, 5, -5, q8);

		State q9 = new State("", "Which one(s) is/are the correct treatment(s)?");

		Action q9A1 = new Action("Administrate bolus morphine and sodium nitruprusside in continuous infusion",
				"Correct! That is my boy", Action.CORRECT);
		Action q9A2 = new Action("Provide non invasive ventilation", "Great! Anything else?", Action.SEMI_CORRECT);
		Action q9A3 = new Action("Needle or chest tube insertion", "Jes! Please, be smarter!");
		Action q9A4 = new Action("Let the time run and the patient die", "Jes! Please, be smarter!");

		addAnswers(Arrays.asList(q9A1, q9A2, q9A3, q9A4), q9);
		addScores(10, 5, -5, q9);

		caseDAO.startOperation();

		MedicalCase medicalCase = caseDAO.findByName("Respiratory Failure");
		if (medicalCase == null){
			medicalCase = new MedicalCase();
			medicalCase.setName("Respiratory Failure");
			medicalCase.setTimeout(10);
		}

		addQuestions(Arrays.asList(q0, q1, q2, q3, q4, q5, q6, q7, q8, q9), medicalCase);
		System.out.println(medicalCase);
		caseDAO.save(medicalCase);
		caseDAO.stopOperation(true);
		System.out.println("foi");
	}

	public void addAnswers(List<Action> answers, State question) {
		for (Action a : answers) {
			question.getAnswers().add(a);
			a.setQuestion(question);
		}
	}

	public void addScores(int right, int semiRight, int wrong, State question) {
		question.setRight_score(right);
		question.setSemi_right_score(semiRight);
		question.setWrong_score(wrong);
	}

	public void addQuestions(List<State> questions, MedicalCase c) {
		for (State q : questions) {
			c.getQuestions().add(q);
			q.setMedicalCase(c);
		}
	}
}
