SELECT *
FROM employees
WHERE LENGTH(first_name) = (
    SELECT MAX(LENGTH(first_name))
    FROM employees
);