CREATE TABLE assignment
(
    assignment_id INT IDENTITY PRIMARY KEY,
    name          VARCHAR(250) DEFAULT NULL,
    description   VARCHAR(250) DEFAULT NULL,
    due_date      TIMESTAMP    DEFAULT CURRENT_TIMESTAMP,
    course_id     INT          DEFAULT NULL
);

CREATE TABLE assignment_submission
(
    assignment_submission_id INT IDENTITY PRIMARY KEY,
    submission_date_time     TIMESTAMP    DEFAULT CURRENT_TIMESTAMP,
    course_id                INT          DEFAULT NULL,
    student_id               INT          DEFAULT NULL,
    assignment_id            INT          DEFAULT NULL,
    file_name                VARCHAR(250) DEFAULT NULL,
    document_type            VARCHAR(250) DEFAULT NULL,
    document_format          VARCHAR(250) DEFAULT NULL,
    upload_dir               VARCHAR(250) DEFAULT NULL
);

CREATE TABLE grade
(
    grade_id      INT IDENTITY PRIMARY KEY,
    description   VARCHAR(250) DEFAULT NULL,
    course_id     INT          DEFAULT NULL,
    assignment_id INT          DEFAULT NULL,
    actual        DOUBLE       DEFAULT NULL,
    possible      DOUBLE       DEFAULT NULL
);

CREATE TABLE instructor
(
    instructor_id  INT IDENTITY PRIMARY KEY,
    first_name     VARCHAR(250) DEFAULT NULL,
    last_name      VARCHAR(250) DEFAULT NULL,
    preferred_name VARCHAR(250) DEFAULT NULL,
    degree         VARCHAR(250) DEFAULT NULL
);

CREATE TABLE student
(
    student_id     INT IDENTITY PRIMARY KEY,
    first_name     VARCHAR(250) DEFAULT NULL,
    last_name      VARCHAR(250) DEFAULT NULL,
    preferred_name VARCHAR(250) DEFAULT NULL
);

CREATE TABLE lecture
(
    lecture_id  INT IDENTITY PRIMARY KEY,
    name        VARCHAR(250) DEFAULT NULL,
    description VARCHAR(250) DEFAULT NULL,
    video_link  VARCHAR(250) DEFAULT NULL
);

CREATE TABLE course
(
    course_id   INT IDENTITY PRIMARY KEY,
    name        VARCHAR(250) DEFAULT NULL,
    description VARCHAR(250) DEFAULT NULL
);

CREATE TABLE course_lectures
(
    course_lecture_id INT IDENTITY PRIMARY KEY,
    course_id         INT,
    FOREIGN KEY (course_id) REFERENCES course (course_id),
    lecture_id        INT,
    FOREIGN KEY (lecture_id) REFERENCES lecture (lecture_id)
);

CREATE TABLE course_assignments
(
    course_assignment_id INT IDENTITY PRIMARY KEY,
    course_id            INT,
    FOREIGN KEY (course_id) REFERENCES course (course_id) ON DELETE NO ACTION ON UPDATE NO ACTION,
    assignment_id        INT,
    FOREIGN KEY (assignment_id) REFERENCES assignment (assignment_id) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE course_grades
(
    course_grade_id INT IDENTITY PRIMARY KEY,
    course_id       INT,
    FOREIGN KEY (course_id) REFERENCES course (course_id) ON DELETE NO ACTION ON UPDATE NO ACTION,
    grade_id        INT,
    FOREIGN KEY (grade_id) REFERENCES grade (grade_id) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE course_students
(
    course_student_id INT IDENTITY PRIMARY KEY,
    course_id         INT,
    FOREIGN KEY (course_id) REFERENCES course (course_id) ON DELETE NO ACTION ON UPDATE NO ACTION,
    student_id        INT,
    FOREIGN KEY (student_id) REFERENCES student (student_id) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE course_instructors
(
    course_instructor_id INT IDENTITY PRIMARY KEY,
    course_id            INT,
    FOREIGN KEY (course_id) REFERENCES course (course_id) ON DELETE NO ACTION ON UPDATE NO ACTION,
    instructor_id        INT,
    FOREIGN KEY (instructor_id) REFERENCES instructor (instructor_id) ON DELETE NO ACTION ON UPDATE NO ACTION
);
--
-- Insert Into course (name, description)
-- VALUES ('test_name', 'test_desc');
-- Insert Into assignment (name, description, due_date, course_id)
-- VALUES ('test_name', 'test_desc', default, 1);
