package Class01;

import org.testng.annotations.Test;

public class Priority {
    @Test(priority = 3)
    public void A(){
        System.out.println("im in test case A");
    }
    @Test(priority = 2,groups="smoke")
    public void B(){
        System.out.println("im in test case B");
    }
    @Test(priority = 1)
    public void C(){
        System.out.println("im in test case C");
    }
    @Test()
    public void Ftest(){
        System.out.println("im in parent test case ");
    }

}
