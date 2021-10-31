package com.learning.online.controller

import com.learning.online.dto.AssignmentDto
import com.learning.online.service.AssignmentService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/assignments")
class AssignmentController(var assignmentService: AssignmentService) {
    @GetMapping
    fun get(): List<AssignmentDto> = assignmentService.findAll().map(AssignmentDto.Companion::fromModel)

    @GetMapping("/{id}")
    fun get(@PathVariable id: Int): AssignmentDto = assignmentService.findById(id).let(AssignmentDto.Companion::fromModel)

    @PostMapping
    fun post(@RequestBody assignmentDto: AssignmentDto): AssignmentDto = assignmentService.save(AssignmentDto.toModel(assignmentDto)).let(AssignmentDto.Companion::fromModel)

    @PutMapping("/{id}")
    fun put(@RequestBody assignmentDto: AssignmentDto, @PathVariable id: Int): AssignmentDto = assignmentService.update(AssignmentDto.toModel(assignmentDto), id).let(AssignmentDto.Companion::fromModel)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int) = assignmentService.deleteById(id)
}