/**
 * Simple configuration for the server and database.
 * MySQL(or MariaDB) database connection is needed.
 * 
 * @author Mike
 */

module.exports = {
    server: {
        port: 8001,
        https: false 
    },
    database: {  
        database_mysql: { 
            type: 'postgres',
            failover: true,
            retryStrategy: {
                interval: 2000,
                limit: 3,
                failoverLimit: 3
            },
            master: {
                host:'localhost',
                port:5432,
                user: 'postgres',
                password:'rootroot',
                database:'postgres',
                max: 10,
                debug:false
            },
            slave: {
                host:'localhost',
                port:5432,
                user: 'postgres',
                password:'rootroot',
                database:'postgres',
                max: 10,
                debug:false
            }
        }
    }
}