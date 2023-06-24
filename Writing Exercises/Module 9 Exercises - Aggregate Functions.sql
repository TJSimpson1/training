-- 1.	Show the average price total for each broker. The results should have two columns: broker_id and average price total. --
SELECT broker_id,
        ROUND(AVG(price_total), 2)
FROM trades
GROUP BY broker_id;

-- 2.	Find the date of the earliest trade for each stock exchange. The results should have two columns: stock_ex_id and transaction_time. --
SELECT stock_ex_id,
        MIN(transaction_time)
FROM trades
GROUP BY stock_ex_id;

-- 3.	Show the number of shares priced in each currency. The results should have two columns: currency_id and number of shares priced in that currency. --
SELECT currency_id,
        COUNT(share_id)
FROM shares
GROUP BY currency_id;

-- 4.	Show the total share amount for each share. The results should have two columns: share_id and total share amount. --
SELECT share_id,
        SUM(share_amount)
FROM trades
GROUP BY share_id;


--===========================================================================================================================================================--
--===========================================================================================================================================================--
--================================================================EXTRA EXERCISES============================================================================--
--===========================================================================================================================================================--
--===========================================================================================================================================================--


-- 1.	How many trades have been made on NYSE. --
SELECT COUNT(trades.trade_id) AS "Number of trades"
FROM trades
INNER JOIN stock_exchanges
ON trades.stock_ex_id = stock_exchanges.stock_ex_id
WHERE stock_exchanges.symbol = 'NYSE';

-- 2.	How many shares have been traded on the LSE  (total share_amount). --
SELECT SUM(t.share_amount)
FROM trades t
INNER JOIN stock_exchanges s
ON t.stock_ex_id = s.stock_ex_id
WHERE s.symbol = 'LSE';

-- 3.	How many companies based in the UK have names starting with B. --
SELECT COUNT(c.name)
FROM companies c
INNER JOIN places p
ON p.place_id = c.place_id
WHERE p.country = 'United Kingdom' AND
        c.name LIKE 'B%';

-- 4.	The number of trades made by any broker in the last 10 days. Show 2 columns: broker name and number of trades. --
SELECT b.first_name || ' ' || b.last_name AS broker,
       COUNT(t.trade_id)
FROM trades t
INNER JOIN brokers b
ON b.broker_id = t.broker_id
WHERE TO_CHAR(t.transaction_time, 'YYYYMMDD') > TO_CHAR(SYSDATE - 10, 'YYYYMMDD')
GROUP BY b.first_name || ' ' || b.last_name;

-- 5.	The total share_amount for any company in the last 90 days. Show 2 columns: company name and total share amount. --
SELECT c.name,
        SUM(t.share_amount)
FROM trades t
INNER JOIN shares s
ON t.share_id = s.share_id
INNER JOIN companies c
ON s.company_id = c.company_id
WHERE TO_CHAR(t.transaction_time, 'YYYYMMDD') > TO_CHAR(SYSDATE - 90, 'YYYYMMDD')
GROUP BY c.name;

-- 6.	Create a list showing the number of companies per city. The result should have two columns: City and number of companies. --
SELECT p.city,
        COUNT(c.company_id)
FROM companies c
INNER JOIN places p
ON p.place_id = c.place_id
GROUP BY p.city;

-- 7.	Find the average price total for each company. The results should have two columns: company name and average price total. 
--      Round the average to 0 decimal places. --
SELECT c.name,
        ROUND(AVG(t.price_total))
FROM companies c
INNER JOIN shares s
ON s.company_id = c.company_id
INNER JOIN trades t
ON t.share_id = s.share_id
GROUP BY c.name;

-- 8.	Create a list showing the name of each broker and the number of stock exchanges that they trade on. 
--      The result should have two columns: broker name, number of exchanges. --
SELECT b.first_name || ' ' || b.last_name AS broker,
        COUNT(bse.stock_ex_id)
FROM brokers b
INNER JOIN broker_stock_ex bse
ON bse.broker_id = b.broker_id
GROUP BY b.first_name || ' ' || b.last_name;

-- 9.	Create a list of names of currencies and the number of shares each currency is used to price. 
--      The result should have two columns: currency name, number of shares. --
SELECT c.name,
        COUNT(s.share_id)
FROM currencies c
INNER JOIN shares s
ON c.currency_id = s.currency_id
GROUP BY c.name;

-- 10.	Create a list showing the average of share price per month per company. 
--      The result should have three columns: company name, month and average price (rounded to 2 decimal places). 
--      Make sure the results are ordered by the company name and the month. --
SELECT c.name,
       TO_CHAR(sp.time_start, 'MM') AS month,
       ROUND(AVG(sp.price), 2) AS "Average share price"
FROM companies c
INNER JOIN shares s
ON s.company_id = c.company_id
INNER JOIN shares_prices sp
ON s.share_id = sp.share_id
GROUP BY c.name, TO_CHAR(sp.time_start, 'MM')
ORDER BY c.name, TO_CHAR(sp.time_start, 'MM');

