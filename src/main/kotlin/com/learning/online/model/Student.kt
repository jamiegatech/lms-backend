package com.learning.online.model

import javax.persistence.*

@Entity
@Table(name = "STUDENT")
data class Student(@Column(name = "first_name")val firstName: String,
                   @Column(name = "last_name")val lastName: String,
                   @Column(name = "preferred_name")val preferredName: String,
                   @GeneratedValue(strategy= GenerationType.IDENTITY) @Column(name = "student_id")@Id val studentId: Int)
