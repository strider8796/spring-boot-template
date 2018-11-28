package com.example.demo.repositories;

import com.example.demo.models.WebsiteUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;



//@RepositoryRestResource(collectionResourceRel = "users", path = "users")
@Repository
public interface UserRepository extends JpaRepository<WebsiteUser, Long> {
//    List<WebsiteUser> findByName(@Param("name") String name);
}

//@Repository
//public interface UserRepository extends JPARe

//@Repository
//public interface UserRepository extends JPARe
