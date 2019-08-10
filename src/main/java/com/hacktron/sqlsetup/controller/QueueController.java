package com.hacktron.sqlsetup.controller;

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

    @GetMapping("/notes")
    public List<Queue> getAllNotes() {
        return queueRepository.findAll();
    }

    @PostMapping("/notes")
    public Queue createNote(@Valid @RequestBody Queue note) {
        return queueRepository.save(note);
    }

    @GetMapping("/notes/{id}")
    public Queue getNoteById(@PathVariable(value = "id") Long noteId) {
        return queueRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Queue", "id", noteId));
    }

    @PutMapping("/notes/{id}")
    public Queue updateNote(@PathVariable(value = "id") Long noteId,
                            @Valid @RequestBody Queue noteDetails) {

        Queue note = queueRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Queue", "id", noteId));

        note.setTitle(noteDetails.getTitle());
        note.setContent(noteDetails.getContent());

        Queue updatedNote = queueRepository.save(note);
        return updatedNote;
    }

    @DeleteMapping("/notes/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long noteId) {
        Queue note = queueRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Queue", "id", noteId));

        queueRepository.delete(note);

        return ResponseEntity.ok().build();
    }
}
