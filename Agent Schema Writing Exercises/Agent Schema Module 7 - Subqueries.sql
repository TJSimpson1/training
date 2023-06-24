-- 1.	The full names of agents who’ve never been on a mission. --
SELECT first_name || ' ' || last_name AS agent
FROM agents
WHERE agent_id NOT IN (
        SELECT agent_id
        FROM missions_agents
);

-- 2.	The full name of the oldest agent. --
SELECT first_name || ' ' || last_name AS agent,
        birth_date
FROM agents
WHERE birth_date = (
        SELECT MIN(birth_date)
        FROM agents
);

-- 3.	The full names of agents with an above average security level. --
SELECT first_name || ' ' || last_name AS agent,
        security_level
FROM agents
WHERE security_level > (
        SELECT AVG(security_level)
        FROM agents
);

-- 4.	The code name of the most recent mission. --
SELECT code_name, 
        mission_date
FROM missions
WHERE mission_date = (
        SELECT MAX(mission_date)
        FROM missions
);

-- 5.	The full names of agents who share a birthday with a target (they can be born in different years). --
SELECT first_name || ' ' || last_name AS agent,
        birth_date
FROM agents
WHERE TO_CHAR(birth_date, 'MMDD') IN (
        SELECT TO_CHAR(birth_date, 'MMDD')
        FROM targets
);

SELECT  a.first_name || ' ' || a.last_name AS agent,
        a.birth_date,
        t.first_name || ' ' || t.last_name AS agent,
        t.birth_date
FROM targets t
INNER JOIN locations l
ON t.location_id = l.location_id
INNER JOIN agents a
ON TO_CHAR(t.birth_date, 'MMDD') = TO_CHAR(a.birth_date, 'MMDD');

-- 6.	The full names of agents who were born on the date that a mission took place. --
SELECT first_name || ' ' || last_name AS agent,
        birth_date
FROM agents
WHERE TO_CHAR(birth_date, 'YYYYMMDD') IN (
        SELECT TO_CHAR(mission_date, 'YYYYMMDD')
        FROM missions
);

SELECT *
FROM missions
WHERE TO_CHAR(mission_date, 'YYYYMMDD') = '19690702';
