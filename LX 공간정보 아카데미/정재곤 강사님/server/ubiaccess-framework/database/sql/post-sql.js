
module.exports = {

    post_list_all: {
        sql: `select title, content, thumbnail, likes, user_id
                from project.post`
    },

    post_list: {
        sql: `select pkNumber, title, content, thumbnail, likes, user_id
                from project.post`,
        count: `select count(*) as total 
                  from project.post`,
        where: ` where # `,
        order: ` order by # `,
        page: ` limit # `
    },

    post_read: {
        sql: `select title, content, thumbnail, likes, user_id
                from project.post
                where pkNumber = :pkNumber`
    },

    // 고객 데이터 추가
    post_add: {
        sql: `insert into project.post(title, content, thumbnail, likes, user_id) 
                values
                (:title, :content, :thumbnail, :likes, :user_id)`
    },

    // 고객 데이터 수정
    post_modify: {
        sql: `update project.post 
                set title = :title,
                    content = :content,
                    thumbnail = :thumbnail, 
                    likes = :likes
                where pkNumber = :pkNumber `
    },

    // 고객 데이터 삭제
    post_remove: {
        sql: `delete from project.post 
                where pkNumber = :pkNumber `
    },


}