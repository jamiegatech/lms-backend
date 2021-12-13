package com.learning.online.controller

import com.learning.online.dto.CourseStudentDto
import com.learning.online.dto.StudentDto
import com.learning.online.service.CourseStudentService
import com.learning.online.service.StudentService
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
@RequestMapping("/course-students")
class CourseStudentController(var courseStudentService: CourseStudentService) {
    @PostMapping
    fun post(@RequestBody courseStudentDto: CourseStudentDto) = courseStudentService.save(CourseStudentDto.toModel(courseStudentDto))

    @DeleteMapping("/{courseId}/{studentId}")
    fun delete(@PathVariable courseId: Int, @PathVariable studentId: Int) = courseStudentService.deleteById(courseId,  studentId)
}