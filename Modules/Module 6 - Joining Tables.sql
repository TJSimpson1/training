SELECT companies.name,
        places.country
FROM    places
INNER JOIN 
        companies
ON      companies.place_id = places.place_id;

SELECT * FROM places;

SELECT * FROM companies;

SELECT brokers.first_name,
        brokers.last_name,
        trades.price_total
FROM brokers
INNER JOIN  trades
ON          trades.broker_id = brokers.broker_id
ORDER BY first_name;

SELECT brokers.first_name,
        brokers.last_name,
        trades.price_total
FROM brokers LEFT OUTER JOIN  trades
ON          trades.broker_id = brokers.broker_id;

SELECT brokers.first_name,
        brokers.last_name,
        trades.price_total
FROM trades RIGHT OUTER JOIN  brokers
ON          trades.broker_id = brokers.broker_id
WHERE   trades.price_total IS NULL;

SELECT b.first_name || ' ' || b.last_name AS broker,
        t.price_total
FROM trades t
INNER JOIN  
brokers b
ON          t.broker_id = b.broker_id;

SELECT DISTINCT b.first_name || ' ' || b.last_name AS broker
FROM trades t
INNER JOIN  
brokers b
ON          t.broker_id = b.broker_id;
