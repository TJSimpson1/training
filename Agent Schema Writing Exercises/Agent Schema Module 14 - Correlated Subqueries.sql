-- 1.	The code name of the most recent mission in for each security level. --
SELECT m.security_level,
        m.code_name,
        m.mission_date
FROM missions m
WHERE m.mission_date = (
        SELECT MAX(m2.mission_date)
        FROM missions m2
        WHERE m.security_level = m2.security_level
)
ORDER BY m.security_level;

-- 2.	The code name of the missions with the lowest security level in each year. --
SELECT TO_CHAR(m.mission_date, 'YYYY'),
        m.code_name,
        m.security_level
FROM missions m
WHERE m.security_level = (
        SELECT MIN(m2.security_level)
        FROM missions m2
        WHERE TO_CHAR(m.mission_date, 'YYYY') = TO_CHAR(m2.mission_date, 'YYYY')
        )
ORDER BY TO_CHAR(m.mission_date, 'YYYY');

-- 3.	The name of the youngest agent in each location id. --
SELECT a.location_id,
        a.first_name || ' ' || a.last_name AS agent,
        a.birth_date
FROM agents a
WHERE a.birth_date = (
        SELECT MAX(a2.birth_date)
        FROM agents a2
        WHERE a.location_id = a2.location_id
)
ORDER BY a.location_id;

-- 4.	The code name of the mission with the highest security level in each location (show the location’s name not its id). --
SELECT l.description,
        m.code_name,
        m.security_level
FROM locations l
INNER JOIN missions m
ON l.location_id = m.location_id
WHERE m.security_level = (
        SELECT MAX(security_level)
        FROM missions m
        WHERE m.location_id = l.location_id
)
ORDER BY l.description;

