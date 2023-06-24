SELECT broker_id,
       share_amount
FROM trades
WHERE share_amount = (
        SELECT MAX(share_amount)
        FROM    trades
);

SELECT broker_id,
        transaction_time
FROM trades
WHERE transaction_time = (
        SELECT MIN(transaction_time)
        FROM    trades
);

SELECT time_start,
        price
FROM shares_prices
WHERE price = (
        SELECT MAX(price)
        FROM shares_prices
);
