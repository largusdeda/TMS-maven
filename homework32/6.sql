SELECT
    employees.department_id,
    employees.salary,
    COUNT(*) AS employee_count
FROM employees
WHERE department_id IS NOT NULL
GROUP BY department_id, salary
HAVING COUNT(*) > 1
ORDER BY department_id, salary;