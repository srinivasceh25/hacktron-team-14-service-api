package com.hacktron.sqlsetup.repository;

import com.hacktron.sqlsetup.model.QueueDetail;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author Sneha.G
 */

@Repository("queueDetailRepository")
public class QueueDetailRepository {

    final String DEL_QUERY = "delete from NetworkSpecs where id=:id";
    final String GET_QUERY = "from QueueDetail queueDetail where queueDetail.queue.id=:id";
    final String UPDATE_QUERY = "update NetworkSpecs networkSpecs set networkSpecs.name=:name where networkSpecs.id=:id";
    final String GET_ALL_QUERY = "from NetworkSpecs";

    @PersistenceContext
    private EntityManager entityManager;

    public List<QueueDetail> get(Long id) {
        return (List<QueueDetail>) entityManager.createQuery(GET_QUERY).setParameter("id",id).getResultList();
    }

    /*public void add(QueueDetail queueDetail,Long queueId) {
        entityManager.merge(queueDetail);
    }

    public void delete(Long id) {
        entityManager.createQuery(DEL_QUERY).setParameter("id",id).executeUpdate();
    }

    public void deleteAll(String name, NetworkSpecs networkSpecs) {
        //merge();
    }*/

}


