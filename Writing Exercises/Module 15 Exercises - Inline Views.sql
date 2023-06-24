-- 1.	Write a query which shows the average share amount for each broker_id rounded to zero decimal places. (this query is not an inline view) --
SELECT broker_id,
        ROUND(AVG(share_amount)) as average_share_amount
FROM trades
GROUP BY broker_id;

-- 2.	Write a query which shows the lowest average share amount for any broker --
SELECT MIN(average_share_amount)
FROM
(
SELECT broker_id,
        ROUND(AVG(share_amount)) as average_share_amount
FROM trades
GROUP BY broker_id
);

-- 3.	Write a query which shows the average share amount for every broker including those brokers who haven’t made any trades. 
-- Your query should return 2 columns: broker name, average share amount. --
SELECT b.first_name || ' ' || b.last_name AS broker,
        ROUND(AVG(t.share_amount))
FROM brokers b
LEFT OUTER JOIN
        (
        SELECT t.broker_id, t.share_amount
        FROM trades t
    )t
ON t.broker_id = b.broker_id
GROUP BY b.first_name || ' ' || b.last_name;

-- 4.	Write a query which shows the number of trades for each share. (this query is not an inline view) --
SELECT share_id,
        COUNT(*)
FROM trades
GROUP BY share_id;

-- 5.	Write a query which shows the highest number of trades for any share. --
SELECT MAX(number_of_trades)
FROM
    (
    SELECT COUNT(*) AS number_of_trades
    FROM trades
    GROUP BY share_id
    );


