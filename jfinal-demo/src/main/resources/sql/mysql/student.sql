#sql("findByNameAndAge")
select name, age
from student
where name = #para(name) and age = #para(age)
#end

