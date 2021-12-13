package com.learning.online.service

import com.learning.online.model.Assignment
import com.learning.online.model.CourseAssignment
import com.learning.online.model.CourseGrade
import com.learning.online.model.Grade
import com.learning.online.repository.GradeRepository
import org.springframework.stereotype.Service

@Service
class GradeService(var gradeRepository: GradeRepository, var courseGradeService: CourseGradeService) {
    fun findAll(): List<Grade> = gradeRepository.findAll()

    fun findAllByCourseIdAndStudentId(courseId: Int, studentId: Int): List<Grade> = gradeRepository.findAllByCourseIdAndStudentId(courseId, studentId)

    fun findAllByCourseId(courseId: Int): List<Grade> = gradeRepository.findAllByCourseId(courseId)

    fun findById(id: Int): Grade = gradeRepository.findById(id).orElseThrow()

    fun save(grade: Grade): Grade = gradeRepository.save(grade)

    fun saveWithCourseLink(grade: Grade, courseId: Int,studentId: Int): Grade {
        var saved = gradeRepository.save(grade)
        courseGradeService.save(CourseGrade(courseId,studentId, saved.gradeId, null))
        return saved
    }

    fun update(grade: Grade, id: Int): Grade {
        gradeRepository.findById(id)
        return gradeRepository.save(grade)
    }

    fun deleteById(id: Int) = gradeRepository.deleteById(id)
}