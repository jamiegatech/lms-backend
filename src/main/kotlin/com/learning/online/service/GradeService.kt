package com.learning.online.service

import com.learning.online.model.Grade
import com.learning.online.repository.GradeRepository
import org.springframework.stereotype.Service

@Service
class GradeService(var gradeRepository: GradeRepository) {
    fun findAll(): List<Grade> = gradeRepository.findAll()

    fun findById(id: Int): Grade = gradeRepository.findById(id).orElseThrow()

    fun save(grade: Grade): Grade = gradeRepository.save(grade)

    fun update(grade: Grade, id: Int): Grade {
        gradeRepository.findById(id)
        return gradeRepository.save(grade)
    }

    fun deleteById(id: Int) = gradeRepository.deleteById(id)
}