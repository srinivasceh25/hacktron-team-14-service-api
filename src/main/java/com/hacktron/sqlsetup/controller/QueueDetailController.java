package com.hacktron.sqlsetup.controller;

import com.hacktron.sqlsetup.domain.QueueDetailDomainService;
import com.hacktron.sqlsetup.model.QueueDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Sneha.G
 */
@RestController
@RequestMapping("/detail")
@CrossOrigin(origins = "http://localhost:4200")
public class QueueDetailController {

    @Autowired
    QueueDetailDomainService queueDetailDomainService;

    @GetMapping(path = "/get/{id}")
    public List<QueueDetail> get(@PathVariable("id") Long id) {
        return queueDetailDomainService.get(id);
    }

    @PostMapping("/add")
    public boolean add(@RequestBody QueueDetail queueDetail) {
        return queueDetailDomainService.add(queueDetail);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") Long id) {
        return queueDetailDomainService.delete(id);
    }

    @DeleteMapping("/delete-all/{id}")
    public boolean deleteAll(@PathVariable("id") Long queueId) {
        return queueDetailDomainService.delete(queueId);
    }
}


