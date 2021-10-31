package com.learning.online.repository

import com.learning.online.model.Grade
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository


interface GradeRepository: CrudRepository<Grade, Int>,JpaRepository<Grade, Int>