package com.learning.online.controller

import com.learning.online.dto.CourseGradeDto
import com.learning.online.service.CourseGradeService
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
@RequestMapping("/course-grades")
class CourseGradeController(var courseGradeService: CourseGradeService) {
    @PostMapping
    fun post(@RequestBody courseGradeDto: CourseGradeDto) = courseGradeService.save(CourseGradeDto.toModel(courseGradeDto))

    @DeleteMapping("/{courseId}/{studentId}/{gradeId}")
    fun delete(@PathVariable courseId: Int, @PathVariable studentId: Int, @PathVariable gradeId: Int) = courseGradeService.deleteById(courseId, studentId, gradeId)

    @DeleteMapping("/{courseId}/{gradeId}")
    fun delete(@PathVariable courseId: Int, @PathVariable gradeId: Int) = courseGradeService.deleteById(courseId, gradeId)

}