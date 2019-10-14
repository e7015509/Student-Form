SELECT count(sca.course_cd) from student_course_attempt sca left join course_version cv on sca.course_cd=cv.course_cd where sca.course_attempt_status in('ENROLLED','INACTIVE') and sca.person_id = '4610792' and cv.course_status='ACTIVE' order by cv.title