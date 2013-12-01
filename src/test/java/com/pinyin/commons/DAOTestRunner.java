package com.pinyin.commons;

import org.apache.log4j.Logger;
import org.junit.runner.Result;
import org.junit.runner.notification.RunListener;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;

import java.util.Properties;

public abstract class DAOTestRunner extends BlockJUnit4ClassRunner {

    private static boolean listenerAdded = false;

    protected String[] dataMethods;
    private static final Logger LOGGER = Logger.getLogger(DAOTestRunner.class);


    public DAOTestRunner(Class<?> klass) throws org.junit.runners.model.InitializationError {
        super(klass);
    }

    protected Properties flywayConfiguration() {
        Properties properties = new Properties();
//        properties.put("flyway.driver", configuration.getDriver());
//        properties.put("flyway.url", configuration.getUrl());
//        properties.put("flyway.user", configuration.getUser());
//        properties.put("flyway.password", configuration.getPassword());
        return properties;
    }

    @Override
    public void run(final RunNotifier notifier) {
        if (!listenerAdded) {
            LOGGER.info("----------before run all tests");
            beforeAllTestsRun();

            notifier.addListener(new RunListener() {
                public void testRunFinished(Result result) throws Exception {
                    LOGGER.info("++++++++++after run all tests");
                    afterAllTestsRun();
                }
            });
            listenerAdded = true;
        }
        try {
            LOGGER.info("----------before run");
            beforeRun();
            super.run(notifier);
        } finally {
            LOGGER.info("++++++++++after run");
            afterRun();
        }
    }

    protected void afterAllTestsRun() {
        closeServer();
//        cleanDatabase(module.getConfiguration().getDatabase());
    }

    protected void beforeAllTestsRun() {
        startServer();
    }

    protected void afterRun() {
    }

    protected void beforeRun() {
    }

    @Override
    protected void runChild(FrameworkMethod method, RunNotifier notifier) {
        try {
            LOGGER.info("---------before run child");
            beforeRunChild(method);
            prepareTestData(method);

            try {
                super.runChild(method, notifier);
            } finally {
                LOGGER.info("++++++++++after run child");
                afterRunChild();
            }
        } catch (Exception e) {
//            Throwables.propagate(e);
        }

    }

    private void prepareTestData(FrameworkMethod method) {
//        TestData testData = method.getAnnotation(TestData.class);
//        dataMethods = testData != null ? testData.value() : new String[0];
    }

    protected void afterRunChild() {
    }

    protected void beforeRunChild(FrameworkMethod method) {
    }

    protected void migrateDatabase() {
//        Flyway flyway = new Flyway();
//        if (config.getMigration().isPresent()) {
//            DatabaseConfiguration.MigrationConfiguration configuration = config.getMigration().get();
//            flyway.setLocations(configuration.getLocations());
//            flyway.setPlaceholders(configuration.getPlaceholders());
//            if (!configuration.isAuto()) {
//                return;
//            }
//        }
//        flyway.setValidateOnMigrate(true);
//        flyway.configure(flywayConfiguration(config));
//        flyway.clean();
//        flyway.init();
//        flyway.migrate();
    }

    protected void cleanDatabase() {
//        Flyway flyway = new Flyway();
//        flyway.configure(flywayConfiguration(config));
//        //   flyway.clean();
    }

    protected void startServer() {
    }

    protected void closeServer() {

    }

    @Override
    protected Object createTest() throws Exception {
        Object currentTest = super.createTest();
//        injector.injectMembers(currentTest);
//        for (String method : dataMethods) {
//            currentTest.getClass().getMethod(method).invoke(currentTest);
//        }

        return currentTest;
    }

}