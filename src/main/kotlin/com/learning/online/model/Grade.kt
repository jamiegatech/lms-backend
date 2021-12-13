package com.learning.online.model

import javax.persistence.*

@Entity
@Table(name = "GRADE")
data class Grade(
        @Column(name = "description") val description: String,
        @Column(name = "actual") val actual: Double,
        @Column(name = "possible") val possible: Double,
        @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "grade_id") @Id val gradeId: Int)
