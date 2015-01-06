package ut.com.xebia.bee;

import org.junit.Test;
import com.xebia.bee.MyPluginComponent;
import com.xebia.bee.MyPluginComponentImpl;

import static org.junit.Assert.assertEquals;

public class MyComponentUnitTest
{
    @Test
    public void testMyName()
    {
        MyPluginComponent component = new MyPluginComponentImpl(null);
        assertEquals("names do not match!", "myComponent",component.getName());
    }
}