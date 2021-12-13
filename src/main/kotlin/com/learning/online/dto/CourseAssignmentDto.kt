package com.learning.online.dto

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.learning.online.model.CourseAssignment

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
data class CourseAssignmentDto(val courseId: Int,
                               val assignmentId: Int) {
    companion object {
        fun toModel(associationDto: CourseAssignmentDto): CourseAssignment {
            return with(associationDto) {
                CourseAssignment(courseId, assignmentId, null)
            }
        }
    }
}

