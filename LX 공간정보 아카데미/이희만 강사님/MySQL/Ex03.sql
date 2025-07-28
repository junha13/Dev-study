/*급여의 등급을 함께 출력하시오.
부서번호, 성명, 급여, 급여등급
5000이하이면 C,
10000이하이면 B, 
15000이하이면 A,
15000을 초과하면 S
*/

select department_id 부서번호, salary 급여,
	concat(first_name, ' ', last_name) 성명,employees
	case when salary <= 5000 then 'C'
		 when salary <= 10000 then 'B'
		 when salary <= 15000 then 'A'
		 when salary > 15000 then 'S'
    end 급여등급
from employees;