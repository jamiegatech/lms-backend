package com.learning.online.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "ASSIGNMENT")
data class Assignment(@Column(name = "name") val name: String,
                      @Column(name = "description") val description: String,
                      @Column(name = "due_date") val dueDate: LocalDateTime,
                      @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "assignment_id") @Id val assignmentId: Int)
