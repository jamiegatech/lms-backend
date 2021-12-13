package com.learning.online.model

import javax.persistence.*

@Entity
@Table(name = "COURSE")
data class Course(@Column(name = "name") val name: String,
                  @Column(name = "description") val description: String,
                  @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name = "course_id") @Id val courseId: Int
)
