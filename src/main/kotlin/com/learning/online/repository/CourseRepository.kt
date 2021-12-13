package com.learning.online.repository

import com.learning.online.model.Assignment
import com.learning.online.model.Course
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface CourseRepository : CrudRepository<Course, Int>, JpaRepository<Course, Int>{
    @Query(
            value = "SELECT * FROM COURSE a JOIN COURSE_STUDENTS ca on a.course_id = ca.course_id where ca.student_id = :studentId ",
            nativeQuery = true)
    fun findAllByStudentId(studentId: Int): List<Course>

    @Query(
            value = "SELECT * FROM COURSE a JOIN COURSE_INSTRUCTORS ca on a.course_id = ca.course_id where ca.instructor_id = :instructorId ",
            nativeQuery = true)
    fun findAllByInstructorId(instructorId: Int): List<Course>
}