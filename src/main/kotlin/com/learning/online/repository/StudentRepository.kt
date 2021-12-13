package com.learning.online.repository

import com.learning.online.model.Course
import com.learning.online.model.Student
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface StudentRepository: CrudRepository<Student, Int>,JpaRepository<Student, Int>{
    @Query(
            value = "SELECT * FROM STUDENT a JOIN COURSE_STUDENTS ca on a.student_id = ca.student_id where ca.course_id = :courseId ",
            nativeQuery = true)
    fun findAllByCourseId(courseId: Int): List<Student>
}