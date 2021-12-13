package com.learning.online.repository

import com.learning.online.model.Assignment
import com.learning.online.model.Grade
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository


interface GradeRepository: CrudRepository<Grade, Int>,JpaRepository<Grade, Int>{
    @Query(
            value = "SELECT * FROM Grade a JOIN COURSE_GRADES ca on a.grade_id = ca.grade_id where ca.course_id = :courseId and  ca.student_id = :studentId",
            nativeQuery = true)
    fun findAllByCourseIdAndStudentId(courseId: Int, studentId: Int): List<Grade>

    @Query(
            value = "SELECT * FROM Grade a JOIN COURSE_GRADES ca on a.grade_id = ca.grade_id where ca.course_id = :courseId",
            nativeQuery = true)
    fun findAllByCourseId(courseId: Int): List<Grade>
}