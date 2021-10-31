package com.learning.online.repository

import com.learning.online.model.Lecture
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository

interface LectureRepository: CrudRepository<Lecture, Int>,JpaRepository<Lecture, Int>