-- Write a query which shows trade ids traded by broker 1.
-- Write a query which shows trade ids traded on stock exchange 3. 
SELECT trade_id
FROM trades
WHERE broker_id = 1;

SELECT trade_id
FROM trades
WHERE stock_ex_id = 3;

-- 1.	Use a set function to combine the two queries to show trade ids which were traded by broker 1 or traded on stock exchange 3 (or both). --
SELECT trade_id
FROM trades
WHERE broker_id = 1
UNION
SELECT trade_id
FROM trades
WHERE stock_ex_id = 3;

-- 2.	Use a set function to show trade ids which were traded by broker 1 but not traded on stock exchange 3. --
SELECT trade_id
FROM trades
WHERE broker_id = 1
MINUS
SELECT trade_id
FROM trades
WHERE stock_ex_id = 3;

-- 3.	Use a set function to show trade ids which were traded by broker 1 on stock exchange 3. --
SELECT trade_id
FROM trades
WHERE broker_id = 1
INTERSECT
SELECT trade_id
FROM trades
WHERE stock_ex_id = 3;

