package com.pinyin.commons;

import com.googlecode.flyway.core.Flyway;
import org.apache.log4j.Logger;
import org.junit.runner.Result;
import org.junit.runner.notification.RunListener;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;

import java.util.Properties;

public class DAOTestRunner extends BlockJUnit4ClassRunner {

    private static boolean listenerAdded = false;

    private static final Logger LOGGER = Logger.getLogger(DAOTestRunner.class);


    public DAOTestRunner(Class<?> klass) throws org.junit.runners.model.InitializationError {
        super(klass);
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
    }

    protected void beforeAllTestsRun() {
        migrateDatabase();
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

    protected void afterRunChild() {
    }

    protected void beforeRunChild(FrameworkMethod method) {
    }

    protected void migrateDatabase() {
        Flyway flyway = new Flyway();
        flyway.setValidateOnMigrate(true);
        flyway.configure(flywayConfiguration());
        flyway.setLocations("db/migration");
        flyway.clean();
        flyway.init();
        flyway.migrate();
        LOGGER.info("flyway finished to migrate successfully.");
    }

    protected void cleanDatabase() {
        Flyway flyway = new Flyway();
        flyway.configure(flywayConfiguration());
        flyway.clean();
    }

    protected Properties flywayConfiguration() {
        Properties properties = new Properties();
        properties.put("flyway.driver", "org.h2.Driver");
        properties.put("flyway.url", "jdbc:h2:~/pinyin");
        properties.put("flyway.user", "pinyin");
        properties.put("flyway.password", "password");
        return properties;
    }
}