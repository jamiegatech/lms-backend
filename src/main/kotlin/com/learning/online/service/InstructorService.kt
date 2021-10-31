package com.learning.online.service

import com.learning.online.model.Instructor
import com.learning.online.repository.InstructorRepository
import org.springframework.stereotype.Service

@Service
class InstructorService(var instructorRepository: InstructorRepository) {
    fun findAll():  List<Instructor> = instructorRepository.findAll()

    fun findById(id: Int): Instructor = instructorRepository.findById(id).orElseThrow()

    fun save(instructor: Instructor): Instructor = instructorRepository.save(instructor)

    fun update(instructor: Instructor, id: Int): Instructor {
        instructorRepository.findById(id)
        return instructorRepository.save(instructor)
    }

    fun deleteById(id: Int) = instructorRepository.deleteById(id)
}