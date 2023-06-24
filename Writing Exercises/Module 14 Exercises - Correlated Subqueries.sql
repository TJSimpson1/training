-- 1.	Use a correlated subquery to show the trade_id of the earliest transaction_time for each stock_exchange. 
--      The output should have 3 columns: stock_ex_id, trade_id, transaction_time. --
SELECT t.stock_ex_id,
        t.trade_id,
        t.transaction_time
FROM trades t
WHERE t.transaction_time = (
        SELECT MIN(t2.transaction_time)
        FROM trades t2
        WHERE t.stock_ex_id = t2.stock_ex_id
)
ORDER BY t.stock_ex_id;

-- 2.	Use a correlated subquery to show the broker with the highest price total for each stock_exchange. 
--      The output should have 3 columns: stock_ex_id, broker_id, price_total. --
SELECT t.stock_ex_id,
        t.broker_id,
        t.price_total
FROM trades t
WHERE t.price_total = (
        SELECT MAX(t2.price_total)
        FROM trades t2
        WHERE t.stock_ex_id = t2.stock_ex_id
)
ORDER BY t.stock_ex_id;

-- 3.	Modify your query from question 1 to show the name of the stock exchange instead of the stock_ex_id. --
SELECT s.name,
        t.trade_id,
        t.transaction_time
FROM trades t
INNER JOIN stock_exchanges s
ON t.stock_ex_id = s.stock_ex_id
WHERE t.transaction_time = (
        SELECT MIN(t2.transaction_time)
        FROM trades t2
        WHERE t.stock_ex_id = t2.stock_ex_id
);

-- 4.	Modify your query from question 2 to show the name of the stock exchange and the name of the broker instead of their IDs. --
SELECT s.name,
        b.first_name || ' ' || b.last_name AS broker,
        t.price_total
FROM trades t
INNER JOIN brokers b
ON t.broker_id = b.broker_id
INNER JOIN stock_exchanges s
ON s.stock_ex_id = t.stock_ex_id
WHERE t.price_total = (
        SELECT MAX(t2.price_total)
        FROM trades t2
        WHERE t.stock_ex_id = t2.stock_ex_id
);

-- 5.	Use a correlated subquery to show the broker with the lowest share amount for each month.
--      The output should have 3 columns:  month, broker_id, share_amount.  --
SELECT TO_CHAR(t.transaction_time, 'YYMM'),
        t.broker_id,
        t.share_amount
FROM trades t
WHERE t.share_amount = (
        SELECT MIN(t2.share_amount)
        FROM trades t2
        WHERE TO_CHAR(t.transaction_time, 'YYMM') = TO_CHAR(t2.transaction_time, 'YYMM')
)
ORDER BY TO_CHAR(t.transaction_time, 'YYMM');

-- 6.	Modify the previous query to show the name of the broker instead of the broker_id. --
SELECT TO_CHAR(t.transaction_time, 'YYMM'),
        b.first_name || ' ' || b.last_name AS broker,
        t.share_amount
FROM trades t
INNER JOIN brokers b
ON t.broker_id = b.broker_id
WHERE t.share_amount = (
        SELECT MIN(t2.share_amount)
        FROM trades t2
        WHERE TO_CHAR(t.transaction_time, 'YYMM') = TO_CHAR(t2.transaction_time, 'YYMM')
)
ORDER BY TO_CHAR(t.transaction_time, 'YYMM');

