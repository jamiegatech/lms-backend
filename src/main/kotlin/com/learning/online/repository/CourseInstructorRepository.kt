package com.learning.online.repository

import com.learning.online.model.CourseInstructor
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.transaction.annotation.Transactional

interface CourseInstructorRepository : CrudRepository<CourseInstructor, Int>, JpaRepository<CourseInstructor, Int> {
    @Transactional
    fun deleteByCourseIdAndInstructorId(courseId: Int, instructorId: Int)
}