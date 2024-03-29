package com.hacktron.sqlsetup.controller;
/**
 * @author Siva.G
 */
import com.hacktron.sqlsetup.exception.ResourceNotFoundException;
import com.hacktron.sqlsetup.model.Queue;
import com.hacktron.sqlsetup.repository.QueueDetailRepository;
import com.hacktron.sqlsetup.repository.QueueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api")
public class QueueController {

    @Autowired
    QueueDetailRepository queueDetailRepository;

    @Autowired
    QueueRepository queueRepository;

    @GetMapping("/queues")
    public List<Queue> getAllQueues() {
        return queueRepository.findAll();
    }

    @PostMapping("/queues")
    public Queue createQueue(@Valid @RequestBody Queue note) {
        return queueRepository.save(note);
    }

    @GetMapping("/queues/{id}")
    public Queue getQueueById(@PathVariable(value = "id") Long queueId) {
        return queueRepository.findById(queueId)
                .orElseThrow(() -> new ResourceNotFoundException("Queue", "id", queueId));
    }

    @PutMapping("/queues/{id}")
    public Queue updateQueue(@PathVariable(value = "id") Long noteId,
                            @Valid @RequestBody Queue noteDetails) {

        Queue queueInfo = queueRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Queue", "id", noteId));

        queueInfo.setTitle(noteDetails.getTitle());
        queueInfo.setContent(noteDetails.getContent());

        Queue updatedNote = queueRepository.save(queueInfo);
        return updatedNote;
    }

    @DeleteMapping("/queues/{id}")
    public ResponseEntity<?> deleteQueue(@PathVariable(value = "id") Long queueId) {
        Queue queueInfo = queueRepository.findById(queueId)
                .orElseThrow(() -> new ResourceNotFoundException("Queue", "id", queueId));

        queueRepository.delete(queueInfo);
        queueDetailRepository.deleteAll(queueInfo.getId());
        return ResponseEntity.ok().build();
    }
}
