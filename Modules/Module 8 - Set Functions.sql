-- companies 1,2,3,5
-- stock exchanges 1,2,3,4,6

SELECT place_id
FROM    companies
UNION
SELECT place_id
FROM    stock_exchanges;

SELECT place_id
FROM    stock_exchanges
MINUS
SELECT place_id
FROM    companies;


SELECT place_id
FROM    companies
MINUS
SELECT place_id
FROM    stock_exchanges;

SELECT place_id
FROM    companies
INTERSECT
SELECT place_id
FROM    stock_exchanges;


