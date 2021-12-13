package com.learning.online.controller

import com.learning.online.dto.AssignmentDto
import com.learning.online.dto.LectureDto
import com.learning.online.service.LectureService
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
@RequestMapping("/lectures")
class LectureController(var lectureService: LectureService) {
    @GetMapping("/course/{courseId}")
    fun getAllByCourseId(@PathVariable courseId: Int): List<LectureDto> = lectureService.findAllByCourseId(courseId).map { LectureDto.fromModel(it) }

    @GetMapping
    fun get(): List<LectureDto> = lectureService.findAll().map(LectureDto.Companion::fromModel)

    @GetMapping("/{id}")
    fun get(@PathVariable id: Int): LectureDto = lectureService.findById(id).let(LectureDto.Companion::fromModel)

    @PostMapping
    fun post(@RequestBody lectureDto: LectureDto): LectureDto = lectureService.save(LectureDto.toModel(lectureDto)).let(LectureDto.Companion::fromModel)


    @PostMapping("/{courseId}")
    fun post(@PathVariable courseId: Int, @RequestBody lectureDto: LectureDto): LectureDto = lectureService.saveWithCourseLink(LectureDto.toModel(lectureDto), courseId).let(LectureDto.Companion::fromModel)

    @PutMapping("/{id}")
    fun put(@RequestBody lectureDto: LectureDto, @PathVariable id: Int): LectureDto = lectureService.update(LectureDto.toModel(lectureDto), id).let(LectureDto.Companion::fromModel)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int) = lectureService.deleteById(id)
}