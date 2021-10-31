package com.learning.online.repository

import com.learning.online.model.Course
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository


interface CourseRepository: CrudRepository<Course, Int>, JpaRepository<Course, Int>