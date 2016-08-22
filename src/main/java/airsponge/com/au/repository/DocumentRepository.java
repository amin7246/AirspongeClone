package airsponge.com.au.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import airsponge.com.au.entity.Document;

public interface DocumentRepository extends JpaRepository<Document, Integer> {

}
