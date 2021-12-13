package com.learning.online.dto

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.learning.online.model.CourseLecture

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
data class CourseLectureDto(val courseId: Int,
                            val lectureId: Int) {
    companion object {
        fun toModel(associationDto: CourseLectureDto): CourseLecture {
            return with(associationDto) {
                CourseLecture(courseId, lectureId, null)
            }
        }
    }
}

