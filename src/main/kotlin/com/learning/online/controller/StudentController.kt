package com.learning.online.controller

import com.learning.online.dto.StudentDto
import com.learning.online.service.StudentService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/students")
class StudentController(var studentService: StudentService) {
    @GetMapping
    fun get(): List<StudentDto> = studentService.findAll().map(StudentDto.Companion::fromModel)

    @GetMapping("/{id}")
    fun get(@PathVariable id: Int): StudentDto = studentService.findById(id).let(StudentDto.Companion::fromModel)

    @PostMapping
    fun post(@RequestBody studentDto: StudentDto): StudentDto = studentService.save(StudentDto.toModel(studentDto)).let(StudentDto.Companion::fromModel)

    @PutMapping("/{id}")
    fun put(@RequestBody studentDto: StudentDto, @PathVariable id: Int): StudentDto = studentService.update(StudentDto.toModel(studentDto), id).let(StudentDto.Companion::fromModel)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int) = studentService.deleteById(id)
}