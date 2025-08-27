
const logger = require('../util/logger');

const Database = require('../database/database_mysql');

const DatabaseHelper = require('../util/database_helper');
const ControllerHelper = require('../util/controller_helper');

const userSql = require('../database/sql/user-sql');

/**
 * @Controller(path="/user")
 */
module.exports = class User {

    constructor() {
        this.database = new Database('database_mysql');

        this.databaseHelper = new DatabaseHelper(this.database);
        this.controllerHelper = new ControllerHelper(this.database);
    }

    ///
    /// 모든 데이터 조회하기
    ///

    /**
     * @RequestMapping(path="/list-all", method="get,post")
     */
    async listAll(req, res) {
        logger.debug(`User::listAll 호출됨.`);

        const sqlName = 'user_list_all';
        this.controllerHelper.execute(req, res, sqlName);

    }


    ///
    /// 리스트 조회하기 (페이지 단위로 조회하거나 조건으로 검색하는 것 포함)
    ///

    /**
     * @RequestMapping(path="/list", method="get,post")
     */
    async list(req, res) {
        logger.debug(`User::list 호출됨.`);

        const sqlObj = userSql.user_list;
        this.controllerHelper.executeList(req, res, sqlObj);

    }


    ///
    /// id를 이용해 하나 검색하기
    ///

    /**
     * @RequestMapping(path="/read", method="get,post")
     */
    async read(req, res) {
        logger.debug(`User::read 호출됨.`);

        const sqlName = 'user_read';
        this.controllerHelper.execute(req, res, sqlName);

    }


    ///
    /// 추가하기
    ///

    /**
     * @RequestMapping(path="/add", method="get,post")
     */
    async add(req, res) {
        logger.debug(`User::add 호출됨.`);

        const sqlName = 'user_add';
        this.controllerHelper.execute(req, res, sqlName);

    }


    ///
    /// 수정하기
    ///

    /**
     * @RequestMapping(path="/modify", method="get,post")
     */
    async modify(req, res) {
        logger.debug(`User::modify 호출됨.`);

        const sqlName = 'user_modify';
        this.controllerHelper.execute(req, res, sqlName);

    }


    ///
    /// 삭제하기
    ///

    /**
     * @RequestMapping(path="/remove", method="get,post")
     */
    async remove(req, res) {
        logger.debug(`User::remove 호출됨.`);

        const sqlName = 'user_remove';
        this.controllerHelper.execute(req, res, sqlName);

    }


    ///
    /// 아이디 더블체크
    ///

    /**
     * @RequestMapping(path="/overlapCheck", method="get,post")
     */
    async overlapCheck(req, res) {
        logger.debug(`User::overlapCheck 호출됨.`);

        const sqlName = 'user_overlapCheck';
        this.controllerHelper.execute(req, res, sqlName);

    }


    ///
    /// 로그인
    ///

    /**
     * @RequestMapping(path="/login", method="get,post")
     */
    async login(req, res) {
        logger.debug(`User::login 호출됨.`);

        const sqlName = 'user_login';
        this.controllerHelper.execute(req, res, sqlName);

    }

}