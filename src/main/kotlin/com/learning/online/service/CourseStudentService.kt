package com.learning.online.service

import com.learning.online.model.CourseStudent
import com.learning.online.model.Student
import com.learning.online.repository.CourseStudentRepository
import com.learning.online.repository.StudentRepository
import org.springframework.stereotype.Service

@Service
class CourseStudentService(var courseStudentRepository: CourseStudentRepository) {
    fun save(courseStudent: CourseStudent) = courseStudentRepository.save(courseStudent)

    fun deleteById(courseId: Int, studentId: Int) = courseStudentRepository.deleteByCourseIdAndStudentId(courseId, studentId)
}