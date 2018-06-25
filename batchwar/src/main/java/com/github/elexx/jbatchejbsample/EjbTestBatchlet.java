package com.github.elexx.jbatchejbsample;

import com.github.elexx.jbatchejbsample.ejb.Connector;

import javax.batch.api.Batchlet;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@Dependent
public class EjbTestBatchlet implements Batchlet {

    @Inject private Connector connector;

    @Override
    public String process() throws Exception {
        System.out.println("Calling remote EJB");
        System.out.println("Got value: " + connector.getCurrentTime());

        return "ok: " + connector.getCurrentTime();
    }

    @Override
    public void stop() throws Exception {
    }
}
