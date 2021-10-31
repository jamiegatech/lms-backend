package com.learning.online.dto

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.learning.online.model.Course

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
data class CourseDto(val name: String,
                     val description: String,
                     val assignments: List<AssignmentDto>,
                     val grades: List<GradeDto>,
                     val lectures: List<LectureDto>,
                     val students: List<StudentDto>,
                     val courseId: Int,
                     val instructors: List<InstructorDto>) {

    companion object {
        fun fromModel(course: Course): CourseDto {
            return with(course) {
                CourseDto(name,
                        description,
                        assignments.map(AssignmentDto.Companion::fromModel),
                        grades.map(GradeDto.Companion::fromModel),
                        lectures.map(LectureDto.Companion::fromModel),
                        students.map(StudentDto.Companion::fromModel),
                        courseId,
                        instructors.map(InstructorDto.Companion::fromModel))
            }

        }

        fun toModel(courseDto: CourseDto): Course {
            return with(courseDto) {
                Course(name,
                        description,
                        assignments.map(AssignmentDto.Companion::toModel),
                        grades.map(GradeDto.Companion::toModel),
                        lectures.map(LectureDto.Companion::toModel),
                        students.map(StudentDto.Companion::toModel),
                        courseId,
                        instructors.map(InstructorDto.Companion::toModel))
            }
        }
    }
}

