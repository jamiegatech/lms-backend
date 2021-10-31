package com.learning.online.dto

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.learning.online.model.Grade

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
data class GradeDto(val courseId: Int,
                    val assignmentId: Int,
                    val description: String,
                    val actual: Double,
                    val possible: Double,
                    val gradeId: Int) {

    companion object {
        fun fromModel(grade: Grade): GradeDto {
            return with(grade) {
                GradeDto(courseId, assignmentId, description, actual, possible, gradeId)
            }

        }

        fun toModel(gradeDto: GradeDto): Grade {
            return with(gradeDto) {
                Grade(courseId, assignmentId, description, actual, possible, gradeId)
            }
        }
    }
}
