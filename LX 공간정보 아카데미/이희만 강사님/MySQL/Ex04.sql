/*
1. 20번 부서의 이름과 그 부서에 근무하는 사원의 이름을 출력하시오. 단, 급여로 오름차순 정렬하시오.

2. 1400,1500 번 위치의 도시 이름과 그곳에 있는 부서의 이름을 출력하시오.

3. IT_PROG가 직무인 직원들의 다음 정보를 출력.
   - 입사일자를 일/월/년으로 출력
   - 부서명, 도시명도 출력합니다.
   */
   
   # 1.
select d.department_name 부서명,
 concat(e.first_name, ' ', e.last_name) 성명
from employees e
join departments d on e.department_id = d.department_id
where d.department_id = 20
order by e.salary asc
;

# 2.
select l.city 도시명, d.department_name 부서명
from departments d
join locations l on d.location_id = l.location_id
where l.location_id in (1400, 1500)
;

# 3.
select date_format(e.hire_date, '%d/%m/%Y') 입사일자, d.department_name 부서명, l.city 도시명
from employees e, departments d, locations l
where e.department_id = d.department_id
    and d.location_id = l.location_id
    and e.job_id = 'IT_PROG'
;