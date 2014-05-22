grails.project.work.dir = 'target'

grails.project.dependency.resolver = "maven"
grails.project.dependency.resolution = {

    inherits "global"
    log "warn"

    repositories {
        grailsCentral()
        mavenLocal()
        mavenCentral()
    }

    dependencies {
        compile 'org.grails:grails-web-databinding-spring:2.4.0'
        compile('org.springframework.webflow:spring-webflow:2.3.3.RELEASE',
                'org.springframework.webflow:spring-binding:2.3.3.RELEASE',
                'org.springframework.webflow:spring-js:2.3.3.RELEASE') {
            exclude group:"org.springframework", name:"spring-beans"
            exclude group:"org.springframework", name:"spring-context"
            exclude group:"org.springframework", name:"spring-core"
            exclude group:"org.springframework", name:"spring-web"
            exclude group:"org.springframework", name:"spring-webmvc"
            exclude group:"commons-logging", name:"commons-logging"
            transitive = false
        }

        compile('org.hibernate:hibernate-core:3.6.10.Final') {
            excludes 'ant', 'antlr', 'cglib', 'commons-collections', 'commons-logging', 'commons-logging-api',
                     'dom4j', 'h2', 'hibernate-commons-annotations', 'hibernate-jpa-2.0-api',
                     'hibernate-validator', 'javassist', 'jaxb-api', 'jaxb-impl', 'jboss-jacc-api_JDK4',
                     'jcl-over-slf4j', 'jta', 'junit', 'slf4j-api', 'slf4j-log4j12', 'validation-api'
        }
   

    }

    plugins {
        build(":release:3.0.1", ':rest-client-builder:2.0.1') {
            export = false
        }
    }
}
