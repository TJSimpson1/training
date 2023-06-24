-- 1.	The average security level for a mission (rounded to 2 decimal places). --
SELECT ROUND(AVG(security_level), 2)
FROM missions;

-- 2.	The total number of agents. --
SELECT COUNT(*)
FROM agents;

-- 3.	The number of missions on each security level. --
SELECT security_level,
        COUNT(*)
FROM missions
GROUP BY security_level
ORDER BY security_level;

-- 4.	The number of agents in each location id --
SELECT location_id,
        COUNT(agent_id)
FROM agents
GROUP BY location_id;

-- 5.	Modify your previous query to show the name of each location. --
SELECT l.description,
        COUNT(a.agent_id)
FROM agents a
INNER JOIN locations l 
ON a.location_id = l.location_id
GROUP BY l.description;

-- 6.	The number of agents on each mission code name. --
SELECT mission_id,
        COUNT(agent_id)
FROM missions_agents
GROUP BY mission_id
ORDER BY mission_id;

-- 7.	The number of missions in each location in the last 1000 days. --
SELECT COUNT(mission_id)
FROM missions
WHERE TO_CHAR(mission_date, 'YYYYMMDD') > TO_CHAR(SYSDATE - 1000, 'YYYYMMDD');

-- 8.	The code names of missions with a security level of 6 and the number of agents on those missions. --
SELECT m.code_name,
        COUNT(ma.agent_id)
FROM missions_agents ma
INNER JOIN missions m
ON m.mission_id = ma.mission_id
WHERE m.security_level = 6
GROUP BY m.code_name
ORDER BY m.code_name;


