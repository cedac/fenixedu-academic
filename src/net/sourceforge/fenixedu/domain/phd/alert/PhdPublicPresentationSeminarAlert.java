package net.sourceforge.fenixedu.domain.phd.alert;

import java.util.Collections;

import net.sourceforge.fenixedu.domain.accessControl.Group;
import net.sourceforge.fenixedu.domain.accessControl.MasterDegreeAdministrativeOfficeGroup;
import net.sourceforge.fenixedu.domain.phd.PhdIndividualProgramProcess;
import net.sourceforge.fenixedu.domain.phd.PhdProgramCalendarUtil;
import net.sourceforge.fenixedu.domain.util.email.Message;
import net.sourceforge.fenixedu.domain.util.email.Recipient;

import org.joda.time.LocalDate;

import pt.utl.ist.fenix.tools.util.i18n.Language;
import pt.utl.ist.fenix.tools.util.i18n.MultiLanguageString;

public class PhdPublicPresentationSeminarAlert extends PhdPublicPresentationSeminarAlert_Base {

    static private int MAX_DAYS = 24 * 30; // months * days

    private PhdPublicPresentationSeminarAlert() {
	super();
    }

    public PhdPublicPresentationSeminarAlert(final PhdIndividualProgramProcess process) {
	this();
	super.init(process, buildSubject(), buildBody());
    }

    private MultiLanguageString buildSubject() {
	return new MultiLanguageString(Language.getDefaultLanguage(), getResourceBundle().getString(
		"message.phd.alert.public.presentation.seminar.subject"));
    }

    private MultiLanguageString buildBody() {
	return new MultiLanguageString(Language.getDefaultLanguage(), getResourceBundle().getString(
		"message.phd.alert.public.presentation.seminar.body"));
    }

    @Override
    public String getDescription() {
	return getResourceBundle().getString("message.phd.alert.public.presentation.seminar.description");
    }

    @Override
    protected boolean isToDiscard() {
	return getProcess().hasPublicPresentationSeminar();
    }

    @Override
    public boolean isToFire() {
	// TODO: method to add months?
	return !new LocalDate().isBefore(PhdProgramCalendarUtil.addWorkDaysTo(getProcess().getWhenStartedStudies(), MAX_DAYS));
    }

    @Override
    protected void generateMessage() {
	// TODO: coordinator?

	final Group academicOfficeGroup = new MasterDegreeAdministrativeOfficeGroup();
	new PhdAlertMessage(getProcess(), academicOfficeGroup.getElements(), getFormattedSubject(), getFormattedBody());
	new Message(getRootDomainObject().getSystemSender(), new Recipient(academicOfficeGroup), buildMailSubject(),
		buildMailBody());

	new PhdAlertMessage(getProcess(), getProcess().getPerson(), getFormattedSubject(), getFormattedBody());
	new Message(getRootDomainObject().getSystemSender(), new Recipient(Collections.singletonList(getProcess().getPerson())),
		buildMailSubject(), buildMailBody());
    }

    @Override
    public boolean isSystemAlert() {
	return true;
    }

    @Override
    public boolean isToSendMail() {
	return true;
    }

}
