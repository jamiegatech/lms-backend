package com.learning.online.model


import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "ASSIGNMENT_SUBMISSION")
data class AssignmentSubmission(@Column(name = "student_id") val studentId: Int,
                                @Column(name = "assignment_id") val assignmentId: Int,
                                @Column(name = "submission_date_time") val submissionDateTime: LocalDateTime,
                                @GeneratedValue(strategy= GenerationType.IDENTITY) @Column(name = "assignment_submission_id") @Id val assignmentSubmissionId: Int,
                                @Column(name = "file_name") val fileName: String,
                                @Column(name = "document_type") val documentType: String,
                                @Column(name = "document_format") val documentFormat: String,
                                @Column(name = "upload_dir") val uploadDir: String
)
