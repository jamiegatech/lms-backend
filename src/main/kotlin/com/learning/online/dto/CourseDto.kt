package com.learning.online.dto

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.learning.online.model.Course

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
data class CourseDto(val name: String,
                     val description: String,
                     val courseId: Int) {

    companion object {
        fun fromModel(course: Course): CourseDto {
            return with(course) {
                CourseDto(name,
                        description,
                        courseId)
            }

        }

        fun toModel(courseDto: CourseDto): Course {
            return with(courseDto) {
                Course(name,
                        description,
                        courseId)
            }
        }
    }
}

