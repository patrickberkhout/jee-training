package local.common;

import java.util.List;

public interface DAO<T> {
	List<T> findAll(Class<T> clazz);
	void create(T t);
	void read(Class<T> clazz, Object key);
	void update(T t);
	void delete(T t);
}
