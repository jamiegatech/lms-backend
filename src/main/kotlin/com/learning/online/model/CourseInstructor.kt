package com.learning.online.model

import javax.persistence.*

@Entity
@Table(name = "COURSE_INSTRUCTORS")
data class CourseInstructor(@Column(name = "course_id") val courseId: Int,
                            @Column(name = "instructor_id") val instructorId: Int,
                            @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "course_instructor_id") @Id val courseInstructorId: Int?)