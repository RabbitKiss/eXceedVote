package model;
import java.util.List;

import javax.persistence.*;



import exceedvote.domain.BallotType;
import exceedvote.domain.Question;
import exceedvote.domain.ScoreType;


public class DAO {
	 public static void main(String[] args){
		 
		 EntityManagerFactory factory = 
			     Persistence.createEntityManagerFactory("exceedVote"); 
			  EntityManager em = factory.createEntityManager(); 
			  EntityTransaction tx = em.getTransaction(); 
			  
//			  tx.begin();
////			  BallotType qb = new BallotType();
//			  ScoreType qs = new ScoreType();
//			  System.out.println("----------"+qs.getClass());
			  
//			  qb.setQuestion("Which team is the best technical team?");
//			  qb.setQuestionIndex(1);
//			  em.persist(qb);
			  
//			  qb.setQuestion("Which team is the best in coding?");
//			  qb.setQuestionIndex(2);
//			  em.persist(qb);
			  
//			  qb.setQuestion("Which team has the best user inteface?");
//			  qb.setQuestionIndex(3);
//			  em.persist(qb);		
			  
//			  qs.setQuestion("THIS IS SCORE");
//			  qs.setQuestionIndex(7);
//			  em.persist(qs);
//			  
//			  qs.setQuestion("Beautifull user interface");
//			  qs.setQuestionIndex(5);
//			  em.persist(qs);
			  
//			  qs.setQuestion("Team work");
//			  qs.setQuestionIndex(6);
//			  em.persist(qs);
//			  tx.commit();
			  
			  
//			  Temp java = new Temp();
//			  Testtable testTable = new Testtable();
//			  testTable.setGrade(4);
//			  testTable.setName("TEE");			  
//			  java.setName("RABBIT");
//			  BallotType ballotType = new BallotType();
//			  
//			  ballotType.setQuestion("Team work");
//			  ballotType.setQuestionIndex(6);
//			  tx.begin();
//			  //em.persist(java);
//			  em.persist(ballotType);
//			  tx.commit();
//			  Query query =  
//					    em.createQuery("SELECT t from Temp t");
//			  List<Temp> cities = query.getResultList();
//			  for(int i = 0 ; i < cities.size() ; i++){
//				  System.out.println(cities.get(i).getName());
//			  }
			  		
//			  QuestionDAO questionDAO = QuestionDAO.getInstance();
//			  List<Question> questions = questionDAO.getQuestion();
//			  for(int i=0;i<questions.size();i++){
//				  System.out.println(questions.get(i).getInstruction()+ " "+questions.get(i).getClass());
//			  }
//			  Query query = em.createQuery("SELECT t from BallotType t");
//			  List<BallotType> testList = query.getResultList();
////			  List<Temp> listTmp = query.getResultList();
//			  for(int i = 0 ; i < testList.size() ; i++){
//				  System.out.println(testList.get(i).getQuestion());
////				  System.out.println(listTmp.get(i).getName());
//				  System.out.println(testList.get(i).getQuestion()+ " "+testList.get(i).getGrade());
			  //}
			  //System.out.print("AA");			  
	 }
}
