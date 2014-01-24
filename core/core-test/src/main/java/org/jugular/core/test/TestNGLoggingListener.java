package org.jugular.core.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

/**
 *
 * @author saden
 */
public class TestNGLoggingListener
        implements ISuiteListener, IInvokedMethodListener {

    private static final Logger LOG = LoggerFactory.getLogger("core.test");

    @Override
    public void onStart(ISuite suite) {
        LOG.info("Started {}", suite.getName());
    }

    @Override
    public void onFinish(ISuite suite) {
        LOG.info("Finished {}", suite.getName());
    }

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        ITestNGMethod testMethod = method.getTestMethod();
        String methodName = testMethod.getMethodName();
        LOG.info(" > Started {}", methodName);
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        ITestNGMethod testMethod = method.getTestMethod();
        String methodName = testMethod.getMethodName();
        LOG.info(" > Finished {}", methodName);
    }
}
