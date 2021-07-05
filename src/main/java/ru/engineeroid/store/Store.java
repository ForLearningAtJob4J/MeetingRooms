package ru.engineeroid.store;

import ru.engineeroid.model.IdOwner;
import ru.engineeroid.model.User;

import java.sql.SQLException;
import java.util.List;

public interface Store {

    List<User> findAllUsers();

    User findUserByEmail(String email);

    <T> T add(T subject) throws SQLException;

    <T> void update(T subject) throws SQLException;

    <T extends IdOwner> void delete(T subject);

    <T extends IdOwner> T findById(T subject);
}