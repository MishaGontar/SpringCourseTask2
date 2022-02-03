
import com.hellospring.persistence.model.SimpleClass;
import org.checkerframework.checker.units.qual.A;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Iterator;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/app-ctx.xml"})
public class UnitTest {
    @Autowired
    List<SimpleClass> chels;

    @Autowired
    @Qualifier(value = "chel1")
    SimpleClass ownChel;

    @Test
    public void test1(){
        Assert.assertEquals("Misha",ownChel.getName());
    }

    @Test
    public void test2(){
        Assert.assertFalse(SimpleClass.isOlder(ownChel, chels.get(0)));
    }
}
