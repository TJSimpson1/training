SELECT * FROM employees;

SELECT e1.name AS employee,
        e2.name AS boss
FROM employees e1
INNER JOIN employees e2
ON e1.boss_id = e2.employee_id;

SELECT e1.name AS employee,
        e2.name AS boss
FROM employees e1
LEFT OUTER JOIN employees e2
ON e1.boss_id = e2.employee_id;

SELECT b.broker_id, se.stock_ex_id
FROM brokers b CROSS JOIN stock_exchanges se;

SELECT b.broker_id, t.trade_id
FROM brokers b
INNER JOIN trades t
ON t.broker_id = b.broker_id;
