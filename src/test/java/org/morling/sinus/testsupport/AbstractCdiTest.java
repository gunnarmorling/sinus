package org.morling.sinus.testsupport;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.se.SeContainerInitializer;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.junit4.WeldInitiator;
import org.jnp.server.NamingBeanImpl;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;

import com.arjuna.ats.jta.utils.JNDIManager;

public abstract class AbstractCdiTest {

    private static NamingBeanImpl NAMING_BEAN;

    @Rule
    public WeldInitiator weld = WeldInitiator.from(
            ((Weld) SeContainerInitializer.newInstance())
                .addBeanClasses(EntityManagerFactoryProducer.class, EntityManagerProducer.class, ObserverTestBean.class)
                .addServices(new MyTransactionServices())
            )
        .activate(RequestScoped.class)
        .inject(this)
        .build();

    @BeforeClass
    public static void startJndiAndBindJtaAndDataSource() throws Exception {
        NAMING_BEAN = new NamingBeanImpl();
        NAMING_BEAN.start();

        JNDIManager.bindJTAImplementation();
        TransactionalConnectionProvider.bindDataSource();
    }

    @AfterClass
    public static void stopJndi() {
        NAMING_BEAN.stop();
    }
}
