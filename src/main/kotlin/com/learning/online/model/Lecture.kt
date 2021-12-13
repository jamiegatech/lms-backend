package com.learning.online.model

import javax.persistence.*

@Entity
@Table(name = "LECTURE")
data class Lecture(@Column(name = "name") val name: String,
                   @Column(name = "description") val description: String,
                   @Column(name = "video_link") val videoLink: String,
                   @GeneratedValue(strategy= GenerationType.IDENTITY) @Column(name = "lecture_id") @Id val lectureId: Int)
