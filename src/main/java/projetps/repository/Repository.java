package projetps.repository;

import java.util.List;

import projetps.entities.Rv;

public interface Repository<T> {
    void insert(T data);
    List<T> selectAll();
   
}
