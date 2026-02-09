package com.nsbm.studenthub.service;

import com.nsbm.studenthub.entity.Student;
import com.nsbm.studenthub.repository.StudentRepository;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public Student create(Student s) { return repo.save(s); }

    public Student get(Long id) { return repo.findById(id).orElseThrow(); }

    public Page<Student> getAll(int page, int size, String sortBy, String direction) {
        Sort sort = direction.equalsIgnoreCase("desc") ?
                Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return repo.findAll(pageable);
    }

    public Student update(Long id, Student s) {
        Student ex = get(id);
        ex.setName(s.getName());
        ex.setEmail(s.getEmail());
        ex.setBatch(s.getBatch());
        ex.setGpa(s.getGpa());
        return repo.save(ex);
    }

    public void delete(Long id) { repo.deleteById(id); }
}
