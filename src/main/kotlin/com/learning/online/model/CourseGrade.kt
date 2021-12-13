package com.learning.online.model

import javax.persistence.*

@Entity
@Table(name = "COURSE_GRADES")
data class CourseGrade(@Column(name = "course_id") val courseId: Int,
                       @Column(name = "student_id") val studentId: Int,
                       @Column(name = "grade_id") val gradeId: Int,
                       @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "course_grade_id") @Id val courseGradeId: Int?)