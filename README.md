app: spring-sports-center
  in this version, we are using Mysql as our db(db name: sportscenter09), 
  so when i go to http://localhost:8080/spring-sports-center/reservation, when we in this page, there is an ajax request(in the WEB-INF/views/frontend/reservation.jsp) to get all the capabilities(Package cloud.migration.frontend.controller.MainController.java)
  i use 'cmd' to run 'mvn tomcat:run', everything works fine till now, but when i deployed to aws, then i get the error of: "No Hibernate Session bound to thread, and configuration does not allow creation of non-transactional one here"
   and then i re-test locally using eclipse to run on the tomcat server, it gets the same error in the /reservation request(cmd command works fine still)
   maybe it's because of the "tx:annotation-driven " stuff in my applicationContext or servlet context... i searched on the internet, they were talking about mostly it's because the config of transaction... but still couldn't make it works 
