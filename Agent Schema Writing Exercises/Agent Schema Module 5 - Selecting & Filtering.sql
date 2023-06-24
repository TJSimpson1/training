-- 1.	The full names of agents with a security level above 3. --
SELECT first_name || ' ' || last_name AS agent
FROM agents
WHERE security_level > 3;

-- 2.	The full names of agents in location 1. --
SELECT first_name || ' ' || last_name AS agent
FROM agents
WHERE location_id = 1;

-- 3.	The code names of missions which took place in the last 10 days. --
SELECT code_name,
        mission_date
FROM missions
WHERE TO_CHAR(mission_date, 'YYYYMMDD') > TO_CHAR(SYSDATE - 10, 'YYYYMMDD');

-- 4.	The code names of missions which took place last year. --
SELECT code_name,
        mission_date
FROM missions
WHERE TO_CHAR(mission_date, 'YYYYMM') > TO_CHAR(ADD_MONTHS(SYSDATE, -12), 'YYYYMM')
ORDER BY mission_date;

-- 5.	The code names of missions which took place in the previous quarter and had a security level of 5 or more. --
SELECT code_name,
        mission_date
FROM missions
WHERE TO_CHAR(mission_date, 'QYYYY') = TO_CHAR(ADD_MONTHS(SYSDATE, -3), 'QYYYY');
