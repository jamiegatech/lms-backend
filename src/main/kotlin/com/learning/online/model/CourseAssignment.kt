package com.learning.online.model

import javax.persistence.*

@Entity
@Table(name = "COURSE_ASSIGNMENTS")
data class CourseAssignment(@Column(name = "course_id") val courseId: Int,
                            @Column(name = "assignment_id") val assignmentId: Int,
                            @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "course_assignment_id") @Id val courseAssignmentId: Int?)