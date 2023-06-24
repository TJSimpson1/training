SELECT flight_code
FROM flight_dates 
WHERE TO_CHAR(actual_departure_date, 'YYMMDD') > TO_CHAR(SYSDATE - 10, 'YYMMDD');

SELECT AVG(number_of_seats)
FROM flights
WHERE origin_airport = 'LGW';

SELECT p.nationality,
        p.name,
        p.age
FROM passengers p
WHERE age = (
        SELECT MAX(p2.age)
        FROM passengers p2
        WHERE p.nationality = p2.nationality
);

SELECT f.flight_code, 
        COUNT(fd.flight_code)
FROM flights f
LEFT OUTER JOIN (
        SELECT flight_code
        FROM flight_dates fd
        WHERE fd.actual_arrival_date - fd.actual_departure_date > fd.scheduled_arrival_date - fd.scheduled_departure_date
)fd
ON f.flight_code = fd.flight_code
GROUP BY f.flight_code;




