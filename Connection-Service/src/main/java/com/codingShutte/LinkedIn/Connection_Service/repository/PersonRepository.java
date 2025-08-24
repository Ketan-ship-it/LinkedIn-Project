package com.codingShutte.LinkedIn.Connection_Service.repository;

import com.codingShutte.LinkedIn.Connection_Service.entity.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface PersonRepository extends Neo4jRepository<Person ,Long> {

    Optional<Person> getByName(String name);

    @Query("MATCH (personA:Person) -[:CONNECTED_TO]- (personB:Person) "+
            "WHERE personA.userId = $userId "+
            "RETURN personB")
    List<Person> getFirstDegreeConnections(Long userId);
}
