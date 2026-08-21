SELECT
    employees.employee_id,
    employees.first_name,
    employees.last_name,
    REPLACE(employees.phone_number, '.', '-') AS phone_number_formatted
FROM employees;