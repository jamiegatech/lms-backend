package com.learning.online.repository

import com.learning.online.model.Instructor
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository

interface InstructorRepository: CrudRepository<Instructor, Int>,JpaRepository<Instructor, Int>