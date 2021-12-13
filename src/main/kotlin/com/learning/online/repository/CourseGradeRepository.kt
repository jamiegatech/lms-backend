package com.learning.online.repository

import com.learning.online.model.CourseAssignment
import com.learning.online.model.CourseGrade
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.transaction.annotation.Transactional

interface CourseGradeRepository : CrudRepository<CourseGrade, Int>, JpaRepository<CourseGrade, Int>{
    @Transactional
    fun deleteByCourseIdAndStudentIdAndGradeId(courseId:Int, studentId:Int, gradeId:Int)
    @Transactional
    fun deleteByCourseIdAndGradeId(courseId:Int, gradeId:Int)
}
