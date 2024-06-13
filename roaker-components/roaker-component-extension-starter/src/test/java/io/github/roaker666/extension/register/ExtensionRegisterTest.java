package io.github.roaker666.extension.register;

import io.github.roaker666.extension.BizScenario;
import io.github.roaker666.extension.ExtensionException;
import io.github.roaker666.extension.ExtensionExecutor;
import io.github.roaker666.extension.Application;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = Application.class)
public class ExtensionRegisterTest {

    @Resource
    private ExtensionRegister register;

    @Resource
    private ExtensionExecutor executor;

    @Test
    public void testDuplicateRegistration() {
        // expect:
        //Duplicate registration is not allowed for :ExtensionCoordinate
        // [extensionPointName=io.github.roaker666.extension.register.SomeExtPt, bizScenarioUniqueIdentity=A.#defaultUseCase#.#defaultScenario#]
        Assertions.assertThrows(ExtensionException.class, ()->{
            SomeExtPt extA = new SomeExtensionA();
            register.doRegistration(extA);

            executor.executeVoid(SomeExtPt.class, BizScenario.valueOf("A"), SomeExtPt::doSomeThing);
        });
    }

}
