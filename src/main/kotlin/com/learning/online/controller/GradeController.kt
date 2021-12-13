package com.learning.online.controller

import com.learning.online.dto.GradeDto
import com.learning.online.service.GradeService
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RestController
@RequestMapping("/grades")
class GradeController(var gradeService: GradeService) {
    @GetMapping
    fun get(): List<GradeDto> = gradeService.findAll().map(GradeDto.Companion::fromModel)

//    @GetMapping("/course/{courseId}/{assignmentId}")
//    fun getByCourseAndAssignment(@PathVariable courseId: Int, @PathVariable assignmentId: Int): List<GradeDto> = gradeService.findAllByCourseIdAndAssignmentId(courseId, assignmentId).map(GradeDto.Companion::fromModel)

    @GetMapping("/course/{courseId}")
    fun getByCourse(@PathVariable courseId: Int): List<GradeDto> = gradeService.findAllByCourseId(courseId).map(GradeDto.Companion::fromModel)

    @GetMapping("/course/{courseId}/{studentId}")
    fun getByCourseAndByStudent(@PathVariable courseId: Int,@PathVariable studentId: Int): List<GradeDto> = gradeService.findAllByCourseIdAndStudentId(courseId, studentId).map(GradeDto.Companion::fromModel)

    @GetMapping("/{id}")
    fun get(@PathVariable id: Int): GradeDto = gradeService.findById(id).let(GradeDto.Companion::fromModel)

    @PostMapping
    fun post(@RequestBody gradeDto: GradeDto): GradeDto = gradeService.save(GradeDto.toModel(gradeDto)).let(GradeDto.Companion::fromModel)

    @PostMapping("/{courseId}/{studentId}")
    fun post(@RequestBody gradeDto: GradeDto,@PathVariable courseId: Int,@PathVariable studentId: Int): GradeDto = gradeService.saveWithCourseLink(GradeDto.toModel(gradeDto), courseId, studentId).let(GradeDto.Companion::fromModel)

    @PutMapping("/{id}")
    fun put(@RequestBody gradeDto: GradeDto, @PathVariable id: Int): GradeDto = gradeService.update(GradeDto.toModel(gradeDto), id).let(GradeDto.Companion::fromModel)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int) = gradeService.deleteById(id)
}