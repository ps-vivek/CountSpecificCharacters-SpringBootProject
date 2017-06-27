package com.count.character.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.count.character.model.CountCharacter;

public interface CountRepository extends MongoRepository<CountCharacter, String>,CountRepositoryCustom {} 