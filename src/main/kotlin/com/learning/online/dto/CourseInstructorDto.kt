package com.learning.online.dto

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.learning.online.model.CourseInstructor
import com.learning.online.model.CourseStudent

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
data class CourseInstructorDto(val courseId: Int,
                               val instructorId: Int) {
    companion object {
        fun toModel(courseInstructorDto: CourseInstructorDto): CourseInstructor {
            return with(courseInstructorDto) {
                CourseInstructor(courseId, instructorId, null)
            }
        }
    }
}

