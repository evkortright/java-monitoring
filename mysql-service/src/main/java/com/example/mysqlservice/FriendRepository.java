package com.example.mysqlservice;
import org.springframework.data.repository.CrudRepository;
import com.example.mysqlservice.Friend;
 
public interface FriendRepository extends CrudRepository<Friend, Integer> {
}

