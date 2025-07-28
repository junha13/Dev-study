select department_id, first_name, last_name, salary, hire_date, email
from employees
where salary >= 10000
    and commission_pct != null
    and department_id in(80,100)
    and manager_id != null
    and job_id like 'P%'
    order by hire_date
;



