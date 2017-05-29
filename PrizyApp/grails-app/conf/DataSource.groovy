dataSource {
        pooled = true
        driverClassName = "org.postgresql.Driver"
        username = "jbilling"
        password = ""
}
hibernate {
    cache.use_second_level_cache=true
    cache.use_query_cache=true
    cache.provider_class='org.hibernate.cache.EhCacheProvider'
}
// environment specific settings
environments {
        development {
                dataSource {
                        dbCreate = "update" // one of 'create', 'create-drop','update'
                        url = "jdbc:postgresql://localhost:5432/prizypricer_db"
                }
        }
        test {
                /*dataSource {
                        dbCreate = "update"
                        url = "jdbc:postgresql://localhost:5432/prizypricer_test_db"
                }*/
        }
        production {
                dataSource {
                        dbCreate = "create"
                        url = "jdbc:postgresql://localhost:5432/prizypricer_db"
						pooled = true
						properties {
						   maxActive = -1
						   minEvictableIdleTimeMillis=1800000
						   timeBetweenEvictionRunsMillis=1800000
						   numTestsPerEvictionRun=3
						   testOnBorrow=true
						   testWhileIdle=true
						   testOnReturn=true
						   validationQuery="SELECT 1"
						}
                }
        }    
}
