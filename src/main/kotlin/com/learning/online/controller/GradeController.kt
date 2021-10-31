package com.learning.online.controller

import com.learning.online.dto.GradeDto
import com.learning.online.service.GradeService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/grades")
class GradeController(var gradeService: GradeService) {
    @GetMapping
    fun get(): List<GradeDto> = gradeService.findAll().map(GradeDto.Companion::fromModel)

    @GetMapping("/{id}")
    fun get(@PathVariable id: Int): GradeDto = gradeService.findById(id).let(GradeDto.Companion::fromModel)

    @PostMapping
    fun post(@RequestBody gradeDto: GradeDto): GradeDto = gradeService.save(GradeDto.toModel(gradeDto)).let(GradeDto.Companion::fromModel)

    @PutMapping("/{id}")
    fun put(@RequestBody gradeDto: GradeDto, @PathVariable id: Int): GradeDto = gradeService.update(GradeDto.toModel(gradeDto), id).let(GradeDto.Companion::fromModel)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int) = gradeService.deleteById(id)
}