package com.learning.online.controller

import com.learning.online.dto.InstructorDto
import com.learning.online.service.InstructorService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/instructors")
class InstructorController(var instructorService: InstructorService) {
    @GetMapping
    fun get(): List<InstructorDto> = instructorService.findAll().map(InstructorDto.Companion::fromModel)

    @GetMapping("/{id}")
    fun get(@PathVariable id: Int): InstructorDto = instructorService.findById(id).let(InstructorDto.Companion::fromModel)

    @PostMapping
    fun post(@RequestBody instructorDto: InstructorDto): InstructorDto = instructorService.save(InstructorDto.toModel(instructorDto)).let(InstructorDto.Companion::fromModel)

    @PutMapping("/{id}")
    fun put(@RequestBody instructorDto: InstructorDto, @PathVariable id: Int): InstructorDto = instructorService.update(InstructorDto.toModel(instructorDto), id).let(InstructorDto.Companion::fromModel)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int) = instructorService.deleteById(id)
}