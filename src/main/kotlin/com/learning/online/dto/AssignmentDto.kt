package com.learning.online.dto

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.learning.online.model.Assignment
import java.time.LocalDateTime

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
data class AssignmentDto(val courseId: Int,
                         val name: String,
                         val description: String,
                         val dueDate: LocalDateTime,
                         val assignmentId: Int) {

    companion object {
        fun fromModel(assignment: Assignment): AssignmentDto {
            return with(assignment) {
                AssignmentDto(courseId, name, description, dueDate, assignmentId)
            }

        }

        fun toModel(assignmentDto: AssignmentDto): Assignment {
            return with(assignmentDto) {
                Assignment(courseId, name, description, dueDate, assignmentId)
            }
        }
    }
}
