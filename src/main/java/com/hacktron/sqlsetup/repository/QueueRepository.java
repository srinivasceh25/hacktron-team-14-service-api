package com.hacktron.sqlsetup.repository;

import com.hacktron.sqlsetup.model.Queue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface QueueRepository extends JpaRepository<Queue, Long> {

}
