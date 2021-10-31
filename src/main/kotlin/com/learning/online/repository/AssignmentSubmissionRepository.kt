package com.learning.online.repository

import com.learning.online.model.AssignmentSubmission
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository

interface AssignmentSubmissionRepository : CrudRepository<AssignmentSubmission, Int>, JpaRepository<AssignmentSubmission, Int>
