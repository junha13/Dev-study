
module.exports = {

    post_list_all: {
        sql: `select title, content, thumbnail, likes, user_id, year, grade, semester
                from project.post`
    },

    post_list: {
        sql: `select pkNumber, title, content, thumbnail, likes, user_id, year, grade, semester
                from project.post
                order by pkNumber desc`,
        count: `select count(*) as total 
                  from project.post`,
        where: ` where # `,
        order: ` order by # `,
        page: ` limit # `
    },

    post_read: {
        sql: `select title, content, thumbnail, likes, user_id, year, grade, semester
                from project.post
                where pkNumber = :pkNumber`
    },


    // post 데이터 추가
    post_add: {
        sql: `insert into project.post(title, content, thumbnail, likes, user_id, year, grade, semester) 
                values
                (:title, :content, :thumbnail, :likes, :user_id, :year, :grade, :semester)`
    },

    // post 데이터 수정
    post_modify: {
        sql: `update project.post 
                set title = :title,
                    content = :content,
                    thumbnail = :thumbnail, 
                    likes = :likes,
                    year = :year, 
                    grade = :grade, 
                    semester = :semester
                where pkNumber = :pkNumber `
    },

    // post 데이터 삭제
    post_remove: {
        sql: `delete from project.post 
                where pkNumber = :pkNumber `
    },

    // post 데이터 검색 / 인트는 문자로 변환
    // 아니 ?(포지셔널 ) 랑 :(네임드 ) 같이쓰면 터짐 ??
    post_search: {
        sql: `Select pkNumber, title, content, thumbnail, likes, user_id, year, grade, semester
                from project.post
                where 1=1
                    and title like :title
                    and user_id like :user_id
                    and cast(year as CHAR) like :year
                    and cast(grade as CHAR) like :grade
                    and cast(semester as CHAR) like :semester
                order by pkNumber desc `,
    },

    post_myList: {
        sql: `Select pkNumber, title, content, thumbnail, likes, user_id, year, grade, semester
                from project.post
                where 1=1
                    and user_id = :user_id 
                order by pkNumber desc`,
    }


}