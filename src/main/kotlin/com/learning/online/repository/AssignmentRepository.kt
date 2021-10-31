package com.learning.online.repository

import com.learning.online.model.Assignment
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository


interface AssignmentRepository: CrudRepository<Assignment, Int>, JpaRepository<Assignment, Int>
