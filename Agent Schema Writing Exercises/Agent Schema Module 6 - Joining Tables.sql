-- 1.	The full names of agents and the names of their locations
SELECT a.first_name || ' ' || a.last_name AS agent,
        l.description
FROM agents a
INNER JOIN locations l
ON a.location_id = l.location_id;

-- 2.	The full names of agents and the code names of any missions they’ve been on.
SELECT a.first_name || ' ' || a.last_name AS agent,
        m.code_name
FROM agents a
INNER JOIN missions m
ON a.location_id = m.location_id;


-- 3.	The code names of missions and the full names of any targets of those missions.
SELECT m.code_name,
        t.first_name || ' ' || t.last_name
FROM missions m
INNER JOIN missions_targets mt
ON m.mission_id = mt.mission_id
INNER JOIN targets t
ON mt.target_id = t.target_id;

-- 4.	The full names of targets located in Oxford.
SELECT t.first_name || ' ' || t.last_name AS target
FROM targets t
INNER JOIN locations l
ON t.location_id = l.location_id
WHERE l.description = 'Oxford';

-- 5.	The full names of any agents who haven’t been on a mission.
SELECT a.first_name || ' ' || a.last_name AS agent
FROM agents a
LEFT OUTER JOIN missions_agents ma
ON a.agent_id = ma.agent_id
WHERE ma.mission_id IS NULL;

-- 6.	The code names of any missions which took place in Lincoln or Manchester last year.
SELECT m.code_name, 
        l.description
FROM missions m
INNER JOIN locations l
ON m.location_id = l.location_id
WHERE l.description = 'Manchester' OR l.description = 'Lincoln';

