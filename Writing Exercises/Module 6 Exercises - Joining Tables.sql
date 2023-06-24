-- 1.	Create a list of companies and their locations. The results should have three columns - company name, city & country.  --
SELECT companies.name,
        places.city,
        places.country
FROM places
INNER JOIN companies
ON companies.place_id = places.place_id;

-- 2.	Create a list of the companies and the stock exchanges they’re traded on. The results should show company name and stock exchange name. --
-- HINT: join the companies table directly to the stock exchange table. --
SELECT c.name AS company_name,
        se.name AS stoke_exchange_name
FROM companies c
INNER JOIN stock_exchanges se
ON c.place_id = se.place_id;

-- 3.	Create a list of shares and the currencies they’re priced in. The results should have two columns – share_id and currency name. --
SELECT s.share_id,
        c.name
FROM shares s
INNER JOIN currencies c
ON s.currency_id = c.currency_id;

-- 4.	Create a list of all currency names and any shares they’re used to price. 
--      The list should include currencies which are not used to price any share. The results should show two columns: currency name and share_id. -- 
-- HINT: modify your query from question 3 to use an outer join. --
SELECT s.share_id,
        c.name
FROM shares s
RIGHT OUTER JOIN currencies c
ON s.currency_id = c.currency_id;

-- 5.	Find the name of any currencies that are not used to price any share. --
-- HINT: modify your query from question 4 to use a filter. --
SELECT c.name,
       s.share_id
FROM currencies c LEFT OUTER JOIN shares s
ON s.currency_id = c.currency_id
WHERE s.share_id IS NULL;

-- 6.	Write a query that will give you the name of each company and the name of the currency their shares are traded in. --
-- HINT: join 3 tables – companies, shares and currencies --
SELECT co.name AS company_name,
        cu.name AS currency
FROM companies co 
LEFT OUTER JOIN shares s
ON co.company_id = s.company_id
LEFT OUTER JOIN currencies cu
ON s.currency_id = cu.currency_id;

-- 7.	Create a list of the brokers with the stock exchanges assigned to them. The results should have two columns – broker’s name & stock exchange name. --
-- HINT: join 3 tables – brokers, broker_stock_ex and stock_exchanges. --
SELECT b.first_name || ' ' || b.last_name AS broker,
        se.name
FROM brokers b
INNER JOIN broker_stock_ex bse
ON bse.broker_id = b.broker_id
INNER JOIN stock_exchanges se
ON bse.stock_ex_id = se.stock_ex_id;

--===========================================================================================================================================================--
--===========================================================================================================================================================--
--================================================================EXTRA EXERCISES============================================================================--
--===========================================================================================================================================================--
--===========================================================================================================================================================--

-- 1.	List brokers names who work at stock exchange id of 1. --
SELECT b.first_name || ' ' || b.last_name AS broker
FROM brokers b
INNER JOIN broker_stock_ex bse
ON bse.broker_id = b.broker_id
WHERE bse.stock_ex_id = 1;

-- 2.	List brokers names who work at NYSE . --
SELECT b.first_name || ' ' || b.last_name AS broker
FROM brokers b
INNER JOIN broker_stock_ex bse
ON bse.broker_id = b.broker_id
INNER JOIN stock_exchanges se
ON bse.stock_ex_id = se.stock_ex_id
WHERE se.symbol = 'NYSE';

SELECT b.first_name || ' ' || b.last_name AS broker
FROM brokers b
INNER JOIN broker_stock_ex bse
ON bse.broker_id = b.broker_id
WHERE bse.stock_ex_id = 3;

-- 3.	List the names of the companies based in London. --
SELECT co.name
FROM companies co
INNER JOIN places p
ON p.place_id = co.place_id
WHERE p.city = 'London';

-- 4.	List the places where there are no companies. --
SELECT places.*
FROM places
LEFT OUTER JOIN companies
ON places.place_id = companies.place_id
WHERE companies.name IS NULL;

-- 5.	List the names of companies and the names of currencies their shares are priced in. --
SELECT co.name AS company,
        cu.name AS shares_currency
FROM companies co
INNER JOIN shares
ON shares.company_id = co.company_id
INNER JOIN currencies cu
ON cu.currency_id = shares.currency_id;

-- 6.	List the names of brokers who work in the United Kingdom. --
SELECT b.first_name || ' ' || b.last_name AS broker,
        p.country
FROM brokers b
INNER JOIN broker_stock_ex bse
ON bse.broker_id = b.broker_id
INNER JOIN stock_exchanges se
ON bse.stock_ex_id = se.stock_ex_id
INNER JOIN places p
ON se.place_id = p.place_id
WHERE p.country = 'United Kingdom';

-- 7.	Without using the price_total column from trades table, work out the price total for each trade_id (give it the alias  "Base Price Total"). --
-- HINT: Finding the price of a share requires comparing its transaction time with the time the share acquired a price and the time the share 
--       ended having the same price. For shares that don't have time end, find their current price by comparing their transaction time with time start only. --
SELECT trades.trade_id,
        shares_prices.price * trades.share_amount AS base_price_total
FROM trades
INNER JOIN shares
ON trades.share_id = shares.share_id
INNER JOIN shares_prices
ON shares_prices.share_id = shares.share_id
WHERE trades.transaction_time > shares_prices.time_start AND
        trades.transaction_time < shares_prices.time_end
ORDER BY trades.trade_id;

SELECT t.trade_id,
       sp.price * t.share_amount AS "Base Price Total"
FROM trades t
   INNER JOIN
     shares s
   ON s.share_id = t.share_id
   INNER JOIN
     shares_prices sp
   ON sp.share_id = s.share_id
WHERE sp.time_end IS NOT NULL
AND t.transaction_time BETWEEN sp.time_start AND sp.time_end  -- this and the previous condition together identify past shares' prices
OR sp.time_end IS NULL
AND t.transaction_time >= sp.time_start  -- this and the previous condition together identify current shares' prices
ORDER BY t.trade_id;

-- 8.	Amend the query produced in previous task to include the commission for each trade (0.025 of the base price total), 
--      as well as the overall price total (base price total + commission) --
SELECT t.trade_id,
       sp.price * t.share_amount AS "Base Price Total",
       sp.price * t.share_amount * 0.025 AS "Commission",
       sp.price * t.share_amount * (1 + 0.025) AS "Overall Price Total"
FROM trades t
   INNER JOIN
     shares s
   ON s.share_id = t.share_id
   INNER JOIN
     shares_prices sp
   ON sp.share_id = s.share_id
WHERE sp.time_end IS NOT NULL
AND t.transaction_time BETWEEN sp.time_start AND sp.time_end
OR sp.time_end IS NULL
AND t.transaction_time >= sp.time_start
ORDER BY t.trade_id;


