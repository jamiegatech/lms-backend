package com.learning.online.dto

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.learning.online.model.Lecture

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
data class LectureDto(val name: String,
                      val courseId: Int,
                      val description: String,
                      val videoLink: String,
                      val lectureId: Int) {

    companion object {
        fun fromModel(lecture: Lecture): LectureDto {
            return with(lecture) {
                LectureDto(name, courseId, description, videoLink, lectureId)
            }

        }

        fun toModel(lectureDto: LectureDto): Lecture {
            return with(lectureDto) {
                Lecture(name, courseId, description, videoLink, lectureId)
            }
        }
    }
}

