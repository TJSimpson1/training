SELECT t.share_id,
        t.price_total,
        t.trade_id
FROM trades t
WHERE t.price_total = (
        SELECT MAX(t2.price_total)
        FROM trades t2
        WHERE t2.share_id = t.share_id
    )
;

SELECT  t.broker_id,
        t.share_amount,
        t.share_id
FROM trades t
WHERE t.share_amount = (
        SELECT MAX(t2.share_amount)
        FROM trades t2
        WHERE t2.broker_id = t.broker_id
        )
ORDER BY t.broker_id;

SELECT s.share_id,
        s.price,
        s.time_start
FROM shares_prices s
WHERE s.price = (
        SELECT MAX(s2.price)
        FROM shares_prices s2
        WHERE s2.share_id = s.share_id
        )
ORDER BY s.share_id;
        


