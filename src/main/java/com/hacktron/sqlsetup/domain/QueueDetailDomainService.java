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

   /* public void add(NetworkSpecs networkSpecs) {
        networkProviderRepository.save(networkSpecs);
    }

    public void delete(Long id) {
        networkProviderRepository.delete(id);
    }

    public void deleteAll(String name, NetworkSpecs networkSpecs) {
        networkProviderRepository.update(name,networkSpecs);
    }*/
}
