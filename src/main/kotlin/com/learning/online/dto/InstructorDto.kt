package com.learning.online.dto

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.learning.online.model.Instructor

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
data class InstructorDto(val firstName: String,
                         val lastName: String,
                         val preferredName: String,
                         val degree: String,
                         val instructorId: Int) {

    companion object {
        fun fromModel(instructor: Instructor): InstructorDto {
            return with(instructor) {
                InstructorDto(firstName, lastName, preferredName, degree, instructorId)
            }

        }

        fun toModel(instructorDto: InstructorDto): Instructor {
            return with(instructorDto) {
                Instructor(firstName, lastName, preferredName, degree, instructorId)
            }
        }
    }
}
