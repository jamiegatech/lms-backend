package com.learning.online.repository

import com.learning.online.model.CourseAssignment
import com.learning.online.model.CourseLecture
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.transaction.annotation.Transactional

interface CourseLectureRepository : CrudRepository<CourseLecture, Int>, JpaRepository<CourseLecture, Int>{
    @Transactional
    fun deleteByCourseIdAndLectureId(courseId:Int, lectureId:Int)
}
