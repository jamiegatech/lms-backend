package com.learning.online.service

import com.learning.online.model.Student
import com.learning.online.repository.StudentRepository
import org.springframework.stereotype.Service

@Service
class StudentService(var studentRepository: StudentRepository) {
    fun findAllByCourseId(id: Int): List<Student> = studentRepository.findAllByCourseId(id)

    fun findAll(): List<Student> = studentRepository.findAll()

    fun findById(id: Int): Student = studentRepository.findById(id).orElseThrow()

    fun save(student: Student): Student = studentRepository.save(student)

    fun update(student: Student, id: Int): Student {
        studentRepository.findById(id)
        return studentRepository.save(student)
    }

    fun deleteById(id: Int) = studentRepository.deleteById(id)
}