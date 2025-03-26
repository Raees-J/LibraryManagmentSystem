/*
IUserRepository.java
User model class
Author: Raees Johaadien (230558135)
Date: 14 March 2025
*/
package za.ac.cput.repository;

import za.ac.cput.domain.User;

import java.util.List;

public interface IUserRepository extends IRepository <User, String> {
    List<User> getAll();
}
