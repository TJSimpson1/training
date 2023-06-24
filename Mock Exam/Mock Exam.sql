SELECT name,
        start_date
FROM trainees
WHERE TO_CHAR(start_date, 'YYYYMM') = TO_CHAR(SYSDATE, 'YYYYMM');

SELECT course_id,
        ROUND(AVG(score))
FROM exam_results
GROUP BY course_id
ORDER BY ROUND(AVG(score));

SELECT name, start_date
FROM trainees
WHERE start_date = (
    SELECT MIN(start_date)
    FROM trainees
);

SELECT t.name,
        t.start_date,
        t.academy_id
FROM trainers t
WHERE t.start_date = (
        SELECT MIN(t2.start_date)
        FROM trainers t2
        WHERE t2.academy_id = t.academy_id
);

SELECT t.name AS trainee,
        c.name AS course,
        er.score 
FROM trainees t
LEFT OUTER JOIN 
        exam_results er
ON er.trainee_id = t.trainee_id
LEFT OUTER JOIN 
        courses c
ON      c.course_id = er.course_id
;
    


