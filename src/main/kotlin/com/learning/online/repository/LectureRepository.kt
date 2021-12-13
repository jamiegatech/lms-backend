package com.learning.online.repository

import com.learning.online.model.Assignment
import com.learning.online.model.Lecture
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface LectureRepository: CrudRepository<Lecture, Int>,JpaRepository<Lecture, Int>{
    @Query(
            value = "SELECT * FROM LECTURE a JOIN COURSE_LECTURES ca on a.lecture_id = ca.lecture_id where ca.course_id = :courseId ",
            nativeQuery = true)
    fun findAllByCourseId(courseId: Int): List<Lecture>}