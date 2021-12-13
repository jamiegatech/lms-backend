package com.learning.online.model

import javax.persistence.*

@Entity
@Table(name = "COURSE_STUDENTS")
data class CourseStudent(@Column(name = "course_id") val courseId: Int,
                         @Column(name = "student_id") val studentId: Int,
                         @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "course_student_id") @Id val courseStudentId: Int?)