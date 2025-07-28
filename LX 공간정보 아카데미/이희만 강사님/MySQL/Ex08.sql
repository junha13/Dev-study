select case when round(datediff(curdate(), hire_date) /365.5, 1)  <= 10 then 'C'
			when round(datediff(curdate(), hire_date) /365.5, 1)  <= 15 then 'B'
            when round(datediff(curdate(), hire_date) /365.5, 1) <= 20 then 'A'
            when round(datediff(curdate(), hire_date) /365.5, 1) > 20 then 'S'
		end hire_grade, count(*) cnt
from employees
group by (case when round(datediff(curdate(), hire_date) /365.5, 1) <= 10 then 'C'
			   when round(datediff(curdate(), hire_date) /365.5, 1) <= 15 then 'B'
               when round(datediff(curdate(), hire_date) /365.5, 1) <= 20 then 'A'
               when round(datediff(curdate(), hire_date) /365.5, 1) > 20 then 'S'
    end )
;


