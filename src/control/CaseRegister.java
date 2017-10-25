package control;

import java.util.Arrays;
import java.util.List;

import dao.MedicalCaseDAO;
import model.Answer;
import model.MedicalCase;
import model.Question;

public class CaseRegister {
	MedicalCaseDAO caseDAO = new MedicalCaseDAO();

	public static void main(String[] args) {
		CaseRegister caseRegister = new CaseRegister();
		caseRegister.register();
	}

	public void register() {
		// Sets the title and description of a question
		Question q0 = new Question("",
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

		Question q1 = new Question("", "Which action are you going to take?");

		Answer q1A1 = new Answer("Provide oxygen by a mask", "The patient feels better", Answer.CORRECT);
		Answer q1A2 = new Answer("Immediate assessment",
				"Patient conscious. Regular abdominal movements. Breathing by mouth", Answer.SEMI_CORRECT);
		Answer q1A3 = new Answer("Provide mechanical ventilation", "An oxygen mask is enough");
		Answer q1A4 = new Answer("Provide an oxygen catheter", "The patient is still with shortness of breath");

		addAnswers(Arrays.asList(q1A1, q1A2, q1A3, q1A4), q1);
		addScores(10, 5, -5, q1);

		// Sets the title and description of a question
		Question q2 = new Question("", "What now? *-*");

		// Sets the possible answers and respective feedbacks
		Answer q2A1 = new Answer("Take an immediate action", "Again?");
		Answer q2A2 = new Answer("Examine the patient", "Alright. Let us see what you can do", Answer.CORRECT);
		Answer q2A3 = new Answer("Point of care ultrasound",
				"Your patient does not have conditions to be examined");
		Answer q2A4 = new Answer("Diagnose", "Better saving the patient than diagnosing the disease now");

		// Adds the possibles answers to the questions
		addAnswers(Arrays.asList(q2A1, q2A2, q2A3, q2A4), q2);
		// Adds the score values to the questions
		addScores(10, 5, -5, q2);

		Question q3 = new Question("", "What kind of exam?");

		Answer q3A1 = new Answer("Physical exam", "No cough, sputum, chest pain or fever", Answer.CORRECT);
		Answer q3A2 = new Answer("History exam", "History of arterial hypertension with irregular treatment",
				Answer.CORRECT);
		Answer q3A3 = new Answer("Vital signs exam",
				"BP = 224 x 122 mmHg. HR = 108 b/min. RR = 33 r/min. O2 Sat =93%", Answer.CORRECT);
		Answer q3A4 = new Answer("Diabetes exam", "Really? Why did you think that?");

		addAnswers(Arrays.asList(q3A1, q3A2, q3A3, q3A4), q3);
		addScores(10, 5, -5, q3);

		Question q4 = new Question("", "Investigate more");

		Answer q4A1 = new Answer("Physical exam", "No cough, sputum, chest pain or fever", Answer.CORRECT);
		Answer q4A2 = new Answer("History exam", "History of arterial hypertension with irregular treatment",
				Answer.CORRECT);
		Answer q4A3 = new Answer("Vital signs exam",
				"BP = 224 x 122 mmHg. HR = 108 b/min. RR = 33 r/min. O2 Sat =93%", Answer.CORRECT);
		Answer q4A4 = new Answer("Guthrie exam", "Really? Why did you think that?");

		addAnswers(Arrays.asList(q4A1, q4A2, q4A3, q4A4), q4);
		addScores(10, 5, -5, q4);

		Question q5 = new Question("", "Investigate even more");

		Answer q5A1 = new Answer("Physical exam", "No cough, sputum, chest pain or fever", Answer.CORRECT);
		Answer q5A2 = new Answer("History exam", "History of arterial hypertension with irregular treatment",
				Answer.CORRECT);
		Answer q5A3 = new Answer("Vital signs exam",
				"BP = 224 x 122 mmHg. HR = 108 b/min. RR = 33 r/min. O2 Sat =93%", Answer.CORRECT);
		Answer q5A4 = new Answer("Urine exam", "Really? Why did you think that?");

		addAnswers(Arrays.asList(q5A1, q5A2, q5A3, q5A4), q5);
		addScores(10, 5, -5, q5);

		// Sets the title and description of a question
		Question q6 = new Question("", "What now? *-*");

		// Sets the possible answers and respective feedbacks
		Answer q6A1 = new Answer("Take an immediate action", "Again?");
		Answer q6A2 = new Answer("Examine the patient", "Once more?");
		Answer q6A3 = new Answer("Point of care ultrasound", "Alright. Let us see what you can do", Answer.CORRECT);
		Answer q6A4 = new Answer("Diagnose", "Better saving the patient than diagnosing the disease now");

		// Adds the possibles answers to the questions
		addAnswers(Arrays.asList(q6A1, q6A2, q6A3, q6A4), q6);
		// Adds the score values to the questions
		addScores(10, 5, -5, q6);

		Question q7 = new Question("", "Which US combination do you want to see?");

		Answer q7A1 = new Answer("Pulmonary + cardiac?", "Pulmonary US shows diffuse B lines. Cardiac US is normal",
				Answer.CORRECT);
		Answer q7A2 = new Answer("Cardiac + foot?", "Nope. Do not do it with yourself");
		Answer q7A3 = new Answer("Head + foot?", "Nope. Do not do it with yourself");
		Answer q7A4 = new Answer("Brain + hand?", "Nope. Do not do it with yourself");

		addAnswers(Arrays.asList(q7A1, q7A2, q7A3, q7A4), q7);
		addScores(10, 5, -5, q7);

		Question q8 = new Question("", "Which one is the correct diagnosis?");

		Answer q8A1 = new Answer("Cardiogenic pulmonary edema", "Nice! Go ahead", Answer.CORRECT);
		Answer q8A2 = new Answer("Left side heart failure", "You are so wrong, child!");
		Answer q8A3 = new Answer("Pulmonary hipertension", "You are so wrong, child!");
		Answer q8A4 = new Answer("Pneumothorax", "You are so wrong, child!");

		addAnswers(Arrays.asList(q8A1, q8A2, q8A3, q8A4), q8);
		addScores(10, 5, -5, q8);

		Question q9 = new Question("", "Which one(s) is/are the correct treatment(s)?");

		Answer q9A1 = new Answer("Administrate bolus morphine and sodium nitruprusside in continuous infusion",
				"Correct! That is my boy", Answer.CORRECT);
		Answer q9A2 = new Answer("Provide non invasive ventilation", "Great! Anything else?", Answer.SEMI_CORRECT);
		Answer q9A3 = new Answer("Needle or chest tube insertion", "Jes! Please, be smarter!");
		Answer q9A4 = new Answer("Let the time run and the patient die", "Jes! Please, be smarter!");

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

	public void addAnswers(List<Answer> answers, Question question) {
		for (Answer a : answers) {
			question.getAnswers().add(a);
			a.setQuestion(question);
		}
	}

	public void addScores(int right, int semiRight, int wrong, Question question) {
		question.setRight_score(right);
		question.setSemi_right_score(semiRight);
		question.setWrong_score(wrong);
	}

	public void addQuestions(List<Question> questions, MedicalCase c) {
		for (Question q : questions) {
			c.getQuestions().add(q);
			q.setMedicalCase(c);
		}
	}
}
