package com.learning.online.model

import javax.persistence.*

@Entity
@Table(name = "COURSE_LECTURES")
data class CourseLecture(@Column(name = "course_id") val courseId: Int,
                         @Column(name = "lecture_id") val lectureId: Int,
                         @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "course_lecture_id") @Id val courseLectureId: Int?)