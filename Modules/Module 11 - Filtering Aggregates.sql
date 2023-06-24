SELECT broker_id,
        AVG(share_amount)
FROM trades
GROUP BY broker_id
HAVING AVG(share_amount) > 10000;

SELECT share_id, 
        AVG(price)
FROM shares_prices
GROUP BY share_id
HAVING AVG(price) < 100;

SELECT broker_id,
        COUNT(trade_id)
FROM trades
GROUP BY broker_id
HAVING COUNT(trade_id) >= 10;

SELECT broker_id,
        AVG(share_amount)
FROM trades
WHERE   transaction_time > SYSDATE - 90
GROUP BY broker_id
HAVING AVG(share_amount) > 10000;

SELECT broker_id,
        AVG(share_amount)
FROM trades
GROUP BY broker_id
HAVING AVG(share_amount) > (
        SELECT AVG(share_amount)
        FROM trades
);

SELECT b.first_name, b.last_name
FROM trades t
INNER JOIN brokers b
ON b.broker_id = t.broker_id
GROUP BY b.first_name, b.last_name
HAVING COUNT(t.trade_id) = (
        SELECT MAX(COUNT(trade_id))
        FROM trades
        GROUP BY broker_id
);

SELECT b.first_name || ' ' || b.last_name AS broker,
        NVL(t.price_total, 0)
FROM    brokers b
LEFT OUTER JOIN trades t
ON      t.broker_id = b.broker_id;


