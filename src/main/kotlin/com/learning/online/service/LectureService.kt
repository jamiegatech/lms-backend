package com.learning.online.service

import com.learning.online.model.CourseAssignment
import com.learning.online.model.CourseLecture
import com.learning.online.model.Lecture
import com.learning.online.repository.LectureRepository
import org.springframework.stereotype.Service

@Service
class LectureService(var lectureRepository: LectureRepository, var courseLectureService: CourseLectureService) {
    fun findAllByCourseId(courseId: Int): List<Lecture> = lectureRepository.findAllByCourseId(courseId)

    fun findAll(): List<Lecture> = lectureRepository.findAll()

    fun findById(id: Int): Lecture = lectureRepository.findById(id).orElseThrow()

    fun save(lecture: Lecture): Lecture = lectureRepository.save(lecture)

    fun saveWithCourseLink(lecture: Lecture, courseId: Int): Lecture {
        var saved = lectureRepository.save(lecture)
        courseLectureService.save(CourseLecture(courseId, saved.lectureId, null))
        return saved
    }

    fun update(lecture: Lecture, id: Int): Lecture {
        lectureRepository.findById(id)
        return lectureRepository.save(lecture)
    }

    fun deleteById(id: Int) = lectureRepository.deleteById(id)
}