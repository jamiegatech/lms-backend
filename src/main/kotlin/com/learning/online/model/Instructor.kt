package com.learning.online.model

import javax.persistence.*

@Entity
@Table(name = "INSTRUCTOR")
data class Instructor(@Column(name = "first_name") val firstName: String,
                      @Column(name = "last_name") val lastName: String,
                      @Column(name = "preferred_name") val preferredName: String,
                      @Column(name = "degree") val degree: String,
                      @GeneratedValue(strategy= GenerationType.IDENTITY) @Column(name = "instructor_id") @Id val instructorId: Int)
