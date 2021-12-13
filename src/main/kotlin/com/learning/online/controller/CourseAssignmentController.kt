package com.learning.online.controller

import com.learning.online.dto.AssignmentDto
import com.learning.online.dto.CourseAssignmentDto
import com.learning.online.service.AssignmentService
import com.learning.online.service.CourseAssignmentService
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
@RequestMapping("/course-assignments")
class CourseAssignmentController(var courseAssignmentService: CourseAssignmentService) {
    @PostMapping
    fun post(@RequestBody courseAssignmentDto: CourseAssignmentDto) = courseAssignmentService.save(CourseAssignmentDto.toModel(courseAssignmentDto))

    @DeleteMapping("/{courseId}/{assignmentId}")
    fun delete(@PathVariable courseId: Int, @PathVariable assignmentId: Int) = courseAssignmentService.deleteById(courseId, assignmentId)
}