package com.learning.online.service

import com.learning.online.model.Course
import com.learning.online.repository.CourseRepository
import org.springframework.stereotype.Service

@Service
class CourseService(var courseRepository: CourseRepository) {
    fun findAll(): List<Course> = courseRepository.findAll()

    fun findAllByStudentId(studentId: Int): List<Course> = courseRepository.findAllByStudentId(studentId)

    fun findAllByInstructorId(instructorId: Int): List<Course> = courseRepository.findAllByInstructorId(instructorId)

    fun findById(id: Int): Course = courseRepository.findById(id).orElseThrow()

    fun save(course: Course): Course = courseRepository.save(course)

    fun update(course: Course, id: Int): Course {
        courseRepository.findById(id)
        return courseRepository.save(course)
    }

    fun deleteById(id: Int) = courseRepository.deleteById(id)
}