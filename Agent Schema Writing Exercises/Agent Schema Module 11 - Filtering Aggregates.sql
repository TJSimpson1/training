-- 1.	Security levels with more than 30 agents. --
SELECT security_level, COUNT(*)
FROM agents
GROUP BY security_level
HAVING COUNT(*) > 30;

-- 2.	The full names of agents who’ve been on more than 50 missions. --
SELECT a.first_name || ' ' || a.last_name AS agent,
        COUNT(m.mission_id)
FROM agents a
INNER JOIN missions_agents m
ON a.agent_id = m.agent_id
GROUP BY a.first_name || ' ' || a.last_name
HAVING COUNT(m.mission_id) > 50;

-- 3.	The names of locations where there have been more than 20 missions. --
SELECT l.description,
        COUNT(m.mission_id)
FROM locations l
INNER JOIN missions m
ON l.location_id = m.location_id
GROUP BY l.description
HAVING COUNT(m.mission_id) > 20;

-- 4.	The names of locations where there have been more than 2 missions in the last 1000 days. --
SELECT l.description,
        COUNT(m.mission_id)
FROM locations l
INNER JOIN missions m
ON l.location_id = m.location_id
WHERE TO_CHAR(m.mission_date, 'YYYYMMDD') > TO_CHAR(SYSDATE - 1000, 'YYYYMMDD')
GROUP BY l.description
HAVING COUNT(m.mission_id) > 2;

-- 5.	The full names of agents who’ve been on missions with an average security level of more than 4. --
SELECT a.first_name || ' ' || a.last_name AS agent,
        AVG(m.security_level)
FROM agents a
INNER JOIN missions_agents ma
ON a.agent_id = ma.agent_id
INNER JOIN missions m
ON ma.mission_id = m.mission_id
GROUP BY a.first_name || ' ' || a.last_name
HAVING AVG(m.security_level) > 4;

-- 6.	The full names of agents who’ve been on more than 5 missions with a security level of at least 5. --
SELECT a.first_name || ' ' || a.last_name AS agent,
        COUNT(m.security_level)
FROM agents a
INNER JOIN missions_agents ma
ON a.agent_id = ma.agent_id
INNER JOIN missions m
ON ma.mission_id = m.mission_id
WHERE m.security_level >= 5
GROUP BY a.first_name || ' ' || a.last_name
HAVING COUNT(m.security_level) > 5;

-- 7.	The year with the most missions --
SELECT TO_CHAR(mission_date, 'YYYY'),
        COUNT(TO_CHAR(mission_date, 'YYYY'))
FROM missions
GROUP BY TO_CHAR(mission_date, 'YYYY')
HAVING COUNT(TO_CHAR(mission_date, 'YYYY')) = (
        SELECT MAX(COUNT(TO_CHAR(mission_date, 'YYYY')))
        FROM missions
        GROUP BY TO_CHAR(mission_date, 'YYYY')
);

-- 8.	The names of locations which have at least 7 agents and at least 7 targets. --
SELECT l.description
FROM locations l
INNER JOIN agents a
ON l.location_id = a.location_id
GROUP BY l.description
HAVING COUNT(a.agent_id) > 6
INTERSECT
SELECT l.description
FROM locations l
INNER JOIN targets t
ON l.location_id = t.location_id
GROUP BY l.description
HAVING COUNT(t.target_id) > 6;

