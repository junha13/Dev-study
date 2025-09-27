
module.exports = {

    coffee_list_all: {
        sql: `select * 
                from tb_coffee`
    },

    // 고객 데이터 추가
    coffee_add: {
        sql: `insert into tb_coffee
                    (name, address, tel, location)
                values
                    (:name, :address, :tel,
                    ST_GeomFromText(':location') 
                    );`
    },

    coffee_search_distance : {
        sql : `select id, name, address, tel,
                    ST_X(location) as longitude,
                    ST_Y(location) as latitude,
                    ST_Distance(ST_GeomFromText(:location1), location)*111995 as Distance
                from tb_coffee
                where ST_Distance(ST_GeomFromText(:location2), location)*111995 < :radius
                Order by distance
                limit 100`
    }
}