
module.exports = {
    user_add: {
        sql: `insert into project.user(id, password, name, email, phone)
                values
                (:id, :password, :name, :email, :phone)`
    },
    user_modify: {
        sql: `insert into (id, password, name, email, phone)
                values
                (:id, :password, :name, :email, :phone)`
    }
}