-- 1.	List broker IDs which have an average price total of over 4,000,000 --
SELECT broker_id,
        AVG(price_total)
FROM trades
GROUP BY broker_id
HAVING AVG(price_total) > 4000000;

-- 2.	List stock exchange IDs where each stock exchange’s earliest transaction time took place within the last 365 days. --
SELECT stock_ex_id,
        MIN(transaction_time)
FROM trades
GROUP BY stock_ex_id
HAVING TO_CHAR(MIN(transaction_time), 'YYMMDD') > TO_CHAR(SYSDATE - 365, 'YYMMDD');

-- 3.	List currency IDs used to price 4 or more shares. --
SELECT currency_id,
        COUNT(*)
FROM shares
GROUP BY currency_id
HAVING COUNT(*) >= 4;

-- 4.	List share IDs with a total share amount above 100,000 --
SELECT share_id,
        SUM(share_amount)
FROM trades
GROUP BY share_id
HAVING SUM(share_amount) > 100000;

-- 5.	List place IDs with more than 2 companies. --
SELECT place_id,
        COUNT(*)
FROM companies
GROUP BY place_id
HAVING COUNT(*) > 2;

-- 6.	List share IDs whose highest price total is above 1 million. --
SELECT share_id,
        MAX(price_total)
FROM trades
GROUP BY share_id
HAVING MAX(price_total) > 1000000;

-- 7.	List share IDs which have been traded more than twice by broker ID 1. --
SELECT share_id,
        COUNT(*)
FROM trades
WHERE broker_id = 1
GROUP BY share_id
HAVING COUNT(*) > 2;

-- 8.	List share IDs which have more than 5 trades with a price_total above 1 million. --
SELECT share_id,
        COUNT(*)
FROM trades
WHERE price_total > 1000000
GROUP BY share_id
HAVING COUNT(*) > 5;

--===========================================================================================================================================================--
--===========================================================================================================================================================--
--================================================================EXTRA EXERCISES============================================================================--
--===========================================================================================================================================================--
--===========================================================================================================================================================--

-- 1.	List stock ex ids with an average share amount above 1000 in the last 60 days. --
SELECT stock_ex_id,
        AVG(share_amount)
FROM trades
WHERE TO_CHAR(transaction_time, 'YYMMDD') > TO_CHAR(SYSDATE - 60, 'YYMMDD')
GROUP BY stock_ex_id
HAVING AVG(share_amount) > 1000;

-- 2.	Modify your query to show the names of the stock exchanges. --
SELECT s.name,
        AVG(t.share_amount)
FROM trades t
INNER JOIN stock_exchanges s
ON t.stock_ex_id = s.stock_ex_id
WHERE TO_CHAR(t.transaction_time, 'YYMMDD') > TO_CHAR(SYSDATE - 60, 'YYMMDD')
GROUP BY s.name
HAVING AVG(t.share_amount) > 1000;

-- 3.	List broker ids who’s lowest share amount on stock ex id 1 is greater than 500 --
SELECT broker_id,
        MIN(share_amount)
FROM trades
WHERE stock_ex_id = 1
GROUP BY broker_id
HAVING MIN(share_amount) > 500;

-- 4.	Modify your query to show the names of the brokers. --
SELECT b.first_name || ' ' || b.last_name AS broker,
        MIN(t.share_amount)
FROM trades t
INNER JOIN brokers b
ON t.broker_id = b.broker_id
WHERE t.stock_ex_id = 1
GROUP BY b.first_name || ' ' || b.last_name
HAVING MIN(t.share_amount) > 500;

-- 5.	List share ids which broker 1 has traded more than 10 times. --
SELECT share_id,
        COUNT(*)
FROM trades
WHERE broker_id = 1
GROUP BY share_id
HAVING COUNT(*) > 10;

-- 6.	List the names of companies in London with an average share price above 150. --
SELECT c.name,
        AVG(sp.price)
FROM companies c
INNER JOIN places p
ON p.place_id = c.place_id
INNER JOIN shares s
ON c.company_id = s.company_id
INNER JOIN shares_prices sp
ON s.share_id = sp.share_id
WHERE p.city = 'London'
GROUP BY c.name
HAVING AVG(sp.price) > 150;

-- 7.	Display the name of the broker who has the highest average share amount. --
SELECT b.first_name || ' ' || b.last_name AS broker,
        AVG(t.share_amount)
FROM brokers b
INNER JOIN trades t
ON b.broker_id = t.broker_id
GROUP BY b.first_name || ' ' || b.last_name
HAVING AVG(t.share_amount) = (
        SELECT MAX(AVG(share_amount))
        FROM trades
        GROUP BY broker_id
);

-- 8.	List share IDs whose lowest share amount is greater than the highest share amount for share ID 4. --
SELECT share_id,
        MIN(share_amount)
FROM trades
GROUP BY share_id
HAVING MIN(share_amount) > (
        SELECT MAX(share_amount)
        FROM trades
        WHERE share_id = 4
);

