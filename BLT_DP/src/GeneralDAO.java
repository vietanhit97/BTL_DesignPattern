import java.util.List;

public interface GeneralDAO<T> {
	public List<T> get();
	public List<T> getByName(String name);
	public T findId(T id);
	public boolean add(T entity);
	public boolean edit(T entity,int index);
	public boolean remove(T entity);

}
