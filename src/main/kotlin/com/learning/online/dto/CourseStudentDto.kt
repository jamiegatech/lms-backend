package com.learning.online.dto

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.learning.online.model.CourseStudent

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
data class CourseStudentDto(val courseId: Int,
                            val studentId: Int) {
    companion object {
        fun toModel(courseStudentDto: CourseStudentDto): CourseStudent {
            return with(courseStudentDto) {
                CourseStudent(courseId, studentId, null)
            }
        }
    }
}

