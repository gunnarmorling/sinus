//package org.morling.sinus.bak;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.enterprise.context.spi.CreationalContext;
//import javax.enterprise.inject.se.SeContainer;
//import javax.enterprise.inject.se.SeContainerInitializer;
//import javax.enterprise.inject.spi.AnnotatedType;
//import javax.enterprise.inject.spi.BeanManager;
//import javax.inject.Inject;
//import javax.naming.InitialContext;
//
//import org.h2.jdbcx.JdbcDataSource;
//import org.jboss.weld.context.bound.BoundRequestContext;
//import org.jboss.weld.environment.se.Weld;
//import org.jnp.server.NamingBeanImpl;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.morling.sinus.testsupport.EntityManagerFactoryProducer;
//import org.morling.sinus.testsupport.EntityManagerProducer;
//import org.morling.sinus.testsupport.MyTransactionServices;
//
//import com.arjuna.ats.jta.utils.JNDIManager;
//
//public class CdiTestBase {
//
//    private static SeContainer seContainer;
//
//    /**
//     * JNDI server.
//     */
//    private static final NamingBeanImpl NAMING_BEAN = new NamingBeanImpl();
//
//    @Inject
//    BoundRequestContext requestContext;
//
//    private Map<String, Object> requestDataStore;
//
//    @BeforeClass
//    public static void startCdiContainer() throws Exception {
//        // Start JNDI server
//        NAMING_BEAN.start();
//
//        // Bind JTA implementation with default names
//        JNDIManager.bindJTAImplementation();
//
//        new InitialContext().bind("java:/sinusDs", getDataSource());
//
//        Weld initializer = (Weld) SeContainerInitializer.newInstance()
//                .addBeanClasses(EntityManagerFactoryProducer.class, EntityManagerProducer.class);
//
//        initializer.addServices(new MyTransactionServices());
//
//        seContainer = initializer.initialize();
//    }
//
//    @AfterClass
//    public static void stopCdiContainer() {
//        seContainer.close();
//    }
//
//    @Before
//    public <T> void injectTestAndStartRequestScope() throws Exception {
//        BeanManager beanManager = seContainer.getBeanManager();
//        AnnotatedType<T> at = (AnnotatedType<T>) beanManager.createAnnotatedType(getClass());
//        CreationalContext<T> ctx = beanManager.createCreationalContext(null);
//        beanManager.createInjectionTarget(at).inject((T)this, ctx);
//
//        requestDataStore = new HashMap<String, Object>();
//        requestContext.associate(requestDataStore);
//        requestContext.activate();
//    }
//
//    static JdbcDataSource getDataSource() {
////        TransactionalDriver transactionalDriver = new TransactionalDriver();
//        JdbcDataSource dataSource = new JdbcDataSource();
////        {
////
////
////            @Override
////            public Connection getConnection() throws SQLException {
////                Properties properties = new Properties();
////                properties.setProperty(TransactionalDriver.userName, "sa");
////                properties.setProperty(TransactionalDriver.password, "");
////                return transactionalDriver.connect("jdbc:arjuna:" + "java:/sinusDs", properties);
////            }
////        };
////        dataSource.setURL("jdbc:h2:./target/quickstart.db");
//        dataSource.setURL("jdbc:h2:mem:db1;DB_CLOSE_DELAY=-1");
//        dataSource.setUser("sa");
//        dataSource.setPassword("");
//
//        return dataSource;
//    }
//
//    @After
//    public void stopRequestScope() {
//        try {
//            requestContext.invalidate();
//            requestContext.deactivate();
//
//        }
//        finally {
//            requestContext.dissociate(requestDataStore);
//        }
//    }
//}
