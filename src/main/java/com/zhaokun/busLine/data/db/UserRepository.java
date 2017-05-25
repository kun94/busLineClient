package com.zhaokun.busLine.data.db;

import com.zhaokun.busLine.data.entity.User;

import java.util.List;

public interface UserRepository {

    String count();

    List<User> findByLimit(String limit, String offset);

    boolean addUser(User user);

    User login(User user);

}
