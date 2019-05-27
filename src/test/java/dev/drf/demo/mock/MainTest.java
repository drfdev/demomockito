package dev.drf.demo.mock;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.mockito.internal.matchers.GreaterThan;

public class MainTest {

    @Test
    public void demoTest() {
        // mock
        DemoEntity demoMock = Mockito.mock(DemoEntity.class);
        // spy
        DemoEntity demo = new DemoEntity();
        DemoEntity demoSpy = Mockito.spy(demo);

        // when - thenReturn
        User user = new User();
        user.setId(10L);
        User user2 = new User();
        User user3 = new User();
        User user4 = new User();

        Mockito.when(demoMock.getUser()).thenReturn(user);

        Assert.assertEquals(user, demoMock.getUser());

        // doReturn - then
        Mockito.doReturn(user2).when(demoMock).getUser();

        Assert.assertEquals(user2, demoMock.getUser());

        // any
        Mockito.when(demoMock.getById(Mockito.any())).thenReturn(user3);

        Assert.assertEquals(user3, demoMock.getById(10L));

        // argThat
        // TODO dont work
        /*Mockito.when(demoMock.getUserById(
                Mockito.argThat(arg -> (arg != null && arg > 10L))))
                .thenReturn(user);

        Assert.assertEquals(user, demoMock.getUserById(12L));*/
        // throw
        Mockito.when(demoMock.getById(-1L))
                .thenThrow(NullPointerException.class);

        try {
            demoMock.getById(-1L);
        } catch (Exception ex) {
            Assert.assertEquals(ex.getClass(), NullPointerException.class);
        }
        // Answer
        Mockito.when(demoMock.getById(Mockito.anyLong()))
                .thenAnswer(invocation -> {
                    Long id = (Long) invocation.getArguments()[0];
                    if (id == null) {
                        return null;
                    }
                    return user4;
                });

        Assert.assertEquals(user4, demoMock.getById(8L));

        // verify
        demoMock.getName();
        demoMock.getName();
        Mockito.verify(demoMock, Mockito.times(2)).getName();

        // order
        InOrder inOrder = Mockito.inOrder(demoMock);
        inOrder.verify(demoMock, Mockito.times(2)).getName();
    }
}
