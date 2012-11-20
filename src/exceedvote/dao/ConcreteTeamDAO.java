package exceedvote.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.print.DocFlavor.STRING;

import exceedvote.domain.TeamBoard;

public class ConcreteTeamDAO implements DAO{

	private EntityManager em;
	
	public ConcreteTeamDAO(EntityManager em){
		this.em = em;
	}
	
	@Override
	public void save(Object o) {
		em.getTransaction().begin();
		em.persist((TeamBoard)o);
		em.getTransaction().commit();
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Object o) {
		TeamBoard teamBoard = (TeamBoard)o;
		
		Query query = em.createQuery("UPDATE TeamBoard t SET t.description = :description , t.name = :name WHERE t.id = :id");
		query.setParameter("description", teamBoard.getDescription());
		query.setParameter("id", teamBoard.getId());
		query.setParameter("name",teamBoard.getName());
		
		em.getTransaction().begin();
		query.executeUpdate();
		em.getTransaction().commit();
						
	}

	@Override
	public void delete(Object o) {	
		TeamBoard teamBoard = (TeamBoard)o;
		TeamBoard tmp = em.find(TeamBoard.class, teamBoard.getId());
		em.getTransaction().begin();
		em.remove(tmp);
		em.getTransaction().commit();
	}

	public int count(){
		Query query = em.createQuery("SELECT count(t) FROM TeamBoard t");
		Number countTeam = (Number) query.getSingleResult();
		return countTeam.intValue();
	}	
	
	public List<String> getTeamName(){
		Query query = em.createQuery("SELECT t FROM TeamBoard t");
		List<TeamBoard> teams = query.getResultList();
		List<String> names = new ArrayList<String>();
		for(TeamBoard t : teams)
			names.add(t.getName());
		return names;
	}
	
	public List<TeamBoard> find(){
		Query query = em.createQuery("SELECT t FROM TeamBoard t");
		List<TeamBoard> teams = query.getResultList();
		return teams;
	}
}
