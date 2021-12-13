package com.learning.online.repository

import com.learning.online.model.CourseStudent
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.transaction.annotation.Transactional

interface CourseStudentRepository : CrudRepository<CourseStudent, Int>, JpaRepository<CourseStudent, Int> {
    @Transactional
    fun deleteByCourseIdAndStudentId(courseId: Int, studentId: Int)
}