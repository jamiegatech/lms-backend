package com.learning.online.dto

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.learning.online.model.Student

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
data class StudentDto(val firstName: String,
                      val lastName: String,
                      val preferredName: String,
                      val studentId: Int) {

    companion object {
        fun fromModel(student: Student): StudentDto {
            return with(student) {
                StudentDto(firstName, lastName, preferredName, studentId)
            }
        }

        fun toModel(studentDto: StudentDto): Student {
            return with(studentDto) {
                Student(firstName, lastName, preferredName, studentId)
            }
        }
    }
}
