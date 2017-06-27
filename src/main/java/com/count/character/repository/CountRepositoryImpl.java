package com.count.character.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.count.character.model.CountCharacter;
import com.mongodb.WriteResult;

//The implementation class name is very strict, the name must be "CoreRepositoryInterface" + Impl
public class CountRepositoryImpl implements CountRepositoryCustom{

    @Autowired
    MongoTemplate mongoTemplate;

    /**
     * Update the string input and char input based on id
     */
    @Override
    public int updateString(String stringInput, String id, char charInput) {

        Query query = new Query(Criteria.where("id").is(id));
        Update update = new Update();
        update.set("stringInput", stringInput);
        update.set("charInput", charInput);

        WriteResult result = mongoTemplate.updateFirst(query, update, CountCharacter.class);

        if(result!=null)
            return result.getN();
        else
            return 0;

    }
}
