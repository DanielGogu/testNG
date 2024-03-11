package Class01;

import org.testng.annotations.Test;

public class DependsOn {
    @Test
    public void login(){
        System.out.println("login case");
    }
    @Test(dependsOnMethods = {"login"})
    public void DashBoard(){
        System.out.println("im a dashboard test");
    }
}
