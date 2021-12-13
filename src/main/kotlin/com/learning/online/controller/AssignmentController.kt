package com.learning.online.controller

import com.learning.online.dto.AssignmentDto
import com.learning.online.service.AssignmentService
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
@RequestMapping("/assignments")
class AssignmentController(var assignmentService: AssignmentService) {
    @GetMapping("/course/{courseId}")
    fun getAllByCourseId(@PathVariable courseId: Int): List<AssignmentDto> = assignmentService.findAllByCourseId(courseId).map { AssignmentDto.fromModel(it) }

    @GetMapping("/{id}")
    fun get(@PathVariable id: Int): AssignmentDto = assignmentService.findById(id).let { AssignmentDto.fromModel(it) }

    @PostMapping
    fun post(@RequestBody assignmentDto: AssignmentDto): AssignmentDto = assignmentService.save(AssignmentDto.toModel(assignmentDto)).let { AssignmentDto.fromModel(it) }

    @PostMapping("/{courseId}")
    fun post(@PathVariable courseId: Int,@RequestBody assignmentDto: AssignmentDto): AssignmentDto = assignmentService.saveWithCourseLink(AssignmentDto.toModel(assignmentDto),courseId).let { AssignmentDto.fromModel(it) }

    @PutMapping("/{id}")
    fun put(@RequestBody assignmentDto: AssignmentDto, @PathVariable id: Int): AssignmentDto = assignmentService.update(AssignmentDto.toModel(assignmentDto), id).let { AssignmentDto.fromModel(it) }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int) = assignmentService.deleteById(id)
}