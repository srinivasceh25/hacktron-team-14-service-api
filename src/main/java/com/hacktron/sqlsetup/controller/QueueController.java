package com.hacktron.sqlsetup.controller;
/**
 * @author Siva.G
 */
import com.hacktron.sqlsetup.exception.ResourceNotFoundException;
import com.hacktron.sqlsetup.model.Queue;
import com.hacktron.sqlsetup.repository.QueueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api")
public class QueueController {

    @Autowired
    QueueRepository queueRepository;

    @GetMapping("/queues")
    public List<Queue> getAllNotes() {
        return queueRepository.findAll();
    }

    @PostMapping("/queues")
    public Queue createNote(@Valid @RequestBody Queue note) {
        return queueRepository.save(note);
    }

    @GetMapping("/queues/{id}")
    public Queue getNoteById(@PathVariable(value = "id") Long queueId) {
        return queueRepository.findById(queueId)
                .orElseThrow(() -> new ResourceNotFoundException("Queue", "id", queueId));
    }

    @PutMapping("/queues/{id}")
    public Queue updateNote(@PathVariable(value = "id") Long noteId,
                            @Valid @RequestBody Queue noteDetails) {

        Queue queueInfo = queueRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Queue", "id", noteId));

        queueInfo.setTitle(noteDetails.getTitle());
        queueInfo.setContent(noteDetails.getContent());

        Queue updatedNote = queueRepository.save(queueInfo);
        return updatedNote;
    }

    @DeleteMapping("/queues/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long queueId) {
        Queue queueInfo = queueRepository.findById(queueId)
                .orElseThrow(() -> new ResourceNotFoundException("Queue", "id", queueId));

        queueRepository.delete(queueInfo);

        return ResponseEntity.ok().build();
    }
}
