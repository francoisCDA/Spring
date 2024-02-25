package com.yourcompany.serietv.repository;

import com.yourcompany.serietv.entity.Subscription;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscritpionRepository extends CrudRepository<Subscription,Long> {

    public Subscription findByMailIs(String mail);
}
