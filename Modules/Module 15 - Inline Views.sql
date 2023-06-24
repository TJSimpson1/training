SELECT MAX(times_traded)
FROM
(
SELECT COUNT(share_id) AS times_traded
FROM trades
GROUP BY share_id
);

SELECT MAX(COUNT(share_id))
FROM trades
GROUP BY share_id;

SELECT AVG(trades_made)
FROM
(
SELECT COUNT(share_id) AS trades_made
FROM trades
GROUP BY broker_id
);

SELECT AVG(COUNT(*))
FROM trades
GROUP BY broker_id;

SELECT MAX(average_price)
FROM
(
SELECT AVG(price) AS average_price
FROM shares_prices
GROUP BY share_id
);

SELECT MAX(AVG(price))
FROM shares_prices
GROUP BY share_id;


SELECT broker_id, 
        COUNT(share_id)
FROM
(
SELECT DISTINCT broker_id,
        share_id
FROM trades
)
GROUP BY broker_id;

CREATE OR REPLACE VIEW total_traded_this_quarter AS
SELECT b.first_name || ' ' || b.last_name AS broker,
        SUM(t.price_total) AS total_traded
FROM brokers b
LEFT OUTER JOIN (
    SELECT  broker_id,
        price_total
    FROM    trades
    WHERE TO_CHAR(transaction_time, 'YYYYQ') = TO_CHAR(SYSDATE, 'YYYYQ')
    ) t
ON b.broker_id = t.broker_id
GROUP BY b.first_name || ' ' || b.last_name;

SELECT *
FROM total_traded_this_quarter;

        




