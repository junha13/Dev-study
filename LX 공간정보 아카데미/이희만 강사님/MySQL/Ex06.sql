/*부서별로 평균급여를 출력합니다.
단, 부서명과 부서위치도시명도 출력합니다.
- 짝수년도에 입사한 직원만 평균합니다.
- 평균급여가 7000이상만 출력합니다.
- 평균급여는 천단위 이하를 버립니다.
- 평균급여가 많은 순서로 정렬합니다.
*/

select d.department_name 부서명, l.city 부서위치도시명, truncate(avg(e.salary), -3) 평균급여
from employees e
join departments d
	on e.department_id = d.department_id
join locations l
	on d.location_id = l.location_id
where mod(year(e.hire_date), 2) = 0
group by d.department_name, l.city
having avg(salary) >= 7000
order by avg(salary) desc
;
    
    

