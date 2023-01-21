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
SELECT countries.id, countries.sortname, countries.name, countries.phonecode,
       COUNT(DISTINCT s.id) AS countOfStates,
       COUNT(c.id) AS countOfCities
FROM countries
         LEFT JOIN states s ON countries.id = s.country_id
         LEFT JOIN cities c ON c.state_id = s.id
GROUP BY countries.id, countries.name;

/*7*/
SELECT * FROM
    (SELECT con.*, COUNT(s.id) as CountOfStates
     FROM countries con
              LEFT JOIN states s ON s.country_id = con.id
     GROUP BY con.id
     ORDER BY CountOfStates DESC
     LIMIT 10) AS max
UNION ALL
(SELECT con.*, COUNT(s.id) as CountOfStates
 FROM countries con
          LEFT JOIN states s ON s.country_id = con.id
 GROUP BY con.id
 ORDER BY CountOfStates
 LIMIT 10)
ORDER BY name;

/*8*/
SELECT countries.id, countries.sortname, countries.name, countries.phonecode, AVG(s.id)
FROM countries
         JOIN states s ON countries.id = s.country_id
WHERE s.id > (SELECT AVG(states.id) FROM states)
GROUP BY countries.id, countries.sortname, countries.name, countries.phonecode;

/*9*/
SELECT id, sortname, name, phonecode, CountOfStates FROM
    (SELECT *, RANK () OVER (PARTITION BY CountOfStates ORDER BY name) num
     FROM
         (SELECT con.*, COUNT(s.id) AS CountOfStates
          FROM countries con
                   LEFT JOIN states s ON s.country_id = con.id
          GROUP BY con.id) tab1) tab2
WHERE num = 1;

/*10*/
SELECT states.name,
       COUNT(states.name)
FROM states
GROUP BY states.name
HAVING COUNT(states.name) > 1;

/*11*/
SELECT states.id, states.name, states.country_id
FROM states
         LEFT JOIN cities c ON states.id = c.state_id
GROUP BY states.id
HAVING COUNT(c.id) = 0;