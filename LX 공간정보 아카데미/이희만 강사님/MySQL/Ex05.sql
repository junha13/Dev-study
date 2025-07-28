/* 1. 사번, 성명, 급여, 입사일자, 관리자사번, 관리자명, 입사일자를 출력합니다.
  - 관리자가 존재하지 않는 경우 관리자없음을 출력합니다.

2. 부서번호, 부서명, 부서장사번, 부서장명을 출력합니다.
  - 부서장이 없으면 부서장사번, 부서장명을 부서장없음이라고 출력합니다.
  */
  
  
  #1
  select e.employee_id 사번, concat(e.last_name, ' ', e.first_name) 성명, e.salary 급여, e.hire_date 입사일자, ifnull(m.last_name,'관리자없음') 관리자명, ifnull(m.employee_id,'관리자없음')  관리자사번
	from employees e
	left join employees m on m.employee_id = e.employee_id
    left join departments d on e.department_id = d.department_id;
    
    #2
    select d.department_id, d.department_name, ifnull(m.employee_id, '부서장없음') 부서장사번, ifnull(concat(m.last_name, ' ', m.first_name), '부서장없음') 부서장명
    from departments d
    left join employees m on d.manager_id = m.employee_id;
    
    
    
    














