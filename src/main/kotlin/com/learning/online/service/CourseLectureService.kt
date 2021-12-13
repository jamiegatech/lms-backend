package com.learning.online.service

import com.learning.online.model.Assignment
import com.learning.online.model.CourseAssignment
import com.learning.online.model.CourseLecture
import com.learning.online.repository.AssignmentRepository
import com.learning.online.repository.CourseAssignmentRepository
import com.learning.online.repository.CourseLectureRepository
import org.springframework.stereotype.Service

@Service
class CourseLectureService(var courseLectureRepository: CourseLectureRepository) {

    fun save(courseLecture: CourseLecture) = courseLectureRepository.save(courseLecture)

    fun deleteById(courseId: Int, lectureId: Int) = courseLectureRepository.deleteByCourseIdAndLectureId(courseId, lectureId)
}