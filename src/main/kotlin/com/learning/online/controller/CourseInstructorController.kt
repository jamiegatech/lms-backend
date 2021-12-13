package com.learning.online.controller

import com.learning.online.dto.CourseInstructorDto
import com.learning.online.service.CourseInstructorService
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
@RequestMapping("/course-instructors")
class CourseInstructorController(var courseInstructorService: CourseInstructorService) {
    @PostMapping
    fun post(@RequestBody courseInstructorDto: CourseInstructorDto) = courseInstructorService.save(CourseInstructorDto.toModel(courseInstructorDto))

    @DeleteMapping("/{courseId}/{instructorId}")
    fun delete(@PathVariable courseId: Int, @PathVariable instructorId: Int) = courseInstructorService.deleteById(courseId, instructorId)
}