SELECT MAX(share_amount)
FROM trades;

SELECT MIN(share_amount)
FROM trades;

SELECT MAX(first_name)
FROM brokers;

SELECT MIN(first_name)
FROM brokers;

SELECT MAX(transaction_time)
FROM trades;

SELECT MIN(transaction_time)
FROM trades;

SELECT ROUND(AVG(price), 2)
FROM shares_prices;

SELECT SUM(share_amount)
FROM trades;

SELECT COUNT(trade_id) 
FROM trades;

SELECT COUNT(time_end) 
FROM shares_prices; --NULL values won't be counted!

SELECT share_id,
        MAX(share_amount)
FROM trades
GROUP BY share_id
ORDER BY share_id;

SELECT share_id,
        MAX(share_amount),
        broker_id
FROM trades
GROUP BY share_id, broker_id
ORDER BY share_id, broker_id;

SELECT trade_id,
        AVG(share_amount)
FROM trades
GROUP BY trade_id  --Never put primary key in GROUP BY
ORDER BY trade_id; 

SELECT share_id,
        ROUND(AVG(price), 2)
FROM shares_prices
GROUP BY share_id
ORDER BY share_id;

SELECT broker_id,
        COUNT(trade_id)
FROM trades
GROUP BY broker_id
ORDER BY broker_id;

SELECT MAX(COUNT(trade_id))
FROM trades
GROUP BY broker_id
ORDER BY broker_id;
