package DAO;

public interface Persistencia<T> {
    public int create (T obj);
}