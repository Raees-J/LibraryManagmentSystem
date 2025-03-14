package za.ac.cput.repository;

import za.ac.cput.domain.User;

public interface IRepository <T, ID> {

    T create(T t);

    T read(ID id);

    T update(T t);

    boolean delete(ID id);

}
