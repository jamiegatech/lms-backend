package com.learning.online.service

import com.learning.online.model.CourseGrade
import com.learning.online.repository.CourseGradeRepository
import org.springframework.stereotype.Service

@Service
class CourseGradeService(var courseGradeRepository: CourseGradeRepository) {

    fun save(courseGrade: CourseGrade) = courseGradeRepository.save(courseGrade)

    fun deleteById(courseId: Int, studentId: Int, gradeId: Int) = courseGradeRepository.deleteByCourseIdAndStudentIdAndGradeId(courseId, studentId, gradeId)
    fun deleteById(courseId: Int, gradeId: Int) = courseGradeRepository.deleteByCourseIdAndGradeId(courseId, gradeId)
}