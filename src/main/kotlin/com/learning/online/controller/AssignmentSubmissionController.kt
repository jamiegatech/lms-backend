package com.learning.online.controller

import com.learning.online.dto.AssignmentSubmissionDto
import com.learning.online.service.AssignmentSubmissionService
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
@RequestMapping("/assignment-submissions")
class AssignmentSubmissionController(var assignmentSubmissionService: AssignmentSubmissionService) {
    @GetMapping
    fun get(): List<AssignmentSubmissionDto> = assignmentSubmissionService.findAll().map(AssignmentSubmissionDto.Companion::fromModel)

    @GetMapping("/{id}")
    fun get(@PathVariable id: Int): AssignmentSubmissionDto = assignmentSubmissionService.findById(id).let(AssignmentSubmissionDto.Companion::fromModel)

    @PostMapping
    fun post(@RequestBody assignmentSubmissionDto: AssignmentSubmissionDto): AssignmentSubmissionDto = assignmentSubmissionService.save(AssignmentSubmissionDto.toModel(assignmentSubmissionDto)).let(AssignmentSubmissionDto.Companion::fromModel)

    @PutMapping("/{id}")
    fun put(@RequestBody assignmentSubmissionDto: AssignmentSubmissionDto, @PathVariable id: Int): AssignmentSubmissionDto = assignmentSubmissionService.update(AssignmentSubmissionDto.toModel(assignmentSubmissionDto), id).let(AssignmentSubmissionDto.Companion::fromModel)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int) = assignmentSubmissionService.deleteById(id)
}