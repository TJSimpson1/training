-- 1.	The highest number of agents in a single location. --
SELECT MAX(agent_count)
FROM
(
SELECT location_id,
        COUNT(agent_id) AS agent_count
FROM agents
GROUP BY location_id
);

-- 2.	The average number of targets in a location (rounded to one decimal place). --
SELECT ROUND(AVG(number_of_targets), 1)
FROM
(
    SELECT location_id,
        COUNT(target_id) AS number_of_targets
    FROM targets
    GROUP BY location_id
);

-- 3.	The total number of agents and targets born in each year. (HINT: use a set function inside the inline view) --
SELECT birth_year,
        COUNT(birth_year)
FROM (
SELECT TO_CHAR(birth_date, 'YYYY') AS birth_year
FROM agents
UNION ALL
SELECT TO_CHAR(birth_date, 'YYYY')
FROM targets
)
GROUP BY birth_year
ORDER BY birth_year;



