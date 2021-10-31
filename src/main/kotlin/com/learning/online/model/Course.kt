package com.learning.online.model

import javax.persistence.*

@Entity
@Table(name = "GRADE")
data class Course(@Column(name = "name") val name: String,
                  @Column(name = "description") val description: String,
                  @OneToMany
                  @JoinTable(
                          name = "course_assignments",
                          joinColumns = [JoinColumn(name = "assignment_id")],
                          inverseJoinColumns = [JoinColumn(name = "course_id")]
                  ) val assignments: List<Assignment>,
                  @OneToMany
                  @JoinTable(
                          name = "course_grades",
                  ) val grades: List<Grade>,
                  @OneToMany
                  @JoinTable(
                          name = "course_lectures",
                  ) val lectures: List<Lecture>,
                  @OneToMany
                  @JoinTable(
                          name = "course_students",
                  ) val students: List<Student>,
                  @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name = "course_id") @Id val courseId: Int,
                  @OneToMany
                  @JoinTable(
                          name = "course_instructors",
                  ) val instructors: List<Instructor>
)
