package org.morling.sinus.testsupport;

import static org.assertj.core.api.Assertions.assertThat;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

import org.junit.Test;

public class InjectionSelfTest extends AbstractCdiTest {

    @Inject
    private EntityManager entityManager;

    @Inject
    private UserTransaction ut;

    @Inject ObserverTestBean observerTestBean;

    @Test
    public void canInjectEntityManager() {
        assertThat(entityManager).isNotNull();
    }

    @Test
    public void canInjectUserTransaction() {
        assertThat(ut).isNotNull();
    }

    @Test
    public void shouldProcessTransactionalObservers() {
        observerTestBean.work();
        assertThat(observerTestBean.getResult()).isEqualTo("321");
    }

}
