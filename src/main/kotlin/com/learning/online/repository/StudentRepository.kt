package com.learning.online.repository

import com.learning.online.model.Student
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository

interface StudentRepository: CrudRepository<Student, Int>,JpaRepository<Student, Int>