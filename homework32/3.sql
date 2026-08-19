SELECT *
FROM employees
WHERE department_id IN (50, 80)
  AND commission_pct IS NOT NULL;