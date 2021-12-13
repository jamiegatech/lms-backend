package com.learning.online.service

import com.learning.online.model.Assignment
import com.learning.online.model.CourseAssignment
import com.learning.online.repository.AssignmentRepository
import com.learning.online.repository.CourseAssignmentRepository
import org.springframework.stereotype.Service

@Service
class CourseAssignmentService(var courseAssignmentRepository: CourseAssignmentRepository) {

    fun save(courseAssignment: CourseAssignment) = courseAssignmentRepository.save(courseAssignment)


    fun deleteById(courseId: Int, assignmentId: Int) = courseAssignmentRepository.deleteByCourseIdAndAssignmentId(courseId, assignmentId)
}