-- 1.	Agent ids of agents who haven’t been on a mission. --
SELECT agent_id
FROM agents
MINUS 
SELECT agent_id
FROM missions_agents;

-- 2.	The birth dates of the oldest and the youngest agent (in a single column) --
SELECT birth_date
FROM agents
MINUS
(SELECT birth_date
FROM agents
MINUS
SELECT MAX(birth_date)
FROM agents
MINUS
SELECT MIN(birth_date)
FROM agents);

-- 3.	Dates when an agent and a target were born (use TO_CHAR and show in the format like ’28 June 2017’) --
SELECT TO_CHAR(birth_date, 'DD MONTH YYYY') AS birthday
FROM agents
INTERSECT
SELECT TO_CHAR(birth_date, 'DD MONTH YYYY') 
FROM targets;

-- 4.	Dates when an agent or a target were born (use TO_CHAR and show in the format like ’28 June 2017’). --
SELECT TO_CHAR(birth_date, 'DD MONTH YYYY') AS birthday
FROM agents
UNION
SELECT TO_CHAR(birth_date, 'DD MONTH YYYY') 
FROM targets;

-- 5.	Agent’s birthdays (day and month) which are not also the birthday of a target (use TO_CHAR and show in the format like ’28 June’). --
SELECT TO_CHAR(birth_date, 'DD MONTH') AS birthday
FROM agents
MINUS
SELECT TO_CHAR(birth_date, 'DD MONTH') 
FROM targets;


