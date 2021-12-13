package com.learning.online.service

import com.learning.online.model.Assignment
import com.learning.online.model.CourseAssignment
import com.learning.online.repository.AssignmentRepository
import org.springframework.stereotype.Service

@Service
class AssignmentService(var assignmentRepository: AssignmentRepository, var courseAssignmentService: CourseAssignmentService) {
    fun findAllByCourseId(courseId: Int): List<Assignment> = assignmentRepository.findAllByCourseId(courseId)

    fun findById(id: Int):Assignment = assignmentRepository.findById(id).orElseThrow()

    fun save(assignment: Assignment): Assignment = assignmentRepository.save(assignment)

    fun saveWithCourseLink(assignment: Assignment, courseId: Int): Assignment {
        var saved = assignmentRepository.save(assignment)
        courseAssignmentService.save(CourseAssignment(courseId, saved.assignmentId, null))
        return saved
    }


    fun update(assignment: Assignment, id: Int): Assignment {
        assignmentRepository.findById(id)
        return assignmentRepository.save(assignment)
    }

    fun deleteById(id: Int) = assignmentRepository.deleteById(id)
}