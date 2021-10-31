package com.learning.online.service

import com.learning.online.model.Assignment
import com.learning.online.repository.AssignmentRepository
import org.springframework.stereotype.Service

@Service
class AssignmentService(var assignmentRepository: AssignmentRepository) {
    fun findAll(): List<Assignment> = assignmentRepository.findAll()

    fun findById(id: Int):Assignment = assignmentRepository.findById(id).orElseThrow()

    fun save(assignment: Assignment): Assignment = assignmentRepository.save(assignment)

    fun update(assignment: Assignment, id: Int): Assignment {
        assignmentRepository.findById(id)
        return assignmentRepository.save(assignment)
    }

    fun deleteById(id: Int) = assignmentRepository.deleteById(id)
}