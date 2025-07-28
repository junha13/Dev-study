/*다음쿼리를 서브쿼리 만으로 수정합니다.
*/

select concat(e.last_name, ' ', e.first_name) 성명
    , e.salary 급여 , e.hire_date 입사일자
from employees e
    join departments d on e.department_id = d.department_id
    join locations l on d.location_id = l.location_id
where l.city = 'Seattle';


select concat(last_name, ' ', first_name) 성명, salary 급여, hire_date 입사일자
from employees
where department_id in (select department_id
						from departments
						where location_id in (select location_id
												from locations
												where city = 'Seattle'));
                        
                        
                        
                        
                        