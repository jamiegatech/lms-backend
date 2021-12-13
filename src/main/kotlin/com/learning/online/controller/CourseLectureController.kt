package com.learning.online.controller

import com.learning.online.dto.CourseLectureDto
import com.learning.online.service.CourseLectureService
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
@RequestMapping("/course-lectures")
class CourseLectureController(var courseLectureService: CourseLectureService) {
    @PostMapping
    fun post(@RequestBody courseLectureDto: CourseLectureDto) = courseLectureService.save(CourseLectureDto.toModel(courseLectureDto))

    @DeleteMapping("/{courseId}/{lectureId}")
    fun delete(@PathVariable courseId: Int, @PathVariable lectureId: Int) = courseLectureService.deleteById(courseId, lectureId)
}