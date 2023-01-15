/*1*/
SELECT countries.*, COUNT(*)
FROM countries
         JOIN states ON countries.id = states.country_id
GROUP BY countries.id
HAVING COUNT (*) = (SELECT MAX (mycount)
                    FROM (SELECT country_id,COUNT(*) mycount
                          FROM states
                          GROUP BY country_id)
                             AS mycount);

/*2*/
SELECT countries.*, COUNT (*) as count
FROM countries
         JOIN states ON countries.id = states.country_id
         JOIN cities ON states.id = cities.state_id
GROUP BY countries.id
HAVING COUNT(*) =
       (SELECT MAX (count)
        FROM
            (SELECT countries.*, COUNT (*) as count
             FROM countries
                      JOIN states ON countries.id = states.country_id
                      JOIN cities ON states.id = cities.state_id
             GROUP BY countries.id) AS max);

/*3*/
SELECT sort.* FROM (
                       SELECT countries.*, COUNT(*) as countOfStates
                       FROM countries
                                JOIN states ON countries.id = states.country_id
                       GROUP BY countries.id) as sort
ORDER BY countOfStates DESC, sort.name, sort.id;

/*4*/
SELECT sort.* FROM (
                       SELECT countries.*, COUNT(*) as countOfCities
                       FROM countries
                                JOIN states ON countries.id = states.country_id
                                JOIN cities ON states.id = cities.state_id
                       GROUP BY countries.id) as sort
ORDER BY countOfCities DESC, sort.name, sort.id;

/*5*/