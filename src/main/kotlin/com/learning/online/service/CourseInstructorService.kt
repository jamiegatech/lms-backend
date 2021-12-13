package com.learning.online.service

import com.learning.online.model.CourseInstructor
import com.learning.online.model.CourseStudent
import com.learning.online.model.Student
import com.learning.online.repository.CourseInstructorRepository
import com.learning.online.repository.CourseStudentRepository
import com.learning.online.repository.StudentRepository
import org.springframework.stereotype.Service

@Service
class CourseInstructorService(var courseInstructorRepository: CourseInstructorRepository) {
    fun save(courseInstructor: CourseInstructor) = courseInstructorRepository.save(courseInstructor)

    fun deleteById(courseId: Int, instructorId: Int) = courseInstructorRepository.deleteByCourseIdAndInstructorId(courseId, instructorId)
}