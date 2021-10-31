package com.learning.online.service

import com.learning.online.model.Assignment
import com.learning.online.model.AssignmentSubmission
import com.learning.online.repository.AssignmentRepository
import com.learning.online.repository.AssignmentSubmissionRepository
import org.springframework.stereotype.Service

@Service
class AssignmentSubmissionService(var assignmentSubmissionRepository: AssignmentSubmissionRepository) {
    fun findAll(): List<AssignmentSubmission> = assignmentSubmissionRepository.findAll()

    fun findById(id: Int): AssignmentSubmission = assignmentSubmissionRepository.findById(id).orElseThrow()

    fun save(assignmentSubmission: AssignmentSubmission): AssignmentSubmission = assignmentSubmissionRepository.save(assignmentSubmission)

    fun update(assignmentSubmission: AssignmentSubmission, id: Int): AssignmentSubmission {
        assignmentSubmissionRepository.findById(id)
        return assignmentSubmissionRepository.save(assignmentSubmission)
    }

    fun deleteById(id: Int) = assignmentSubmissionRepository.deleteById(id)
}