-- 1,2,3,4,5,7

SELECT broker_id
FROM trades
ORDER BY broker_id;

SELECT first_name || ' ' || last_name AS broker  -- OUTER QUERY
FROM brokers
WHERE broker_id IN (    -- INNER QUERY
        SELECT broker_id
        FROM trades
);

SELECT first_name || ' ' || last_name AS broker  -- OUTER QUERY
FROM brokers
WHERE broker_id NOT IN (    -- INNER QUERY
        SELECT broker_id
        FROM trades
);

SELECT name
FROM currencies
WHERE currency_id NOT IN (
        SELECT currency_id
        FROM shares
);

SELECT name
FROM companies
WHERE company_id IN (
        SELECT company_id
        FROM shares
);

SELECT c.name
FROM companies c
INNER JOIN shares s
ON s.company_id = c.company_id;