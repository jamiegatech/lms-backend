package com.learning.online.service

import com.learning.online.model.Lecture
import com.learning.online.repository.LectureRepository
import org.springframework.stereotype.Service

@Service
class LectureService(var lectureRepository: LectureRepository) {
    fun findAll(): List<Lecture> = lectureRepository.findAll()

    fun findById(id: Int): Lecture = lectureRepository.findById(id).orElseThrow()

    fun save(lecture: Lecture): Lecture = lectureRepository.save(lecture)

    fun update(lecture: Lecture, id: Int): Lecture {
        lectureRepository.findById(id)
        return lectureRepository.save(lecture)
    }

    fun deleteById(id: Int) = lectureRepository.deleteById(id)
}