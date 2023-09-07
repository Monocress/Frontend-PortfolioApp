package com.dorukt.repository;

import com.dorukt.repository.entity.Works;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IWorksRepository extends JpaRepository<Works, Long> {

}
