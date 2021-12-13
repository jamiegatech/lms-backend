package com.learning.online.repository

import com.learning.online.model.CourseAssignment
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.transaction.annotation.Transactional

interface CourseAssignmentRepository : CrudRepository<CourseAssignment, Int>, JpaRepository<CourseAssignment, Int>{
    @Transactional
    fun deleteByCourseIdAndAssignmentId(courseId:Int, assignmentId:Int)
}
