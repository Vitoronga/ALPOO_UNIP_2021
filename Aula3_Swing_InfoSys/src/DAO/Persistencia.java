package DAO;

public interface Persistencia<T> {
    public int create (T obj);
    public T findByCodigo(int id);
    public void delete(int id);
    public void update(T obj);
}
