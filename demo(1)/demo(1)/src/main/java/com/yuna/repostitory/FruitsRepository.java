package com.yuna.repostitory;

import com.yuna.entity.Fruits;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FruitsRepository extends CrudRepository<Fruits, Long > {


     Fruits save(Fruits u);

    @Query("select t from Fruits t where t.name=:name")
     Fruits findUserByName(@Param("name") String name);
}

