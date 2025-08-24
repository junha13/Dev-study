
const logger = require('../util/logger')

const Database = require('../database/database_mysql');

const ControllerHelper = require('../util/controller_helper');
const DatabaseHelper = require('../util/database_helper');

const userSql = require('../database/sql/user-sql');



/**
 * @Controller(path="/user")
 */
class User {

    constructor() {
        this.database = new Database('database_mysql');

        this.controllerHelper = new ControllerHelper(this.database);
        this.databaseHelper = new DatabaseHelper(this.database);
    }

    /**
     * @RequestMapping(path="/add", method="get,post")
     */
    add(req, res) {
        logger.debug("user::add 실행됨")

        const sqlName = 'user_add';
        this.controllerHelper.execute(req, res, sqlName);
    }

    /**
     * @RequestMapping(path="/modify", method="get,post")
     */
    modify(req, res) {
        logger.debug("user::modify 실행됨")

        const sqlObj = userSql.user_modify
        this.controllerHelper.execute(req, res, sqlObj)
    }


}

module.exports = User;