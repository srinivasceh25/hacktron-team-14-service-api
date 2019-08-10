package com.hacktron.sqlsetup.domain;

import com.hacktron.sqlsetup.model.QueueDetail;
import com.hacktron.sqlsetup.repository.QueueDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Sneha.G
 */

@Service("queueDetailDomainService")
public class QueueDetailDomainService {

    @Autowired
    QueueDetailRepository queueDetailRepository;

    public List<QueueDetail> get(Long queueId) {
        List<QueueDetail> detail = queueDetailRepository.get(queueId);
        return detail;
    }

    public boolean add(QueueDetail queueDetail) {
        return queueDetailRepository.add(queueDetail);
    }

    public boolean delete(Long id) {
        return queueDetailRepository.delete(id);
    }

    public boolean deleteAll(Long id) {
        return queueDetailRepository.deleteAll(id);
    }
}
