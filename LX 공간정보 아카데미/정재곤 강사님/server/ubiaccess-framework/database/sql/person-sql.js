module.exports = {

    test_person_list: {
        sql: `select id, name, age, mobile
                from test.person`,
        count: `select count(*) as total
                from test.person`,
        where: `where #`,
        order: `order by #`,
        page: `limit #`
    }

}