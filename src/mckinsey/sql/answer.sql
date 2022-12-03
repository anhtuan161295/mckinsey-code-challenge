SELECT MIN(p.salary) INTO @minSalary FROM professor p WHERE department_id = 4;
SELECT p.name, p.salary  FROM professor p WHERE department_id != 4 AND salary > @minSalary;
