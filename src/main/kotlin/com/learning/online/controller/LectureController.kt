package com.learning.online.controller

import com.learning.online.dto.LectureDto
import com.learning.online.service.LectureService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/lectures")
class LectureController(var lectureService: LectureService) {
    @GetMapping
    fun get(): List<LectureDto> = lectureService.findAll().map(LectureDto.Companion::fromModel)

    @GetMapping("/{id}")
    fun get(@PathVariable id: Int): LectureDto = lectureService.findById(id).let(LectureDto.Companion::fromModel)

    @PostMapping
    fun post(@RequestBody lectureDto: LectureDto): LectureDto = lectureService.save(LectureDto.toModel(lectureDto)).let(LectureDto.Companion::fromModel)

    @PutMapping("/{id}")
    fun put(@RequestBody lectureDto: LectureDto, @PathVariable id: Int): LectureDto = lectureService.update(LectureDto.toModel(lectureDto), id).let(LectureDto.Companion::fromModel)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int) = lectureService.deleteById(id)
}