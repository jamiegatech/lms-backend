package com.learning.online.controller

import com.learning.online.dto.CourseDto
import com.learning.online.service.CourseService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/courses")
class CourseController(var courseService: CourseService) {
    @GetMapping
    fun get(): List<CourseDto> = courseService.findAll().map(CourseDto.Companion::fromModel)

    @GetMapping("/{id}")
    fun get(@PathVariable id: Int): CourseDto = courseService.findById(id).let(CourseDto.Companion::fromModel)

    @PostMapping
    fun post(@RequestBody courseDto: CourseDto): CourseDto = courseService.save(CourseDto.toModel(courseDto)).let(CourseDto.Companion::fromModel)

    @PutMapping("/{id}")
    fun put(@RequestBody courseDto: CourseDto, @PathVariable id: Int): CourseDto = courseService.update(CourseDto.toModel(courseDto), id).let(CourseDto.Companion::fromModel)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int) = courseService.deleteById(id)
}