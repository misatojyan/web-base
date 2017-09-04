import org.apache.tomcat.jdbc.pool.PoolProperties

object DataSource : org.apache.tomcat.jdbc.pool.DataSource() {
    init {
        setPoolProperties(PoolProperties().apply {
            /**
             * (boolean) The default auto-commit state of connections created by this pool.
             * If not set, default is JDBC driver default
             * (If not set then the setAutoCommit method will not be called.)
             */
            defaultAutoCommit


            /**
             * (boolean) The default read-only state of connections created by this pool.
             * If not set then the setReadOnly method will not be called.
             * (Some drivers don't support read only mode, ex: Informix)
             */
            defaultReadOnly


            /**
             * (String) The default TransactionIsolation state of connections created by this pool.
             * One of the following: (see javadoc )
             *      NONE
             *      READ_COMMITTED
             *      READ_UNCOMMITTED
             *      REPEATABLE_READ
             *      SERIALIZABLE
             * If not set, the method will not be called and it defaults to the JDBC driver.
             */
            defaultTransactionIsolation


            /**
             * (String) The default catalog of connections created by this pool.
             */
            defaultCatalog


            /**
             * (String) The fully qualified Java class name of the JDBC driver to be used.
             * The driver has to be accessible from the same classloader as tomcat-jdbc.jar
             */
            driverClassName


            /**
             * (String) The connection username to be passed to our JDBC driver to establish a connection.
             * Note that method DataSource.getConnection(username,password) by default
             * will not use credentials passed into the method, but will use the ones configured here.
             * See alternateUsernameAllowed property for more details.
             */
            username


            /**
             * (String) The connection password to be passed to our JDBC driver to establish a connection.
             * Note that method DataSource.getConnection(username,password) by default
             * will not use credentials passed into the method, but will use the ones configured here.
             * See alternateUsernameAllowed property for more details.
             */
            password


            /**
             * (int) The maximum number of active connections that can be allocated from this pool at the same time.
             * The default value is 100
             */
            maxActive


            /**
             * (int) The maximum number of connections that should be kept in the pool at all times.
             * Default value is maxActive:100 Idle connections are checked periodically (if enabled)
             * and connections that been idle for longer than minEvictableIdleTimeMillis will be released.
             * (also see testWhileIdle)
             */
            maxIdle


            /**
             * (int) The minimum number of established connections that should be kept in the pool at all times.
             * The connection pool can shrink below this number if validation queries fail.
             * Default value is derived from initialSize:10 (also see testWhileIdle)
             */
            minIdle


            /**
             * (int)The initial number of connections that are created when the pool is started. Default value is 10
             */
            initialSize


            /**
             * (int) The maximum number of milliseconds that the pool will wait
             * (when there are no available connections) for a connection to be returned before throwing an exception.
             * Default value is 30000 (30 seconds)
             */
            maxWait


            /**
             * (boolean) The indication of whether objects will be validated before being borrowed from the pool.
             * If the object fails to validate, it will be dropped from the pool,
             * and we will attempt to borrow another. In order to have a more efficient validation,
             * see validationInterval. Default value is false
             */
            isTestOnBorrow


            /**
             * (boolean) The indication of whether objects will be validated when a connection is first created.
             * If an object fails to validate, it will be throw SQLException. Default value is false
             */
            isTestOnConnect


            /**
             * (boolean) The indication of whether objects will be validated before being returned to the pool.
             * The default value is false.
             */
            isTestOnReturn


            /**
             * (boolean) The indication of whether objects will be validated by the idle object evictor (if any).
             * If an object fails to validate, it will be dropped from the pool.
             * The default value is false and this property has to be set
             * in order for the pool cleaner/test thread is to run (also see timeBetweenEvictionRunsMillis)
             */
            isTestWhileIdle


            /**
             * (String) The SQL query that will be used to validate connections from this pool
             * before returning them to the caller. If specified,
             * this query does not have to return any data, it just can't throw a SQLException.
             * The default value is null. If not specified, connections will be validation by the isValid() method.
             * Example values are SELECT 1(mysql), select 1 from dual(oracle), SELECT 1(MS Sql Server)
             */
            validationQuery


            /**
             * (int) The timeout in seconds before a connection validation queries fail.
             * This works by calling java.sql.Statement.setQueryTimeout(seconds)
             * on the statement that executes the validationQuery. The pool itself doesn't timeout the query,
             * it is still up to the JDBC driver to enforce query timeouts.
             * A value less than or equal to zero will disable this feature.
             * The default value is -1.
             */
            validationQueryTimeout


            /**
             * (String) The name of a class which implements the org.apache.tomcat.jdbc.pool.Validator interface
             * and provides a no-arg constructor (may be implicit).
             * If specified, the class will be used to create a Validator instance
             * which is then used instead of any validation query to validate connections.
             * The default value is null. An example value is com.mycompany.project.SimpleValidator.
             */
            validatorClassName


            /**
             * (int) The number of milliseconds to sleep between runs of the idle connection validation/cleaner thread.
             * This value should not be set under 1 second. It dictates how often we check for idle,
             * abandoned connections, and how often we validate idle connections.
             * The default value is 5000 (5 seconds).
             */
            timeBetweenEvictionRunsMillis


            /**
             * (int) Property not used in tomcat-jdbc-pool.
             */
            numTestsPerEvictionRun


            /**
             * (int) The minimum amount of time an object may sit idle in the pool before it is eligible for eviction.
             * The default value is 60000 (60 seconds).
             */
            minEvictableIdleTimeMillis


            /**
             * (boolean) Property not used. Access can be achieved by calling unwrap on the pooled connection.
             * see javax.sql.DataSource interface,
             * or call getConnection through reflection or cast the object as javax.sql.PooledConnection
             */
            isAccessToUnderlyingConnectionAllowed


            /**
             * (boolean) Flag to remove abandoned connections if they exceed the removeAbandonedTimeout.
             * If set to true a connection is considered abandoned and eligible for removal
             * if it has been in use longer than the removeAbandonedTimeout
             * Setting this to true can recover db connections from applications that fail to close a connection.
             * See also logAbandoned The default value is false.
             */
            isRemoveAbandoned


            /**
             * (int) Timeout in seconds before an abandoned(in use) connection can be removed.
             * The default value is 60 (60 seconds).
             * The value should be set to the longest running query your applications might have.
             */
            removeAbandonedTimeout


            /**
             * (boolean) Flag to log stack traces for application code which abandoned a Connection.
             * Logging of abandoned Connections adds overhead for every Connection borrow
             * because a stack trace has to be generated. The default value is false.
             */
            isLogAbandoned


            /**
             * (String) The connection properties that will be sent to our JDBC driver when establishing new connections.
             * Format of the string must be [propertyName=property;]
             * * NOTE - The "user" and "password" properties will be passed explicitly,
             * so they do not need to be included here. The default value is null.
             */
            connectionProperties


            /**
             * (boolean) Property not used.
             */
            // poolPreparedStatements


            /**
             * (int) Property not used.
             */
            // maxOpenPreparedStatements
        })
    }
}
