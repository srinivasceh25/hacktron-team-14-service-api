package com.hacktron.sqlsetup.repository;

import com.hacktron.sqlsetup.model.QueueDetail;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author Sneha.G
 */

@Transactional
@Repository("queueDetailRepository")
public class QueueDetailRepository {

    final String DEL_QUERY = "delete from QueueDetail where id=:id";
    final String GET_QUERY = "from QueueDetail queueDetail where queueDetail.queueId=:id";
    final String DEL_ALL_QUERY = "delete from QueueDetail where queueId=:id";
    @PersistenceContext
    private EntityManager entityManager;

    public List<QueueDetail> get(Long id) {
        return (List<QueueDetail>) entityManager.createQuery(GET_QUERY).setParameter("id",id).getResultList();
    }

    public boolean add(QueueDetail queueDetail) {
        entityManager.merge(queueDetail);
        return true;
    }

    public boolean delete(Long id) {
        entityManager.createQuery(DEL_QUERY).setParameter("id",id).executeUpdate();
        return true;
    }

    public boolean deleteAll(Long queueId) {
        entityManager.createQuery(DEL_ALL_QUERY).setParameter("id",queueId).executeUpdate();
        return true;
    }

}


