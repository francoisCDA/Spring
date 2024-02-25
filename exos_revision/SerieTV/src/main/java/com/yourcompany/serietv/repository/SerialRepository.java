package com.yourcompany.serietv.repository;

import com.yourcompany.serietv.entity.Serial;
import com.yourcompany.serietv.enumerate.SerialKind;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SerialRepository extends CrudRepository<Serial,Long> {

    public List<Serial> findSerialByNameIsContainingIgnoreCaseOrSerialKindContainingIgnoreCase(String name, SerialKind serialKind) ;

}
