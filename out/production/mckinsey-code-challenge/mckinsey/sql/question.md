## 1. Professor Name and Salary

A university maintains data on professors and departments in two table: PROFESSOR and DEPARTMENT  
Write a query to print the NAME and SALARY for each professor who satisfies the following two requirements:  
- The professor does not work in the Arts and Humanities department
- The professor's salary is _greater than_ the _smallest salary_ of any professor in the Arts and Humanities department

The name must be printed before the salary, but row order does not matter

### Schema
#### Department
| Name | Type    | Description |
|------|---------| ----------- |
| ID   | Integer | A department ID in the inclusive range [1, 1000]. This is a primary key |
| NAME | String  | A department name. This field con tains between 1 and 100 characters |


#### Professor
| Name          | Type    | Description                                                             |
|---------------|---------|-------------------------------------------------------------------------|
| ID            | Integer | A professor's ID in the inclusive range [1, 1000]. This is a primary key |
| NAME          | String  | A professor's name. This field contains between 1 and 100 characters    |
| DEPARTMENT_ID | Integer  | A professor's department ID. This is a foreign key to DEPARTMENT.ID     |
| SALARY        | Integer  | A professor's salary in the inclusive range [5000, 40000]               |


