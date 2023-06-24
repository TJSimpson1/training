-- 1.	Show the stock_ex_id of the stock exchange where the most recent trade took place. --
SELECT stock_ex_id,
        transaction_time
FROM trades
WHERE transaction_time = (
        SELECT MAX(transaction_time)
        FROM trades
);

-- 2.	Show the broker_id of the broker who made the trade with the highest trade_id. --
SELECT broker_id,
        trade_id
FROM trades
WHERE trade_id = (
        SELECT MAX(trade_id)
        FROM trades
);

-- 3.	List the trade_ids which have an above average share_amount. --
SELECT trade_id,
        share_amount
FROM trades
WHERE share_amount > (
        SELECT AVG(share_amount)
        FROM trades
);