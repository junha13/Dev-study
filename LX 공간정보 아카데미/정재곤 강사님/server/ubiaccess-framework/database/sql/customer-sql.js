
module.exports = {

    customer_list_all: {
        sql: `select id, name, age, mobile 
                from test.customer`
    },

    customer_list: {
        sql: `select id, name, age, mobile 
                from test.customer`,
        count: `select count(*) as total 
                  from test.customer`,
        where: ` where # `,
        order: ` order by # `,
        page: ` limit # `
    },

    customer_read: {
        sql: `select id, name, age, mobile 
                from test.customer
                where id = :id`
    },

    // 고객 데이터 추가
    customer_add: {
        sql: `insert into test.customer(name, age, mobile) 
                values
                (:name, :age, :mobile)`
    },

    // 고객 데이터 수정
    customer_modify: {
        sql: `update test.customer 
                set name = :name, 
                    age = :age,
                    mobile = :mobile
                where id = :id `
    },

    // 고객 데이터 삭제
    customer_remove: {
        sql: `delete from test.customer 
                where id = :id `
    },

}