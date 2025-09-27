
const logger = require('../util/logger');

const Database = require('../database/database_mysql');

const DatabaseHelper = require('../util/database_helper');
const ControllerHelper = require('../util/controller_helper');

const coffeeSql = require('../database/sql/coffee-sql');

/**
 * @Controller(path="/post")
 */
module.exports = class Post {

    constructor() {
        this.database = new Database('database_mysql');

        this.databaseHelper = new DatabaseHelper(this.database);
        this.controllerHelper = new ControllerHelper(this.database);
    }

    ///
    /// 모든 데이터 조회하기
    ///

    /**
     * @RequestMapping(path="/coffee_list_all", method="get,post")
     */
    async listAll(req, res) {
        logger.debug(`Post::listAll 호출됨.`);

        const sqlName = 'coffee_list_all';
        this.controllerHelper.execute(req, res, sqlName);

    }
    ///
    /// 추가하기
    ///

    /**
     * @RequestMapping(path="/coffee_add", method="get,post")
     */
    async add(req, res) {
        logger.debug(`Post::add 호출됨.`);

        const sqlName = 'coffee_add';
        this.controllerHelper.execute(req, res, sqlName);

    }

    /**
     * @RequestMapping(path="/coffee_search_distance", method="get,post")
     */
    async myList(req, res) {
        logger.debug(`Post::myList 호출됨.`);

        const sqlName = 'coffee_search_distance';
        this.controllerHelper.execute(req, res, sqlName);

    }

}