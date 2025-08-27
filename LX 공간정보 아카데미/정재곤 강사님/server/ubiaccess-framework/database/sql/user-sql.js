
module.exports = {

    user_list_all: {
        sql: `select id, password, name, email, mobile 
                from project.user`
    },

    user_list: {
        sql: `select id, password, name, email, mobile 
                from project.user`,
        count: `select count(*) as total 
                  from project.user`,
        where: ` where # `,
        order: ` order by # `,
        page: ` limit # `
    },

    user_read: {
        sql: `select id, password, name, email, mobile 
                from project.user
                where id = :id`
    },

    // 고객 데이터 추가
    user_add: {
        sql: `insert into project.user(id, password, name, email, mobile ) 
                values
                (:id, :password, :name, :email, :mobile )`
    },

    // 고객 데이터 수정
    user_modify: {
        sql: `update project.user 
                set password = :password,
                    name = :name, 
                    email = :email,
                    mobile = :mobile
                where id = :id `
    },

    // 고객 데이터 삭제
    user_remove: {
        sql: `delete from project.user 
                where id = :id `
    },

    // 고객 id overlapCheck
    user_overlapCheck: {
        sql: `select count(*) as cnt
                from project.user
                where id = :id`
    },

    // 고객 id login
    user_login: {
        sql: `select count(*) as cnt, pkNumber, id
                from project.user
                where id = :id and password = :password`
    }

}