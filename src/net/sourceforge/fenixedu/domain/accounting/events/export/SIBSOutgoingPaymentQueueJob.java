package net.sourceforge.fenixedu.domain.accounting.events.export;

import java.util.ArrayList;
import java.util.List;

import net.sourceforge.fenixedu.domain.QueueJob;
import net.sourceforge.fenixedu.domain.QueueJobResult;
import net.sourceforge.fenixedu.domain.RootDomainObject;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.joda.time.DateTime;

import pt.ist.fenixWebFramework.services.Service;

public class SIBSOutgoingPaymentQueueJob extends SIBSOutgoingPaymentQueueJob_Base {

    private transient DateTime lastSuccessfulSentPaymentFileDateTime;

    public SIBSOutgoingPaymentQueueJob(DateTime lastSuccessfulSentPaymentFileDateTime) {
	super();

	this.lastSuccessfulSentPaymentFileDateTime = lastSuccessfulSentPaymentFileDateTime;
    }

    @Override
    public QueueJobResult execute() throws Exception {
	new SIBSOutgoingPaymentFile(lastSuccessfulSentPaymentFileDateTime);
	QueueJobResult queueJobResult = new QueueJobResult();
	queueJobResult.setDone(true);
	return queueJobResult;
    }

    @Service
    public static SIBSOutgoingPaymentQueueJob launchJob(DateTime lastSuccessfulSentPaymentFileDateTime) {
	return new SIBSOutgoingPaymentQueueJob(lastSuccessfulSentPaymentFileDateTime);
    }

    public static List<SIBSOutgoingPaymentQueueJob> readAllSIBSOutgoingPaymentQueueJobs() {
	return new ArrayList<SIBSOutgoingPaymentQueueJob>(RootDomainObject
		.readAllDomainObjects(SIBSOutgoingPaymentQueueJob.class));
    }

    public static SIBSOutgoingPaymentQueueJob getQueueJobNotDoneAndNotCancelled() {
	List<SIBSOutgoingPaymentQueueJob> jobList = readAllSIBSOutgoingPaymentQueueJobs();

	return (SIBSOutgoingPaymentQueueJob) CollectionUtils.find(jobList, new Predicate() {

	    @Override
	    public boolean evaluate(Object arg0) {
		return ((QueueJob) arg0).getIsNotDoneAndNotCancelled();
	    }

	});
    }

    public static boolean hasExportationQueueJobToRun() {
	return getQueueJobNotDoneAndNotCancelled() != null;
    }
}
