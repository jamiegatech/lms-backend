package com.learning.online.dto

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.learning.online.model.CourseGrade

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
data class CourseGradeDto(val courseId: Int,
                          val studentId: Int,
                          val gradeId: Int) {
    companion object {
        fun toModel(associationDto: CourseGradeDto): CourseGrade {
            return with(associationDto) {
                CourseGrade(courseId,studentId, gradeId, null)
            }
        }
    }
}

