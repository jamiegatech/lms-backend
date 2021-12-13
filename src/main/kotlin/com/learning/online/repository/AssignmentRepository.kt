package com.learning.online.repository

import com.learning.online.model.Assignment
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository


interface AssignmentRepository: CrudRepository<Assignment, Int>, JpaRepository<Assignment, Int>{
    @Query(
            value = "SELECT * FROM ASSIGNMENT a JOIN COURSE_ASSIGNMENTS ca on a.assignment_id = ca.assignment_id where ca.course_id = :courseId ",
            nativeQuery = true)
    fun findAllByCourseId(courseId: Int): List<Assignment>
}
