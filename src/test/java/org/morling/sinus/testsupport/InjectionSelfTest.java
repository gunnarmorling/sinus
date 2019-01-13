package org.morling.sinus.testsupport;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.UUID;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

import org.junit.Test;
import org.morling.sinus.injectiontest.TestEntity;
import org.morling.sinus.injectiontest.TestService;

public class InjectionSelfTest extends AbstractCdiTest {

    @Inject
    private EntityManager entityManager;

    @Inject
    private UserTransaction ut;

    @Inject
    private ObserverTestBean observerTestBean;

    @Inject
    private TestService testService;

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

    @Test
    public void canUseDiInEntityListener() {
        entityManager.getTransaction().begin();

        TestEntity te = new TestEntity();
        te.id = UUID.randomUUID();
        te.name = "Test 1";
        entityManager.persist(te);

        te = new TestEntity();
        te.id = UUID.randomUUID();
        te.name = "Test 2";
        entityManager.persist(te);

        entityManager.getTransaction().commit();

        assertThat(testService.getTestEntityNames()).contains("Test 1", "Test 2");
    }
}
