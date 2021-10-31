package com.learning.online.dto

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.learning.online.model.AssignmentSubmission
import java.time.LocalDateTime

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
data class AssignmentSubmissionDto(val studentId: Int,
                                   val assignmentId: Int,
                                   val submissionDateTime: LocalDateTime,
                                   val assignmentSubmissionId: Int,
                                   val fileName: String,
                                   val documentType: String,
                                   val documentFormat: String,
                                   val uploadDir: String) {

    companion object {
        fun fromModel(assignmentSubmission: AssignmentSubmission): AssignmentSubmissionDto {
            return with(assignmentSubmission) {
                AssignmentSubmissionDto(studentId,
                        assignmentId,
                        submissionDateTime,
                        assignmentSubmissionId,
                        fileName,
                        documentType,
                        documentFormat,
                        uploadDir)
            }
        }

        fun toModel(assignmentSubmissionDto: AssignmentSubmissionDto): AssignmentSubmission {
            return with(assignmentSubmissionDto) {
                AssignmentSubmission(studentId,
                        assignmentId,
                        submissionDateTime,
                        assignmentSubmissionId,
                        fileName,
                        documentType,
                        documentFormat,
                        uploadDir
                )
            }
        }
    }
}
