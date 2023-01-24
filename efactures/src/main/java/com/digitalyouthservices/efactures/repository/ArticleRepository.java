package com.digitalyouthservices.efactures.repository;

import com.digitalyouthservices.efactures.entity.ArticleEntity;
import com.digitalyouthservices.efactures.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<ArticleEntity, Long> {
    
}
