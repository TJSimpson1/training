-- 1.	Write a query which shows the names of stock exchanges where some trades have been made. --
SELECT name 
FROM stock_exchanges
WHERE stock_ex_id IN (
        SELECT stock_ex_id
        FROM trades
);

SELECT DISTINCT s.name
FROM stock_exchanges s
INNER JOIN trades t
ON s.stock_ex_id = t.stock_ex_id;

-- 2.	Modify your previous query so that it shows the names of stock exchanges where no trades have been made. --
SELECT name 
FROM stock_exchanges
WHERE stock_ex_id NOT IN (
        SELECT stock_ex_id
        FROM trades
);

SELECT DISTINCT s.name
FROM stock_exchanges s
LEFT OUTER JOIN trades t
ON s.stock_ex_id = t.stock_ex_id
WHERE t.stock_ex_id IS NULL;

-- 3.	Write a query which shows the names of cities which have a stock exchange. --
SELECT city
FROM places
WHERE place_id IN (
        SELECT place_id
        FROM stock_exchanges
);

SELECT p.city
FROM places p
INNER JOIN stock_exchanges s
ON s.place_id = p.place_id;

-- 4.	Modify your previous query to show cities which don’t have a stock exchange. --
SELECT city
FROM places
WHERE place_id NOT IN (
        SELECT place_id
        FROM stock_exchanges
);

SELECT p.city
FROM places p
LEFT OUTER JOIN stock_exchanges s
ON s.place_id = p.place_id
WHERE s.place_id IS NULL;
