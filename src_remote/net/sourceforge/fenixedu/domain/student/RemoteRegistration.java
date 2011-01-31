package net.sourceforge.fenixedu.domain.student;

import org.joda.time.DateTime;

import net.sourceforge.fenixedu.domain.RemoteStudentCurricularPlan;
import pt.ist.fenixframework.plugins.remote.domain.RemoteHost;
import net.sourceforge.fenixedu.domain.RemoteExecutionYear;

public class RemoteRegistration extends RemoteRegistration_Base {

    public RemoteRegistration() {
	super();
    }
    
    public RemoteStudentCurricularPlan getStudentCurricularPlanForCurrentExecutionYear() {
	return (RemoteStudentCurricularPlan) readRemoteDomainObjectByMethod("getStudentCurricularPlanForCurrentExecutionYear");
    }

    public RemoteStudentCurricularPlan getLastStudentCurricularPlan() {
	return (RemoteStudentCurricularPlan) readRemoteDomainObjectByMethod("getLastStudentCurricularPlan");
    }

    public RemoteExecutionYear getConclusionYear() {
	return (RemoteExecutionYear) readRemoteDomainObjectByMethod("getConclusionYear");
    }

    public Boolean isRegistrationConclusionProcessed() {
	return toBoolean(readRemoteMethod("isRegistrationConclusionProcessed"));
    }

    public static String readAllStudentInfo(RemoteHost host) {
	return host.readRemoteStaticMethod("net.sourceforge.fenixedu.domain.student.Registration", "readAllStudentInfo");
    }

}
