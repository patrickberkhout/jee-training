package local.domein.dao;

import java.util.List;

public interface DAO<T> {
	List<T> findAll();
	void delete(T t);
	void save(T t);
}
