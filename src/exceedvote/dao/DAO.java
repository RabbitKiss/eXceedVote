package exceedvote.dao;

import java.util.List;

import exceedvote.domain.Question;

public interface DAO {
	public void save(Object o);
	public void update(Object o);
	public void delete(Object o);
}